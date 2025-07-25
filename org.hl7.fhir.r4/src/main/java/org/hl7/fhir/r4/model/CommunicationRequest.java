package org.hl7.fhir.r4.model;

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

// Generated on Tue, May 12, 2020 07:26+1000 for FHIR v4.0.1
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.IBaseBackboneElement;

import ca.uhn.fhir.model.api.annotation.Block;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import ca.uhn.fhir.model.api.annotation.SearchParamDefinition;

/**
 * A request to convey information; e.g. the CDS system proposes that an alert
 * be sent to a responsible provider, the CDS system proposes that the public
 * health agency be notified about a reportable condition.
 */
@ResourceDef(name = "CommunicationRequest", profile = "http://hl7.org/fhir/StructureDefinition/CommunicationRequest")
public class CommunicationRequest extends DomainResource {

  public enum CommunicationRequestStatus {
    /**
     * The request has been created but is not yet complete or ready for action.
     */
    DRAFT,
    /**
     * The request is in force and ready to be acted upon.
     */
    ACTIVE,
    /**
     * The request (and any implicit authorization to act) has been temporarily
     * withdrawn but is expected to resume in the future.
     */
    ONHOLD,
    /**
     * The request (and any implicit authorization to act) has been terminated prior
     * to the known full completion of the intended actions. No further activity
     * should occur.
     */
    REVOKED,
    /**
     * The activity described by the request has been fully performed. No further
     * activity will occur.
     */
    COMPLETED,
    /**
     * This request should never have existed and should be considered 'void'. (It
     * is possible that real-world decisions were based on it. If real-world
     * activity has occurred, the status should be "revoked" rather than
     * "entered-in-error".).
     */
    ENTEREDINERROR,
    /**
     * The authoring/source system does not know which of the status values
     * currently applies for this request. Note: This concept is not to be used for
     * "other" - one of the listed statuses is presumed to apply, but the
     * authoring/source system does not know which.
     */
    UNKNOWN,
    /**
     * added to help the parsers with the generic types
     */
    NULL;

    public static CommunicationRequestStatus fromCode(String codeString) throws FHIRException {
      if (codeString == null || "".equals(codeString))
        return null;
      if ("draft".equals(codeString))
        return DRAFT;
      if ("active".equals(codeString))
        return ACTIVE;
      if ("on-hold".equals(codeString))
        return ONHOLD;
      if ("revoked".equals(codeString))
        return REVOKED;
      if ("completed".equals(codeString))
        return COMPLETED;
      if ("entered-in-error".equals(codeString))
        return ENTEREDINERROR;
      if ("unknown".equals(codeString))
        return UNKNOWN;
      if (Configuration.isAcceptInvalidEnums())
        return null;
      else
        throw new FHIRException("Unknown CommunicationRequestStatus code '" + codeString + "'");
    }

    public String toCode() {
      switch (this) {
      case DRAFT:
        return "draft";
      case ACTIVE:
        return "active";
      case ONHOLD:
        return "on-hold";
      case REVOKED:
        return "revoked";
      case COMPLETED:
        return "completed";
      case ENTEREDINERROR:
        return "entered-in-error";
      case UNKNOWN:
        return "unknown";
      case NULL:
        return null;
      default:
        return "?";
      }
    }

    public String getSystem() {
      switch (this) {
      case DRAFT:
        return "http://hl7.org/fhir/request-status";
      case ACTIVE:
        return "http://hl7.org/fhir/request-status";
      case ONHOLD:
        return "http://hl7.org/fhir/request-status";
      case REVOKED:
        return "http://hl7.org/fhir/request-status";
      case COMPLETED:
        return "http://hl7.org/fhir/request-status";
      case ENTEREDINERROR:
        return "http://hl7.org/fhir/request-status";
      case UNKNOWN:
        return "http://hl7.org/fhir/request-status";
      case NULL:
        return null;
      default:
        return "?";
      }
    }

    public String getDefinition() {
      switch (this) {
      case DRAFT:
        return "The request has been created but is not yet complete or ready for action.";
      case ACTIVE:
        return "The request is in force and ready to be acted upon.";
      case ONHOLD:
        return "The request (and any implicit authorization to act) has been temporarily withdrawn but is expected to resume in the future.";
      case REVOKED:
        return "The request (and any implicit authorization to act) has been terminated prior to the known full completion of the intended actions.  No further activity should occur.";
      case COMPLETED:
        return "The activity described by the request has been fully performed.  No further activity will occur.";
      case ENTEREDINERROR:
        return "This request should never have existed and should be considered 'void'.  (It is possible that real-world decisions were based on it.  If real-world activity has occurred, the status should be \"revoked\" rather than \"entered-in-error\".).";
      case UNKNOWN:
        return "The authoring/source system does not know which of the status values currently applies for this request.  Note: This concept is not to be used for \"other\" - one of the listed statuses is presumed to apply,  but the authoring/source system does not know which.";
      case NULL:
        return null;
      default:
        return "?";
      }
    }

    public String getDisplay() {
      switch (this) {
      case DRAFT:
        return "Draft";
      case ACTIVE:
        return "Active";
      case ONHOLD:
        return "On Hold";
      case REVOKED:
        return "Revoked";
      case COMPLETED:
        return "Completed";
      case ENTEREDINERROR:
        return "Entered in Error";
      case UNKNOWN:
        return "Unknown";
      case NULL:
        return null;
      default:
        return "?";
      }
    }
  }

  public static class CommunicationRequestStatusEnumFactory implements EnumFactory<CommunicationRequestStatus> {
    public CommunicationRequestStatus fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
        if (codeString == null || "".equals(codeString))
          return null;
      if ("draft".equals(codeString))
        return CommunicationRequestStatus.DRAFT;
      if ("active".equals(codeString))
        return CommunicationRequestStatus.ACTIVE;
      if ("on-hold".equals(codeString))
        return CommunicationRequestStatus.ONHOLD;
      if ("revoked".equals(codeString))
        return CommunicationRequestStatus.REVOKED;
      if ("completed".equals(codeString))
        return CommunicationRequestStatus.COMPLETED;
      if ("entered-in-error".equals(codeString))
        return CommunicationRequestStatus.ENTEREDINERROR;
      if ("unknown".equals(codeString))
        return CommunicationRequestStatus.UNKNOWN;
      throw new IllegalArgumentException("Unknown CommunicationRequestStatus code '" + codeString + "'");
    }

    public Enumeration<CommunicationRequestStatus> fromType(PrimitiveType<?> code) throws FHIRException {
      if (code == null)
        return null;
      if (code.isEmpty())
        return new Enumeration<CommunicationRequestStatus>(this, CommunicationRequestStatus.NULL, code);
      String codeString = code.asStringValue();
      if (codeString == null || "".equals(codeString))
        return new Enumeration<CommunicationRequestStatus>(this, CommunicationRequestStatus.NULL, code);
      if ("draft".equals(codeString))
        return new Enumeration<CommunicationRequestStatus>(this, CommunicationRequestStatus.DRAFT, code);
      if ("active".equals(codeString))
        return new Enumeration<CommunicationRequestStatus>(this, CommunicationRequestStatus.ACTIVE, code);
      if ("on-hold".equals(codeString))
        return new Enumeration<CommunicationRequestStatus>(this, CommunicationRequestStatus.ONHOLD, code);
      if ("revoked".equals(codeString))
        return new Enumeration<CommunicationRequestStatus>(this, CommunicationRequestStatus.REVOKED, code);
      if ("completed".equals(codeString))
        return new Enumeration<CommunicationRequestStatus>(this, CommunicationRequestStatus.COMPLETED, code);
      if ("entered-in-error".equals(codeString))
        return new Enumeration<CommunicationRequestStatus>(this, CommunicationRequestStatus.ENTEREDINERROR, code);
      if ("unknown".equals(codeString))
        return new Enumeration<CommunicationRequestStatus>(this, CommunicationRequestStatus.UNKNOWN, code);
      throw new FHIRException("Unknown CommunicationRequestStatus code '" + codeString + "'");
    }

    public String toCode(CommunicationRequestStatus code) {
       if (code == CommunicationRequestStatus.NULL)
           return null;
       if (code == CommunicationRequestStatus.DRAFT)
        return "draft";
      if (code == CommunicationRequestStatus.ACTIVE)
        return "active";
      if (code == CommunicationRequestStatus.ONHOLD)
        return "on-hold";
      if (code == CommunicationRequestStatus.REVOKED)
        return "revoked";
      if (code == CommunicationRequestStatus.COMPLETED)
        return "completed";
      if (code == CommunicationRequestStatus.ENTEREDINERROR)
        return "entered-in-error";
      if (code == CommunicationRequestStatus.UNKNOWN)
        return "unknown";
      return "?";
   }

    public String toSystem(CommunicationRequestStatus code) {
      return code.getSystem();
    }
  }

  public enum CommunicationPriority {
    /**
     * The request has normal priority.
     */
    ROUTINE,
    /**
     * The request should be actioned promptly - higher priority than routine.
     */
    URGENT,
    /**
     * The request should be actioned as soon as possible - higher priority than
     * urgent.
     */
    ASAP,
    /**
     * The request should be actioned immediately - highest possible priority. E.g.
     * an emergency.
     */
    STAT,
    /**
     * added to help the parsers with the generic types
     */
    NULL;

    public static CommunicationPriority fromCode(String codeString) throws FHIRException {
      if (codeString == null || "".equals(codeString))
        return null;
      if ("routine".equals(codeString))
        return ROUTINE;
      if ("urgent".equals(codeString))
        return URGENT;
      if ("asap".equals(codeString))
        return ASAP;
      if ("stat".equals(codeString))
        return STAT;
      if (Configuration.isAcceptInvalidEnums())
        return null;
      else
        throw new FHIRException("Unknown CommunicationPriority code '" + codeString + "'");
    }

    public String toCode() {
      switch (this) {
      case ROUTINE:
        return "routine";
      case URGENT:
        return "urgent";
      case ASAP:
        return "asap";
      case STAT:
        return "stat";
      case NULL:
        return null;
      default:
        return "?";
      }
    }

    public String getSystem() {
      switch (this) {
      case ROUTINE:
        return "http://hl7.org/fhir/request-priority";
      case URGENT:
        return "http://hl7.org/fhir/request-priority";
      case ASAP:
        return "http://hl7.org/fhir/request-priority";
      case STAT:
        return "http://hl7.org/fhir/request-priority";
      case NULL:
        return null;
      default:
        return "?";
      }
    }

    public String getDefinition() {
      switch (this) {
      case ROUTINE:
        return "The request has normal priority.";
      case URGENT:
        return "The request should be actioned promptly - higher priority than routine.";
      case ASAP:
        return "The request should be actioned as soon as possible - higher priority than urgent.";
      case STAT:
        return "The request should be actioned immediately - highest possible priority.  E.g. an emergency.";
      case NULL:
        return null;
      default:
        return "?";
      }
    }

    public String getDisplay() {
      switch (this) {
      case ROUTINE:
        return "Routine";
      case URGENT:
        return "Urgent";
      case ASAP:
        return "ASAP";
      case STAT:
        return "STAT";
      case NULL:
        return null;
      default:
        return "?";
      }
    }
  }

  public static class CommunicationPriorityEnumFactory implements EnumFactory<CommunicationPriority> {
    public CommunicationPriority fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
        if (codeString == null || "".equals(codeString))
          return null;
      if ("routine".equals(codeString))
        return CommunicationPriority.ROUTINE;
      if ("urgent".equals(codeString))
        return CommunicationPriority.URGENT;
      if ("asap".equals(codeString))
        return CommunicationPriority.ASAP;
      if ("stat".equals(codeString))
        return CommunicationPriority.STAT;
      throw new IllegalArgumentException("Unknown CommunicationPriority code '" + codeString + "'");
    }

    public Enumeration<CommunicationPriority> fromType(PrimitiveType<?> code) throws FHIRException {
      if (code == null)
        return null;
      if (code.isEmpty())
        return new Enumeration<CommunicationPriority>(this, CommunicationPriority.NULL, code);
      String codeString = code.asStringValue();
      if (codeString == null || "".equals(codeString))
        return new Enumeration<CommunicationPriority>(this, CommunicationPriority.NULL, code);
      if ("routine".equals(codeString))
        return new Enumeration<CommunicationPriority>(this, CommunicationPriority.ROUTINE, code);
      if ("urgent".equals(codeString))
        return new Enumeration<CommunicationPriority>(this, CommunicationPriority.URGENT, code);
      if ("asap".equals(codeString))
        return new Enumeration<CommunicationPriority>(this, CommunicationPriority.ASAP, code);
      if ("stat".equals(codeString))
        return new Enumeration<CommunicationPriority>(this, CommunicationPriority.STAT, code);
      throw new FHIRException("Unknown CommunicationPriority code '" + codeString + "'");
    }

    public String toCode(CommunicationPriority code) {
       if (code == CommunicationPriority.NULL)
           return null;
       if (code == CommunicationPriority.ROUTINE)
        return "routine";
      if (code == CommunicationPriority.URGENT)
        return "urgent";
      if (code == CommunicationPriority.ASAP)
        return "asap";
      if (code == CommunicationPriority.STAT)
        return "stat";
      return "?";
   }

    public String toSystem(CommunicationPriority code) {
      return code.getSystem();
    }
  }

  @Block()
  public static class CommunicationRequestPayloadComponent extends BackboneElement implements IBaseBackboneElement {
    /**
     * The communicated content (or for multi-part communications, one portion of
     * the communication).
     */
    @Child(name = "content", type = { StringType.class, Attachment.class,
        Reference.class }, order = 1, min = 1, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Message part content", formalDefinition = "The communicated content (or for multi-part communications, one portion of the communication).")
    protected Type content;

    private static final long serialVersionUID = -1763459053L;

    /**
     * Constructor
     */
    public CommunicationRequestPayloadComponent() {
      super();
    }

    /**
     * Constructor
     */
    public CommunicationRequestPayloadComponent(Type content) {
      super();
      this.content = content;
    }

    /**
     * @return {@link #content} (The communicated content (or for multi-part
     *         communications, one portion of the communication).)
     */
    public Type getContent() {
      return this.content;
    }

    /**
     * @return {@link #content} (The communicated content (or for multi-part
     *         communications, one portion of the communication).)
     */
    public StringType getContentStringType() throws FHIRException {
      if (this.content == null)
        this.content = new StringType();
      if (!(this.content instanceof StringType))
        throw new FHIRException("Type mismatch: the type StringType was expected, but "
            + this.content.getClass().getName() + " was encountered");
      return (StringType) this.content;
    }

    public boolean hasContentStringType() {
        return this.content instanceof StringType;
    }

    /**
     * @return {@link #content} (The communicated content (or for multi-part
     *         communications, one portion of the communication).)
     */
    public Attachment getContentAttachment() throws FHIRException {
      if (this.content == null)
        this.content = new Attachment();
      if (!(this.content instanceof Attachment))
        throw new FHIRException("Type mismatch: the type Attachment was expected, but "
            + this.content.getClass().getName() + " was encountered");
      return (Attachment) this.content;
    }

    public boolean hasContentAttachment() {
        return this.content instanceof Attachment;
    }

    /**
     * @return {@link #content} (The communicated content (or for multi-part
     *         communications, one portion of the communication).)
     */
    public Reference getContentReference() throws FHIRException {
      if (this.content == null)
        this.content = new Reference();
      if (!(this.content instanceof Reference))
        throw new FHIRException("Type mismatch: the type Reference was expected, but "
            + this.content.getClass().getName() + " was encountered");
      return (Reference) this.content;
    }

    public boolean hasContentReference() {
        return this.content instanceof Reference;
    }

    public boolean hasContent() {
      return this.content != null && !this.content.isEmpty();
    }

    /**
     * @param value {@link #content} (The communicated content (or for multi-part
     *              communications, one portion of the communication).)
     */
    public CommunicationRequestPayloadComponent setContent(Type value) {
      if (value != null && !(value instanceof StringType || value instanceof Attachment || value instanceof Reference))
        throw new Error("Not the right type for CommunicationRequest.payload.content[x]: " + value.fhirType());
      this.content = value;
      return this;
    }

    protected void listChildren(List<Property> children) {
      super.listChildren(children);
      children.add(new Property("content[x]", "string|Attachment|Reference(Any)",
          "The communicated content (or for multi-part communications, one portion of the communication).", 0, 1,
          content));
    }

    @Override
    public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
      switch (_hash) {
      case 264548711:
        /* content[x] */ return new Property("content[x]", "string|Attachment|Reference(Any)",
            "The communicated content (or for multi-part communications, one portion of the communication).", 0, 1,
            content);
      case 951530617:
        /* content */ return new Property("content[x]", "string|Attachment|Reference(Any)",
            "The communicated content (or for multi-part communications, one portion of the communication).", 0, 1,
            content);
      case -326336022:
        /* contentString */ return new Property("content[x]", "string|Attachment|Reference(Any)",
            "The communicated content (or for multi-part communications, one portion of the communication).", 0, 1,
            content);
      case -702028164:
        /* contentAttachment */ return new Property("content[x]", "string|Attachment|Reference(Any)",
            "The communicated content (or for multi-part communications, one portion of the communication).", 0, 1,
            content);
      case 1193747154:
        /* contentReference */ return new Property("content[x]", "string|Attachment|Reference(Any)",
            "The communicated content (or for multi-part communications, one portion of the communication).", 0, 1,
            content);
      default:
        return super.getNamedProperty(_hash, _name, _checkValid);
      }

    }

    @Override
    public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
      switch (hash) {
      case 951530617:
        /* content */ return this.content == null ? new Base[0] : new Base[] { this.content }; // Type
      default:
        return super.getProperty(hash, name, checkValid);
      }

    }

    @Override
    public Base setProperty(int hash, String name, Base value) throws FHIRException {
      switch (hash) {
      case 951530617: // content
        this.content = castToType(value); // Type
        return value;
      default:
        return super.setProperty(hash, name, value);
      }

    }

    @Override
    public Base setProperty(String name, Base value) throws FHIRException {
      if (name.equals("content[x]")) {
        this.content = castToType(value); // Type
      } else
        return super.setProperty(name, value);
      return value;
    }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
      if (name.equals("content[x]")) {
        this.content = null;
      } else
        super.removeChild(name, value);
      
    }

    @Override
    public Base makeProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case 264548711:
        return getContent();
      case 951530617:
        return getContent();
      default:
        return super.makeProperty(hash, name);
      }

    }

    @Override
    public String[] getTypesForProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case 951530617:
        /* content */ return new String[] { "string", "Attachment", "Reference" };
      default:
        return super.getTypesForProperty(hash, name);
      }

    }

    @Override
    public Base addChild(String name) throws FHIRException {
      if (name.equals("contentString")) {
        this.content = new StringType();
        return this.content;
      } else if (name.equals("contentAttachment")) {
        this.content = new Attachment();
        return this.content;
      } else if (name.equals("contentReference")) {
        this.content = new Reference();
        return this.content;
      } else
        return super.addChild(name);
    }

    public CommunicationRequestPayloadComponent copy() {
      CommunicationRequestPayloadComponent dst = new CommunicationRequestPayloadComponent();
      copyValues(dst);
      return dst;
    }

    public void copyValues(CommunicationRequestPayloadComponent dst) {
      super.copyValues(dst);
      dst.content = content == null ? null : content.copy();
    }

    @Override
    public boolean equalsDeep(Base other_) {
      if (!super.equalsDeep(other_))
        return false;
      if (!(other_ instanceof CommunicationRequestPayloadComponent))
        return false;
      CommunicationRequestPayloadComponent o = (CommunicationRequestPayloadComponent) other_;
      return compareDeep(content, o.content, true);
    }

    @Override
    public boolean equalsShallow(Base other_) {
      if (!super.equalsShallow(other_))
        return false;
      if (!(other_ instanceof CommunicationRequestPayloadComponent))
        return false;
      CommunicationRequestPayloadComponent o = (CommunicationRequestPayloadComponent) other_;
      return true;
    }

    public boolean isEmpty() {
      return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(content);
    }

    public String fhirType() {
      return "CommunicationRequest.payload";

    }

  }

  /**
   * Business identifiers assigned to this communication request by the performer
   * or other systems which remain constant as the resource is updated and
   * propagates from server to server.
   */
  @Child(name = "identifier", type = {
      Identifier.class }, order = 0, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = true)
  @Description(shortDefinition = "Unique identifier", formalDefinition = "Business identifiers assigned to this communication request by the performer or other systems which remain constant as the resource is updated and propagates from server to server.")
  protected List<Identifier> identifier;

  /**
   * A plan or proposal that is fulfilled in whole or in part by this request.
   */
  @Child(name = "basedOn", type = {
      Reference.class }, order = 1, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = true)
  @Description(shortDefinition = "Fulfills plan or proposal", formalDefinition = "A plan or proposal that is fulfilled in whole or in part by this request.")
  protected List<Reference> basedOn;
  /**
   * The actual objects that are the target of the reference (A plan or proposal
   * that is fulfilled in whole or in part by this request.)
   */
  protected List<Resource> basedOnTarget;

  /**
   * Completed or terminated request(s) whose function is taken by this new
   * request.
   */
  @Child(name = "replaces", type = {
      CommunicationRequest.class }, order = 2, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = true)
  @Description(shortDefinition = "Request(s) replaced by this request", formalDefinition = "Completed or terminated request(s) whose function is taken by this new request.")
  protected List<Reference> replaces;
  /**
   * The actual objects that are the target of the reference (Completed or
   * terminated request(s) whose function is taken by this new request.)
   */
  protected List<CommunicationRequest> replacesTarget;

  /**
   * A shared identifier common to all requests that were authorized more or less
   * simultaneously by a single author, representing the identifier of the
   * requisition, prescription or similar form.
   */
  @Child(name = "groupIdentifier", type = {
      Identifier.class }, order = 3, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "Composite request this is part of", formalDefinition = "A shared identifier common to all requests that were authorized more or less simultaneously by a single author, representing the identifier of the requisition, prescription or similar form.")
  protected Identifier groupIdentifier;

  /**
   * The status of the proposal or order.
   */
  @Child(name = "status", type = { CodeType.class }, order = 4, min = 1, max = 1, modifier = true, summary = true)
  @Description(shortDefinition = "draft | active | on-hold | revoked | completed | entered-in-error | unknown", formalDefinition = "The status of the proposal or order.")
  @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/request-status")
  protected Enumeration<CommunicationRequestStatus> status;

  /**
   * Captures the reason for the current state of the CommunicationRequest.
   */
  @Child(name = "statusReason", type = {
      CodeableConcept.class }, order = 5, min = 0, max = 1, modifier = false, summary = false)
  @Description(shortDefinition = "Reason for current status", formalDefinition = "Captures the reason for the current state of the CommunicationRequest.")
  protected CodeableConcept statusReason;

  /**
   * The type of message to be sent such as alert, notification, reminder,
   * instruction, etc.
   */
  @Child(name = "category", type = {
      CodeableConcept.class }, order = 6, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
  @Description(shortDefinition = "Message category", formalDefinition = "The type of message to be sent such as alert, notification, reminder, instruction, etc.")
  @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/communication-category")
  protected List<CodeableConcept> category;

  /**
   * Characterizes how quickly the proposed act must be initiated. Includes
   * concepts such as stat, urgent, routine.
   */
  @Child(name = "priority", type = { CodeType.class }, order = 7, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "routine | urgent | asap | stat", formalDefinition = "Characterizes how quickly the proposed act must be initiated. Includes concepts such as stat, urgent, routine.")
  @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/request-priority")
  protected Enumeration<CommunicationPriority> priority;

  /**
   * If true indicates that the CommunicationRequest is asking for the specified
   * action to *not* occur.
   */
  @Child(name = "doNotPerform", type = {
      BooleanType.class }, order = 8, min = 0, max = 1, modifier = true, summary = true)
  @Description(shortDefinition = "True if request is prohibiting action", formalDefinition = "If true indicates that the CommunicationRequest is asking for the specified action to *not* occur.")
  protected BooleanType doNotPerform;

  /**
   * A channel that was used for this communication (e.g. email, fax).
   */
  @Child(name = "medium", type = {
      CodeableConcept.class }, order = 9, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
  @Description(shortDefinition = "A channel of communication", formalDefinition = "A channel that was used for this communication (e.g. email, fax).")
  @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://terminology.hl7.org/ValueSet/v3-ParticipationMode")
  protected List<CodeableConcept> medium;

  /**
   * The patient or group that is the focus of this communication request.
   */
  @Child(name = "subject", type = { Patient.class,
      Group.class }, order = 10, min = 0, max = 1, modifier = false, summary = false)
  @Description(shortDefinition = "Focus of message", formalDefinition = "The patient or group that is the focus of this communication request.")
  protected Reference subject;

  /**
   * The actual object that is the target of the reference (The patient or group
   * that is the focus of this communication request.)
   */
  protected Resource subjectTarget;

  /**
   * Other resources that pertain to this communication request and to which this
   * communication request should be associated.
   */
  @Child(name = "about", type = {
      Reference.class }, order = 11, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
  @Description(shortDefinition = "Resources that pertain to this communication request", formalDefinition = "Other resources that pertain to this communication request and to which this communication request should be associated.")
  protected List<Reference> about;
  /**
   * The actual objects that are the target of the reference (Other resources that
   * pertain to this communication request and to which this communication request
   * should be associated.)
   */
  protected List<Resource> aboutTarget;

  /**
   * The Encounter during which this CommunicationRequest was created or to which
   * the creation of this record is tightly associated.
   */
  @Child(name = "encounter", type = { Encounter.class }, order = 12, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "Encounter created as part of", formalDefinition = "The Encounter during which this CommunicationRequest was created or to which the creation of this record is tightly associated.")
  protected Reference encounter;

  /**
   * The actual object that is the target of the reference (The Encounter during
   * which this CommunicationRequest was created or to which the creation of this
   * record is tightly associated.)
   */
  protected Encounter encounterTarget;

  /**
   * Text, attachment(s), or resource(s) to be communicated to the recipient.
   */
  @Child(name = "payload", type = {}, order = 13, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
  @Description(shortDefinition = "Message payload", formalDefinition = "Text, attachment(s), or resource(s) to be communicated to the recipient.")
  protected List<CommunicationRequestPayloadComponent> payload;

  /**
   * The time when this communication is to occur.
   */
  @Child(name = "occurrence", type = { DateTimeType.class,
      Period.class }, order = 14, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "When scheduled", formalDefinition = "The time when this communication is to occur.")
  protected Type occurrence;

  /**
   * For draft requests, indicates the date of initial creation. For requests with
   * other statuses, indicates the date of activation.
   */
  @Child(name = "authoredOn", type = {
      DateTimeType.class }, order = 15, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "When request transitioned to being actionable", formalDefinition = "For draft requests, indicates the date of initial creation.  For requests with other statuses, indicates the date of activation.")
  protected DateTimeType authoredOn;

  /**
   * The device, individual, or organization who initiated the request and has
   * responsibility for its activation.
   */
  @Child(name = "requester", type = { Practitioner.class, PractitionerRole.class, Organization.class, Patient.class,
      RelatedPerson.class, Device.class }, order = 16, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "Who/what is requesting service", formalDefinition = "The device, individual, or organization who initiated the request and has responsibility for its activation.")
  protected Reference requester;

  /**
   * The actual object that is the target of the reference (The device,
   * individual, or organization who initiated the request and has responsibility
   * for its activation.)
   */
  protected Resource requesterTarget;

  /**
   * The entity (e.g. person, organization, clinical information system, device,
   * group, or care team) which is the intended target of the communication.
   */
  @Child(name = "recipient", type = { Device.class, Organization.class, Patient.class, Practitioner.class,
      PractitionerRole.class, RelatedPerson.class, Group.class, CareTeam.class,
      HealthcareService.class }, order = 17, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
  @Description(shortDefinition = "Message recipient", formalDefinition = "The entity (e.g. person, organization, clinical information system, device, group, or care team) which is the intended target of the communication.")
  protected List<Reference> recipient;
  /**
   * The actual objects that are the target of the reference (The entity (e.g.
   * person, organization, clinical information system, device, group, or care
   * team) which is the intended target of the communication.)
   */
  protected List<Resource> recipientTarget;

  /**
   * The entity (e.g. person, organization, clinical information system, or
   * device) which is to be the source of the communication.
   */
  @Child(name = "sender", type = { Device.class, Organization.class, Patient.class, Practitioner.class,
      PractitionerRole.class, RelatedPerson.class,
      HealthcareService.class }, order = 18, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "Message sender", formalDefinition = "The entity (e.g. person, organization, clinical information system, or device) which is to be the source of the communication.")
  protected Reference sender;

  /**
   * The actual object that is the target of the reference (The entity (e.g.
   * person, organization, clinical information system, or device) which is to be
   * the source of the communication.)
   */
  protected Resource senderTarget;

  /**
   * Describes why the request is being made in coded or textual form.
   */
  @Child(name = "reasonCode", type = {
      CodeableConcept.class }, order = 19, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = true)
  @Description(shortDefinition = "Why is communication needed?", formalDefinition = "Describes why the request is being made in coded or textual form.")
  @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://terminology.hl7.org/ValueSet/v3-ActReason")
  protected List<CodeableConcept> reasonCode;

  /**
   * Indicates another resource whose existence justifies this request.
   */
  @Child(name = "reasonReference", type = { Condition.class, Observation.class, DiagnosticReport.class,
      DocumentReference.class }, order = 20, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = true)
  @Description(shortDefinition = "Why is communication needed?", formalDefinition = "Indicates another resource whose existence justifies this request.")
  protected List<Reference> reasonReference;
  /**
   * The actual objects that are the target of the reference (Indicates another
   * resource whose existence justifies this request.)
   */
  protected List<Resource> reasonReferenceTarget;

  /**
   * Comments made about the request by the requester, sender, recipient, subject
   * or other participants.
   */
  @Child(name = "note", type = {
      Annotation.class }, order = 21, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
  @Description(shortDefinition = "Comments made about communication request", formalDefinition = "Comments made about the request by the requester, sender, recipient, subject or other participants.")
  protected List<Annotation> note;

  private static final long serialVersionUID = 2131096857L;

  /**
   * Constructor
   */
  public CommunicationRequest() {
    super();
  }

  /**
   * Constructor
   */
  public CommunicationRequest(Enumeration<CommunicationRequestStatus> status) {
    super();
    this.status = status;
  }

  /**
   * @return {@link #identifier} (Business identifiers assigned to this
   *         communication request by the performer or other systems which remain
   *         constant as the resource is updated and propagates from server to
   *         server.)
   */
  public List<Identifier> getIdentifier() {
    if (this.identifier == null)
      this.identifier = new ArrayList<Identifier>();
    return this.identifier;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public CommunicationRequest setIdentifier(List<Identifier> theIdentifier) {
    this.identifier = theIdentifier;
    return this;
  }

  public boolean hasIdentifier() {
    if (this.identifier == null)
      return false;
    for (Identifier item : this.identifier)
      if (!item.isEmpty())
        return true;
    return false;
  }

  public Identifier addIdentifier() { // 3
    Identifier t = new Identifier();
    if (this.identifier == null)
      this.identifier = new ArrayList<Identifier>();
    this.identifier.add(t);
    return t;
  }

  public CommunicationRequest addIdentifier(Identifier t) { // 3
    if (t == null)
      return this;
    if (this.identifier == null)
      this.identifier = new ArrayList<Identifier>();
    this.identifier.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #identifier}, creating
   *         it if it does not already exist
   */
  public Identifier getIdentifierFirstRep() {
    if (getIdentifier().isEmpty()) {
      addIdentifier();
    }
    return getIdentifier().get(0);
  }

  /**
   * @return {@link #basedOn} (A plan or proposal that is fulfilled in whole or in
   *         part by this request.)
   */
  public List<Reference> getBasedOn() {
    if (this.basedOn == null)
      this.basedOn = new ArrayList<Reference>();
    return this.basedOn;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public CommunicationRequest setBasedOn(List<Reference> theBasedOn) {
    this.basedOn = theBasedOn;
    return this;
  }

  public boolean hasBasedOn() {
    if (this.basedOn == null)
      return false;
    for (Reference item : this.basedOn)
      if (!item.isEmpty())
        return true;
    return false;
  }

  public Reference addBasedOn() { // 3
    Reference t = new Reference();
    if (this.basedOn == null)
      this.basedOn = new ArrayList<Reference>();
    this.basedOn.add(t);
    return t;
  }

  public CommunicationRequest addBasedOn(Reference t) { // 3
    if (t == null)
      return this;
    if (this.basedOn == null)
      this.basedOn = new ArrayList<Reference>();
    this.basedOn.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #basedOn}, creating it
   *         if it does not already exist
   */
  public Reference getBasedOnFirstRep() {
    if (getBasedOn().isEmpty()) {
      addBasedOn();
    }
    return getBasedOn().get(0);
  }

  /**
   * @return {@link #replaces} (Completed or terminated request(s) whose function
   *         is taken by this new request.)
   */
  public List<Reference> getReplaces() {
    if (this.replaces == null)
      this.replaces = new ArrayList<Reference>();
    return this.replaces;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public CommunicationRequest setReplaces(List<Reference> theReplaces) {
    this.replaces = theReplaces;
    return this;
  }

  public boolean hasReplaces() {
    if (this.replaces == null)
      return false;
    for (Reference item : this.replaces)
      if (!item.isEmpty())
        return true;
    return false;
  }

  public Reference addReplaces() { // 3
    Reference t = new Reference();
    if (this.replaces == null)
      this.replaces = new ArrayList<Reference>();
    this.replaces.add(t);
    return t;
  }

  public CommunicationRequest addReplaces(Reference t) { // 3
    if (t == null)
      return this;
    if (this.replaces == null)
      this.replaces = new ArrayList<Reference>();
    this.replaces.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #replaces}, creating
   *         it if it does not already exist
   */
  public Reference getReplacesFirstRep() {
    if (getReplaces().isEmpty()) {
      addReplaces();
    }
    return getReplaces().get(0);
  }

  /**
   * @return {@link #groupIdentifier} (A shared identifier common to all requests
   *         that were authorized more or less simultaneously by a single author,
   *         representing the identifier of the requisition, prescription or
   *         similar form.)
   */
  public Identifier getGroupIdentifier() {
    if (this.groupIdentifier == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create CommunicationRequest.groupIdentifier");
      else if (Configuration.doAutoCreate())
        this.groupIdentifier = new Identifier(); // cc
    return this.groupIdentifier;
  }

  public boolean hasGroupIdentifier() {
    return this.groupIdentifier != null && !this.groupIdentifier.isEmpty();
  }

  /**
   * @param value {@link #groupIdentifier} (A shared identifier common to all
   *              requests that were authorized more or less simultaneously by a
   *              single author, representing the identifier of the requisition,
   *              prescription or similar form.)
   */
  public CommunicationRequest setGroupIdentifier(Identifier value) {
    this.groupIdentifier = value;
    return this;
  }

  /**
   * @return {@link #status} (The status of the proposal or order.). This is the
   *         underlying object with id, value and extensions. The accessor
   *         "getStatus" gives direct access to the value
   */
  public Enumeration<CommunicationRequestStatus> getStatusElement() {
    if (this.status == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create CommunicationRequest.status");
      else if (Configuration.doAutoCreate())
        this.status = new Enumeration<CommunicationRequestStatus>(new CommunicationRequestStatusEnumFactory()); // bb
    return this.status;
  }

  public boolean hasStatusElement() {
    return this.status != null && !this.status.isEmpty();
  }

  public boolean hasStatus() {
    return this.status != null && !this.status.isEmpty();
  }

  /**
   * @param value {@link #status} (The status of the proposal or order.). This is
   *              the underlying object with id, value and extensions. The
   *              accessor "getStatus" gives direct access to the value
   */
  public CommunicationRequest setStatusElement(Enumeration<CommunicationRequestStatus> value) {
    this.status = value;
    return this;
  }

  /**
   * @return The status of the proposal or order.
   */
  public CommunicationRequestStatus getStatus() {
    return this.status == null ? null : this.status.getValue();
  }

  /**
   * @param value The status of the proposal or order.
   */
  public CommunicationRequest setStatus(CommunicationRequestStatus value) {
    if (this.status == null)
      this.status = new Enumeration<CommunicationRequestStatus>(new CommunicationRequestStatusEnumFactory());
    this.status.setValue(value);
    return this;
  }

  /**
   * @return {@link #statusReason} (Captures the reason for the current state of
   *         the CommunicationRequest.)
   */
  public CodeableConcept getStatusReason() {
    if (this.statusReason == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create CommunicationRequest.statusReason");
      else if (Configuration.doAutoCreate())
        this.statusReason = new CodeableConcept(); // cc
    return this.statusReason;
  }

  public boolean hasStatusReason() {
    return this.statusReason != null && !this.statusReason.isEmpty();
  }

  /**
   * @param value {@link #statusReason} (Captures the reason for the current state
   *              of the CommunicationRequest.)
   */
  public CommunicationRequest setStatusReason(CodeableConcept value) {
    this.statusReason = value;
    return this;
  }

  /**
   * @return {@link #category} (The type of message to be sent such as alert,
   *         notification, reminder, instruction, etc.)
   */
  public List<CodeableConcept> getCategory() {
    if (this.category == null)
      this.category = new ArrayList<CodeableConcept>();
    return this.category;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public CommunicationRequest setCategory(List<CodeableConcept> theCategory) {
    this.category = theCategory;
    return this;
  }

  public boolean hasCategory() {
    if (this.category == null)
      return false;
    for (CodeableConcept item : this.category)
      if (!item.isEmpty())
        return true;
    return false;
  }

  public CodeableConcept addCategory() { // 3
    CodeableConcept t = new CodeableConcept();
    if (this.category == null)
      this.category = new ArrayList<CodeableConcept>();
    this.category.add(t);
    return t;
  }

  public CommunicationRequest addCategory(CodeableConcept t) { // 3
    if (t == null)
      return this;
    if (this.category == null)
      this.category = new ArrayList<CodeableConcept>();
    this.category.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #category}, creating
   *         it if it does not already exist
   */
  public CodeableConcept getCategoryFirstRep() {
    if (getCategory().isEmpty()) {
      addCategory();
    }
    return getCategory().get(0);
  }

  /**
   * @return {@link #priority} (Characterizes how quickly the proposed act must be
   *         initiated. Includes concepts such as stat, urgent, routine.). This is
   *         the underlying object with id, value and extensions. The accessor
   *         "getPriority" gives direct access to the value
   */
  public Enumeration<CommunicationPriority> getPriorityElement() {
    if (this.priority == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create CommunicationRequest.priority");
      else if (Configuration.doAutoCreate())
        this.priority = new Enumeration<CommunicationPriority>(new CommunicationPriorityEnumFactory()); // bb
    return this.priority;
  }

  public boolean hasPriorityElement() {
    return this.priority != null && !this.priority.isEmpty();
  }

  public boolean hasPriority() {
    return this.priority != null && !this.priority.isEmpty();
  }

  /**
   * @param value {@link #priority} (Characterizes how quickly the proposed act
   *              must be initiated. Includes concepts such as stat, urgent,
   *              routine.). This is the underlying object with id, value and
   *              extensions. The accessor "getPriority" gives direct access to
   *              the value
   */
  public CommunicationRequest setPriorityElement(Enumeration<CommunicationPriority> value) {
    this.priority = value;
    return this;
  }

  /**
   * @return Characterizes how quickly the proposed act must be initiated.
   *         Includes concepts such as stat, urgent, routine.
   */
  public CommunicationPriority getPriority() {
    return this.priority == null ? null : this.priority.getValue();
  }

  /**
   * @param value Characterizes how quickly the proposed act must be initiated.
   *              Includes concepts such as stat, urgent, routine.
   */
  public CommunicationRequest setPriority(CommunicationPriority value) {
    if (value == null)
      this.priority = null;
    else {
      if (this.priority == null)
        this.priority = new Enumeration<CommunicationPriority>(new CommunicationPriorityEnumFactory());
      this.priority.setValue(value);
    }
    return this;
  }

  /**
   * @return {@link #doNotPerform} (If true indicates that the
   *         CommunicationRequest is asking for the specified action to *not*
   *         occur.). This is the underlying object with id, value and extensions.
   *         The accessor "getDoNotPerform" gives direct access to the value
   */
  public BooleanType getDoNotPerformElement() {
    if (this.doNotPerform == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create CommunicationRequest.doNotPerform");
      else if (Configuration.doAutoCreate())
        this.doNotPerform = new BooleanType(); // bb
    return this.doNotPerform;
  }

  public boolean hasDoNotPerformElement() {
    return this.doNotPerform != null && !this.doNotPerform.isEmpty();
  }

  public boolean hasDoNotPerform() {
    return this.doNotPerform != null && !this.doNotPerform.isEmpty();
  }

  /**
   * @param value {@link #doNotPerform} (If true indicates that the
   *              CommunicationRequest is asking for the specified action to *not*
   *              occur.). This is the underlying object with id, value and
   *              extensions. The accessor "getDoNotPerform" gives direct access
   *              to the value
   */
  public CommunicationRequest setDoNotPerformElement(BooleanType value) {
    this.doNotPerform = value;
    return this;
  }

  /**
   * @return If true indicates that the CommunicationRequest is asking for the
   *         specified action to *not* occur.
   */
  public boolean getDoNotPerform() {
    return this.doNotPerform == null || this.doNotPerform.isEmpty() ? false : this.doNotPerform.getValue();
  }

  /**
   * @param value If true indicates that the CommunicationRequest is asking for
   *              the specified action to *not* occur.
   */
  public CommunicationRequest setDoNotPerform(boolean value) {
    if (this.doNotPerform == null)
      this.doNotPerform = new BooleanType();
    this.doNotPerform.setValue(value);
    return this;
  }

  /**
   * @return {@link #medium} (A channel that was used for this communication (e.g.
   *         email, fax).)
   */
  public List<CodeableConcept> getMedium() {
    if (this.medium == null)
      this.medium = new ArrayList<CodeableConcept>();
    return this.medium;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public CommunicationRequest setMedium(List<CodeableConcept> theMedium) {
    this.medium = theMedium;
    return this;
  }

  public boolean hasMedium() {
    if (this.medium == null)
      return false;
    for (CodeableConcept item : this.medium)
      if (!item.isEmpty())
        return true;
    return false;
  }

  public CodeableConcept addMedium() { // 3
    CodeableConcept t = new CodeableConcept();
    if (this.medium == null)
      this.medium = new ArrayList<CodeableConcept>();
    this.medium.add(t);
    return t;
  }

  public CommunicationRequest addMedium(CodeableConcept t) { // 3
    if (t == null)
      return this;
    if (this.medium == null)
      this.medium = new ArrayList<CodeableConcept>();
    this.medium.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #medium}, creating it
   *         if it does not already exist
   */
  public CodeableConcept getMediumFirstRep() {
    if (getMedium().isEmpty()) {
      addMedium();
    }
    return getMedium().get(0);
  }

  /**
   * @return {@link #subject} (The patient or group that is the focus of this
   *         communication request.)
   */
  public Reference getSubject() {
    if (this.subject == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create CommunicationRequest.subject");
      else if (Configuration.doAutoCreate())
        this.subject = new Reference(); // cc
    return this.subject;
  }

  public boolean hasSubject() {
    return this.subject != null && !this.subject.isEmpty();
  }

  /**
   * @param value {@link #subject} (The patient or group that is the focus of this
   *              communication request.)
   */
  public CommunicationRequest setSubject(Reference value) {
    this.subject = value;
    return this;
  }

  /**
   * @return {@link #subject} The actual object that is the target of the
   *         reference. The reference library doesn't populate this, but you can
   *         use it to hold the resource if you resolve it. (The patient or group
   *         that is the focus of this communication request.)
   */
  public Resource getSubjectTarget() {
    return this.subjectTarget;
  }

  /**
   * @param value {@link #subject} The actual object that is the target of the
   *              reference. The reference library doesn't use these, but you can
   *              use it to hold the resource if you resolve it. (The patient or
   *              group that is the focus of this communication request.)
   */
  public CommunicationRequest setSubjectTarget(Resource value) {
    this.subjectTarget = value;
    return this;
  }

  /**
   * @return {@link #about} (Other resources that pertain to this communication
   *         request and to which this communication request should be
   *         associated.)
   */
  public List<Reference> getAbout() {
    if (this.about == null)
      this.about = new ArrayList<Reference>();
    return this.about;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public CommunicationRequest setAbout(List<Reference> theAbout) {
    this.about = theAbout;
    return this;
  }

  public boolean hasAbout() {
    if (this.about == null)
      return false;
    for (Reference item : this.about)
      if (!item.isEmpty())
        return true;
    return false;
  }

  public Reference addAbout() { // 3
    Reference t = new Reference();
    if (this.about == null)
      this.about = new ArrayList<Reference>();
    this.about.add(t);
    return t;
  }

  public CommunicationRequest addAbout(Reference t) { // 3
    if (t == null)
      return this;
    if (this.about == null)
      this.about = new ArrayList<Reference>();
    this.about.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #about}, creating it
   *         if it does not already exist
   */
  public Reference getAboutFirstRep() {
    if (getAbout().isEmpty()) {
      addAbout();
    }
    return getAbout().get(0);
  }

  /**
   * @return {@link #encounter} (The Encounter during which this
   *         CommunicationRequest was created or to which the creation of this
   *         record is tightly associated.)
   */
  public Reference getEncounter() {
    if (this.encounter == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create CommunicationRequest.encounter");
      else if (Configuration.doAutoCreate())
        this.encounter = new Reference(); // cc
    return this.encounter;
  }

  public boolean hasEncounter() {
    return this.encounter != null && !this.encounter.isEmpty();
  }

  /**
   * @param value {@link #encounter} (The Encounter during which this
   *              CommunicationRequest was created or to which the creation of
   *              this record is tightly associated.)
   */
  public CommunicationRequest setEncounter(Reference value) {
    this.encounter = value;
    return this;
  }

  /**
   * @return {@link #encounter} The actual object that is the target of the
   *         reference. The reference library doesn't populate this, but you can
   *         use it to hold the resource if you resolve it. (The Encounter during
   *         which this CommunicationRequest was created or to which the creation
   *         of this record is tightly associated.)
   */
  public Encounter getEncounterTarget() {
    if (this.encounterTarget == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create CommunicationRequest.encounter");
      else if (Configuration.doAutoCreate())
        this.encounterTarget = new Encounter(); // aa
    return this.encounterTarget;
  }

  /**
   * @param value {@link #encounter} The actual object that is the target of the
   *              reference. The reference library doesn't use these, but you can
   *              use it to hold the resource if you resolve it. (The Encounter
   *              during which this CommunicationRequest was created or to which
   *              the creation of this record is tightly associated.)
   */
  public CommunicationRequest setEncounterTarget(Encounter value) {
    this.encounterTarget = value;
    return this;
  }

  /**
   * @return {@link #payload} (Text, attachment(s), or resource(s) to be
   *         communicated to the recipient.)
   */
  public List<CommunicationRequestPayloadComponent> getPayload() {
    if (this.payload == null)
      this.payload = new ArrayList<CommunicationRequestPayloadComponent>();
    return this.payload;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public CommunicationRequest setPayload(List<CommunicationRequestPayloadComponent> thePayload) {
    this.payload = thePayload;
    return this;
  }

  public boolean hasPayload() {
    if (this.payload == null)
      return false;
    for (CommunicationRequestPayloadComponent item : this.payload)
      if (!item.isEmpty())
        return true;
    return false;
  }

  public CommunicationRequestPayloadComponent addPayload() { // 3
    CommunicationRequestPayloadComponent t = new CommunicationRequestPayloadComponent();
    if (this.payload == null)
      this.payload = new ArrayList<CommunicationRequestPayloadComponent>();
    this.payload.add(t);
    return t;
  }

  public CommunicationRequest addPayload(CommunicationRequestPayloadComponent t) { // 3
    if (t == null)
      return this;
    if (this.payload == null)
      this.payload = new ArrayList<CommunicationRequestPayloadComponent>();
    this.payload.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #payload}, creating it
   *         if it does not already exist
   */
  public CommunicationRequestPayloadComponent getPayloadFirstRep() {
    if (getPayload().isEmpty()) {
      addPayload();
    }
    return getPayload().get(0);
  }

  /**
   * @return {@link #occurrence} (The time when this communication is to occur.)
   */
  public Type getOccurrence() {
    return this.occurrence;
  }

  /**
   * @return {@link #occurrence} (The time when this communication is to occur.)
   */
  public DateTimeType getOccurrenceDateTimeType() throws FHIRException {
    if (this.occurrence == null)
      this.occurrence = new DateTimeType();
    if (!(this.occurrence instanceof DateTimeType))
      throw new FHIRException("Type mismatch: the type DateTimeType was expected, but "
          + this.occurrence.getClass().getName() + " was encountered");
    return (DateTimeType) this.occurrence;
  }

  public boolean hasOccurrenceDateTimeType() {
      return this.occurrence instanceof DateTimeType;
  }

  /**
   * @return {@link #occurrence} (The time when this communication is to occur.)
   */
  public Period getOccurrencePeriod() throws FHIRException {
    if (this.occurrence == null)
      this.occurrence = new Period();
    if (!(this.occurrence instanceof Period))
      throw new FHIRException("Type mismatch: the type Period was expected, but " + this.occurrence.getClass().getName()
          + " was encountered");
    return (Period) this.occurrence;
  }

  public boolean hasOccurrencePeriod() {
      return this.occurrence instanceof Period;
  }

  public boolean hasOccurrence() {
    return this.occurrence != null && !this.occurrence.isEmpty();
  }

  /**
   * @param value {@link #occurrence} (The time when this communication is to
   *              occur.)
   */
  public CommunicationRequest setOccurrence(Type value) {
    if (value != null && !(value instanceof DateTimeType || value instanceof Period))
      throw new Error("Not the right type for CommunicationRequest.occurrence[x]: " + value.fhirType());
    this.occurrence = value;
    return this;
  }

  /**
   * @return {@link #authoredOn} (For draft requests, indicates the date of
   *         initial creation. For requests with other statuses, indicates the
   *         date of activation.). This is the underlying object with id, value
   *         and extensions. The accessor "getAuthoredOn" gives direct access to
   *         the value
   */
  public DateTimeType getAuthoredOnElement() {
    if (this.authoredOn == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create CommunicationRequest.authoredOn");
      else if (Configuration.doAutoCreate())
        this.authoredOn = new DateTimeType(); // bb
    return this.authoredOn;
  }

  public boolean hasAuthoredOnElement() {
    return this.authoredOn != null && !this.authoredOn.isEmpty();
  }

  public boolean hasAuthoredOn() {
    return this.authoredOn != null && !this.authoredOn.isEmpty();
  }

  /**
   * @param value {@link #authoredOn} (For draft requests, indicates the date of
   *              initial creation. For requests with other statuses, indicates
   *              the date of activation.). This is the underlying object with id,
   *              value and extensions. The accessor "getAuthoredOn" gives direct
   *              access to the value
   */
  public CommunicationRequest setAuthoredOnElement(DateTimeType value) {
    this.authoredOn = value;
    return this;
  }

  /**
   * @return For draft requests, indicates the date of initial creation. For
   *         requests with other statuses, indicates the date of activation.
   */
  public Date getAuthoredOn() {
    return this.authoredOn == null ? null : this.authoredOn.getValue();
  }

  /**
   * @param value For draft requests, indicates the date of initial creation. For
   *              requests with other statuses, indicates the date of activation.
   */
  public CommunicationRequest setAuthoredOn(Date value) {
    if (value == null)
      this.authoredOn = null;
    else {
      if (this.authoredOn == null)
        this.authoredOn = new DateTimeType();
      this.authoredOn.setValue(value);
    }
    return this;
  }

  /**
   * @return {@link #requester} (The device, individual, or organization who
   *         initiated the request and has responsibility for its activation.)
   */
  public Reference getRequester() {
    if (this.requester == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create CommunicationRequest.requester");
      else if (Configuration.doAutoCreate())
        this.requester = new Reference(); // cc
    return this.requester;
  }

  public boolean hasRequester() {
    return this.requester != null && !this.requester.isEmpty();
  }

  /**
   * @param value {@link #requester} (The device, individual, or organization who
   *              initiated the request and has responsibility for its
   *              activation.)
   */
  public CommunicationRequest setRequester(Reference value) {
    this.requester = value;
    return this;
  }

  /**
   * @return {@link #requester} The actual object that is the target of the
   *         reference. The reference library doesn't populate this, but you can
   *         use it to hold the resource if you resolve it. (The device,
   *         individual, or organization who initiated the request and has
   *         responsibility for its activation.)
   */
  public Resource getRequesterTarget() {
    return this.requesterTarget;
  }

  /**
   * @param value {@link #requester} The actual object that is the target of the
   *              reference. The reference library doesn't use these, but you can
   *              use it to hold the resource if you resolve it. (The device,
   *              individual, or organization who initiated the request and has
   *              responsibility for its activation.)
   */
  public CommunicationRequest setRequesterTarget(Resource value) {
    this.requesterTarget = value;
    return this;
  }

  /**
   * @return {@link #recipient} (The entity (e.g. person, organization, clinical
   *         information system, device, group, or care team) which is the
   *         intended target of the communication.)
   */
  public List<Reference> getRecipient() {
    if (this.recipient == null)
      this.recipient = new ArrayList<Reference>();
    return this.recipient;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public CommunicationRequest setRecipient(List<Reference> theRecipient) {
    this.recipient = theRecipient;
    return this;
  }

  public boolean hasRecipient() {
    if (this.recipient == null)
      return false;
    for (Reference item : this.recipient)
      if (!item.isEmpty())
        return true;
    return false;
  }

  public Reference addRecipient() { // 3
    Reference t = new Reference();
    if (this.recipient == null)
      this.recipient = new ArrayList<Reference>();
    this.recipient.add(t);
    return t;
  }

  public CommunicationRequest addRecipient(Reference t) { // 3
    if (t == null)
      return this;
    if (this.recipient == null)
      this.recipient = new ArrayList<Reference>();
    this.recipient.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #recipient}, creating
   *         it if it does not already exist
   */
  public Reference getRecipientFirstRep() {
    if (getRecipient().isEmpty()) {
      addRecipient();
    }
    return getRecipient().get(0);
  }

  /**
   * @return {@link #sender} (The entity (e.g. person, organization, clinical
   *         information system, or device) which is to be the source of the
   *         communication.)
   */
  public Reference getSender() {
    if (this.sender == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create CommunicationRequest.sender");
      else if (Configuration.doAutoCreate())
        this.sender = new Reference(); // cc
    return this.sender;
  }

  public boolean hasSender() {
    return this.sender != null && !this.sender.isEmpty();
  }

  /**
   * @param value {@link #sender} (The entity (e.g. person, organization, clinical
   *              information system, or device) which is to be the source of the
   *              communication.)
   */
  public CommunicationRequest setSender(Reference value) {
    this.sender = value;
    return this;
  }

  /**
   * @return {@link #sender} The actual object that is the target of the
   *         reference. The reference library doesn't populate this, but you can
   *         use it to hold the resource if you resolve it. (The entity (e.g.
   *         person, organization, clinical information system, or device) which
   *         is to be the source of the communication.)
   */
  public Resource getSenderTarget() {
    return this.senderTarget;
  }

  /**
   * @param value {@link #sender} The actual object that is the target of the
   *              reference. The reference library doesn't use these, but you can
   *              use it to hold the resource if you resolve it. (The entity (e.g.
   *              person, organization, clinical information system, or device)
   *              which is to be the source of the communication.)
   */
  public CommunicationRequest setSenderTarget(Resource value) {
    this.senderTarget = value;
    return this;
  }

  /**
   * @return {@link #reasonCode} (Describes why the request is being made in coded
   *         or textual form.)
   */
  public List<CodeableConcept> getReasonCode() {
    if (this.reasonCode == null)
      this.reasonCode = new ArrayList<CodeableConcept>();
    return this.reasonCode;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public CommunicationRequest setReasonCode(List<CodeableConcept> theReasonCode) {
    this.reasonCode = theReasonCode;
    return this;
  }

  public boolean hasReasonCode() {
    if (this.reasonCode == null)
      return false;
    for (CodeableConcept item : this.reasonCode)
      if (!item.isEmpty())
        return true;
    return false;
  }

  public CodeableConcept addReasonCode() { // 3
    CodeableConcept t = new CodeableConcept();
    if (this.reasonCode == null)
      this.reasonCode = new ArrayList<CodeableConcept>();
    this.reasonCode.add(t);
    return t;
  }

  public CommunicationRequest addReasonCode(CodeableConcept t) { // 3
    if (t == null)
      return this;
    if (this.reasonCode == null)
      this.reasonCode = new ArrayList<CodeableConcept>();
    this.reasonCode.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #reasonCode}, creating
   *         it if it does not already exist
   */
  public CodeableConcept getReasonCodeFirstRep() {
    if (getReasonCode().isEmpty()) {
      addReasonCode();
    }
    return getReasonCode().get(0);
  }

  /**
   * @return {@link #reasonReference} (Indicates another resource whose existence
   *         justifies this request.)
   */
  public List<Reference> getReasonReference() {
    if (this.reasonReference == null)
      this.reasonReference = new ArrayList<Reference>();
    return this.reasonReference;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public CommunicationRequest setReasonReference(List<Reference> theReasonReference) {
    this.reasonReference = theReasonReference;
    return this;
  }

  public boolean hasReasonReference() {
    if (this.reasonReference == null)
      return false;
    for (Reference item : this.reasonReference)
      if (!item.isEmpty())
        return true;
    return false;
  }

  public Reference addReasonReference() { // 3
    Reference t = new Reference();
    if (this.reasonReference == null)
      this.reasonReference = new ArrayList<Reference>();
    this.reasonReference.add(t);
    return t;
  }

  public CommunicationRequest addReasonReference(Reference t) { // 3
    if (t == null)
      return this;
    if (this.reasonReference == null)
      this.reasonReference = new ArrayList<Reference>();
    this.reasonReference.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #reasonReference},
   *         creating it if it does not already exist
   */
  public Reference getReasonReferenceFirstRep() {
    if (getReasonReference().isEmpty()) {
      addReasonReference();
    }
    return getReasonReference().get(0);
  }

  /**
   * @return {@link #note} (Comments made about the request by the requester,
   *         sender, recipient, subject or other participants.)
   */
  public List<Annotation> getNote() {
    if (this.note == null)
      this.note = new ArrayList<Annotation>();
    return this.note;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public CommunicationRequest setNote(List<Annotation> theNote) {
    this.note = theNote;
    return this;
  }

  public boolean hasNote() {
    if (this.note == null)
      return false;
    for (Annotation item : this.note)
      if (!item.isEmpty())
        return true;
    return false;
  }

  public Annotation addNote() { // 3
    Annotation t = new Annotation();
    if (this.note == null)
      this.note = new ArrayList<Annotation>();
    this.note.add(t);
    return t;
  }

  public CommunicationRequest addNote(Annotation t) { // 3
    if (t == null)
      return this;
    if (this.note == null)
      this.note = new ArrayList<Annotation>();
    this.note.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #note}, creating it if
   *         it does not already exist
   */
  public Annotation getNoteFirstRep() {
    if (getNote().isEmpty()) {
      addNote();
    }
    return getNote().get(0);
  }

  protected void listChildren(List<Property> children) {
    super.listChildren(children);
    children.add(new Property("identifier", "Identifier",
        "Business identifiers assigned to this communication request by the performer or other systems which remain constant as the resource is updated and propagates from server to server.",
        0, java.lang.Integer.MAX_VALUE, identifier));
    children.add(new Property("basedOn", "Reference(Any)",
        "A plan or proposal that is fulfilled in whole or in part by this request.", 0, java.lang.Integer.MAX_VALUE,
        basedOn));
    children.add(new Property("replaces", "Reference(CommunicationRequest)",
        "Completed or terminated request(s) whose function is taken by this new request.", 0,
        java.lang.Integer.MAX_VALUE, replaces));
    children.add(new Property("groupIdentifier", "Identifier",
        "A shared identifier common to all requests that were authorized more or less simultaneously by a single author, representing the identifier of the requisition, prescription or similar form.",
        0, 1, groupIdentifier));
    children.add(new Property("status", "code", "The status of the proposal or order.", 0, 1, status));
    children.add(new Property("statusReason", "CodeableConcept",
        "Captures the reason for the current state of the CommunicationRequest.", 0, 1, statusReason));
    children.add(new Property("category", "CodeableConcept",
        "The type of message to be sent such as alert, notification, reminder, instruction, etc.", 0,
        java.lang.Integer.MAX_VALUE, category));
    children.add(new Property("priority", "code",
        "Characterizes how quickly the proposed act must be initiated. Includes concepts such as stat, urgent, routine.",
        0, 1, priority));
    children.add(new Property("doNotPerform", "boolean",
        "If true indicates that the CommunicationRequest is asking for the specified action to *not* occur.", 0, 1,
        doNotPerform));
    children.add(new Property("medium", "CodeableConcept",
        "A channel that was used for this communication (e.g. email, fax).", 0, java.lang.Integer.MAX_VALUE, medium));
    children.add(new Property("subject", "Reference(Patient|Group)",
        "The patient or group that is the focus of this communication request.", 0, 1, subject));
    children.add(new Property("about", "Reference(Any)",
        "Other resources that pertain to this communication request and to which this communication request should be associated.",
        0, java.lang.Integer.MAX_VALUE, about));
    children.add(new Property("encounter", "Reference(Encounter)",
        "The Encounter during which this CommunicationRequest was created or to which the creation of this record is tightly associated.",
        0, 1, encounter));
    children.add(new Property("payload", "", "Text, attachment(s), or resource(s) to be communicated to the recipient.",
        0, java.lang.Integer.MAX_VALUE, payload));
    children.add(new Property("occurrence[x]", "dateTime|Period", "The time when this communication is to occur.", 0, 1,
        occurrence));
    children.add(new Property("authoredOn", "dateTime",
        "For draft requests, indicates the date of initial creation.  For requests with other statuses, indicates the date of activation.",
        0, 1, authoredOn));
    children.add(new Property("requester",
        "Reference(Practitioner|PractitionerRole|Organization|Patient|RelatedPerson|Device)",
        "The device, individual, or organization who initiated the request and has responsibility for its activation.",
        0, 1, requester));
    children.add(new Property("recipient",
        "Reference(Device|Organization|Patient|Practitioner|PractitionerRole|RelatedPerson|Group|CareTeam|HealthcareService)",
        "The entity (e.g. person, organization, clinical information system, device, group, or care team) which is the intended target of the communication.",
        0, java.lang.Integer.MAX_VALUE, recipient));
    children.add(new Property("sender",
        "Reference(Device|Organization|Patient|Practitioner|PractitionerRole|RelatedPerson|HealthcareService)",
        "The entity (e.g. person, organization, clinical information system, or device) which is to be the source of the communication.",
        0, 1, sender));
    children.add(new Property("reasonCode", "CodeableConcept",
        "Describes why the request is being made in coded or textual form.", 0, java.lang.Integer.MAX_VALUE,
        reasonCode));
    children.add(new Property("reasonReference", "Reference(Condition|Observation|DiagnosticReport|DocumentReference)",
        "Indicates another resource whose existence justifies this request.", 0, java.lang.Integer.MAX_VALUE,
        reasonReference));
    children.add(new Property("note", "Annotation",
        "Comments made about the request by the requester, sender, recipient, subject or other participants.", 0,
        java.lang.Integer.MAX_VALUE, note));
  }

  @Override
  public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
    switch (_hash) {
    case -1618432855:
      /* identifier */ return new Property("identifier", "Identifier",
          "Business identifiers assigned to this communication request by the performer or other systems which remain constant as the resource is updated and propagates from server to server.",
          0, java.lang.Integer.MAX_VALUE, identifier);
    case -332612366:
      /* basedOn */ return new Property("basedOn", "Reference(Any)",
          "A plan or proposal that is fulfilled in whole or in part by this request.", 0, java.lang.Integer.MAX_VALUE,
          basedOn);
    case -430332865:
      /* replaces */ return new Property("replaces", "Reference(CommunicationRequest)",
          "Completed or terminated request(s) whose function is taken by this new request.", 0,
          java.lang.Integer.MAX_VALUE, replaces);
    case -445338488:
      /* groupIdentifier */ return new Property("groupIdentifier", "Identifier",
          "A shared identifier common to all requests that were authorized more or less simultaneously by a single author, representing the identifier of the requisition, prescription or similar form.",
          0, 1, groupIdentifier);
    case -892481550:
      /* status */ return new Property("status", "code", "The status of the proposal or order.", 0, 1, status);
    case 2051346646:
      /* statusReason */ return new Property("statusReason", "CodeableConcept",
          "Captures the reason for the current state of the CommunicationRequest.", 0, 1, statusReason);
    case 50511102:
      /* category */ return new Property("category", "CodeableConcept",
          "The type of message to be sent such as alert, notification, reminder, instruction, etc.", 0,
          java.lang.Integer.MAX_VALUE, category);
    case -1165461084:
      /* priority */ return new Property("priority", "code",
          "Characterizes how quickly the proposed act must be initiated. Includes concepts such as stat, urgent, routine.",
          0, 1, priority);
    case -1788508167:
      /* doNotPerform */ return new Property("doNotPerform", "boolean",
          "If true indicates that the CommunicationRequest is asking for the specified action to *not* occur.", 0, 1,
          doNotPerform);
    case -1078030475:
      /* medium */ return new Property("medium", "CodeableConcept",
          "A channel that was used for this communication (e.g. email, fax).", 0, java.lang.Integer.MAX_VALUE, medium);
    case -1867885268:
      /* subject */ return new Property("subject", "Reference(Patient|Group)",
          "The patient or group that is the focus of this communication request.", 0, 1, subject);
    case 92611469:
      /* about */ return new Property("about", "Reference(Any)",
          "Other resources that pertain to this communication request and to which this communication request should be associated.",
          0, java.lang.Integer.MAX_VALUE, about);
    case 1524132147:
      /* encounter */ return new Property("encounter", "Reference(Encounter)",
          "The Encounter during which this CommunicationRequest was created or to which the creation of this record is tightly associated.",
          0, 1, encounter);
    case -786701938:
      /* payload */ return new Property("payload", "",
          "Text, attachment(s), or resource(s) to be communicated to the recipient.", 0, java.lang.Integer.MAX_VALUE,
          payload);
    case -2022646513:
      /* occurrence[x] */ return new Property("occurrence[x]", "dateTime|Period",
          "The time when this communication is to occur.", 0, 1, occurrence);
    case 1687874001:
      /* occurrence */ return new Property("occurrence[x]", "dateTime|Period",
          "The time when this communication is to occur.", 0, 1, occurrence);
    case -298443636:
      /* occurrenceDateTime */ return new Property("occurrence[x]", "dateTime|Period",
          "The time when this communication is to occur.", 0, 1, occurrence);
    case 1397156594:
      /* occurrencePeriod */ return new Property("occurrence[x]", "dateTime|Period",
          "The time when this communication is to occur.", 0, 1, occurrence);
    case -1500852503:
      /* authoredOn */ return new Property("authoredOn", "dateTime",
          "For draft requests, indicates the date of initial creation.  For requests with other statuses, indicates the date of activation.",
          0, 1, authoredOn);
    case 693933948:
      /* requester */ return new Property("requester",
          "Reference(Practitioner|PractitionerRole|Organization|Patient|RelatedPerson|Device)",
          "The device, individual, or organization who initiated the request and has responsibility for its activation.",
          0, 1, requester);
    case 820081177:
      /* recipient */ return new Property("recipient",
          "Reference(Device|Organization|Patient|Practitioner|PractitionerRole|RelatedPerson|Group|CareTeam|HealthcareService)",
          "The entity (e.g. person, organization, clinical information system, device, group, or care team) which is the intended target of the communication.",
          0, java.lang.Integer.MAX_VALUE, recipient);
    case -905962955:
      /* sender */ return new Property("sender",
          "Reference(Device|Organization|Patient|Practitioner|PractitionerRole|RelatedPerson|HealthcareService)",
          "The entity (e.g. person, organization, clinical information system, or device) which is to be the source of the communication.",
          0, 1, sender);
    case 722137681:
      /* reasonCode */ return new Property("reasonCode", "CodeableConcept",
          "Describes why the request is being made in coded or textual form.", 0, java.lang.Integer.MAX_VALUE,
          reasonCode);
    case -1146218137:
      /* reasonReference */ return new Property("reasonReference",
          "Reference(Condition|Observation|DiagnosticReport|DocumentReference)",
          "Indicates another resource whose existence justifies this request.", 0, java.lang.Integer.MAX_VALUE,
          reasonReference);
    case 3387378:
      /* note */ return new Property("note", "Annotation",
          "Comments made about the request by the requester, sender, recipient, subject or other participants.", 0,
          java.lang.Integer.MAX_VALUE, note);
    default:
      return super.getNamedProperty(_hash, _name, _checkValid);
    }

  }

  @Override
  public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
    switch (hash) {
    case -1618432855:
      /* identifier */ return this.identifier == null ? new Base[0]
          : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
    case -332612366:
      /* basedOn */ return this.basedOn == null ? new Base[0] : this.basedOn.toArray(new Base[this.basedOn.size()]); // Reference
    case -430332865:
      /* replaces */ return this.replaces == null ? new Base[0] : this.replaces.toArray(new Base[this.replaces.size()]); // Reference
    case -445338488:
      /* groupIdentifier */ return this.groupIdentifier == null ? new Base[0] : new Base[] { this.groupIdentifier }; // Identifier
    case -892481550:
      /* status */ return this.status == null ? new Base[0] : new Base[] { this.status }; // Enumeration<CommunicationRequestStatus>
    case 2051346646:
      /* statusReason */ return this.statusReason == null ? new Base[0] : new Base[] { this.statusReason }; // CodeableConcept
    case 50511102:
      /* category */ return this.category == null ? new Base[0] : this.category.toArray(new Base[this.category.size()]); // CodeableConcept
    case -1165461084:
      /* priority */ return this.priority == null ? new Base[0] : new Base[] { this.priority }; // Enumeration<CommunicationPriority>
    case -1788508167:
      /* doNotPerform */ return this.doNotPerform == null ? new Base[0] : new Base[] { this.doNotPerform }; // BooleanType
    case -1078030475:
      /* medium */ return this.medium == null ? new Base[0] : this.medium.toArray(new Base[this.medium.size()]); // CodeableConcept
    case -1867885268:
      /* subject */ return this.subject == null ? new Base[0] : new Base[] { this.subject }; // Reference
    case 92611469:
      /* about */ return this.about == null ? new Base[0] : this.about.toArray(new Base[this.about.size()]); // Reference
    case 1524132147:
      /* encounter */ return this.encounter == null ? new Base[0] : new Base[] { this.encounter }; // Reference
    case -786701938:
      /* payload */ return this.payload == null ? new Base[0] : this.payload.toArray(new Base[this.payload.size()]); // CommunicationRequestPayloadComponent
    case 1687874001:
      /* occurrence */ return this.occurrence == null ? new Base[0] : new Base[] { this.occurrence }; // Type
    case -1500852503:
      /* authoredOn */ return this.authoredOn == null ? new Base[0] : new Base[] { this.authoredOn }; // DateTimeType
    case 693933948:
      /* requester */ return this.requester == null ? new Base[0] : new Base[] { this.requester }; // Reference
    case 820081177:
      /* recipient */ return this.recipient == null ? new Base[0]
          : this.recipient.toArray(new Base[this.recipient.size()]); // Reference
    case -905962955:
      /* sender */ return this.sender == null ? new Base[0] : new Base[] { this.sender }; // Reference
    case 722137681:
      /* reasonCode */ return this.reasonCode == null ? new Base[0]
          : this.reasonCode.toArray(new Base[this.reasonCode.size()]); // CodeableConcept
    case -1146218137:
      /* reasonReference */ return this.reasonReference == null ? new Base[0]
          : this.reasonReference.toArray(new Base[this.reasonReference.size()]); // Reference
    case 3387378:
      /* note */ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
    default:
      return super.getProperty(hash, name, checkValid);
    }

  }

  @Override
  public Base setProperty(int hash, String name, Base value) throws FHIRException {
    switch (hash) {
    case -1618432855: // identifier
      this.getIdentifier().add(castToIdentifier(value)); // Identifier
      return value;
    case -332612366: // basedOn
      this.getBasedOn().add(castToReference(value)); // Reference
      return value;
    case -430332865: // replaces
      this.getReplaces().add(castToReference(value)); // Reference
      return value;
    case -445338488: // groupIdentifier
      this.groupIdentifier = castToIdentifier(value); // Identifier
      return value;
    case -892481550: // status
      value = new CommunicationRequestStatusEnumFactory().fromType(castToCode(value));
      this.status = (Enumeration) value; // Enumeration<CommunicationRequestStatus>
      return value;
    case 2051346646: // statusReason
      this.statusReason = castToCodeableConcept(value); // CodeableConcept
      return value;
    case 50511102: // category
      this.getCategory().add(castToCodeableConcept(value)); // CodeableConcept
      return value;
    case -1165461084: // priority
      value = new CommunicationPriorityEnumFactory().fromType(castToCode(value));
      this.priority = (Enumeration) value; // Enumeration<CommunicationPriority>
      return value;
    case -1788508167: // doNotPerform
      this.doNotPerform = castToBoolean(value); // BooleanType
      return value;
    case -1078030475: // medium
      this.getMedium().add(castToCodeableConcept(value)); // CodeableConcept
      return value;
    case -1867885268: // subject
      this.subject = castToReference(value); // Reference
      return value;
    case 92611469: // about
      this.getAbout().add(castToReference(value)); // Reference
      return value;
    case 1524132147: // encounter
      this.encounter = castToReference(value); // Reference
      return value;
    case -786701938: // payload
      this.getPayload().add((CommunicationRequestPayloadComponent) value); // CommunicationRequestPayloadComponent
      return value;
    case 1687874001: // occurrence
      this.occurrence = castToType(value); // Type
      return value;
    case -1500852503: // authoredOn
      this.authoredOn = castToDateTime(value); // DateTimeType
      return value;
    case 693933948: // requester
      this.requester = castToReference(value); // Reference
      return value;
    case 820081177: // recipient
      this.getRecipient().add(castToReference(value)); // Reference
      return value;
    case -905962955: // sender
      this.sender = castToReference(value); // Reference
      return value;
    case 722137681: // reasonCode
      this.getReasonCode().add(castToCodeableConcept(value)); // CodeableConcept
      return value;
    case -1146218137: // reasonReference
      this.getReasonReference().add(castToReference(value)); // Reference
      return value;
    case 3387378: // note
      this.getNote().add(castToAnnotation(value)); // Annotation
      return value;
    default:
      return super.setProperty(hash, name, value);
    }

  }

  @Override
  public Base setProperty(String name, Base value) throws FHIRException {
    if (name.equals("identifier")) {
      this.getIdentifier().add(castToIdentifier(value));
    } else if (name.equals("basedOn")) {
      this.getBasedOn().add(castToReference(value));
    } else if (name.equals("replaces")) {
      this.getReplaces().add(castToReference(value));
    } else if (name.equals("groupIdentifier")) {
      this.groupIdentifier = castToIdentifier(value); // Identifier
    } else if (name.equals("status")) {
      value = new CommunicationRequestStatusEnumFactory().fromType(castToCode(value));
      this.status = (Enumeration) value; // Enumeration<CommunicationRequestStatus>
    } else if (name.equals("statusReason")) {
      this.statusReason = castToCodeableConcept(value); // CodeableConcept
    } else if (name.equals("category")) {
      this.getCategory().add(castToCodeableConcept(value));
    } else if (name.equals("priority")) {
      value = new CommunicationPriorityEnumFactory().fromType(castToCode(value));
      this.priority = (Enumeration) value; // Enumeration<CommunicationPriority>
    } else if (name.equals("doNotPerform")) {
      this.doNotPerform = castToBoolean(value); // BooleanType
    } else if (name.equals("medium")) {
      this.getMedium().add(castToCodeableConcept(value));
    } else if (name.equals("subject")) {
      this.subject = castToReference(value); // Reference
    } else if (name.equals("about")) {
      this.getAbout().add(castToReference(value));
    } else if (name.equals("encounter")) {
      this.encounter = castToReference(value); // Reference
    } else if (name.equals("payload")) {
      this.getPayload().add((CommunicationRequestPayloadComponent) value);
    } else if (name.equals("occurrence[x]")) {
      this.occurrence = castToType(value); // Type
    } else if (name.equals("authoredOn")) {
      this.authoredOn = castToDateTime(value); // DateTimeType
    } else if (name.equals("requester")) {
      this.requester = castToReference(value); // Reference
    } else if (name.equals("recipient")) {
      this.getRecipient().add(castToReference(value));
    } else if (name.equals("sender")) {
      this.sender = castToReference(value); // Reference
    } else if (name.equals("reasonCode")) {
      this.getReasonCode().add(castToCodeableConcept(value));
    } else if (name.equals("reasonReference")) {
      this.getReasonReference().add(castToReference(value));
    } else if (name.equals("note")) {
      this.getNote().add(castToAnnotation(value));
    } else
      return super.setProperty(name, value);
    return value;
  }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
    if (name.equals("identifier")) {
      this.getIdentifier().remove(castToIdentifier(value));
    } else if (name.equals("basedOn")) {
      this.getBasedOn().remove(castToReference(value));
    } else if (name.equals("replaces")) {
      this.getReplaces().remove(castToReference(value));
    } else if (name.equals("groupIdentifier")) {
      this.groupIdentifier = null;
    } else if (name.equals("status")) {
      this.status = null;
    } else if (name.equals("statusReason")) {
      this.statusReason = null;
    } else if (name.equals("category")) {
      this.getCategory().remove(castToCodeableConcept(value));
    } else if (name.equals("priority")) {
      this.priority = null;
    } else if (name.equals("doNotPerform")) {
      this.doNotPerform = null;
    } else if (name.equals("medium")) {
      this.getMedium().remove(castToCodeableConcept(value));
    } else if (name.equals("subject")) {
      this.subject = null;
    } else if (name.equals("about")) {
      this.getAbout().remove(castToReference(value));
    } else if (name.equals("encounter")) {
      this.encounter = null;
    } else if (name.equals("payload")) {
      this.getPayload().remove((CommunicationRequestPayloadComponent) value);
    } else if (name.equals("occurrence[x]")) {
      this.occurrence = null;
    } else if (name.equals("authoredOn")) {
      this.authoredOn = null;
    } else if (name.equals("requester")) {
      this.requester = null;
    } else if (name.equals("recipient")) {
      this.getRecipient().remove(castToReference(value));
    } else if (name.equals("sender")) {
      this.sender = null;
    } else if (name.equals("reasonCode")) {
      this.getReasonCode().remove(castToCodeableConcept(value));
    } else if (name.equals("reasonReference")) {
      this.getReasonReference().remove(castToReference(value));
    } else if (name.equals("note")) {
      this.getNote().remove(castToAnnotation(value));
    } else
      super.removeChild(name, value);
    
  }

  @Override
  public Base makeProperty(int hash, String name) throws FHIRException {
    switch (hash) {
    case -1618432855:
      return addIdentifier();
    case -332612366:
      return addBasedOn();
    case -430332865:
      return addReplaces();
    case -445338488:
      return getGroupIdentifier();
    case -892481550:
      return getStatusElement();
    case 2051346646:
      return getStatusReason();
    case 50511102:
      return addCategory();
    case -1165461084:
      return getPriorityElement();
    case -1788508167:
      return getDoNotPerformElement();
    case -1078030475:
      return addMedium();
    case -1867885268:
      return getSubject();
    case 92611469:
      return addAbout();
    case 1524132147:
      return getEncounter();
    case -786701938:
      return addPayload();
    case -2022646513:
      return getOccurrence();
    case 1687874001:
      return getOccurrence();
    case -1500852503:
      return getAuthoredOnElement();
    case 693933948:
      return getRequester();
    case 820081177:
      return addRecipient();
    case -905962955:
      return getSender();
    case 722137681:
      return addReasonCode();
    case -1146218137:
      return addReasonReference();
    case 3387378:
      return addNote();
    default:
      return super.makeProperty(hash, name);
    }

  }

  @Override
  public String[] getTypesForProperty(int hash, String name) throws FHIRException {
    switch (hash) {
    case -1618432855:
      /* identifier */ return new String[] { "Identifier" };
    case -332612366:
      /* basedOn */ return new String[] { "Reference" };
    case -430332865:
      /* replaces */ return new String[] { "Reference" };
    case -445338488:
      /* groupIdentifier */ return new String[] { "Identifier" };
    case -892481550:
      /* status */ return new String[] { "code" };
    case 2051346646:
      /* statusReason */ return new String[] { "CodeableConcept" };
    case 50511102:
      /* category */ return new String[] { "CodeableConcept" };
    case -1165461084:
      /* priority */ return new String[] { "code" };
    case -1788508167:
      /* doNotPerform */ return new String[] { "boolean" };
    case -1078030475:
      /* medium */ return new String[] { "CodeableConcept" };
    case -1867885268:
      /* subject */ return new String[] { "Reference" };
    case 92611469:
      /* about */ return new String[] { "Reference" };
    case 1524132147:
      /* encounter */ return new String[] { "Reference" };
    case -786701938:
      /* payload */ return new String[] {};
    case 1687874001:
      /* occurrence */ return new String[] { "dateTime", "Period" };
    case -1500852503:
      /* authoredOn */ return new String[] { "dateTime" };
    case 693933948:
      /* requester */ return new String[] { "Reference" };
    case 820081177:
      /* recipient */ return new String[] { "Reference" };
    case -905962955:
      /* sender */ return new String[] { "Reference" };
    case 722137681:
      /* reasonCode */ return new String[] { "CodeableConcept" };
    case -1146218137:
      /* reasonReference */ return new String[] { "Reference" };
    case 3387378:
      /* note */ return new String[] { "Annotation" };
    default:
      return super.getTypesForProperty(hash, name);
    }

  }

  @Override
  public Base addChild(String name) throws FHIRException {
    if (name.equals("identifier")) {
      return addIdentifier();
    } else if (name.equals("basedOn")) {
      return addBasedOn();
    } else if (name.equals("replaces")) {
      return addReplaces();
    } else if (name.equals("groupIdentifier")) {
      this.groupIdentifier = new Identifier();
      return this.groupIdentifier;
    } else if (name.equals("status")) {
      throw new FHIRException("Cannot call addChild on a singleton property CommunicationRequest.status");
    } else if (name.equals("statusReason")) {
      this.statusReason = new CodeableConcept();
      return this.statusReason;
    } else if (name.equals("category")) {
      return addCategory();
    } else if (name.equals("priority")) {
      throw new FHIRException("Cannot call addChild on a singleton property CommunicationRequest.priority");
    } else if (name.equals("doNotPerform")) {
      throw new FHIRException("Cannot call addChild on a singleton property CommunicationRequest.doNotPerform");
    } else if (name.equals("medium")) {
      return addMedium();
    } else if (name.equals("subject")) {
      this.subject = new Reference();
      return this.subject;
    } else if (name.equals("about")) {
      return addAbout();
    } else if (name.equals("encounter")) {
      this.encounter = new Reference();
      return this.encounter;
    } else if (name.equals("payload")) {
      return addPayload();
    } else if (name.equals("occurrenceDateTime")) {
      this.occurrence = new DateTimeType();
      return this.occurrence;
    } else if (name.equals("occurrencePeriod")) {
      this.occurrence = new Period();
      return this.occurrence;
    } else if (name.equals("authoredOn")) {
      throw new FHIRException("Cannot call addChild on a singleton property CommunicationRequest.authoredOn");
    } else if (name.equals("requester")) {
      this.requester = new Reference();
      return this.requester;
    } else if (name.equals("recipient")) {
      return addRecipient();
    } else if (name.equals("sender")) {
      this.sender = new Reference();
      return this.sender;
    } else if (name.equals("reasonCode")) {
      return addReasonCode();
    } else if (name.equals("reasonReference")) {
      return addReasonReference();
    } else if (name.equals("note")) {
      return addNote();
    } else
      return super.addChild(name);
  }

  public String fhirType() {
    return "CommunicationRequest";

  }

  public CommunicationRequest copy() {
    CommunicationRequest dst = new CommunicationRequest();
    copyValues(dst);
    return dst;
  }

  public void copyValues(CommunicationRequest dst) {
    super.copyValues(dst);
    if (identifier != null) {
      dst.identifier = new ArrayList<Identifier>();
      for (Identifier i : identifier)
        dst.identifier.add(i.copy());
    }
    ;
    if (basedOn != null) {
      dst.basedOn = new ArrayList<Reference>();
      for (Reference i : basedOn)
        dst.basedOn.add(i.copy());
    }
    ;
    if (replaces != null) {
      dst.replaces = new ArrayList<Reference>();
      for (Reference i : replaces)
        dst.replaces.add(i.copy());
    }
    ;
    dst.groupIdentifier = groupIdentifier == null ? null : groupIdentifier.copy();
    dst.status = status == null ? null : status.copy();
    dst.statusReason = statusReason == null ? null : statusReason.copy();
    if (category != null) {
      dst.category = new ArrayList<CodeableConcept>();
      for (CodeableConcept i : category)
        dst.category.add(i.copy());
    }
    ;
    dst.priority = priority == null ? null : priority.copy();
    dst.doNotPerform = doNotPerform == null ? null : doNotPerform.copy();
    if (medium != null) {
      dst.medium = new ArrayList<CodeableConcept>();
      for (CodeableConcept i : medium)
        dst.medium.add(i.copy());
    }
    ;
    dst.subject = subject == null ? null : subject.copy();
    if (about != null) {
      dst.about = new ArrayList<Reference>();
      for (Reference i : about)
        dst.about.add(i.copy());
    }
    ;
    dst.encounter = encounter == null ? null : encounter.copy();
    if (payload != null) {
      dst.payload = new ArrayList<CommunicationRequestPayloadComponent>();
      for (CommunicationRequestPayloadComponent i : payload)
        dst.payload.add(i.copy());
    }
    ;
    dst.occurrence = occurrence == null ? null : occurrence.copy();
    dst.authoredOn = authoredOn == null ? null : authoredOn.copy();
    dst.requester = requester == null ? null : requester.copy();
    if (recipient != null) {
      dst.recipient = new ArrayList<Reference>();
      for (Reference i : recipient)
        dst.recipient.add(i.copy());
    }
    ;
    dst.sender = sender == null ? null : sender.copy();
    if (reasonCode != null) {
      dst.reasonCode = new ArrayList<CodeableConcept>();
      for (CodeableConcept i : reasonCode)
        dst.reasonCode.add(i.copy());
    }
    ;
    if (reasonReference != null) {
      dst.reasonReference = new ArrayList<Reference>();
      for (Reference i : reasonReference)
        dst.reasonReference.add(i.copy());
    }
    ;
    if (note != null) {
      dst.note = new ArrayList<Annotation>();
      for (Annotation i : note)
        dst.note.add(i.copy());
    }
    ;
  }

  protected CommunicationRequest typedCopy() {
    return copy();
  }

  @Override
  public boolean equalsDeep(Base other_) {
    if (!super.equalsDeep(other_))
      return false;
    if (!(other_ instanceof CommunicationRequest))
      return false;
    CommunicationRequest o = (CommunicationRequest) other_;
    return compareDeep(identifier, o.identifier, true) && compareDeep(basedOn, o.basedOn, true)
        && compareDeep(replaces, o.replaces, true) && compareDeep(groupIdentifier, o.groupIdentifier, true)
        && compareDeep(status, o.status, true) && compareDeep(statusReason, o.statusReason, true)
        && compareDeep(category, o.category, true) && compareDeep(priority, o.priority, true)
        && compareDeep(doNotPerform, o.doNotPerform, true) && compareDeep(medium, o.medium, true)
        && compareDeep(subject, o.subject, true) && compareDeep(about, o.about, true)
        && compareDeep(encounter, o.encounter, true) && compareDeep(payload, o.payload, true)
        && compareDeep(occurrence, o.occurrence, true) && compareDeep(authoredOn, o.authoredOn, true)
        && compareDeep(requester, o.requester, true) && compareDeep(recipient, o.recipient, true)
        && compareDeep(sender, o.sender, true) && compareDeep(reasonCode, o.reasonCode, true)
        && compareDeep(reasonReference, o.reasonReference, true) && compareDeep(note, o.note, true);
  }

  @Override
  public boolean equalsShallow(Base other_) {
    if (!super.equalsShallow(other_))
      return false;
    if (!(other_ instanceof CommunicationRequest))
      return false;
    CommunicationRequest o = (CommunicationRequest) other_;
    return compareValues(status, o.status, true) && compareValues(priority, o.priority, true)
        && compareValues(doNotPerform, o.doNotPerform, true) && compareValues(authoredOn, o.authoredOn, true);
  }

  public boolean isEmpty() {
    return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, basedOn, replaces, groupIdentifier,
        status, statusReason, category, priority, doNotPerform, medium, subject, about, encounter, payload, occurrence,
        authoredOn, requester, recipient, sender, reasonCode, reasonReference, note);
  }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.CommunicationRequest;
  }

  /**
   * Search parameter: <b>requester</b>
   * <p>
   * Description: <b>Who/what is requesting service</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CommunicationRequest.requester</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "requester", path = "CommunicationRequest.requester", description = "Who/what is requesting service", type = "reference", providesMembershipIn = {
      @ca.uhn.fhir.model.api.annotation.Compartment(name = "Patient"),
      @ca.uhn.fhir.model.api.annotation.Compartment(name = "Practitioner"),
      @ca.uhn.fhir.model.api.annotation.Compartment(name = "RelatedPerson") }, target = { Device.class,
          Organization.class, Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class })
  public static final String SP_REQUESTER = "requester";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>requester</b>
   * <p>
   * Description: <b>Who/what is requesting service</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CommunicationRequest.requester</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam REQUESTER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(
      SP_REQUESTER);

  /**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>CommunicationRequest:requester</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_REQUESTER = new ca.uhn.fhir.model.api.Include(
      "CommunicationRequest:requester").toLocked();

  /**
   * Search parameter: <b>authored</b>
   * <p>
   * Description: <b>When request transitioned to being actionable</b><br>
   * Type: <b>date</b><br>
   * Path: <b>CommunicationRequest.authoredOn</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "authored", path = "CommunicationRequest.authoredOn", description = "When request transitioned to being actionable", type = "date")
  public static final String SP_AUTHORED = "authored";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>authored</b>
   * <p>
   * Description: <b>When request transitioned to being actionable</b><br>
   * Type: <b>date</b><br>
   * Path: <b>CommunicationRequest.authoredOn</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam AUTHORED = new ca.uhn.fhir.rest.gclient.DateClientParam(
      SP_AUTHORED);

  /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>Unique identifier</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CommunicationRequest.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "identifier", path = "CommunicationRequest.identifier", description = "Unique identifier", type = "token")
  public static final String SP_IDENTIFIER = "identifier";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>Unique identifier</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CommunicationRequest.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(
      SP_IDENTIFIER);

  /**
   * Search parameter: <b>subject</b>
   * <p>
   * Description: <b>Focus of message</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CommunicationRequest.subject</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "subject", path = "CommunicationRequest.subject", description = "Focus of message", type = "reference", providesMembershipIn = {
      @ca.uhn.fhir.model.api.annotation.Compartment(name = "Patient") }, target = { Group.class, Patient.class })
  public static final String SP_SUBJECT = "subject";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>subject</b>
   * <p>
   * Description: <b>Focus of message</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CommunicationRequest.subject</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SUBJECT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(
      SP_SUBJECT);

  /**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>CommunicationRequest:subject</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SUBJECT = new ca.uhn.fhir.model.api.Include(
      "CommunicationRequest:subject").toLocked();

  /**
   * Search parameter: <b>replaces</b>
   * <p>
   * Description: <b>Request(s) replaced by this request</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CommunicationRequest.replaces</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "replaces", path = "CommunicationRequest.replaces", description = "Request(s) replaced by this request", type = "reference", target = {
      CommunicationRequest.class })
  public static final String SP_REPLACES = "replaces";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>replaces</b>
   * <p>
   * Description: <b>Request(s) replaced by this request</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CommunicationRequest.replaces</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam REPLACES = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(
      SP_REPLACES);

  /**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>CommunicationRequest:replaces</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_REPLACES = new ca.uhn.fhir.model.api.Include(
      "CommunicationRequest:replaces").toLocked();

  /**
   * Search parameter: <b>medium</b>
   * <p>
   * Description: <b>A channel of communication</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CommunicationRequest.medium</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "medium", path = "CommunicationRequest.medium", description = "A channel of communication", type = "token")
  public static final String SP_MEDIUM = "medium";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>medium</b>
   * <p>
   * Description: <b>A channel of communication</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CommunicationRequest.medium</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam MEDIUM = new ca.uhn.fhir.rest.gclient.TokenClientParam(
      SP_MEDIUM);

  /**
   * Search parameter: <b>encounter</b>
   * <p>
   * Description: <b>Encounter created as part of</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CommunicationRequest.encounter</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "encounter", path = "CommunicationRequest.encounter", description = "Encounter created as part of", type = "reference", providesMembershipIn = {
      @ca.uhn.fhir.model.api.annotation.Compartment(name = "Encounter") }, target = { Encounter.class })
  public static final String SP_ENCOUNTER = "encounter";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>encounter</b>
   * <p>
   * Description: <b>Encounter created as part of</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CommunicationRequest.encounter</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam ENCOUNTER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(
      SP_ENCOUNTER);

  /**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>CommunicationRequest:encounter</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_ENCOUNTER = new ca.uhn.fhir.model.api.Include(
      "CommunicationRequest:encounter").toLocked();

  /**
   * Search parameter: <b>occurrence</b>
   * <p>
   * Description: <b>When scheduled</b><br>
   * Type: <b>date</b><br>
   * Path: <b>CommunicationRequest.occurrenceDateTime</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "occurrence", path = "(CommunicationRequest.occurrence as dateTime)", description = "When scheduled", type = "date")
  public static final String SP_OCCURRENCE = "occurrence";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>occurrence</b>
   * <p>
   * Description: <b>When scheduled</b><br>
   * Type: <b>date</b><br>
   * Path: <b>CommunicationRequest.occurrenceDateTime</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam OCCURRENCE = new ca.uhn.fhir.rest.gclient.DateClientParam(
      SP_OCCURRENCE);

  /**
   * Search parameter: <b>priority</b>
   * <p>
   * Description: <b>routine | urgent | asap | stat</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CommunicationRequest.priority</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "priority", path = "CommunicationRequest.priority", description = "routine | urgent | asap | stat", type = "token")
  public static final String SP_PRIORITY = "priority";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>priority</b>
   * <p>
   * Description: <b>routine | urgent | asap | stat</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CommunicationRequest.priority</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam PRIORITY = new ca.uhn.fhir.rest.gclient.TokenClientParam(
      SP_PRIORITY);

  /**
   * Search parameter: <b>group-identifier</b>
   * <p>
   * Description: <b>Composite request this is part of</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CommunicationRequest.groupIdentifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "group-identifier", path = "CommunicationRequest.groupIdentifier", description = "Composite request this is part of", type = "token")
  public static final String SP_GROUP_IDENTIFIER = "group-identifier";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>group-identifier</b>
   * <p>
   * Description: <b>Composite request this is part of</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CommunicationRequest.groupIdentifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam GROUP_IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(
      SP_GROUP_IDENTIFIER);

  /**
   * Search parameter: <b>based-on</b>
   * <p>
   * Description: <b>Fulfills plan or proposal</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CommunicationRequest.basedOn</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "based-on", path = "CommunicationRequest.basedOn", description = "Fulfills plan or proposal", type = "reference")
  public static final String SP_BASED_ON = "based-on";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>based-on</b>
   * <p>
   * Description: <b>Fulfills plan or proposal</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CommunicationRequest.basedOn</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam BASED_ON = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(
      SP_BASED_ON);

  /**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>CommunicationRequest:based-on</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_BASED_ON = new ca.uhn.fhir.model.api.Include(
      "CommunicationRequest:based-on").toLocked();

  /**
   * Search parameter: <b>sender</b>
   * <p>
   * Description: <b>Message sender</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CommunicationRequest.sender</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "sender", path = "CommunicationRequest.sender", description = "Message sender", type = "reference", providesMembershipIn = {
      @ca.uhn.fhir.model.api.annotation.Compartment(name = "Device"),
      @ca.uhn.fhir.model.api.annotation.Compartment(name = "Patient"),
      @ca.uhn.fhir.model.api.annotation.Compartment(name = "Practitioner"),
      @ca.uhn.fhir.model.api.annotation.Compartment(name = "RelatedPerson") }, target = { Device.class,
          HealthcareService.class, Organization.class, Patient.class, Practitioner.class, PractitionerRole.class,
          RelatedPerson.class })
  public static final String SP_SENDER = "sender";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>sender</b>
   * <p>
   * Description: <b>Message sender</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CommunicationRequest.sender</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SENDER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(
      SP_SENDER);

  /**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>CommunicationRequest:sender</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SENDER = new ca.uhn.fhir.model.api.Include(
      "CommunicationRequest:sender").toLocked();

  /**
   * Search parameter: <b>patient</b>
   * <p>
   * Description: <b>Focus of message</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CommunicationRequest.subject</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "patient", path = "CommunicationRequest.subject.where(resolve() is Patient)", description = "Focus of message", type = "reference", target = {
      Patient.class })
  public static final String SP_PATIENT = "patient";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>patient</b>
   * <p>
   * Description: <b>Focus of message</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CommunicationRequest.subject</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PATIENT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(
      SP_PATIENT);

  /**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>CommunicationRequest:patient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PATIENT = new ca.uhn.fhir.model.api.Include(
      "CommunicationRequest:patient").toLocked();

  /**
   * Search parameter: <b>recipient</b>
   * <p>
   * Description: <b>Message recipient</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CommunicationRequest.recipient</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "recipient", path = "CommunicationRequest.recipient", description = "Message recipient", type = "reference", providesMembershipIn = {
      @ca.uhn.fhir.model.api.annotation.Compartment(name = "Device"),
      @ca.uhn.fhir.model.api.annotation.Compartment(name = "Patient"),
      @ca.uhn.fhir.model.api.annotation.Compartment(name = "Practitioner"),
      @ca.uhn.fhir.model.api.annotation.Compartment(name = "RelatedPerson") }, target = { CareTeam.class, Device.class,
          Group.class, HealthcareService.class, Organization.class, Patient.class, Practitioner.class,
          PractitionerRole.class, RelatedPerson.class })
  public static final String SP_RECIPIENT = "recipient";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>recipient</b>
   * <p>
   * Description: <b>Message recipient</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CommunicationRequest.recipient</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam RECIPIENT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(
      SP_RECIPIENT);

  /**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>CommunicationRequest:recipient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_RECIPIENT = new ca.uhn.fhir.model.api.Include(
      "CommunicationRequest:recipient").toLocked();

  /**
   * Search parameter: <b>category</b>
   * <p>
   * Description: <b>Message category</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CommunicationRequest.category</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "category", path = "CommunicationRequest.category", description = "Message category", type = "token")
  public static final String SP_CATEGORY = "category";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>category</b>
   * <p>
   * Description: <b>Message category</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CommunicationRequest.category</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CATEGORY = new ca.uhn.fhir.rest.gclient.TokenClientParam(
      SP_CATEGORY);

  /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>draft | active | on-hold | revoked | completed |
   * entered-in-error | unknown</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CommunicationRequest.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "status", path = "CommunicationRequest.status", description = "draft | active | on-hold | revoked | completed | entered-in-error | unknown", type = "token")
  public static final String SP_STATUS = "status";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>draft | active | on-hold | revoked | completed |
   * entered-in-error | unknown</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CommunicationRequest.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(
      SP_STATUS);

}
