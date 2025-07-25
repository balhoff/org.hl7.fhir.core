package org.hl7.fhir.r5.utils;




import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.NotImplementedException;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.extensions.ExtensionUtilities;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.BooleanType;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.DateTimeType;
import org.hl7.fhir.r5.model.DateType;
import org.hl7.fhir.r5.model.DecimalType;
import org.hl7.fhir.r5.model.Element;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.Enumeration;
import org.hl7.fhir.r5.model.Enumerations.BindingStrength;
import org.hl7.fhir.r5.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r5.model.Factory;
import org.hl7.fhir.r5.model.IntegerType;
import org.hl7.fhir.r5.model.Quantity;
import org.hl7.fhir.r5.model.Questionnaire;
import org.hl7.fhir.r5.model.Questionnaire.QuestionnaireAnswerConstraint;
import org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent;
import org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType;
import org.hl7.fhir.r5.model.QuestionnaireResponse;
import org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent;
import org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseStatus;
import org.hl7.fhir.r5.model.Reference;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.model.TimeType;
import org.hl7.fhir.r5.model.UriType;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent;
import org.hl7.fhir.r5.terminologies.expansion.ValueSetExpander;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.Utilities;



/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.

  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:

 * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
 * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.

  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.

 */


/**
 * This class takes a profile, and builds a questionnaire from it
 * 
 * If you then convert this questionnaire to a form using the 
 * XMLTools form builder, and then take the QuestionnaireResponse 
 * this creates, you can use QuestionnaireInstanceConvert to 
 * build an instance the conforms to the profile
 *  
 * FHIR context: 
 *   conceptLocator, codeSystems, valueSets, maps, client, profiles
 * You don"t have to provide any of these, but 
 * the more you provide, the better the conversion will be
 * 
 * @author Grahame
 *
 */
@MarkedToMoveToAdjunctPackage
public class QuestionnaireBuilder {

  private static final int MaxListboxCodings = 20;
  private IWorkerContext context;
  private int lastid = 0;
  private Resource resource;
  private StructureDefinition profile;
  private Questionnaire questionnaire;
  private QuestionnaireResponse response;
  private String questionnaireId;
  private Factory factory = new Factory();
  private Map<String, String> vsCache = new HashMap<String, String>();
  private ValueSetExpander expander;
  private Set<String> linkIds = new HashSet<>();

  // sometimes, when this is used, the questionnaire is already build and cached, and we are
  // processing the response. for technical reasons, we still go through the process, but
  // we don't do the intensive parts of the work (save time)
  private Questionnaire prebuiltQuestionnaire;
  private ProfileUtilities profileUtilities;
  private String rootPath;

  public QuestionnaireBuilder(IWorkerContext context, String rootPath) {
    super();
    this.context = context;
    profileUtilities = new ProfileUtilities(context, null, null); 
    this.rootPath = rootPath;
  }

  public Resource getReference() {
    return resource;
  }

  public void setReference(Resource resource) {
    this.resource = resource;
  }

  public StructureDefinition getProfile() {
    return profile;
  }

  public void setProfile(StructureDefinition profile) {
    this.profile = profile;
  }

  public Questionnaire getQuestionnaire() {
    return questionnaire;
  }

  public void setQuestionnaire(Questionnaire questionnaire) {
    this.questionnaire = questionnaire;
  }

  public QuestionnaireResponse getResponse() {
    return response;
  }

  public void setResponse(QuestionnaireResponse response) {
    this.response = response;
  }

  public String getQuestionnaireId() {
    return questionnaireId;
  }

  public void setQuestionnaireId(String questionnaireId) {
    this.questionnaireId = questionnaireId;
  }

  public Questionnaire getPrebuiltQuestionnaire() {
    return prebuiltQuestionnaire;
  }

  public void setPrebuiltQuestionnaire(Questionnaire prebuiltQuestionnaire) {
    this.prebuiltQuestionnaire = prebuiltQuestionnaire;
  }

  public ValueSetExpander getExpander() {
    return expander;
  }

  public void setExpander(ValueSetExpander expander) {
    this.expander = expander;
  }

  public void build() throws FHIRException {
		if (profile == null)
      throw new DefinitionException("QuestionnaireBuilder.build: no profile found");

    if (resource != null)
      if (!profile.getType().equals(resource.getResourceType().toString()))
        throw new DefinitionException("Wrong Type");

    if (prebuiltQuestionnaire != null)
      questionnaire = prebuiltQuestionnaire;
    else
      questionnaire = new Questionnaire();
    if (resource != null) 
      response = new QuestionnaireResponse();
    processMetadata();


    List<ElementDefinition> list = new ArrayList<ElementDefinition>();
    List<QuestionnaireResponse.QuestionnaireResponseItemComponent> answerGroups = new ArrayList<QuestionnaireResponse.QuestionnaireResponseItemComponent>();

    if (resource != null)
      answerGroups.addAll(response.getItem());
    if (prebuiltQuestionnaire != null) {
      // give it a fake group to build
      Questionnaire.QuestionnaireItemComponent group = new Questionnaire.QuestionnaireItemComponent();
      group.setType(QuestionnaireItemType.GROUP);
      buildGroup(group, profile, profile.getSnapshot().getElement().get(0), profile.getSnapshot().getElement().get(0).getPath(), list, answerGroups);
    } else
      buildGroup(questionnaire.getItem().get(0), profile, profile.getSnapshot().getElement().get(0), profile.getSnapshot().getElement().get(0).getPath(), list, answerGroups);
    //
    //     NarrativeGenerator ngen = new NarrativeGenerator(context);
    //     ngen.generate(result);
    //
    //    if FResponse <> nil then
    //      FResponse.collapseAllContained;
  }

  private void processMetadata() {
    // todo: can we derive a more informative identifier from the questionnaire if we have a profile
    if (prebuiltQuestionnaire == null) {
      questionnaire.addIdentifier().setSystem("urn:ietf:rfc:3986").setValue(questionnaireId);
      questionnaire.setVersion(profile.getVersion());
      questionnaire.setStatus(profile.getStatus());
      questionnaire.setDate(profile.getDate());
      questionnaire.setPublisher(profile.getPublisher());
      Questionnaire.QuestionnaireItemComponent item = new Questionnaire.QuestionnaireItemComponent();
      questionnaire.addItem(item);
      item.setLinkId("meta");
      item.getCode().addAll(profile.getKeyword());
      questionnaire.setId(nextId("qgen-"+profile.getId()));
      questionnaire.setUrl(Utilities.pathURL(rootPath, "Questionnaire", questionnaire.getId()));
    }

    if (response != null) {
      // no identifier - this is transient
      response.setQuestionnaire("#"+questionnaire.getId());
      response.getContained().add(questionnaire);
      response.setStatus(QuestionnaireResponseStatus.INPROGRESS);
      QuestionnaireResponse.QuestionnaireResponseItemComponent item = new QuestionnaireResponse.QuestionnaireResponseItemComponent();
      response.addItem(item);
      item.setLinkId("meta");
      item.setUserData(UserDataNames.questionnaire_object, resource);
    }

  }

  private String nextId(String prefix) {
    lastid++;
    return prefix+Integer.toString(lastid);
  }

  private void buildGroup(QuestionnaireItemComponent group, StructureDefinition profile, ElementDefinition element, String path,
      List<ElementDefinition> parents, List<QuestionnaireResponse.QuestionnaireResponseItemComponent> answerGroups) throws FHIRException {
	  if (linkIds.contains(path)) {
	    return;
	  }
	  linkIds.add(path);
    group.setLinkId(path); // todo: this will be wrong when we start slicing
	  group.setText(element.getShort()); // todo - may need to prepend the name tail... 
	  if (element.getComment() != null) {
	  	Questionnaire.QuestionnaireItemComponent display = new Questionnaire.QuestionnaireItemComponent();
	  	display.setType(QuestionnaireItemType.DISPLAY);
	  	display.setText(element.getComment());
	  	group.addItem(display);
	  	display.setLinkId(element.getId()+"-display");
	  }
	  group.setType(QuestionnaireItemType.GROUP);
    ExtensionUtilities.addFlyOver(group, element.getDefinition(), element.getId()+"-flyover");
    group.setRequired(element.getMin() > 0);
    if (element.getMin() > 0)
      ExtensionUtilities.addMin(group, element.getMin());
    group.setRepeats(!element.getMax().equals("1"));
    if (!element.getMax().equals("*"))
      ExtensionUtilities.addMax(group, Integer.parseInt(element.getMax()));

    int i = 0;
    for (org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemComponent ag : answerGroups) {
      i++;
      ag.setLinkId(group.getLinkId()+i);
      ag.setText(group.getText());
    }

    // now, we iterate the children
    List<ElementDefinition> list = profileUtilities.getChildList(profile, element);
    for (ElementDefinition child : list) {

      if (!isExempt(element, child) && !parents.contains(child)) {
				List<ElementDefinition> nparents = new ArrayList<ElementDefinition>();
        nparents.addAll(parents);
        nparents.add(child);
        QuestionnaireItemComponent childGroup = group.addItem();
        childGroup.setLinkId(child.getId()+"-grp");
        childGroup.setType(QuestionnaireItemType.GROUP);

        List<QuestionnaireResponse.QuestionnaireResponseItemComponent> nResponse = new ArrayList<QuestionnaireResponse.QuestionnaireResponseItemComponent>();
        processExisting(child.getPath(), answerGroups, childGroup, nResponse);
        // if the element has a type, we add a question. else we add a group on the basis that
        // it will have children of its own
        if (child.getType().isEmpty() || isAbstractType(child.getType())) 
          buildGroup(childGroup, profile, child, path+"."+child.getName(), nparents, nResponse);
        else if (isInlineDataType(child.getType()))
          buildGroup(childGroup, profile, child, path+"."+child.getName(), nparents, nResponse); // todo: get the right children for this one...
        else
          buildQuestion(childGroup, profile, child, child.getPath(), nResponse, parents);
      }
    }
  }

  private boolean isAbstractType(List<TypeRefComponent> type) {
    return type.size() == 1 && (type.get(0).getWorkingCode().equals("Element") || type.get(0).getWorkingCode().equals("BackboneElement"));
  }

  private boolean isInlineDataType(List<TypeRefComponent> type) {
    return type.size() == 1 && !Utilities.existsInList(type.get(0).getWorkingCode(), "code", "string", "id", "oid", "markdown", "uri", "boolean", "decimal", "dateTime", "date", "instant", "time", "CodeableConcept", "Period", "Ratio",
        "HumanName", "Address", "ContactPoint", "Identifier", "integer", "positiveInt", "unsignedInt", "Coding", "Quantity",  "Count",  "Age",  "Duration", 
        "Distance",  "Money", "Money", "Reference", "Duration", "base64Binary", "Attachment", "Age", "Range", "Timing", "Annotation", "SampledData", "Extension",
        "SampledData", "Narrative", "Resource", "Meta", "url", "canonical");
  }

  private boolean isExempt(ElementDefinition element, ElementDefinition child) {
    String n = tail(child.getPath());
    String t = "";
    if (!element.getType().isEmpty())
      t =  element.getType().get(0).getWorkingCode();

    // we don't generate questions for the base stuff in every element
    if (t.equals("Resource")  && (n.equals("text") || n.equals("language") || n.equals("contained")))
      return true;
      // we don't generate questions for extensions
    else if (n.equals("extension") || n.equals("modifierExtension")) {
      if (child.getType().size() > 0 && !child.getType().get(0).hasProfile()) 
      return false;
      else
        return true;
    } else
      return false;
  }

  private String tail(String path) {
    return path.substring(path.lastIndexOf('.')+1);
  }

  private void processExisting(String path, List<QuestionnaireResponse.QuestionnaireResponseItemComponent> answerGroups, QuestionnaireItemComponent item, List<QuestionnaireResponse.QuestionnaireResponseItemComponent> nResponse) throws FHIRException {
    // processing existing data
    for (QuestionnaireResponse.QuestionnaireResponseItemComponent ag : answerGroups) {
      List<Base> children = ((Element) ag.getUserData(UserDataNames.questionnaire_object)).listChildrenByName(tail(path));
      for (Base child : children) {
        if (child != null) {
          QuestionnaireResponse.QuestionnaireResponseItemComponent ans = ag.addItem();
          ag.setLinkId(item.getLinkId());
          ans.setUserData(UserDataNames.questionnaire_object, child);
          nResponse.add(ans);
        }
      }
    }
  }

  private void buildQuestion(QuestionnaireItemComponent group, StructureDefinition profile, ElementDefinition element, String path, List<QuestionnaireResponse.QuestionnaireResponseItemComponent> answerGroups, List<ElementDefinition> parents) throws FHIRException {
      group.setLinkId(path);

      // in this context, we don't have any concepts to mark...
      group.setText(element.getShort()); // prefix with name?
      group.setRequired(element.getMin() > 0);
	    if (element.getMin() > 0)
	    	ExtensionUtilities.addMin(group, element.getMin());
      group.setRepeats(!element.getMax().equals('1'));
	    if (!element.getMax().equals("*"))
	    	ExtensionUtilities.addMax(group, Integer.parseInt(element.getMax()));

      for (QuestionnaireResponse.QuestionnaireResponseItemComponent ag : answerGroups) {
        ag.setLinkId(group.getLinkId());
        ag.setText(group.getText());
      }

      if (!Utilities.noString(element.getComment())) 
        ExtensionUtilities.addFlyOver(group, element.getDefinition()+" "+element.getComment(), group.getLinkId()+"-flyover");
      else
        ExtensionUtilities.addFlyOver(group, element.getDefinition(), group.getLinkId()+"-flyover");

      if (element.getType().size() > 1 || element.getType().get(0).getWorkingCode().equals("*")) {
        List<TypeRefComponent> types = expandTypeList(element.getType());
        Questionnaire.QuestionnaireItemComponent q = addQuestion(group, QuestionnaireItemType.CODING, QuestionnaireAnswerConstraint.OPTIONSONLY, element.getPath(), "_type", "type", null, makeTypeList(profile, types, element.getPath()));
          for (TypeRefComponent t : types) {
            Questionnaire.QuestionnaireItemComponent sub = q.addItem();
            sub.setType(QuestionnaireItemType.GROUP);
            sub.setLinkId(element.getPath()+"._"+t.getUserData(UserDataNames.questionnaire_text));
            sub.setText((String) t.getUserData(UserDataNames.questionnaire_text));
            // always optional, never repeats

            List<QuestionnaireResponse.QuestionnaireResponseItemComponent> selected = new ArrayList<QuestionnaireResponse.QuestionnaireResponseItemComponent>();
            selectTypes(profile, sub, t, answerGroups, selected);
            processDataType(profile, sub, element, element.getPath()+"._"+t.getUserData(UserDataNames.questionnaire_text), t, selected, parents);
          }
      } else
        // now we have to build the question panel for each different data type
        processDataType(profile, group, element, element.getPath(), element.getType().get(0), answerGroups, parents);

  }

  private List<TypeRefComponent> expandTypeList(List<TypeRefComponent> types) {
	  List<TypeRefComponent> result = new ArrayList<TypeRefComponent>();
    for (TypeRefComponent t : types) {
	    if (t.hasProfile())
        result.add(t);
	    else if (t.getWorkingCode().equals("*")) {
	      result.add(new TypeRefComponent().setCode("integer"));
	      result.add(new TypeRefComponent().setCode("decimal"));
	      result.add(new TypeRefComponent().setCode("dateTime"));
	      result.add(new TypeRefComponent().setCode("date"));
	      result.add(new TypeRefComponent().setCode("instant"));
	      result.add(new TypeRefComponent().setCode("time"));
	      result.add(new TypeRefComponent().setCode("string"));
	      result.add(new TypeRefComponent().setCode("uri"));
	      result.add(new TypeRefComponent().setCode("boolean"));
	      result.add(new TypeRefComponent().setCode("Coding"));
	      result.add(new TypeRefComponent().setCode("CodeableConcept"));
	      result.add(new TypeRefComponent().setCode("Attachment"));
	      result.add(new TypeRefComponent().setCode("Identifier"));
	      result.add(new TypeRefComponent().setCode("Quantity"));
	      result.add(new TypeRefComponent().setCode("Range"));
	      result.add(new TypeRefComponent().setCode("Period"));
	      result.add(new TypeRefComponent().setCode("Ratio"));
	      result.add(new TypeRefComponent().setCode("HumanName"));
	      result.add(new TypeRefComponent().setCode("Address"));
        result.add(new TypeRefComponent().setCode("ContactPoint"));
        result.add(new TypeRefComponent().setCode("Timing"));
	      result.add(new TypeRefComponent().setCode("Reference"));
      } else
        result.add(t);
    }
    return result;
  }

  private ValueSet makeTypeList(StructureDefinition profile, List<TypeRefComponent> types, String path) {
    ValueSet vs = new ValueSet();
    vs.setName("Type options for "+path);
    vs.setDescription(vs.present());
	  vs.setStatus(PublicationStatus.ACTIVE);
    vs.setExpansion(new ValueSetExpansionComponent());
    vs.getExpansion().setIdentifier(Factory.createUUID());
    vs.getExpansion().setTimestampElement(DateTimeType.now());
    for (TypeRefComponent t : types) {
      if (t.hasTarget()) {
        for (UriType u : t.getTargetProfile()) {
	        if (u.getValue().startsWith("http://hl7.org/fhir/StructureDefinition/")) { 
	          ValueSetExpansionContainsComponent cc = vs.getExpansion().addContains();
    	      cc.setCode(u.getValue().substring(40));
            cc.setSystem("http://hl7.org/fhir/fhir-types");
    	      cc.setDisplay(cc.getCode());
	        }
        }
      } else if (!t.hasProfile()) {
        ValueSetExpansionContainsComponent cc = vs.getExpansion().addContains();
        cc.setCode(t.getWorkingCode());
        cc.setDisplay(t.getWorkingCode());
        cc.setSystem("http://hl7.org/fhir/fhir-types");
      } else for (UriType u : t.getProfile()) {
        ProfileUtilities pu = new ProfileUtilities(context, null, null);
        StructureDefinition ps = pu.getProfile(profile, u.getValue());
        if (ps != null) {
          ValueSetExpansionContainsComponent cc = vs.getExpansion().addContains();
	        cc.setCode(u.getValue());
          cc.setDisplay(ps.getType());
          cc.setSystem("http://hl7.org/fhir/fhir-types");
        }
      }
    }

    return vs;
  }

  private void selectTypes(StructureDefinition profile, QuestionnaireItemComponent sub, TypeRefComponent t, List<QuestionnaireResponse.QuestionnaireResponseItemComponent> source, List<QuestionnaireResponse.QuestionnaireResponseItemComponent> dest) throws FHIRFormatError {
    List<QuestionnaireResponse.QuestionnaireResponseItemComponent> temp = new ArrayList<QuestionnaireResponse.QuestionnaireResponseItemComponent>();

    for (QuestionnaireResponse.QuestionnaireResponseItemComponent g : source)
      if (instanceOf(t, (Element) g.getUserData(UserDataNames.questionnaire_object))) 
        temp.add(g);
    for (QuestionnaireResponse.QuestionnaireResponseItemComponent g : temp)
      source.remove(g);
    for (QuestionnaireResponse.QuestionnaireResponseItemComponent g : temp) {
      // 1st the answer:
      assert(g.getItem().size() == 0); // it should be empty
      QuestionnaireResponse.QuestionnaireResponseItemComponent q = g.addItem();
      q.setLinkId(g.getLinkId()+"._type");
      q.setText("type");

      QuestionnaireResponseItemAnswerComponent a = q.addAnswer();
      if (t.hasTarget()) {
        for (UriType u : t.getTargetProfile()) {
          if (u.getValue().startsWith("http://hl7.org/fhir/StructureDefinition/")) {
            Coding cc = new Coding();
            a.setValue(cc);
            cc.setCode(u.getValue().substring(40));
            cc.setSystem("http://hl7.org/fhir/fhir-types");
          }
        }
      } else {
        Coding cc = new Coding();
        a.setValue(cc);
        ProfileUtilities pu = new ProfileUtilities(context, null, null);
        StructureDefinition ps = null;
        if (t.hasProfile())
          ps = pu.getProfile(profile, t.getProfile().get(0).getValue());

        if (ps != null) {
          cc.setCode(t.getProfile().get(0).getValue());
          cc.setSystem("http://hl7.org/fhir/fhir-types");
        } else {
          cc.setCode(t.getWorkingCode());
          cc.setSystem("http://hl7.org/fhir/fhir-types");
        }
      }

      // 1st: create the subgroup
      QuestionnaireResponse.QuestionnaireResponseItemComponent subg = a.addItem();
      dest.add(subg);
      subg.setLinkId(sub.getLinkId());
      subg.setText(sub.getText());
      subg.setUserData(UserDataNames.questionnaire_object, g.getUserData(UserDataNames.questionnaire_object));
    }
  }

  private boolean instanceOf(TypeRefComponent t, Element obj) {
    if (t.getWorkingCode().equals("Reference")) {
      if (!(obj instanceof Reference)) {
        return false;
      } else {
        String url = ((Reference) obj).getReference();
        // there are several problems here around profile matching. This process is degenerative, and there's probably nothing we can do to solve it
        if (url.startsWith("http:") || url.startsWith("https:"))
            return true;
        else if (t.hasProfile() && t.getProfile().get(0).getValue().startsWith("http://hl7.org/fhir/StructureDefinition/")) 
          return url.startsWith(t.getProfile().get(0).getValue().substring(40)+'/');
        else
          return true;
      }
    } else if (t.getWorkingCode().equals("Quantity")) {
      return obj instanceof Quantity;
    } else
      throw new NotImplementedException("Not Done Yet");
  }

  private QuestionnaireItemComponent addQuestion(QuestionnaireItemComponent group, QuestionnaireItemType af, QuestionnaireAnswerConstraint constraint, String path, String id, String name, List<QuestionnaireResponse.QuestionnaireResponseItemComponent> answerGroups) throws FHIRException {
    return addQuestion(group, af, constraint, path, id, name, answerGroups, null);
  }
  
  private QuestionnaireItemComponent addQuestion(QuestionnaireItemComponent group, QuestionnaireItemType af, QuestionnaireAnswerConstraint constraint, String path, String id, String name, List<QuestionnaireResponse.QuestionnaireResponseItemComponent> answerGroups, ValueSet vs) throws FHIRException {
    QuestionnaireItemComponent result = group.addItem();
    if (vs != null) {
      if (vs.getExpansion() == null) {
        result.setAnswerValueSet(vs.getUrl());
        ExtensionUtilities.addControl(result, "lookup"); 
      } else {
        if (Utilities.noString(vs.getId())) {
          vs.setId(nextId("vs"));
          questionnaire.getContained().add(vs);
          vsCache.put(vs.getUrl(), vs.getId());
          vs.setText(null);
          vs.setCompose(null);
          vs.getContact().clear();
          vs.setPublisherElement(null);
          vs.setCopyrightElement(null);
        }
        result.setAnswerValueSet("#"+vs.getId());
      }
    }
  
    result.setLinkId(path+'.'+id);
    result.setText(name);
    result.setType(af);
    result.setAnswerConstraint(constraint);
    result.setRequired(false);
    result.setRepeats(false);
    if (id.endsWith("/1")) 
      id = id.substring(0, id.length()-2);

    if (answerGroups != null) {

      for (QuestionnaireResponse.QuestionnaireResponseItemComponent ag : answerGroups) {
        List<Base> children = new ArrayList<Base>(); 

        QuestionnaireResponse.QuestionnaireResponseItemComponent aq = null;
        Element obj = (Element) ag.getUserData(UserDataNames.questionnaire_object);
        if (isPrimitive((TypeRefComponent) obj))
          children.add(obj);
        else if (obj instanceof Enumeration) {
          String value = ((Enumeration) obj).toString();
          children.add(new StringType(value));
        } else
          children = obj.listChildrenByName(id);

        for (Base child: children) {
          if (child != null) {
            if (aq == null) {
              aq = ag.addItem();
              aq.setLinkId(result.getLinkId());
              aq.setText(result.getText());
            }
            aq.addAnswer().setValue(convertType(child, af, vs, result.getLinkId()));
          }
        }
      }
    }
    return result;
  }

  @SuppressWarnings("unchecked")
  private DataType convertType(Base value, QuestionnaireItemType af, ValueSet vs, String path) throws FHIRException {
    switch (af) {
      // simple cases
    case BOOLEAN: if (value instanceof BooleanType) return (DataType) value; break;
    case DECIMAL: if (value instanceof DecimalType) return (DataType) value; break;
    case INTEGER: if (value instanceof IntegerType) return (DataType) value; break;
    case DATE: if (value instanceof DateType) return (DataType) value; break;
    case DATETIME: if (value instanceof DateTimeType) return (DataType) value; break;
    case TIME: if (value instanceof TimeType) return (DataType) value; break;
    case STRING:
      if (value instanceof StringType) 
        return (DataType) value;
      else if (value instanceof UriType) 
        return new StringType(((UriType) value).asStringValue());
		break;
    case TEXT: if (value instanceof StringType) return (DataType) value; break;
    case QUANTITY: if (value instanceof  Quantity) return (DataType) value; break;

    // complex cases:
    // ? QuestionnaireItemTypeAttachment: ...?
    case CODING:
      if (value instanceof Coding)
        return (DataType) value;
      else if (value instanceof Enumeration) { 
        Coding cc = new Coding();
        cc.setCode(((Enumeration<Enum<?>>) value).asStringValue());
        cc.setSystem(getSystemForCode(vs, cc.getCode(), path));
        return cc;
      }  else if (value instanceof StringType) {
        Coding cc = new Coding();
        cc.setCode(((StringType) value).asStringValue());
        cc.setSystem(getSystemForCode(vs, cc.getCode(), path));
        return cc;
      }
		break;

    case REFERENCE:
      if (value instanceof Reference)
        return (DataType) value;
      else if (value instanceof StringType) {
        Reference r = new Reference();
        r.setReference(((StringType) value).asStringValue());
      }
		break;
	 default:
		break;
    }

    throw new FHIRException("Unable to convert from '"+value.getClass().toString()+"' for Answer Format "+af.toCode()+", path = "+path);
  }

  private String getSystemForCode(ValueSet vs, String code, String path) throws FHIRException {
//    var
//    i, q : integer;
//  begin
    String result = null;
    if (vs == null) {
      if (prebuiltQuestionnaire == null) 
        throw new FHIRException("Logic error at path = "+path);
      for (Resource r : prebuiltQuestionnaire.getContained()) {
        if (r instanceof ValueSet) {
          vs = (ValueSet) r;
          if (vs.hasExpansion()) {
            for (ValueSetExpansionContainsComponent c : vs.getExpansion().getContains()) {
              if (c.getCode().equals(code)) {
                  if (result == null)
                    result = c.getSystem();
                  else
                    throw new FHIRException("Multiple matches in "+vs.getUrl()+" for code "+code+" at path = "+path);
              }
            }
          }
        }
      }
    }
    
    for (ValueSetExpansionContainsComponent c : vs.getExpansion().getContains()) {
      if (c.getCode().equals(code)) {
        if (result == null)
          result = c.getSystem();
        else
          throw new FHIRException("Multiple matches in "+vs.getUrl()+" for code "+code+" at path = "+path);
      }
    }
    if (result != null)
      return result;
    throw new FHIRException("Unable to resolve code "+code+" at path = "+path);
  }

  private boolean isPrimitive(TypeRefComponent t) {
    String code = t.getWorkingCode();
    StructureDefinition sd = context.fetchTypeDefinition(code);
    return sd != null && sd.getKind() == StructureDefinitionKind.PRIMITIVETYPE;
  }

  private void processDataType(StructureDefinition profile, QuestionnaireItemComponent group, ElementDefinition element, String path, TypeRefComponent t, List<QuestionnaireResponse.QuestionnaireResponseItemComponent> answerGroups, List<ElementDefinition> parents) throws FHIRException {
    String tc = t.getWorkingCode();
    if (tc.equals("code"))
      addCodeQuestions(group, element, path, answerGroups);
    else if (Utilities.existsInList(tc, "string", "id", "oid", "uuid", "markdown"))
      addStringQuestions(group, element, path, answerGroups);
    else if (Utilities.existsInList(tc, "uri", "url", "canonical"))
      addUriQuestions(group, element, path, answerGroups);
    else if (tc.equals("boolean"))
      addBooleanQuestions(group, element, path, answerGroups);
    else if (tc.equals("decimal"))
      addDecimalQuestions(group, element, path, answerGroups);
    else if (tc.equals("dateTime") || tc.equals("date"))
        addDateTimeQuestions(group, element, path, answerGroups);
    else if (tc.equals("instant"))
      addInstantQuestions(group, element, path, answerGroups);
    else if (tc.equals("time"))
      addTimeQuestions(group, element, path, answerGroups);
    else if (tc.equals("CodeableConcept"))
      addCodeableConceptQuestions(group, element, path, answerGroups);
    else if (tc.equals("Period"))
      addPeriodQuestions(group, element, path, answerGroups);
    else if (tc.equals("Ratio"))
      addRatioQuestions(group, element, path, answerGroups);
    else if (tc.equals("HumanName"))
      addHumanNameQuestions(group, element, path, answerGroups);
    else if (tc.equals("Address"))
      addAddressQuestions(group, element, path, answerGroups);
    else if (tc.equals("ContactPoint"))
      addContactPointQuestions(group, element, path, answerGroups);
    else if (tc.equals("Identifier"))
      addIdentifierQuestions(group, element, path, answerGroups);
    else if (tc.equals("integer") || tc.equals("positiveInt") || tc.equals("unsignedInt") )
      addIntegerQuestions(group, element, path, answerGroups);
    else if (tc.equals("Coding"))
      addCodingQuestions(group, element, path, answerGroups);
    else if (Utilities.existsInList(tc, "Quantity", "Count", "Age", "Duration", "Distance", "Money"))
      addQuantityQuestions(group, element, path, answerGroups);
    else if (tc.equals("Money"))
      addMoneyQuestions(group, element, path, answerGroups);
    else if (tc.equals("Reference"))
      addReferenceQuestions(group, element, path, t.getTargetProfile(), answerGroups);
    else if (tc.equals("Duration"))
      addDurationQuestions(group, element, path, answerGroups);
    else if (tc.equals("base64Binary"))
      addBinaryQuestions(group, element, path, answerGroups);
    else if (tc.equals("Attachment"))
      addAttachmentQuestions(group, element, path, answerGroups);
    else if (tc.equals("Age"))
      addAgeQuestions(group, element, path, answerGroups);
    else if (tc.equals("Range"))
      addRangeQuestions(group, element, path, answerGroups);
    else if (tc.equals("Timing"))
      addTimingQuestions(group, element, path, answerGroups);
    else if (tc.equals("Annotation"))
      addAnnotationQuestions(group, element, path, answerGroups);
    else if (tc.equals("SampledData"))
      addSampledDataQuestions(group, element, path, answerGroups);
    else if (tc.equals("Extension")) {
      if (t.hasProfile())
        addExtensionQuestions(profile, group, element, path, t.getProfile().get(0).getValue(), answerGroups, parents);
    } else if (tc.equals("SampledData"))
      addSampledDataQuestions(group, element, path, answerGroups);
    else if (!tc.equals("Narrative") && !tc.equals("Resource") && !tc.equals("Meta") && !tc.equals("Signature")) {
      StructureDefinition sd = context.fetchTypeDefinition(tc);
      if (sd == null)
        throw new NotImplementedException("Unhandled Data Type: "+tc+" on element "+element.getPath());
      buildGroup(group, sd, sd.getSnapshot().getElementFirstRep(), path+"."+sd.getSnapshot().getElementFirstRep().getPath(), parents, answerGroups);
    }
  }

  private void addCodeQuestions(QuestionnaireItemComponent group, ElementDefinition element, String path, List<QuestionnaireResponse.QuestionnaireResponseItemComponent> answerGroups) throws FHIRException {
    ExtensionUtilities.addFhirType(group, "code");
    ValueSet vs = resolveValueSet(null, element.hasBinding() ? element.getBinding() : null);
    addQuestion(group, QuestionnaireItemType.CODING, constraintTypeForBinding(element.getBinding()), path, "value", unCamelCase(tail(element.getPath())), answerGroups, vs);
    group.setText(null);
    for (QuestionnaireResponse.QuestionnaireResponseItemComponent ag : answerGroups)
      ag.setText(null);
  }

  private String unCamelCase(String s) {
    StringBuilder result = new StringBuilder();
    
      for (int i = 0; i < s.length(); i++) {
        if (Character.isUpperCase(s.charAt(i))) 
          result.append(' ');
        result.append(s.charAt(i));
      }
      return result.toString().toLowerCase();
  }

  private void addStringQuestions(QuestionnaireItemComponent group, ElementDefinition element, String path, List<QuestionnaireResponse.QuestionnaireResponseItemComponent> answerGroups) throws FHIRException {
    ExtensionUtilities.addFhirType(group, "string");
    addQuestion(group, QuestionnaireItemType.STRING, null, path, "value", group.getText(), answerGroups);
	  group.setText(null);
    for (QuestionnaireResponse.QuestionnaireResponseItemComponent ag : answerGroups)
      ag.setText(null);
  }

  private void addTimeQuestions(QuestionnaireItemComponent group, ElementDefinition element, String path, List<QuestionnaireResponse.QuestionnaireResponseItemComponent> answerGroups) throws FHIRException {
    ExtensionUtilities.addFhirType(group, "time");
    addQuestion(group, QuestionnaireItemType.TIME, null, path, "value", group.getText(), answerGroups);
	  group.setText(null);
    for (QuestionnaireResponse.QuestionnaireResponseItemComponent ag : answerGroups)
      ag.setText(null);
  }

  private void addUriQuestions(QuestionnaireItemComponent group, ElementDefinition element, String path, List<QuestionnaireResponse.QuestionnaireResponseItemComponent> answerGroups) throws FHIRException {
    ExtensionUtilities.addFhirType(group, "uri");
    addQuestion(group, QuestionnaireItemType.STRING, null, path, "value", group.getText(), answerGroups);
	  group.setText(null);
    for (QuestionnaireResponse.QuestionnaireResponseItemComponent ag : answerGroups)
      ag.setText(null);
  }

  private void addBooleanQuestions(QuestionnaireItemComponent group, ElementDefinition element, String path, List<QuestionnaireResponse.QuestionnaireResponseItemComponent> answerGroups) throws FHIRException {
    ExtensionUtilities.addFhirType(group, "boolean");
    addQuestion(group, QuestionnaireItemType.BOOLEAN, null, path, "value", group.getText(), answerGroups);
	  group.setText(null);
    for (QuestionnaireResponse.QuestionnaireResponseItemComponent ag : answerGroups)
      ag.setText(null);
  }

  private void addDecimalQuestions(QuestionnaireItemComponent group, ElementDefinition element, String path, List<QuestionnaireResponse.QuestionnaireResponseItemComponent> answerGroups) throws FHIRException {
    ExtensionUtilities.addFhirType(group, "decimal");
    addQuestion(group, QuestionnaireItemType.DECIMAL, null, path, "value", group.getText(), answerGroups);
	  group.setText(null);
    for (QuestionnaireResponse.QuestionnaireResponseItemComponent ag : answerGroups)
      ag.setText(null);
  }

  private void addIntegerQuestions(QuestionnaireItemComponent group, ElementDefinition element, String path, List<QuestionnaireResponse.QuestionnaireResponseItemComponent> answerGroups) throws FHIRException {
    ExtensionUtilities.addFhirType(group, "integer");
    addQuestion(group, QuestionnaireItemType.INTEGER, null, path, "value", group.getText(), answerGroups);
	  group.setText(null);
    for (QuestionnaireResponse.QuestionnaireResponseItemComponent ag : answerGroups)
      ag.setText(null);
  }

  private void addDateTimeQuestions(QuestionnaireItemComponent group, ElementDefinition element, String path, List<QuestionnaireResponse.QuestionnaireResponseItemComponent> answerGroups) throws FHIRException {
    ExtensionUtilities.addFhirType(group, "datetime");
    addQuestion(group, QuestionnaireItemType.DATETIME, null, path, "value", group.getText(), answerGroups);
	  group.setText(null);
    for (QuestionnaireResponse.QuestionnaireResponseItemComponent ag : answerGroups)
      ag.setText(null);
  }

  private void addInstantQuestions(QuestionnaireItemComponent group, ElementDefinition element, String path, List<QuestionnaireResponse.QuestionnaireResponseItemComponent> answerGroups) throws FHIRException {
    ExtensionUtilities.addFhirType(group, "instant");
    addQuestion(group, QuestionnaireItemType.DATETIME, null, path, "value", group.getText(), answerGroups);
	  group.setText(null);
    for (QuestionnaireResponse.QuestionnaireResponseItemComponent ag : answerGroups)
      ag.setText(null);
  }

  private void addBinaryQuestions(QuestionnaireItemComponent group, ElementDefinition element, String path, List<QuestionnaireResponse.QuestionnaireResponseItemComponent> answerGroups) {
    ExtensionUtilities.addFhirType(group, "binary");
    // ? Lloyd: how to support binary content
  }
  
  // Complex Types ---------------------------------------------------------------

  private QuestionnaireAnswerConstraint constraintTypeForBinding(ElementDefinitionBindingComponent binding) {
    if (binding == null) 
      return null;
    else if (binding.getStrength() != BindingStrength.REQUIRED) 
      return QuestionnaireAnswerConstraint.OPTIONSONLY;
    else
      return QuestionnaireAnswerConstraint.OPTIONSORTYPE; 
  }

  private void addCodingQuestions(QuestionnaireItemComponent group, ElementDefinition element, String path, List<QuestionnaireResponse.QuestionnaireResponseItemComponent> answerGroups) throws FHIRException {
    ExtensionUtilities.addFhirType(group, "Coding");
    addQuestion(group, QuestionnaireItemType.CODING, constraintTypeForBinding(element.getBinding()), path, "value", group.getText(), answerGroups, resolveValueSet(null, element.hasBinding() ? element.getBinding() : null));
    group.setText(null);
    for (QuestionnaireResponse.QuestionnaireResponseItemComponent ag : answerGroups)
      ag.setText(null);
  }

  private void addCodeableConceptQuestions(QuestionnaireItemComponent group, ElementDefinition element, String path, List<QuestionnaireResponse.QuestionnaireResponseItemComponent> answerGroups) throws FHIRException {
    ExtensionUtilities.addFhirType(group, "CodeableConcept");
    addQuestion(group, QuestionnaireItemType.CODING, constraintTypeForBinding(element.getBinding()), path, "coding", "code:", answerGroups, resolveValueSet(null, element.hasBinding() ? element.getBinding() : null));
    addQuestion(group, QuestionnaireItemType.STRING, null, path, "text", "text:", answerGroups);
  }

  private ValueSet makeAnyValueSet() {
    // TODO Auto-generated method stub
    return null;
  }

  private void addPeriodQuestions(QuestionnaireItemComponent group, ElementDefinition element, String path, List<QuestionnaireResponse.QuestionnaireResponseItemComponent> answerGroups) throws FHIRException {
    ExtensionUtilities.addFhirType(group, "Period");
    addQuestion(group, QuestionnaireItemType.DATETIME, null, path, "low", "start:", answerGroups);
    addQuestion(group, QuestionnaireItemType.DATETIME, null, path, "end", "end:", answerGroups);
  }

  private void addRatioQuestions(QuestionnaireItemComponent group, ElementDefinition element, String path, List<QuestionnaireResponse.QuestionnaireResponseItemComponent> answerGroups) throws FHIRException {
    ExtensionUtilities.addFhirType(group, "Ratio");
    addQuestion(group, QuestionnaireItemType.DECIMAL, null, path, "numerator", "numerator:", answerGroups);
    addQuestion(group, QuestionnaireItemType.DECIMAL, null, path, "denominator", "denominator:", answerGroups);
    addQuestion(group, QuestionnaireItemType.STRING, null, path, "units", "units:", answerGroups);
  }

  private void addHumanNameQuestions(QuestionnaireItemComponent group, ElementDefinition element, String path, List<QuestionnaireResponse.QuestionnaireResponseItemComponent> answerGroups) throws FHIRException {
    ExtensionUtilities.addFhirType(group, "Name");
    addQuestion(group, QuestionnaireItemType.STRING, null, path, "text", "text:", answerGroups);
    addQuestion(group, QuestionnaireItemType.STRING, null, path, "family", "family:", answerGroups).setRepeats(true);
    addQuestion(group, QuestionnaireItemType.STRING, null, path, "given", "given:", answerGroups).setRepeats(true);
  }

  private void addAddressQuestions(QuestionnaireItemComponent group, ElementDefinition element, String path, List<QuestionnaireResponse.QuestionnaireResponseItemComponent> answerGroups) throws FHIRException {
    ExtensionUtilities.addFhirType(group, "Address");
    addQuestion(group, QuestionnaireItemType.STRING, null, path, "text", "text:", answerGroups);
    addQuestion(group, QuestionnaireItemType.STRING, null, path, "line", "line:", answerGroups).setRepeats(true);
    addQuestion(group, QuestionnaireItemType.STRING, null, path, "city", "city:", answerGroups);
    addQuestion(group, QuestionnaireItemType.STRING, null, path, "state", "state:", answerGroups);
    addQuestion(group, QuestionnaireItemType.STRING, null, path, "postalCode", "post code:", answerGroups);
    addQuestion(group, QuestionnaireItemType.STRING, null, path, "country", "country:", answerGroups);
    addQuestion(group, QuestionnaireItemType.CODING, QuestionnaireAnswerConstraint.OPTIONSONLY, path, "use", "use:", answerGroups, resolveValueSet("http://hl7.org/fhir/vs/address-use"));
  }

    private void addContactPointQuestions(QuestionnaireItemComponent group, ElementDefinition element, String path, List<QuestionnaireResponse.QuestionnaireResponseItemComponent> answerGroups) throws FHIRException {
    ExtensionUtilities.addFhirType(group, "ContactPoint");
    addQuestion(group, QuestionnaireItemType.CODING, QuestionnaireAnswerConstraint.OPTIONSONLY, path, "system", "type:", answerGroups, resolveValueSet("http://hl7.org/fhir/vs/contact-point-system"));
    addQuestion(group, QuestionnaireItemType.STRING, null, path, "value", "value:", answerGroups);
    addQuestion(group, QuestionnaireItemType.CODING, QuestionnaireAnswerConstraint.OPTIONSONLY, path, "use", "use:", answerGroups, resolveValueSet("http://hl7.org/fhir/vs/contact-point-use"));
    }
    
    private void addIdentifierQuestions(QuestionnaireItemComponent group, ElementDefinition element, String path, List<QuestionnaireResponse.QuestionnaireResponseItemComponent> answerGroups) throws FHIRException {
      ExtensionUtilities.addFhirType(group, "Identifier");
      addQuestion(group, QuestionnaireItemType.STRING, null, path, "label", "label:", answerGroups);
      addQuestion(group, QuestionnaireItemType.STRING, null, path, "system", "system:", answerGroups);
      addQuestion(group, QuestionnaireItemType.STRING, null, path, "value", "value:", answerGroups);
    }

    private void addSimpleQuantityQuestions(QuestionnaireItemComponent group, ElementDefinition element, String path, List<QuestionnaireResponse.QuestionnaireResponseItemComponent> answerGroups) throws FHIRException {
      ExtensionUtilities.addFhirType(group, "Quantity");
      addQuestion(group, QuestionnaireItemType.DECIMAL, null, path, "value", "value:", answerGroups);
      addQuestion(group, QuestionnaireItemType.STRING, null, path, "units", "units:", answerGroups);
      addQuestion(group, QuestionnaireItemType.STRING, null, path, "code", "coded units:", answerGroups);
      addQuestion(group, QuestionnaireItemType.STRING, null, path, "system", "units system:", answerGroups);
    }

    private void addQuantityQuestions(QuestionnaireItemComponent group, ElementDefinition element, String path, List<QuestionnaireResponse.QuestionnaireResponseItemComponent> answerGroups) throws FHIRException {
      ExtensionUtilities.addFhirType(group, "Quantity");
      addQuestion(group, QuestionnaireItemType.CODING, QuestionnaireAnswerConstraint.OPTIONSONLY, path, "comparator", "comp:", answerGroups, resolveValueSet("http://hl7.org/fhir/vs/quantity-comparator"));
      addQuestion(group, QuestionnaireItemType.DECIMAL, null, path, "value", "value:", answerGroups);
      addQuestion(group, QuestionnaireItemType.STRING, null, path, "units", "units:", answerGroups);
      addQuestion(group, QuestionnaireItemType.STRING, null, path, "code", "coded units:", answerGroups);
      addQuestion(group, QuestionnaireItemType.STRING, null, path, "system", "units system:", answerGroups);
    }

    private void addMoneyQuestions(QuestionnaireItemComponent group, ElementDefinition element, String path, List<QuestionnaireResponse.QuestionnaireResponseItemComponent> answerGroups) throws FHIRException {
      ExtensionUtilities.addFhirType(group, "Money");
      addQuestion(group, QuestionnaireItemType.DECIMAL, null, path, "value", "value:", answerGroups);
      addQuestion(group, QuestionnaireItemType.STRING, null, path, "currency", "currency:", answerGroups);
  }

    private void addAgeQuestions(QuestionnaireItemComponent group, ElementDefinition element, String path, List<QuestionnaireResponse.QuestionnaireResponseItemComponent> answerGroups) throws FHIRException {
      ExtensionUtilities.addFhirType(group, "Age");
      addQuestion(group, QuestionnaireItemType.CODING, QuestionnaireAnswerConstraint.OPTIONSONLY, path, "comparator", "comp:", answerGroups, resolveValueSet("http://hl7.org/fhir/vs/quantity-comparator"));
      addQuestion(group, QuestionnaireItemType.DECIMAL, null, path, "value", "value:", answerGroups);
      addQuestion(group, QuestionnaireItemType.CODING, QuestionnaireAnswerConstraint.OPTIONSONLY, path, "units", "units:", answerGroups, resolveValueSet("http://hl7.org/fhir/vs/duration-units"));
    }

    private void addDurationQuestions(QuestionnaireItemComponent group, ElementDefinition element, String path, List<QuestionnaireResponse.QuestionnaireResponseItemComponent> answerGroups) throws FHIRException {
      ExtensionUtilities.addFhirType(group, "Duration");
      addQuestion(group, QuestionnaireItemType.DECIMAL, null, path, "value", "value:", answerGroups);
      addQuestion(group, QuestionnaireItemType.STRING, null, path, "units", "units:", answerGroups);
    }

    private void addAttachmentQuestions(QuestionnaireItemComponent group, ElementDefinition element, String path, List<QuestionnaireResponse.QuestionnaireResponseItemComponent> answerGroups) {
      ExtensionUtilities.addFhirType(group, "Attachment");
      //    raise Exception.Create("addAttachmentQuestions not Done Yet");
    }

    private void addRangeQuestions(QuestionnaireItemComponent group, ElementDefinition element, String path, List<QuestionnaireResponse.QuestionnaireResponseItemComponent> answerGroups) throws FHIRException {
      ExtensionUtilities.addFhirType(group, "Range");
      addQuestion(group, QuestionnaireItemType.DECIMAL, null, path, "low", "low:", answerGroups);
      addQuestion(group, QuestionnaireItemType.DECIMAL, null, path, "high", "high:", answerGroups);
      addQuestion(group, QuestionnaireItemType.STRING, null, path, "units", "units:", answerGroups);
    }
    
    private void addSampledDataQuestions(QuestionnaireItemComponent group, ElementDefinition element, String path, List<QuestionnaireResponse.QuestionnaireResponseItemComponent> answerGroups) {
      ExtensionUtilities.addFhirType(group, "SampledData");
    }
    
    private void addTimingQuestions(QuestionnaireItemComponent group, ElementDefinition element, String path, List<QuestionnaireResponse.QuestionnaireResponseItemComponent> answerGroups) throws FHIRException {
      ExtensionUtilities.addFhirType(group, "Schedule");
      addQuestion(group, QuestionnaireItemType.STRING, null, path, "text", "text:", answerGroups);
      addQuestion(group, QuestionnaireItemType.DATETIME, null, path, "date", "date:", answerGroups);
      QuestionnaireItemComponent q = addQuestion(group, QuestionnaireItemType.REFERENCE, null, path, "author", "author:", answerGroups);
      ExtensionUtilities.addAllowedResource(q, "Patient");
      ExtensionUtilities.addAllowedResource(q, "Practitioner");
      ExtensionUtilities.addAllowedResource(q, "RelatedPerson");
    }
    
    private void addAnnotationQuestions(QuestionnaireItemComponent group, ElementDefinition element, String path, List<QuestionnaireResponse.QuestionnaireResponseItemComponent> answerGroups) {
      ExtensionUtilities.addFhirType(group, "Annotation");
    }
  // Special Types ---------------------------------------------------------------

    private void addReferenceQuestions(QuestionnaireItemComponent group, ElementDefinition element, String path, List<CanonicalType> profileURL, List<QuestionnaireResponse.QuestionnaireResponseItemComponent> answerGroups) throws FHIRException {
      //  var
      //    rn : String;
      //    i : integer;
      //    q : TFhirQuestionnaireGroupQuestion;
      ExtensionUtilities.addFhirType(group, "Reference");

      QuestionnaireItemComponent q = addQuestion(group, QuestionnaireItemType.REFERENCE, null, path, "value", group.getText(), answerGroups);
      group.setText(null);
      CommaSeparatedStringBuilder rn = new CommaSeparatedStringBuilder();
      for (UriType u : profileURL)
      if (u.getValue().startsWith("http://hl7.org/fhir/StructureDefinition/"))
        rn.append(u.getValue().substring(40));
      if (rn.length() == 0)
        ExtensionUtilities.addReferenceFilter(q, "subject=$subj&patient=$subj&encounter=$encounter");
      else {
        ExtensionUtilities.addAllowedResource(q, rn.toString());
        ExtensionUtilities.addReferenceFilter(q, "subject=$subj&patient=$subj&encounter=$encounter");
      }
      for (QuestionnaireResponse.QuestionnaireResponseItemComponent ag : answerGroups)
        ag.setText(null);
    }


    private void addExtensionQuestions(StructureDefinition profile, QuestionnaireItemComponent group, ElementDefinition element, String path, String url, List<QuestionnaireResponse.QuestionnaireResponseItemComponent> answerGroups, List<ElementDefinition> parents) throws FHIRException { 
      // if this a  profiled extension, then we add it
    	if (!Utilities.noString(url)) {
    		StructureDefinition ed =  context.fetchResource(StructureDefinition.class, url);
    		if (ed != null) {
          if (answerGroups.size() > 0)
            throw new NotImplementedException("Debug this");
    			buildQuestion(group, profile, ed.getSnapshot().getElement().get(0), path+".extension["+url+"]", answerGroups, parents);
        }
      }
    }

    private ValueSet resolveValueSet(String url) {
//      if (prebuiltQuestionnaire != null)
        return null; // we don't do anything with value sets in this case

//      if (vsCache.containsKey(url))
//        return (ValueSet) questionnaire.getContained(vsCache.get(url));
//      else {
//        ValueSet vs = context.findValueSet(url);
//        if (vs != null)
//          return expander.expand(vs, MaxListboxCodings, false);
//      }
//       
//       /*     on e: ETooCostly do
//            begin
//              result := TFhirValueSet.Create;
//              try
//                result.identifierST := ref.referenceST;
//                result.link;
//              finally
//                result.Free;
//              end;
//            end;
//            on e : Exception do
//              raise;
//          end;*/
//      }
    }

    private ValueSet resolveValueSet(Object object, ElementDefinitionBindingComponent binding) {
      return null;
    }

}