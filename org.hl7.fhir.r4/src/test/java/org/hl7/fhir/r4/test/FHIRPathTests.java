package org.hl7.fhir.r4.test;

import org.apache.commons.lang3.NotImplementedException;
import org.fhir.ucum.UcumException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.PathEngineException;
import org.hl7.fhir.r4.formats.XmlParser;
import org.hl7.fhir.r4.model.*;
import org.hl7.fhir.r4.test.utils.TestingUtilities;
import org.hl7.fhir.r4.utils.FHIRPathEngine;
import org.hl7.fhir.r4.utils.FHIRPathEngine.IEvaluationContext;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xml.XMLUtil;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class FHIRPathTests {

  public class FHIRPathTestEvaluationServices implements IEvaluationContext {

    @Override
    public List<Base> resolveConstant(Object appContext, String name, boolean beforeContext) throws PathEngineException {
      throw new NotImplementedException("Not done yet (FHIRPathTestEvaluationServices.resolveConstant), when item is element");
    }

    @Override
    public TypeDetails resolveConstantType(Object appContext, String name) throws PathEngineException {

      throw new NotImplementedException("Not done yet (FHIRPathTestEvaluationServices.resolveConstantType), when item is element");
    }

    @Override
    public boolean log(String argument, List<Base> focus) {
      return false;
    }

    @Override
    public FunctionDetails resolveFunction(String functionName) {
      throw new NotImplementedException("Not done yet (FHIRPathTestEvaluationServices.resolveFunction), when item is element (for " + functionName + ")");
    }

    @Override
    public TypeDetails checkFunction(Object appContext, String functionName, List<TypeDetails> parameters) throws PathEngineException {
      throw new NotImplementedException("Not done yet (FHIRPathTestEvaluationServices.checkFunction), when item is element");
    }

    @Override
    public List<Base> executeFunction(Object appContext, List<Base> focus, String functionName, List<List<Base>> parameters) {
      throw new NotImplementedException("Not done yet (FHIRPathTestEvaluationServices.executeFunction), when item is element");
    }

    @Override
    public Base resolveReference(Object appContext, String url) throws FHIRException {
      throw new NotImplementedException("Not done yet (FHIRPathTestEvaluationServices.resolveReference), when item is element");
    }

    @Override
    public boolean conformsToProfile(Object appContext, Base item, String url) throws FHIRException {
      if (url.equals("http://hl7.org/fhir/StructureDefinition/Patient"))
        return true;
      if (url.equals("http://hl7.org/fhir/StructureDefinition/Person"))
        return false;
      throw new FHIRException("unknown profile " + url);

    }

    @Override
    public ValueSet resolveValueSet(Object appContext, String url) {
      return TestingUtilities.context().fetchResource(ValueSet.class, url);
    }
  }

  private static FHIRPathEngine fp;

  @BeforeAll
  public static void setup() {
    fp = new FHIRPathEngine(TestingUtilities.context());
  }

  public static Stream<Arguments> data() throws ParserConfigurationException, SAXException, IOException {
    Document dom = XMLUtil.parseFileToDom(TestingUtilities.resourceNameToFile("fhirpath", "tests-fhir-r4.xml"));

    List<Element> list = new ArrayList<Element>();
    List<Element> groups = new ArrayList<Element>();
    XMLUtil.getNamedChildren(dom.getDocumentElement(), "group", groups);
    for (Element g : groups) {
      XMLUtil.getNamedChildren(g, "test", list);
    }

    List<Arguments> objects = new ArrayList();
    for (Element e : list) {
      objects.add(Arguments.of(getName(e), e));
    }
    return objects.stream();
  }

  private static Object getName(Element e) {
    String s = e.getAttribute("name");
    Element p = (Element) e.getParentNode();
    int ndx = 0;
    for (int i = 0; i < p.getChildNodes().getLength(); i++) {
      Node c = p.getChildNodes().item(i);
      if (c == e)
        break;
      else if (c instanceof Element)
        ndx++;
    }
    if (Utilities.noString(s))
      s = "?? - G " + p.getAttribute("name") + "[" + Integer.toString(ndx + 1) + "]";
    else
      s = s + " - G " + p.getAttribute("name") + "[" + Integer.toString(ndx + 1) + "]";
    return s;
  }


  private Map<String, Resource> resources = new HashMap<String, Resource>();


  @SuppressWarnings("deprecation")
  @Disabled
  @ParameterizedTest(name = "{index}: file {0}")
  @MethodSource("data")
  public void test(String name, Element test) throws FileNotFoundException, IOException, FHIRException, org.hl7.fhir.exceptions.FHIRException, UcumException {

    fp.setHostServices(new FHIRPathTestEvaluationServices());
    String input = test.getAttribute("inputfile");
    String expression = XMLUtil.getNamedChild(test, "expression").getTextContent();
    boolean fail = Utilities.existsInList(XMLUtil.getNamedChild(test, "expression").getAttribute("invalid"), "true", "semantic");
    Resource res = null;

    List<Base> outcome = new ArrayList<Base>();

    ExpressionNode node = fp.parse(expression);
    try {
      if (Utilities.noString(input))
        fp.check(null, null, node);
      else {
        res = resources.get(input);
        if (res == null) {
          res = new XmlParser().parse(new FileInputStream(TestingUtilities.resourceNameToFile(input)));
          resources.put(input, res);
        }
        fp.check(res, res.getResourceType().toString(), res.getResourceType().toString(), node);
      }
      outcome = fp.evaluate(res, node);
      Assertions.assertFalse(fail, String.format("Expected exception parsing %s", expression));
    } catch (Exception e) {
      Assertions.assertTrue(fail, String.format("Unexpected exception parsing %s: " + e.getMessage(), expression));
    }

    if ("true".equals(test.getAttribute("predicate"))) {
      boolean ok = fp.convertToBoolean(outcome);
      outcome.clear();
      outcome.add(new BooleanType(ok));
    }
    if (fp.hasLog())
      System.out.println(fp.takeLog());

    List<Element> expected = new ArrayList<Element>();
    XMLUtil.getNamedChildren(test, "output", expected);
    Assertions.assertEquals(outcome.size(), expected.size(), String.format("Expected %d objects but found %d for expression %s", expected.size(), outcome.size(), expression));
    if ("false".equals(test.getAttribute("ordered"))) {
      for (int i = 0; i < Math.min(outcome.size(), expected.size()); i++) {
        String tn = outcome.get(i).fhirType();
        String s;
        if (outcome.get(i) instanceof Quantity)
          s = fp.convertToString(outcome.get(i));
        else
          s = ((PrimitiveType) outcome.get(i)).asStringValue();
        boolean found = false;
        for (Element e : expected) {
          if ((Utilities.noString(e.getAttribute("type")) || e.getAttribute("type").equals(tn)) &&
            (Utilities.noString(e.getTextContent()) || e.getTextContent().equals(s)))
            found = true;
        }
        Assertions.assertTrue(found, String.format("Outcome %d: Value %s of type %s not expected for %s", i, s, tn, expression));
      }
    } else {
      for (int i = 0; i < Math.min(outcome.size(), expected.size()); i++) {
        String tn = expected.get(i).getAttribute("type");
        if (!Utilities.noString(tn)) {
          Assertions.assertEquals(tn, outcome.get(i).fhirType(), String.format("Outcome %d: Type should be %s but was %s", i, tn, outcome.get(i).fhirType()));
        }
        String v = expected.get(i).getTextContent();
        if (!Utilities.noString(v)) {
          if (outcome.get(i) instanceof Quantity) {
            Quantity q = fp.parseQuantityString(v);
            Assertions.assertTrue(outcome.get(i).equalsDeep(q), String.format("Outcome %d: Value should be %s but was %s", i, v, outcome.get(i).toString()));
          } else {
            Assertions.assertTrue(outcome.get(i) instanceof PrimitiveType, String.format("Outcome %d: Value should be a primitive type but was %s", i, outcome.get(i).fhirType()));
            Assertions.assertEquals(v, ((PrimitiveType) outcome.get(i)).fpValue(), String.format("Outcome %d: Value should be %s but was %s for expression %s", i, v, ((PrimitiveType) outcome.get(i)).fpValue(), expression));
          }
        }
      }
    }
  }

  @Test
  @DisplayName("resolveConstant returns a list of Base")
  public void resolveConstantReturnsList() {
    final String DUMMY_CONSTANT_1 = "dummyConstant1";
    final String DUMMY_CONSTANT_2 = "dummyConstant2";
    fp.setHostServices(new FHIRPathTestEvaluationServices() {
      @Override
      public List<Base> resolveConstant(Object appContext, String name, boolean beforeContext) throws PathEngineException {

        return Arrays.asList(
          new StringType(DUMMY_CONSTANT_1).noExtensions(),
          new StringType(DUMMY_CONSTANT_2).noExtensions());
      }
    });

    ExpressionNode expressionNode = fp.parse("%dummyConstant");

    List<Base> result = fp.evaluate(null, expressionNode);
    assertEquals(2, result.size());
    assertEquals(DUMMY_CONSTANT_1, result.get(0).primitiveValue());
    assertEquals(DUMMY_CONSTANT_2, result.get(1).primitiveValue());
  }
}