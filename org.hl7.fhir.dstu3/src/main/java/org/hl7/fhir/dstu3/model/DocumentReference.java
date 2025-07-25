package org.hl7.fhir.dstu3.model;



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

// Generated on Fri, Mar 16, 2018 15:21+1100 for FHIR v3.0.x
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hl7.fhir.dstu3.model.Enumerations.DocumentReferenceStatus;
import org.hl7.fhir.dstu3.model.Enumerations.DocumentReferenceStatusEnumFactory;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.IBaseBackboneElement;
import org.hl7.fhir.utilities.Utilities;

import ca.uhn.fhir.model.api.annotation.Block;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import ca.uhn.fhir.model.api.annotation.SearchParamDefinition;
/**
 * A reference to a document.
 */
@ResourceDef(name="DocumentReference", profile="http://hl7.org/fhir/Profile/DocumentReference")
public class DocumentReference extends DomainResource {

    public enum ReferredDocumentStatus {
        /**
         * This is a preliminary composition or document (also known as initial or interim). The content may be incomplete or unverified.
         */
        PRELIMINARY, 
        /**
         * This version of the composition is complete and verified by an appropriate person and no further work is planned. Any subsequent updates would be on a new version of the composition.
         */
        FINAL, 
        /**
         * The composition content or the referenced resources have been modified (edited or added to) subsequent to being released as "final" and the composition is complete and verified by an authorized person.
         */
        AMENDED, 
        /**
         * The composition or document was originally created/issued in error, and this is an amendment that marks that the entire series should not be considered as valid.
         */
        ENTEREDINERROR, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static ReferredDocumentStatus fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("preliminary".equals(codeString))
          return PRELIMINARY;
        if ("final".equals(codeString))
          return FINAL;
        if ("amended".equals(codeString))
          return AMENDED;
        if ("entered-in-error".equals(codeString))
          return ENTEREDINERROR;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown ReferredDocumentStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case PRELIMINARY: return "preliminary";
            case FINAL: return "final";
            case AMENDED: return "amended";
            case ENTEREDINERROR: return "entered-in-error";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case PRELIMINARY: return "http://hl7.org/fhir/composition-status";
            case FINAL: return "http://hl7.org/fhir/composition-status";
            case AMENDED: return "http://hl7.org/fhir/composition-status";
            case ENTEREDINERROR: return "http://hl7.org/fhir/composition-status";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case PRELIMINARY: return "This is a preliminary composition or document (also known as initial or interim). The content may be incomplete or unverified.";
            case FINAL: return "This version of the composition is complete and verified by an appropriate person and no further work is planned. Any subsequent updates would be on a new version of the composition.";
            case AMENDED: return "The composition content or the referenced resources have been modified (edited or added to) subsequent to being released as \"final\" and the composition is complete and verified by an authorized person.";
            case ENTEREDINERROR: return "The composition or document was originally created/issued in error, and this is an amendment that marks that the entire series should not be considered as valid.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case PRELIMINARY: return "Preliminary";
            case FINAL: return "Final";
            case AMENDED: return "Amended";
            case ENTEREDINERROR: return "Entered in Error";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class ReferredDocumentStatusEnumFactory implements EnumFactory<ReferredDocumentStatus> {
    public ReferredDocumentStatus fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("preliminary".equals(codeString))
          return ReferredDocumentStatus.PRELIMINARY;
        if ("final".equals(codeString))
          return ReferredDocumentStatus.FINAL;
        if ("amended".equals(codeString))
          return ReferredDocumentStatus.AMENDED;
        if ("entered-in-error".equals(codeString))
          return ReferredDocumentStatus.ENTEREDINERROR;
        throw new IllegalArgumentException("Unknown ReferredDocumentStatus code '"+codeString+"'");
        }
        public Enumeration<ReferredDocumentStatus> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<ReferredDocumentStatus>(this);
          String codeString = code.asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("preliminary".equals(codeString))
          return new Enumeration<ReferredDocumentStatus>(this, ReferredDocumentStatus.PRELIMINARY);
        if ("final".equals(codeString))
          return new Enumeration<ReferredDocumentStatus>(this, ReferredDocumentStatus.FINAL);
        if ("amended".equals(codeString))
          return new Enumeration<ReferredDocumentStatus>(this, ReferredDocumentStatus.AMENDED);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<ReferredDocumentStatus>(this, ReferredDocumentStatus.ENTEREDINERROR);
        throw new FHIRException("Unknown ReferredDocumentStatus code '"+codeString+"'");
        }
    public String toCode(ReferredDocumentStatus code) {
       if (code == ReferredDocumentStatus.NULL)
           return null;
       if (code == ReferredDocumentStatus.PRELIMINARY)
        return "preliminary";
      if (code == ReferredDocumentStatus.FINAL)
        return "final";
      if (code == ReferredDocumentStatus.AMENDED)
        return "amended";
      if (code == ReferredDocumentStatus.ENTEREDINERROR)
        return "entered-in-error";
      return "?";
   }
    public String toSystem(ReferredDocumentStatus code) {
      return code.getSystem();
      }
    }

    public enum DocumentRelationshipType {
        /**
         * This document logically replaces or supersedes the target document.
         */
        REPLACES, 
        /**
         * This document was generated by transforming the target document (e.g. format or language conversion).
         */
        TRANSFORMS, 
        /**
         * This document is a signature of the target document.
         */
        SIGNS, 
        /**
         * This document adds additional information to the target document.
         */
        APPENDS, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static DocumentRelationshipType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("replaces".equals(codeString))
          return REPLACES;
        if ("transforms".equals(codeString))
          return TRANSFORMS;
        if ("signs".equals(codeString))
          return SIGNS;
        if ("appends".equals(codeString))
          return APPENDS;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown DocumentRelationshipType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case REPLACES: return "replaces";
            case TRANSFORMS: return "transforms";
            case SIGNS: return "signs";
            case APPENDS: return "appends";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case REPLACES: return "http://hl7.org/fhir/document-relationship-type";
            case TRANSFORMS: return "http://hl7.org/fhir/document-relationship-type";
            case SIGNS: return "http://hl7.org/fhir/document-relationship-type";
            case APPENDS: return "http://hl7.org/fhir/document-relationship-type";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case REPLACES: return "This document logically replaces or supersedes the target document.";
            case TRANSFORMS: return "This document was generated by transforming the target document (e.g. format or language conversion).";
            case SIGNS: return "This document is a signature of the target document.";
            case APPENDS: return "This document adds additional information to the target document.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case REPLACES: return "Replaces";
            case TRANSFORMS: return "Transforms";
            case SIGNS: return "Signs";
            case APPENDS: return "Appends";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class DocumentRelationshipTypeEnumFactory implements EnumFactory<DocumentRelationshipType> {
    public DocumentRelationshipType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("replaces".equals(codeString))
          return DocumentRelationshipType.REPLACES;
        if ("transforms".equals(codeString))
          return DocumentRelationshipType.TRANSFORMS;
        if ("signs".equals(codeString))
          return DocumentRelationshipType.SIGNS;
        if ("appends".equals(codeString))
          return DocumentRelationshipType.APPENDS;
        throw new IllegalArgumentException("Unknown DocumentRelationshipType code '"+codeString+"'");
        }
        public Enumeration<DocumentRelationshipType> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<DocumentRelationshipType>(this);
          String codeString = code.asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("replaces".equals(codeString))
          return new Enumeration<DocumentRelationshipType>(this, DocumentRelationshipType.REPLACES);
        if ("transforms".equals(codeString))
          return new Enumeration<DocumentRelationshipType>(this, DocumentRelationshipType.TRANSFORMS);
        if ("signs".equals(codeString))
          return new Enumeration<DocumentRelationshipType>(this, DocumentRelationshipType.SIGNS);
        if ("appends".equals(codeString))
          return new Enumeration<DocumentRelationshipType>(this, DocumentRelationshipType.APPENDS);
        throw new FHIRException("Unknown DocumentRelationshipType code '"+codeString+"'");
        }
    public String toCode(DocumentRelationshipType code) {
       if (code == DocumentRelationshipType.NULL)
           return null;
       if (code == DocumentRelationshipType.REPLACES)
        return "replaces";
      if (code == DocumentRelationshipType.TRANSFORMS)
        return "transforms";
      if (code == DocumentRelationshipType.SIGNS)
        return "signs";
      if (code == DocumentRelationshipType.APPENDS)
        return "appends";
      return "?";
   }
    public String toSystem(DocumentRelationshipType code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class DocumentReferenceRelatesToComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The type of relationship that this document has with anther document.
         */
        @Child(name = "code", type = {CodeType.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="replaces | transforms | signs | appends", formalDefinition="The type of relationship that this document has with anther document." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/document-relationship-type")
        protected Enumeration<DocumentRelationshipType> code;

        /**
         * The target document of this relationship.
         */
        @Child(name = "target", type = {DocumentReference.class}, order=2, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Target of the relationship", formalDefinition="The target document of this relationship." )
        protected Reference target;

        /**
         * The actual object that is the target of the reference (The target document of this relationship.)
         */
        protected DocumentReference targetTarget;

        private static final long serialVersionUID = -347257495L;

    /**
     * Constructor
     */
      public DocumentReferenceRelatesToComponent() {
        super();
      }

    /**
     * Constructor
     */
      public DocumentReferenceRelatesToComponent(Enumeration<DocumentRelationshipType> code, Reference target) {
        super();
        this.code = code;
        this.target = target;
      }

        /**
         * @return {@link #code} (The type of relationship that this document has with anther document.). This is the underlying object with id, value and extensions. The accessor "getCode" gives direct access to the value
         */
        public Enumeration<DocumentRelationshipType> getCodeElement() { 
          if (this.code == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DocumentReferenceRelatesToComponent.code");
            else if (Configuration.doAutoCreate())
              this.code = new Enumeration<DocumentRelationshipType>(new DocumentRelationshipTypeEnumFactory()); // bb
          return this.code;
        }

        public boolean hasCodeElement() { 
          return this.code != null && !this.code.isEmpty();
        }

        public boolean hasCode() { 
          return this.code != null && !this.code.isEmpty();
        }

        /**
         * @param value {@link #code} (The type of relationship that this document has with anther document.). This is the underlying object with id, value and extensions. The accessor "getCode" gives direct access to the value
         */
        public DocumentReferenceRelatesToComponent setCodeElement(Enumeration<DocumentRelationshipType> value) { 
          this.code = value;
          return this;
        }

        /**
         * @return The type of relationship that this document has with anther document.
         */
        public DocumentRelationshipType getCode() { 
          return this.code == null ? null : this.code.getValue();
        }

        /**
         * @param value The type of relationship that this document has with anther document.
         */
        public DocumentReferenceRelatesToComponent setCode(DocumentRelationshipType value) { 
            if (this.code == null)
              this.code = new Enumeration<DocumentRelationshipType>(new DocumentRelationshipTypeEnumFactory());
            this.code.setValue(value);
          return this;
        }

        /**
         * @return {@link #target} (The target document of this relationship.)
         */
        public Reference getTarget() { 
          if (this.target == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DocumentReferenceRelatesToComponent.target");
            else if (Configuration.doAutoCreate())
              this.target = new Reference(); // cc
          return this.target;
        }

        public boolean hasTarget() { 
          return this.target != null && !this.target.isEmpty();
        }

        /**
         * @param value {@link #target} (The target document of this relationship.)
         */
        public DocumentReferenceRelatesToComponent setTarget(Reference value)  { 
          this.target = value;
          return this;
        }

        /**
         * @return {@link #target} The actual object that is the target of the reference. The reference library doesn't populate this, but you can use it to hold the resource if you resolve it. (The target document of this relationship.)
         */
        public DocumentReference getTargetTarget() { 
          if (this.targetTarget == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DocumentReferenceRelatesToComponent.target");
            else if (Configuration.doAutoCreate())
              this.targetTarget = new DocumentReference(); // aa
          return this.targetTarget;
        }

        /**
         * @param value {@link #target} The actual object that is the target of the reference. The reference library doesn't use these, but you can use it to hold the resource if you resolve it. (The target document of this relationship.)
         */
        public DocumentReferenceRelatesToComponent setTargetTarget(DocumentReference value) { 
          this.targetTarget = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("code", "code", "The type of relationship that this document has with anther document.", 0, 1, code));
          children.add(new Property("target", "Reference(DocumentReference)", "The target document of this relationship.", 0, 1, target));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3059181: /*code*/  return new Property("code", "code", "The type of relationship that this document has with anther document.", 0, 1, code);
          case -880905839: /*target*/  return new Property("target", "Reference(DocumentReference)", "The target document of this relationship.", 0, 1, target);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // Enumeration<DocumentRelationshipType>
        case -880905839: /*target*/ return this.target == null ? new Base[0] : new Base[] {this.target}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3059181: // code
          value = new DocumentRelationshipTypeEnumFactory().fromType(castToCode(value));
          this.code = (Enumeration) value; // Enumeration<DocumentRelationshipType>
          return value;
        case -880905839: // target
          this.target = castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("code")) {
          value = new DocumentRelationshipTypeEnumFactory().fromType(castToCode(value));
          this.code = (Enumeration) value; // Enumeration<DocumentRelationshipType>
        } else if (name.equals("target")) {
          this.target = castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181:  return getCodeElement();
        case -880905839:  return getTarget(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return new String[] {"code"};
        case -880905839: /*target*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("code")) {
          throw new FHIRException("Cannot call addChild on a singleton property DocumentReference.code");
        }
        else if (name.equals("target")) {
          this.target = new Reference();
          return this.target;
        }
        else
          return super.addChild(name);
      }

      public DocumentReferenceRelatesToComponent copy() {
        DocumentReferenceRelatesToComponent dst = new DocumentReferenceRelatesToComponent();
        copyValues(dst);
        dst.code = code == null ? null : code.copy();
        dst.target = target == null ? null : target.copy();
        return dst;
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DocumentReferenceRelatesToComponent))
          return false;
        DocumentReferenceRelatesToComponent o = (DocumentReferenceRelatesToComponent) other_;
        return compareDeep(code, o.code, true) && compareDeep(target, o.target, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DocumentReferenceRelatesToComponent))
          return false;
        DocumentReferenceRelatesToComponent o = (DocumentReferenceRelatesToComponent) other_;
        return compareValues(code, o.code, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(code, target);
      }

  public String fhirType() {
    return "DocumentReference.relatesTo";

  }

  }

    @Block()
    public static class DocumentReferenceContentComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The document or URL of the document along with critical metadata to prove content has integrity.
         */
        @Child(name = "attachment", type = {Attachment.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Where to access the document", formalDefinition="The document or URL of the document along with critical metadata to prove content has integrity." )
        protected Attachment attachment;

        /**
         * An identifier of the document encoding, structure, and template that the document conforms to beyond the base format indicated in the mimeType.
         */
        @Child(name = "format", type = {Coding.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Format/content rules for the document", formalDefinition="An identifier of the document encoding, structure, and template that the document conforms to beyond the base format indicated in the mimeType." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/formatcodes")
        protected Coding format;

        private static final long serialVersionUID = -1313860217L;

    /**
     * Constructor
     */
      public DocumentReferenceContentComponent() {
        super();
      }

    /**
     * Constructor
     */
      public DocumentReferenceContentComponent(Attachment attachment) {
        super();
        this.attachment = attachment;
      }

        /**
         * @return {@link #attachment} (The document or URL of the document along with critical metadata to prove content has integrity.)
         */
        public Attachment getAttachment() { 
          if (this.attachment == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DocumentReferenceContentComponent.attachment");
            else if (Configuration.doAutoCreate())
              this.attachment = new Attachment(); // cc
          return this.attachment;
        }

        public boolean hasAttachment() { 
          return this.attachment != null && !this.attachment.isEmpty();
        }

        /**
         * @param value {@link #attachment} (The document or URL of the document along with critical metadata to prove content has integrity.)
         */
        public DocumentReferenceContentComponent setAttachment(Attachment value)  { 
          this.attachment = value;
          return this;
        }

        /**
         * @return {@link #format} (An identifier of the document encoding, structure, and template that the document conforms to beyond the base format indicated in the mimeType.)
         */
        public Coding getFormat() { 
          if (this.format == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DocumentReferenceContentComponent.format");
            else if (Configuration.doAutoCreate())
              this.format = new Coding(); // cc
          return this.format;
        }

        public boolean hasFormat() { 
          return this.format != null && !this.format.isEmpty();
        }

        /**
         * @param value {@link #format} (An identifier of the document encoding, structure, and template that the document conforms to beyond the base format indicated in the mimeType.)
         */
        public DocumentReferenceContentComponent setFormat(Coding value)  { 
          this.format = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("attachment", "Attachment", "The document or URL of the document along with critical metadata to prove content has integrity.", 0, 1, attachment));
          children.add(new Property("format", "Coding", "An identifier of the document encoding, structure, and template that the document conforms to beyond the base format indicated in the mimeType.", 0, 1, format));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1963501277: /*attachment*/  return new Property("attachment", "Attachment", "The document or URL of the document along with critical metadata to prove content has integrity.", 0, 1, attachment);
          case -1268779017: /*format*/  return new Property("format", "Coding", "An identifier of the document encoding, structure, and template that the document conforms to beyond the base format indicated in the mimeType.", 0, 1, format);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1963501277: /*attachment*/ return this.attachment == null ? new Base[0] : new Base[] {this.attachment}; // Attachment
        case -1268779017: /*format*/ return this.format == null ? new Base[0] : new Base[] {this.format}; // Coding
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1963501277: // attachment
          this.attachment = castToAttachment(value); // Attachment
          return value;
        case -1268779017: // format
          this.format = castToCoding(value); // Coding
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("attachment")) {
          this.attachment = castToAttachment(value); // Attachment
        } else if (name.equals("format")) {
          this.format = castToCoding(value); // Coding
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1963501277:  return getAttachment(); 
        case -1268779017:  return getFormat(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1963501277: /*attachment*/ return new String[] {"Attachment"};
        case -1268779017: /*format*/ return new String[] {"Coding"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("attachment")) {
          this.attachment = new Attachment();
          return this.attachment;
        }
        else if (name.equals("format")) {
          this.format = new Coding();
          return this.format;
        }
        else
          return super.addChild(name);
      }

      public DocumentReferenceContentComponent copy() {
        DocumentReferenceContentComponent dst = new DocumentReferenceContentComponent();
        copyValues(dst);
        dst.attachment = attachment == null ? null : attachment.copy();
        dst.format = format == null ? null : format.copy();
        return dst;
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DocumentReferenceContentComponent))
          return false;
        DocumentReferenceContentComponent o = (DocumentReferenceContentComponent) other_;
        return compareDeep(attachment, o.attachment, true) && compareDeep(format, o.format, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DocumentReferenceContentComponent))
          return false;
        DocumentReferenceContentComponent o = (DocumentReferenceContentComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(attachment, format);
      }

  public String fhirType() {
    return "DocumentReference.content";

  }

  }

    @Block()
    public static class DocumentReferenceContextComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Describes the clinical encounter or type of care that the document content is associated with.
         */
        @Child(name = "encounter", type = {Encounter.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Context of the document  content", formalDefinition="Describes the clinical encounter or type of care that the document content is associated with." )
        protected Reference encounter;

        /**
         * The actual object that is the target of the reference (Describes the clinical encounter or type of care that the document content is associated with.)
         */
        protected Encounter encounterTarget;

        /**
         * This list of codes represents the main clinical acts, such as a colonoscopy or an appendectomy, being documented. In some cases, the event is inherent in the typeCode, such as a "History and Physical Report" in which the procedure being documented is necessarily a "History and Physical" act.
         */
        @Child(name = "event", type = {CodeableConcept.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Main clinical acts documented", formalDefinition="This list of codes represents the main clinical acts, such as a colonoscopy or an appendectomy, being documented. In some cases, the event is inherent in the typeCode, such as a \"History and Physical Report\" in which the procedure being documented is necessarily a \"History and Physical\" act." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/v3-ActCode")
        protected List<CodeableConcept> event;

        /**
         * The time period over which the service that is described by the document was provided.
         */
        @Child(name = "period", type = {Period.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Time of service that is being documented", formalDefinition="The time period over which the service that is described by the document was provided." )
        protected Period period;

        /**
         * The kind of facility where the patient was seen.
         */
        @Child(name = "facilityType", type = {CodeableConcept.class}, order=4, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Kind of facility where patient was seen", formalDefinition="The kind of facility where the patient was seen." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/c80-facilitycodes")
        protected CodeableConcept facilityType;

        /**
         * This property may convey specifics about the practice setting where the content was created, often reflecting the clinical specialty.
         */
        @Child(name = "practiceSetting", type = {CodeableConcept.class}, order=5, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Additional details about where the content was created (e.g. clinical specialty)", formalDefinition="This property may convey specifics about the practice setting where the content was created, often reflecting the clinical specialty." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/c80-practice-codes")
        protected CodeableConcept practiceSetting;

        /**
         * The Patient Information as known when the document was published. May be a reference to a version specific, or contained.
         */
        @Child(name = "sourcePatientInfo", type = {Patient.class}, order=6, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Patient demographics from source", formalDefinition="The Patient Information as known when the document was published. May be a reference to a version specific, or contained." )
        protected Reference sourcePatientInfo;

        /**
         * The actual object that is the target of the reference (The Patient Information as known when the document was published. May be a reference to a version specific, or contained.)
         */
        protected Patient sourcePatientInfoTarget;

        /**
         * Related identifiers or resources associated with the DocumentReference.
         */
        @Child(name = "related", type = {}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Related identifiers or resources", formalDefinition="Related identifiers or resources associated with the DocumentReference." )
        protected List<DocumentReferenceContextRelatedComponent> related;

        private static final long serialVersionUID = 994799273L;

    /**
     * Constructor
     */
      public DocumentReferenceContextComponent() {
        super();
      }

        /**
         * @return {@link #encounter} (Describes the clinical encounter or type of care that the document content is associated with.)
         */
        public Reference getEncounter() { 
          if (this.encounter == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DocumentReferenceContextComponent.encounter");
            else if (Configuration.doAutoCreate())
              this.encounter = new Reference(); // cc
          return this.encounter;
        }

        public boolean hasEncounter() { 
          return this.encounter != null && !this.encounter.isEmpty();
        }

        /**
         * @param value {@link #encounter} (Describes the clinical encounter or type of care that the document content is associated with.)
         */
        public DocumentReferenceContextComponent setEncounter(Reference value)  { 
          this.encounter = value;
          return this;
        }

        /**
         * @return {@link #encounter} The actual object that is the target of the reference. The reference library doesn't populate this, but you can use it to hold the resource if you resolve it. (Describes the clinical encounter or type of care that the document content is associated with.)
         */
        public Encounter getEncounterTarget() { 
          if (this.encounterTarget == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DocumentReferenceContextComponent.encounter");
            else if (Configuration.doAutoCreate())
              this.encounterTarget = new Encounter(); // aa
          return this.encounterTarget;
        }

        /**
         * @param value {@link #encounter} The actual object that is the target of the reference. The reference library doesn't use these, but you can use it to hold the resource if you resolve it. (Describes the clinical encounter or type of care that the document content is associated with.)
         */
        public DocumentReferenceContextComponent setEncounterTarget(Encounter value) { 
          this.encounterTarget = value;
          return this;
        }

        /**
         * @return {@link #event} (This list of codes represents the main clinical acts, such as a colonoscopy or an appendectomy, being documented. In some cases, the event is inherent in the typeCode, such as a "History and Physical Report" in which the procedure being documented is necessarily a "History and Physical" act.)
         */
        public List<CodeableConcept> getEvent() { 
          if (this.event == null)
            this.event = new ArrayList<CodeableConcept>();
          return this.event;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public DocumentReferenceContextComponent setEvent(List<CodeableConcept> theEvent) { 
          this.event = theEvent;
          return this;
        }

        public boolean hasEvent() { 
          if (this.event == null)
            return false;
          for (CodeableConcept item : this.event)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addEvent() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.event == null)
            this.event = new ArrayList<CodeableConcept>();
          this.event.add(t);
          return t;
        }

        public DocumentReferenceContextComponent addEvent(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.event == null)
            this.event = new ArrayList<CodeableConcept>();
          this.event.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #event}, creating it if it does not already exist
         */
        public CodeableConcept getEventFirstRep() { 
          if (getEvent().isEmpty()) {
            addEvent();
          }
          return getEvent().get(0);
        }

        /**
         * @return {@link #period} (The time period over which the service that is described by the document was provided.)
         */
        public Period getPeriod() { 
          if (this.period == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DocumentReferenceContextComponent.period");
            else if (Configuration.doAutoCreate())
              this.period = new Period(); // cc
          return this.period;
        }

        public boolean hasPeriod() { 
          return this.period != null && !this.period.isEmpty();
        }

        /**
         * @param value {@link #period} (The time period over which the service that is described by the document was provided.)
         */
        public DocumentReferenceContextComponent setPeriod(Period value)  { 
          this.period = value;
          return this;
        }

        /**
         * @return {@link #facilityType} (The kind of facility where the patient was seen.)
         */
        public CodeableConcept getFacilityType() { 
          if (this.facilityType == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DocumentReferenceContextComponent.facilityType");
            else if (Configuration.doAutoCreate())
              this.facilityType = new CodeableConcept(); // cc
          return this.facilityType;
        }

        public boolean hasFacilityType() { 
          return this.facilityType != null && !this.facilityType.isEmpty();
        }

        /**
         * @param value {@link #facilityType} (The kind of facility where the patient was seen.)
         */
        public DocumentReferenceContextComponent setFacilityType(CodeableConcept value)  { 
          this.facilityType = value;
          return this;
        }

        /**
         * @return {@link #practiceSetting} (This property may convey specifics about the practice setting where the content was created, often reflecting the clinical specialty.)
         */
        public CodeableConcept getPracticeSetting() { 
          if (this.practiceSetting == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DocumentReferenceContextComponent.practiceSetting");
            else if (Configuration.doAutoCreate())
              this.practiceSetting = new CodeableConcept(); // cc
          return this.practiceSetting;
        }

        public boolean hasPracticeSetting() { 
          return this.practiceSetting != null && !this.practiceSetting.isEmpty();
        }

        /**
         * @param value {@link #practiceSetting} (This property may convey specifics about the practice setting where the content was created, often reflecting the clinical specialty.)
         */
        public DocumentReferenceContextComponent setPracticeSetting(CodeableConcept value)  { 
          this.practiceSetting = value;
          return this;
        }

        /**
         * @return {@link #sourcePatientInfo} (The Patient Information as known when the document was published. May be a reference to a version specific, or contained.)
         */
        public Reference getSourcePatientInfo() { 
          if (this.sourcePatientInfo == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DocumentReferenceContextComponent.sourcePatientInfo");
            else if (Configuration.doAutoCreate())
              this.sourcePatientInfo = new Reference(); // cc
          return this.sourcePatientInfo;
        }

        public boolean hasSourcePatientInfo() { 
          return this.sourcePatientInfo != null && !this.sourcePatientInfo.isEmpty();
        }

        /**
         * @param value {@link #sourcePatientInfo} (The Patient Information as known when the document was published. May be a reference to a version specific, or contained.)
         */
        public DocumentReferenceContextComponent setSourcePatientInfo(Reference value)  { 
          this.sourcePatientInfo = value;
          return this;
        }

        /**
         * @return {@link #sourcePatientInfo} The actual object that is the target of the reference. The reference library doesn't populate this, but you can use it to hold the resource if you resolve it. (The Patient Information as known when the document was published. May be a reference to a version specific, or contained.)
         */
        public Patient getSourcePatientInfoTarget() { 
          if (this.sourcePatientInfoTarget == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DocumentReferenceContextComponent.sourcePatientInfo");
            else if (Configuration.doAutoCreate())
              this.sourcePatientInfoTarget = new Patient(); // aa
          return this.sourcePatientInfoTarget;
        }

        /**
         * @param value {@link #sourcePatientInfo} The actual object that is the target of the reference. The reference library doesn't use these, but you can use it to hold the resource if you resolve it. (The Patient Information as known when the document was published. May be a reference to a version specific, or contained.)
         */
        public DocumentReferenceContextComponent setSourcePatientInfoTarget(Patient value) { 
          this.sourcePatientInfoTarget = value;
          return this;
        }

        /**
         * @return {@link #related} (Related identifiers or resources associated with the DocumentReference.)
         */
        public List<DocumentReferenceContextRelatedComponent> getRelated() { 
          if (this.related == null)
            this.related = new ArrayList<DocumentReferenceContextRelatedComponent>();
          return this.related;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public DocumentReferenceContextComponent setRelated(List<DocumentReferenceContextRelatedComponent> theRelated) { 
          this.related = theRelated;
          return this;
        }

        public boolean hasRelated() { 
          if (this.related == null)
            return false;
          for (DocumentReferenceContextRelatedComponent item : this.related)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public DocumentReferenceContextRelatedComponent addRelated() { //3
          DocumentReferenceContextRelatedComponent t = new DocumentReferenceContextRelatedComponent();
          if (this.related == null)
            this.related = new ArrayList<DocumentReferenceContextRelatedComponent>();
          this.related.add(t);
          return t;
        }

        public DocumentReferenceContextComponent addRelated(DocumentReferenceContextRelatedComponent t) { //3
          if (t == null)
            return this;
          if (this.related == null)
            this.related = new ArrayList<DocumentReferenceContextRelatedComponent>();
          this.related.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #related}, creating it if it does not already exist
         */
        public DocumentReferenceContextRelatedComponent getRelatedFirstRep() { 
          if (getRelated().isEmpty()) {
            addRelated();
          }
          return getRelated().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("encounter", "Reference(Encounter)", "Describes the clinical encounter or type of care that the document content is associated with.", 0, 1, encounter));
          children.add(new Property("event", "CodeableConcept", "This list of codes represents the main clinical acts, such as a colonoscopy or an appendectomy, being documented. In some cases, the event is inherent in the typeCode, such as a \"History and Physical Report\" in which the procedure being documented is necessarily a \"History and Physical\" act.", 0, java.lang.Integer.MAX_VALUE, event));
          children.add(new Property("period", "Period", "The time period over which the service that is described by the document was provided.", 0, 1, period));
          children.add(new Property("facilityType", "CodeableConcept", "The kind of facility where the patient was seen.", 0, 1, facilityType));
          children.add(new Property("practiceSetting", "CodeableConcept", "This property may convey specifics about the practice setting where the content was created, often reflecting the clinical specialty.", 0, 1, practiceSetting));
          children.add(new Property("sourcePatientInfo", "Reference(Patient)", "The Patient Information as known when the document was published. May be a reference to a version specific, or contained.", 0, 1, sourcePatientInfo));
          children.add(new Property("related", "", "Related identifiers or resources associated with the DocumentReference.", 0, java.lang.Integer.MAX_VALUE, related));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 1524132147: /*encounter*/  return new Property("encounter", "Reference(Encounter)", "Describes the clinical encounter or type of care that the document content is associated with.", 0, 1, encounter);
          case 96891546: /*event*/  return new Property("event", "CodeableConcept", "This list of codes represents the main clinical acts, such as a colonoscopy or an appendectomy, being documented. In some cases, the event is inherent in the typeCode, such as a \"History and Physical Report\" in which the procedure being documented is necessarily a \"History and Physical\" act.", 0, java.lang.Integer.MAX_VALUE, event);
          case -991726143: /*period*/  return new Property("period", "Period", "The time period over which the service that is described by the document was provided.", 0, 1, period);
          case 370698365: /*facilityType*/  return new Property("facilityType", "CodeableConcept", "The kind of facility where the patient was seen.", 0, 1, facilityType);
          case 331373717: /*practiceSetting*/  return new Property("practiceSetting", "CodeableConcept", "This property may convey specifics about the practice setting where the content was created, often reflecting the clinical specialty.", 0, 1, practiceSetting);
          case 2031381048: /*sourcePatientInfo*/  return new Property("sourcePatientInfo", "Reference(Patient)", "The Patient Information as known when the document was published. May be a reference to a version specific, or contained.", 0, 1, sourcePatientInfo);
          case 1090493483: /*related*/  return new Property("related", "", "Related identifiers or resources associated with the DocumentReference.", 0, java.lang.Integer.MAX_VALUE, related);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1524132147: /*encounter*/ return this.encounter == null ? new Base[0] : new Base[] {this.encounter}; // Reference
        case 96891546: /*event*/ return this.event == null ? new Base[0] : this.event.toArray(new Base[this.event.size()]); // CodeableConcept
        case -991726143: /*period*/ return this.period == null ? new Base[0] : new Base[] {this.period}; // Period
        case 370698365: /*facilityType*/ return this.facilityType == null ? new Base[0] : new Base[] {this.facilityType}; // CodeableConcept
        case 331373717: /*practiceSetting*/ return this.practiceSetting == null ? new Base[0] : new Base[] {this.practiceSetting}; // CodeableConcept
        case 2031381048: /*sourcePatientInfo*/ return this.sourcePatientInfo == null ? new Base[0] : new Base[] {this.sourcePatientInfo}; // Reference
        case 1090493483: /*related*/ return this.related == null ? new Base[0] : this.related.toArray(new Base[this.related.size()]); // DocumentReferenceContextRelatedComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1524132147: // encounter
          this.encounter = castToReference(value); // Reference
          return value;
        case 96891546: // event
          this.getEvent().add(castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -991726143: // period
          this.period = castToPeriod(value); // Period
          return value;
        case 370698365: // facilityType
          this.facilityType = castToCodeableConcept(value); // CodeableConcept
          return value;
        case 331373717: // practiceSetting
          this.practiceSetting = castToCodeableConcept(value); // CodeableConcept
          return value;
        case 2031381048: // sourcePatientInfo
          this.sourcePatientInfo = castToReference(value); // Reference
          return value;
        case 1090493483: // related
          this.getRelated().add((DocumentReferenceContextRelatedComponent) value); // DocumentReferenceContextRelatedComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("encounter")) {
          this.encounter = castToReference(value); // Reference
        } else if (name.equals("event")) {
          this.getEvent().add(castToCodeableConcept(value));
        } else if (name.equals("period")) {
          this.period = castToPeriod(value); // Period
        } else if (name.equals("facilityType")) {
          this.facilityType = castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("practiceSetting")) {
          this.practiceSetting = castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("sourcePatientInfo")) {
          this.sourcePatientInfo = castToReference(value); // Reference
        } else if (name.equals("related")) {
          this.getRelated().add((DocumentReferenceContextRelatedComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1524132147:  return getEncounter(); 
        case 96891546:  return addEvent(); 
        case -991726143:  return getPeriod(); 
        case 370698365:  return getFacilityType(); 
        case 331373717:  return getPracticeSetting(); 
        case 2031381048:  return getSourcePatientInfo(); 
        case 1090493483:  return addRelated(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1524132147: /*encounter*/ return new String[] {"Reference"};
        case 96891546: /*event*/ return new String[] {"CodeableConcept"};
        case -991726143: /*period*/ return new String[] {"Period"};
        case 370698365: /*facilityType*/ return new String[] {"CodeableConcept"};
        case 331373717: /*practiceSetting*/ return new String[] {"CodeableConcept"};
        case 2031381048: /*sourcePatientInfo*/ return new String[] {"Reference"};
        case 1090493483: /*related*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("encounter")) {
          this.encounter = new Reference();
          return this.encounter;
        }
        else if (name.equals("event")) {
          return addEvent();
        }
        else if (name.equals("period")) {
          this.period = new Period();
          return this.period;
        }
        else if (name.equals("facilityType")) {
          this.facilityType = new CodeableConcept();
          return this.facilityType;
        }
        else if (name.equals("practiceSetting")) {
          this.practiceSetting = new CodeableConcept();
          return this.practiceSetting;
        }
        else if (name.equals("sourcePatientInfo")) {
          this.sourcePatientInfo = new Reference();
          return this.sourcePatientInfo;
        }
        else if (name.equals("related")) {
          return addRelated();
        }
        else
          return super.addChild(name);
      }

      public DocumentReferenceContextComponent copy() {
        DocumentReferenceContextComponent dst = new DocumentReferenceContextComponent();
        copyValues(dst);
        dst.encounter = encounter == null ? null : encounter.copy();
        if (event != null) {
          dst.event = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : event)
            dst.event.add(i.copy());
        };
        dst.period = period == null ? null : period.copy();
        dst.facilityType = facilityType == null ? null : facilityType.copy();
        dst.practiceSetting = practiceSetting == null ? null : practiceSetting.copy();
        dst.sourcePatientInfo = sourcePatientInfo == null ? null : sourcePatientInfo.copy();
        if (related != null) {
          dst.related = new ArrayList<DocumentReferenceContextRelatedComponent>();
          for (DocumentReferenceContextRelatedComponent i : related)
            dst.related.add(i.copy());
        };
        return dst;
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DocumentReferenceContextComponent))
          return false;
        DocumentReferenceContextComponent o = (DocumentReferenceContextComponent) other_;
        return compareDeep(encounter, o.encounter, true) && compareDeep(event, o.event, true) && compareDeep(period, o.period, true)
           && compareDeep(facilityType, o.facilityType, true) && compareDeep(practiceSetting, o.practiceSetting, true)
           && compareDeep(sourcePatientInfo, o.sourcePatientInfo, true) && compareDeep(related, o.related, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DocumentReferenceContextComponent))
          return false;
        DocumentReferenceContextComponent o = (DocumentReferenceContextComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(encounter, event, period
          , facilityType, practiceSetting, sourcePatientInfo, related);
      }

  public String fhirType() {
    return "DocumentReference.context";

  }

  }

    @Block()
    public static class DocumentReferenceContextRelatedComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Related identifier to this DocumentReference. If both id and ref are present they shall refer to the same thing.
         */
        @Child(name = "identifier", type = {Identifier.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Identifier of related objects or events", formalDefinition="Related identifier to this DocumentReference. If both id and ref are present they shall refer to the same thing." )
        protected Identifier identifier;

        /**
         * Related Resource to this DocumentReference. If both id and ref are present they shall refer to the same thing.
         */
        @Child(name = "ref", type = {Reference.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Related Resource", formalDefinition="Related Resource to this DocumentReference. If both id and ref are present they shall refer to the same thing." )
        protected Reference ref;

        /**
         * The actual object that is the target of the reference (Related Resource to this DocumentReference. If both id and ref are present they shall refer to the same thing.)
         */
        protected Resource refTarget;

        private static final long serialVersionUID = -1670123330L;

    /**
     * Constructor
     */
      public DocumentReferenceContextRelatedComponent() {
        super();
      }

        /**
         * @return {@link #identifier} (Related identifier to this DocumentReference. If both id and ref are present they shall refer to the same thing.)
         */
        public Identifier getIdentifier() { 
          if (this.identifier == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DocumentReferenceContextRelatedComponent.identifier");
            else if (Configuration.doAutoCreate())
              this.identifier = new Identifier(); // cc
          return this.identifier;
        }

        public boolean hasIdentifier() { 
          return this.identifier != null && !this.identifier.isEmpty();
        }

        /**
         * @param value {@link #identifier} (Related identifier to this DocumentReference. If both id and ref are present they shall refer to the same thing.)
         */
        public DocumentReferenceContextRelatedComponent setIdentifier(Identifier value)  { 
          this.identifier = value;
          return this;
        }

        /**
         * @return {@link #ref} (Related Resource to this DocumentReference. If both id and ref are present they shall refer to the same thing.)
         */
        public Reference getRef() { 
          if (this.ref == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DocumentReferenceContextRelatedComponent.ref");
            else if (Configuration.doAutoCreate())
              this.ref = new Reference(); // cc
          return this.ref;
        }

        public boolean hasRef() { 
          return this.ref != null && !this.ref.isEmpty();
        }

        /**
         * @param value {@link #ref} (Related Resource to this DocumentReference. If both id and ref are present they shall refer to the same thing.)
         */
        public DocumentReferenceContextRelatedComponent setRef(Reference value)  { 
          this.ref = value;
          return this;
        }

        /**
         * @return {@link #ref} The actual object that is the target of the reference. The reference library doesn't populate this, but you can use it to hold the resource if you resolve it. (Related Resource to this DocumentReference. If both id and ref are present they shall refer to the same thing.)
         */
        public Resource getRefTarget() { 
          return this.refTarget;
        }

        /**
         * @param value {@link #ref} The actual object that is the target of the reference. The reference library doesn't use these, but you can use it to hold the resource if you resolve it. (Related Resource to this DocumentReference. If both id and ref are present they shall refer to the same thing.)
         */
        public DocumentReferenceContextRelatedComponent setRefTarget(Resource value) { 
          this.refTarget = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("identifier", "Identifier", "Related identifier to this DocumentReference. If both id and ref are present they shall refer to the same thing.", 0, 1, identifier));
          children.add(new Property("ref", "Reference(Any)", "Related Resource to this DocumentReference. If both id and ref are present they shall refer to the same thing.", 0, 1, ref));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Related identifier to this DocumentReference. If both id and ref are present they shall refer to the same thing.", 0, 1, identifier);
          case 112787: /*ref*/  return new Property("ref", "Reference(Any)", "Related Resource to this DocumentReference. If both id and ref are present they shall refer to the same thing.", 0, 1, ref);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : new Base[] {this.identifier}; // Identifier
        case 112787: /*ref*/ return this.ref == null ? new Base[0] : new Base[] {this.ref}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.identifier = castToIdentifier(value); // Identifier
          return value;
        case 112787: // ref
          this.ref = castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.identifier = castToIdentifier(value); // Identifier
        } else if (name.equals("ref")) {
          this.ref = castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return getIdentifier(); 
        case 112787:  return getRef(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case 112787: /*ref*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          this.identifier = new Identifier();
          return this.identifier;
        }
        else if (name.equals("ref")) {
          this.ref = new Reference();
          return this.ref;
        }
        else
          return super.addChild(name);
      }

      public DocumentReferenceContextRelatedComponent copy() {
        DocumentReferenceContextRelatedComponent dst = new DocumentReferenceContextRelatedComponent();
        copyValues(dst);
        dst.identifier = identifier == null ? null : identifier.copy();
        dst.ref = ref == null ? null : ref.copy();
        return dst;
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DocumentReferenceContextRelatedComponent))
          return false;
        DocumentReferenceContextRelatedComponent o = (DocumentReferenceContextRelatedComponent) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(ref, o.ref, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DocumentReferenceContextRelatedComponent))
          return false;
        DocumentReferenceContextRelatedComponent o = (DocumentReferenceContextRelatedComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, ref);
      }

  public String fhirType() {
    return "DocumentReference.context.related";

  }

  }

    /**
     * Document identifier as assigned by the source of the document. This identifier is specific to this version of the document. This unique identifier may be used elsewhere to identify this version of the document.
     */
    @Child(name = "masterIdentifier", type = {Identifier.class}, order=0, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Master Version Specific Identifier", formalDefinition="Document identifier as assigned by the source of the document. This identifier is specific to this version of the document. This unique identifier may be used elsewhere to identify this version of the document." )
    protected Identifier masterIdentifier;

    /**
     * Other identifiers associated with the document, including version independent identifiers.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Other identifiers for the document", formalDefinition="Other identifiers associated with the document, including version independent identifiers." )
    protected List<Identifier> identifier;

    /**
     * The status of this document reference.
     */
    @Child(name = "status", type = {CodeType.class}, order=2, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="current | superseded | entered-in-error", formalDefinition="The status of this document reference." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/document-reference-status")
    protected Enumeration<DocumentReferenceStatus> status;

    /**
     * The status of the underlying document.
     */
    @Child(name = "docStatus", type = {CodeType.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="preliminary | final | appended | amended | entered-in-error", formalDefinition="The status of the underlying document." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/composition-status")
    protected Enumeration<ReferredDocumentStatus> docStatus;

    /**
     * Specifies the particular kind of document referenced  (e.g. History and Physical, Discharge Summary, Progress Note). This usually equates to the purpose of making the document referenced.
     */
    @Child(name = "type", type = {CodeableConcept.class}, order=4, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Kind of document (LOINC if possible)", formalDefinition="Specifies the particular kind of document referenced  (e.g. History and Physical, Discharge Summary, Progress Note). This usually equates to the purpose of making the document referenced." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/c80-doc-typecodes")
    protected CodeableConcept type;

    /**
     * A categorization for the type of document referenced - helps for indexing and searching. This may be implied by or derived from the code specified in the DocumentReference.type.
     */
    @Child(name = "class", type = {CodeableConcept.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Categorization of document", formalDefinition="A categorization for the type of document referenced - helps for indexing and searching. This may be implied by or derived from the code specified in the DocumentReference.type." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/c80-doc-classcodes")
    protected CodeableConcept class_;

    /**
     * Who or what the document is about. The document can be about a person, (patient or healthcare practitioner), a device (e.g. a machine) or even a group of subjects (such as a document about a herd of farm animals, or a set of patients that share a common exposure).
     */
    @Child(name = "subject", type = {Patient.class, Practitioner.class, Group.class, Device.class}, order=6, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Who/what is the subject of the document", formalDefinition="Who or what the document is about. The document can be about a person, (patient or healthcare practitioner), a device (e.g. a machine) or even a group of subjects (such as a document about a herd of farm animals, or a set of patients that share a common exposure)." )
    protected Reference subject;

    /**
     * The actual object that is the target of the reference (Who or what the document is about. The document can be about a person, (patient or healthcare practitioner), a device (e.g. a machine) or even a group of subjects (such as a document about a herd of farm animals, or a set of patients that share a common exposure).)
     */
    protected Resource subjectTarget;

    /**
     * When the document was created.
     */
    @Child(name = "created", type = {DateTimeType.class}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Document creation time", formalDefinition="When the document was created." )
    protected DateTimeType created;

    /**
     * When the document reference was created.
     */
    @Child(name = "indexed", type = {InstantType.class}, order=8, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="When this document reference was created", formalDefinition="When the document reference was created." )
    protected InstantType indexed;

    /**
     * Identifies who is responsible for adding the information to the document.
     */
    @Child(name = "author", type = {Practitioner.class, Organization.class, Device.class, Patient.class, RelatedPerson.class}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Who and/or what authored the document", formalDefinition="Identifies who is responsible for adding the information to the document." )
    protected List<Reference> author;
    /**
     * The actual objects that are the target of the reference (Identifies who is responsible for adding the information to the document.)
     */
    protected List<Resource> authorTarget;


    /**
     * Which person or organization authenticates that this document is valid.
     */
    @Child(name = "authenticator", type = {Practitioner.class, Organization.class}, order=10, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Who/what authenticated the document", formalDefinition="Which person or organization authenticates that this document is valid." )
    protected Reference authenticator;

    /**
     * The actual object that is the target of the reference (Which person or organization authenticates that this document is valid.)
     */
    protected Resource authenticatorTarget;

    /**
     * Identifies the organization or group who is responsible for ongoing maintenance of and access to the document.
     */
    @Child(name = "custodian", type = {Organization.class}, order=11, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Organization which maintains the document", formalDefinition="Identifies the organization or group who is responsible for ongoing maintenance of and access to the document." )
    protected Reference custodian;

    /**
     * The actual object that is the target of the reference (Identifies the organization or group who is responsible for ongoing maintenance of and access to the document.)
     */
    protected Organization custodianTarget;

    /**
     * Relationships that this document has with other document references that already exist.
     */
    @Child(name = "relatesTo", type = {}, order=12, min=0, max=Child.MAX_UNLIMITED, modifier=true, summary=true)
    @Description(shortDefinition="Relationships to other documents", formalDefinition="Relationships that this document has with other document references that already exist." )
    protected List<DocumentReferenceRelatesToComponent> relatesTo;

    /**
     * Human-readable description of the source document. This is sometimes known as the "title".
     */
    @Child(name = "description", type = {StringType.class}, order=13, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Human-readable description (title)", formalDefinition="Human-readable description of the source document. This is sometimes known as the \"title\"." )
    protected StringType description;

    /**
     * A set of Security-Tag codes specifying the level of privacy/security of the Document. Note that DocumentReference.meta.security contains the security labels of the "reference" to the document, while DocumentReference.securityLabel contains a snapshot of the security labels on the document the reference refers to.
     */
    @Child(name = "securityLabel", type = {CodeableConcept.class}, order=14, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Document security-tags", formalDefinition="A set of Security-Tag codes specifying the level of privacy/security of the Document. Note that DocumentReference.meta.security contains the security labels of the \"reference\" to the document, while DocumentReference.securityLabel contains a snapshot of the security labels on the document the reference refers to." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/security-labels")
    protected List<CodeableConcept> securityLabel;

    /**
     * The document and format referenced. There may be multiple content element repetitions, each with a different format.
     */
    @Child(name = "content", type = {}, order=15, min=1, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Document referenced", formalDefinition="The document and format referenced. There may be multiple content element repetitions, each with a different format." )
    protected List<DocumentReferenceContentComponent> content;

    /**
     * The clinical context in which the document was prepared.
     */
    @Child(name = "context", type = {}, order=16, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Clinical context of document", formalDefinition="The clinical context in which the document was prepared." )
    protected DocumentReferenceContextComponent context;

    private static final long serialVersionUID = 1465770040L;

  /**
   * Constructor
   */
    public DocumentReference() {
      super();
    }

  /**
   * Constructor
   */
    public DocumentReference(Enumeration<DocumentReferenceStatus> status, CodeableConcept type, InstantType indexed) {
      super();
      this.status = status;
      this.type = type;
      this.indexed = indexed;
    }

    /**
     * @return {@link #masterIdentifier} (Document identifier as assigned by the source of the document. This identifier is specific to this version of the document. This unique identifier may be used elsewhere to identify this version of the document.)
     */
    public Identifier getMasterIdentifier() { 
      if (this.masterIdentifier == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DocumentReference.masterIdentifier");
        else if (Configuration.doAutoCreate())
          this.masterIdentifier = new Identifier(); // cc
      return this.masterIdentifier;
    }

    public boolean hasMasterIdentifier() { 
      return this.masterIdentifier != null && !this.masterIdentifier.isEmpty();
    }

    /**
     * @param value {@link #masterIdentifier} (Document identifier as assigned by the source of the document. This identifier is specific to this version of the document. This unique identifier may be used elsewhere to identify this version of the document.)
     */
    public DocumentReference setMasterIdentifier(Identifier value)  { 
      this.masterIdentifier = value;
      return this;
    }

    /**
     * @return {@link #identifier} (Other identifiers associated with the document, including version independent identifiers.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DocumentReference setIdentifier(List<Identifier> theIdentifier) { 
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

    public Identifier addIdentifier() { //3
      Identifier t = new Identifier();
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      this.identifier.add(t);
      return t;
    }

    public DocumentReference addIdentifier(Identifier t) { //3
      if (t == null)
        return this;
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      this.identifier.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #identifier}, creating it if it does not already exist
     */
    public Identifier getIdentifierFirstRep() { 
      if (getIdentifier().isEmpty()) {
        addIdentifier();
      }
      return getIdentifier().get(0);
    }

    /**
     * @return {@link #status} (The status of this document reference.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<DocumentReferenceStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DocumentReference.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<DocumentReferenceStatus>(new DocumentReferenceStatusEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (The status of this document reference.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public DocumentReference setStatusElement(Enumeration<DocumentReferenceStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The status of this document reference.
     */
    public DocumentReferenceStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The status of this document reference.
     */
    public DocumentReference setStatus(DocumentReferenceStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<DocumentReferenceStatus>(new DocumentReferenceStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #docStatus} (The status of the underlying document.). This is the underlying object with id, value and extensions. The accessor "getDocStatus" gives direct access to the value
     */
    public Enumeration<ReferredDocumentStatus> getDocStatusElement() { 
      if (this.docStatus == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DocumentReference.docStatus");
        else if (Configuration.doAutoCreate())
          this.docStatus = new Enumeration<ReferredDocumentStatus>(new ReferredDocumentStatusEnumFactory()); // bb
      return this.docStatus;
    }

    public boolean hasDocStatusElement() { 
      return this.docStatus != null && !this.docStatus.isEmpty();
    }

    public boolean hasDocStatus() { 
      return this.docStatus != null && !this.docStatus.isEmpty();
    }

    /**
     * @param value {@link #docStatus} (The status of the underlying document.). This is the underlying object with id, value and extensions. The accessor "getDocStatus" gives direct access to the value
     */
    public DocumentReference setDocStatusElement(Enumeration<ReferredDocumentStatus> value) { 
      this.docStatus = value;
      return this;
    }

    /**
     * @return The status of the underlying document.
     */
    public ReferredDocumentStatus getDocStatus() { 
      return this.docStatus == null ? null : this.docStatus.getValue();
    }

    /**
     * @param value The status of the underlying document.
     */
    public DocumentReference setDocStatus(ReferredDocumentStatus value) { 
      if (value == null)
        this.docStatus = null;
      else {
        if (this.docStatus == null)
          this.docStatus = new Enumeration<ReferredDocumentStatus>(new ReferredDocumentStatusEnumFactory());
        this.docStatus.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #type} (Specifies the particular kind of document referenced  (e.g. History and Physical, Discharge Summary, Progress Note). This usually equates to the purpose of making the document referenced.)
     */
    public CodeableConcept getType() { 
      if (this.type == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DocumentReference.type");
        else if (Configuration.doAutoCreate())
          this.type = new CodeableConcept(); // cc
      return this.type;
    }

    public boolean hasType() { 
      return this.type != null && !this.type.isEmpty();
    }

    /**
     * @param value {@link #type} (Specifies the particular kind of document referenced  (e.g. History and Physical, Discharge Summary, Progress Note). This usually equates to the purpose of making the document referenced.)
     */
    public DocumentReference setType(CodeableConcept value)  { 
      this.type = value;
      return this;
    }

    /**
     * @return {@link #class_} (A categorization for the type of document referenced - helps for indexing and searching. This may be implied by or derived from the code specified in the DocumentReference.type.)
     */
    public CodeableConcept getClass_() { 
      if (this.class_ == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DocumentReference.class_");
        else if (Configuration.doAutoCreate())
          this.class_ = new CodeableConcept(); // cc
      return this.class_;
    }

    public boolean hasClass_() { 
      return this.class_ != null && !this.class_.isEmpty();
    }

    /**
     * @param value {@link #class_} (A categorization for the type of document referenced - helps for indexing and searching. This may be implied by or derived from the code specified in the DocumentReference.type.)
     */
    public DocumentReference setClass_(CodeableConcept value)  { 
      this.class_ = value;
      return this;
    }

    /**
     * @return {@link #subject} (Who or what the document is about. The document can be about a person, (patient or healthcare practitioner), a device (e.g. a machine) or even a group of subjects (such as a document about a herd of farm animals, or a set of patients that share a common exposure).)
     */
    public Reference getSubject() { 
      if (this.subject == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DocumentReference.subject");
        else if (Configuration.doAutoCreate())
          this.subject = new Reference(); // cc
      return this.subject;
    }

    public boolean hasSubject() { 
      return this.subject != null && !this.subject.isEmpty();
    }

    /**
     * @param value {@link #subject} (Who or what the document is about. The document can be about a person, (patient or healthcare practitioner), a device (e.g. a machine) or even a group of subjects (such as a document about a herd of farm animals, or a set of patients that share a common exposure).)
     */
    public DocumentReference setSubject(Reference value)  { 
      this.subject = value;
      return this;
    }

    /**
     * @return {@link #subject} The actual object that is the target of the reference. The reference library doesn't populate this, but you can use it to hold the resource if you resolve it. (Who or what the document is about. The document can be about a person, (patient or healthcare practitioner), a device (e.g. a machine) or even a group of subjects (such as a document about a herd of farm animals, or a set of patients that share a common exposure).)
     */
    public Resource getSubjectTarget() { 
      return this.subjectTarget;
    }

    /**
     * @param value {@link #subject} The actual object that is the target of the reference. The reference library doesn't use these, but you can use it to hold the resource if you resolve it. (Who or what the document is about. The document can be about a person, (patient or healthcare practitioner), a device (e.g. a machine) or even a group of subjects (such as a document about a herd of farm animals, or a set of patients that share a common exposure).)
     */
    public DocumentReference setSubjectTarget(Resource value) { 
      this.subjectTarget = value;
      return this;
    }

    /**
     * @return {@link #created} (When the document was created.). This is the underlying object with id, value and extensions. The accessor "getCreated" gives direct access to the value
     */
    public DateTimeType getCreatedElement() { 
      if (this.created == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DocumentReference.created");
        else if (Configuration.doAutoCreate())
          this.created = new DateTimeType(); // bb
      return this.created;
    }

    public boolean hasCreatedElement() { 
      return this.created != null && !this.created.isEmpty();
    }

    public boolean hasCreated() { 
      return this.created != null && !this.created.isEmpty();
    }

    /**
     * @param value {@link #created} (When the document was created.). This is the underlying object with id, value and extensions. The accessor "getCreated" gives direct access to the value
     */
    public DocumentReference setCreatedElement(DateTimeType value) { 
      this.created = value;
      return this;
    }

    /**
     * @return When the document was created.
     */
    public Date getCreated() { 
      return this.created == null ? null : this.created.getValue();
    }

    /**
     * @param value When the document was created.
     */
    public DocumentReference setCreated(Date value) { 
      if (value == null)
        this.created = null;
      else {
        if (this.created == null)
          this.created = new DateTimeType();
        this.created.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #indexed} (When the document reference was created.). This is the underlying object with id, value and extensions. The accessor "getIndexed" gives direct access to the value
     */
    public InstantType getIndexedElement() { 
      if (this.indexed == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DocumentReference.indexed");
        else if (Configuration.doAutoCreate())
          this.indexed = new InstantType(); // bb
      return this.indexed;
    }

    public boolean hasIndexedElement() { 
      return this.indexed != null && !this.indexed.isEmpty();
    }

    public boolean hasIndexed() { 
      return this.indexed != null && !this.indexed.isEmpty();
    }

    /**
     * @param value {@link #indexed} (When the document reference was created.). This is the underlying object with id, value and extensions. The accessor "getIndexed" gives direct access to the value
     */
    public DocumentReference setIndexedElement(InstantType value) { 
      this.indexed = value;
      return this;
    }

    /**
     * @return When the document reference was created.
     */
    public Date getIndexed() { 
      return this.indexed == null ? null : this.indexed.getValue();
    }

    /**
     * @param value When the document reference was created.
     */
    public DocumentReference setIndexed(Date value) { 
        if (this.indexed == null)
          this.indexed = new InstantType();
        this.indexed.setValue(value);
      return this;
    }

    /**
     * @return {@link #author} (Identifies who is responsible for adding the information to the document.)
     */
    public List<Reference> getAuthor() { 
      if (this.author == null)
        this.author = new ArrayList<Reference>();
      return this.author;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DocumentReference setAuthor(List<Reference> theAuthor) { 
      this.author = theAuthor;
      return this;
    }

    public boolean hasAuthor() { 
      if (this.author == null)
        return false;
      for (Reference item : this.author)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addAuthor() { //3
      Reference t = new Reference();
      if (this.author == null)
        this.author = new ArrayList<Reference>();
      this.author.add(t);
      return t;
    }

    public DocumentReference addAuthor(Reference t) { //3
      if (t == null)
        return this;
      if (this.author == null)
        this.author = new ArrayList<Reference>();
      this.author.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #author}, creating it if it does not already exist
     */
    public Reference getAuthorFirstRep() { 
      if (getAuthor().isEmpty()) {
        addAuthor();
      }
      return getAuthor().get(0);
    }

    /**
     * @return {@link #authenticator} (Which person or organization authenticates that this document is valid.)
     */
    public Reference getAuthenticator() { 
      if (this.authenticator == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DocumentReference.authenticator");
        else if (Configuration.doAutoCreate())
          this.authenticator = new Reference(); // cc
      return this.authenticator;
    }

    public boolean hasAuthenticator() { 
      return this.authenticator != null && !this.authenticator.isEmpty();
    }

    /**
     * @param value {@link #authenticator} (Which person or organization authenticates that this document is valid.)
     */
    public DocumentReference setAuthenticator(Reference value)  { 
      this.authenticator = value;
      return this;
    }

    /**
     * @return {@link #authenticator} The actual object that is the target of the reference. The reference library doesn't populate this, but you can use it to hold the resource if you resolve it. (Which person or organization authenticates that this document is valid.)
     */
    public Resource getAuthenticatorTarget() { 
      return this.authenticatorTarget;
    }

    /**
     * @param value {@link #authenticator} The actual object that is the target of the reference. The reference library doesn't use these, but you can use it to hold the resource if you resolve it. (Which person or organization authenticates that this document is valid.)
     */
    public DocumentReference setAuthenticatorTarget(Resource value) { 
      this.authenticatorTarget = value;
      return this;
    }

    /**
     * @return {@link #custodian} (Identifies the organization or group who is responsible for ongoing maintenance of and access to the document.)
     */
    public Reference getCustodian() { 
      if (this.custodian == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DocumentReference.custodian");
        else if (Configuration.doAutoCreate())
          this.custodian = new Reference(); // cc
      return this.custodian;
    }

    public boolean hasCustodian() { 
      return this.custodian != null && !this.custodian.isEmpty();
    }

    /**
     * @param value {@link #custodian} (Identifies the organization or group who is responsible for ongoing maintenance of and access to the document.)
     */
    public DocumentReference setCustodian(Reference value)  { 
      this.custodian = value;
      return this;
    }

    /**
     * @return {@link #custodian} The actual object that is the target of the reference. The reference library doesn't populate this, but you can use it to hold the resource if you resolve it. (Identifies the organization or group who is responsible for ongoing maintenance of and access to the document.)
     */
    public Organization getCustodianTarget() { 
      if (this.custodianTarget == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DocumentReference.custodian");
        else if (Configuration.doAutoCreate())
          this.custodianTarget = new Organization(); // aa
      return this.custodianTarget;
    }

    /**
     * @param value {@link #custodian} The actual object that is the target of the reference. The reference library doesn't use these, but you can use it to hold the resource if you resolve it. (Identifies the organization or group who is responsible for ongoing maintenance of and access to the document.)
     */
    public DocumentReference setCustodianTarget(Organization value) { 
      this.custodianTarget = value;
      return this;
    }

    /**
     * @return {@link #relatesTo} (Relationships that this document has with other document references that already exist.)
     */
    public List<DocumentReferenceRelatesToComponent> getRelatesTo() { 
      if (this.relatesTo == null)
        this.relatesTo = new ArrayList<DocumentReferenceRelatesToComponent>();
      return this.relatesTo;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DocumentReference setRelatesTo(List<DocumentReferenceRelatesToComponent> theRelatesTo) { 
      this.relatesTo = theRelatesTo;
      return this;
    }

    public boolean hasRelatesTo() { 
      if (this.relatesTo == null)
        return false;
      for (DocumentReferenceRelatesToComponent item : this.relatesTo)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public DocumentReferenceRelatesToComponent addRelatesTo() { //3
      DocumentReferenceRelatesToComponent t = new DocumentReferenceRelatesToComponent();
      if (this.relatesTo == null)
        this.relatesTo = new ArrayList<DocumentReferenceRelatesToComponent>();
      this.relatesTo.add(t);
      return t;
    }

    public DocumentReference addRelatesTo(DocumentReferenceRelatesToComponent t) { //3
      if (t == null)
        return this;
      if (this.relatesTo == null)
        this.relatesTo = new ArrayList<DocumentReferenceRelatesToComponent>();
      this.relatesTo.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #relatesTo}, creating it if it does not already exist
     */
    public DocumentReferenceRelatesToComponent getRelatesToFirstRep() { 
      if (getRelatesTo().isEmpty()) {
        addRelatesTo();
      }
      return getRelatesTo().get(0);
    }

    /**
     * @return {@link #description} (Human-readable description of the source document. This is sometimes known as the "title".). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public StringType getDescriptionElement() { 
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DocumentReference.description");
        else if (Configuration.doAutoCreate())
          this.description = new StringType(); // bb
      return this.description;
    }

    public boolean hasDescriptionElement() { 
      return this.description != null && !this.description.isEmpty();
    }

    public boolean hasDescription() { 
      return this.description != null && !this.description.isEmpty();
    }

    /**
     * @param value {@link #description} (Human-readable description of the source document. This is sometimes known as the "title".). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public DocumentReference setDescriptionElement(StringType value) { 
      this.description = value;
      return this;
    }

    /**
     * @return Human-readable description of the source document. This is sometimes known as the "title".
     */
    public String getDescription() { 
      return this.description == null ? null : this.description.getValue();
    }

    /**
     * @param value Human-readable description of the source document. This is sometimes known as the "title".
     */
    public DocumentReference setDescription(String value) { 
      if (Utilities.noString(value))
        this.description = null;
      else {
        if (this.description == null)
          this.description = new StringType();
        this.description.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #securityLabel} (A set of Security-Tag codes specifying the level of privacy/security of the Document. Note that DocumentReference.meta.security contains the security labels of the "reference" to the document, while DocumentReference.securityLabel contains a snapshot of the security labels on the document the reference refers to.)
     */
    public List<CodeableConcept> getSecurityLabel() { 
      if (this.securityLabel == null)
        this.securityLabel = new ArrayList<CodeableConcept>();
      return this.securityLabel;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DocumentReference setSecurityLabel(List<CodeableConcept> theSecurityLabel) { 
      this.securityLabel = theSecurityLabel;
      return this;
    }

    public boolean hasSecurityLabel() { 
      if (this.securityLabel == null)
        return false;
      for (CodeableConcept item : this.securityLabel)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addSecurityLabel() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.securityLabel == null)
        this.securityLabel = new ArrayList<CodeableConcept>();
      this.securityLabel.add(t);
      return t;
    }

    public DocumentReference addSecurityLabel(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.securityLabel == null)
        this.securityLabel = new ArrayList<CodeableConcept>();
      this.securityLabel.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #securityLabel}, creating it if it does not already exist
     */
    public CodeableConcept getSecurityLabelFirstRep() { 
      if (getSecurityLabel().isEmpty()) {
        addSecurityLabel();
      }
      return getSecurityLabel().get(0);
    }

    /**
     * @return {@link #content} (The document and format referenced. There may be multiple content element repetitions, each with a different format.)
     */
    public List<DocumentReferenceContentComponent> getContent() { 
      if (this.content == null)
        this.content = new ArrayList<DocumentReferenceContentComponent>();
      return this.content;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DocumentReference setContent(List<DocumentReferenceContentComponent> theContent) { 
      this.content = theContent;
      return this;
    }

    public boolean hasContent() { 
      if (this.content == null)
        return false;
      for (DocumentReferenceContentComponent item : this.content)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public DocumentReferenceContentComponent addContent() { //3
      DocumentReferenceContentComponent t = new DocumentReferenceContentComponent();
      if (this.content == null)
        this.content = new ArrayList<DocumentReferenceContentComponent>();
      this.content.add(t);
      return t;
    }

    public DocumentReference addContent(DocumentReferenceContentComponent t) { //3
      if (t == null)
        return this;
      if (this.content == null)
        this.content = new ArrayList<DocumentReferenceContentComponent>();
      this.content.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #content}, creating it if it does not already exist
     */
    public DocumentReferenceContentComponent getContentFirstRep() { 
      if (getContent().isEmpty()) {
        addContent();
      }
      return getContent().get(0);
    }

    /**
     * @return {@link #context} (The clinical context in which the document was prepared.)
     */
    public DocumentReferenceContextComponent getContext() { 
      if (this.context == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DocumentReference.context");
        else if (Configuration.doAutoCreate())
          this.context = new DocumentReferenceContextComponent(); // cc
      return this.context;
    }

    public boolean hasContext() { 
      return this.context != null && !this.context.isEmpty();
    }

    /**
     * @param value {@link #context} (The clinical context in which the document was prepared.)
     */
    public DocumentReference setContext(DocumentReferenceContextComponent value)  { 
      this.context = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("masterIdentifier", "Identifier", "Document identifier as assigned by the source of the document. This identifier is specific to this version of the document. This unique identifier may be used elsewhere to identify this version of the document.", 0, 1, masterIdentifier));
        children.add(new Property("identifier", "Identifier", "Other identifiers associated with the document, including version independent identifiers.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("status", "code", "The status of this document reference.", 0, 1, status));
        children.add(new Property("docStatus", "code", "The status of the underlying document.", 0, 1, docStatus));
        children.add(new Property("type", "CodeableConcept", "Specifies the particular kind of document referenced  (e.g. History and Physical, Discharge Summary, Progress Note). This usually equates to the purpose of making the document referenced.", 0, 1, type));
        children.add(new Property("class", "CodeableConcept", "A categorization for the type of document referenced - helps for indexing and searching. This may be implied by or derived from the code specified in the DocumentReference.type.", 0, 1, class_));
        children.add(new Property("subject", "Reference(Patient|Practitioner|Group|Device)", "Who or what the document is about. The document can be about a person, (patient or healthcare practitioner), a device (e.g. a machine) or even a group of subjects (such as a document about a herd of farm animals, or a set of patients that share a common exposure).", 0, 1, subject));
        children.add(new Property("created", "dateTime", "When the document was created.", 0, 1, created));
        children.add(new Property("indexed", "instant", "When the document reference was created.", 0, 1, indexed));
        children.add(new Property("author", "Reference(Practitioner|Organization|Device|Patient|RelatedPerson)", "Identifies who is responsible for adding the information to the document.", 0, java.lang.Integer.MAX_VALUE, author));
        children.add(new Property("authenticator", "Reference(Practitioner|Organization)", "Which person or organization authenticates that this document is valid.", 0, 1, authenticator));
        children.add(new Property("custodian", "Reference(Organization)", "Identifies the organization or group who is responsible for ongoing maintenance of and access to the document.", 0, 1, custodian));
        children.add(new Property("relatesTo", "", "Relationships that this document has with other document references that already exist.", 0, java.lang.Integer.MAX_VALUE, relatesTo));
        children.add(new Property("description", "string", "Human-readable description of the source document. This is sometimes known as the \"title\".", 0, 1, description));
        children.add(new Property("securityLabel", "CodeableConcept", "A set of Security-Tag codes specifying the level of privacy/security of the Document. Note that DocumentReference.meta.security contains the security labels of the \"reference\" to the document, while DocumentReference.securityLabel contains a snapshot of the security labels on the document the reference refers to.", 0, java.lang.Integer.MAX_VALUE, securityLabel));
        children.add(new Property("content", "", "The document and format referenced. There may be multiple content element repetitions, each with a different format.", 0, java.lang.Integer.MAX_VALUE, content));
        children.add(new Property("context", "", "The clinical context in which the document was prepared.", 0, 1, context));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 243769515: /*masterIdentifier*/  return new Property("masterIdentifier", "Identifier", "Document identifier as assigned by the source of the document. This identifier is specific to this version of the document. This unique identifier may be used elsewhere to identify this version of the document.", 0, 1, masterIdentifier);
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Other identifiers associated with the document, including version independent identifiers.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -892481550: /*status*/  return new Property("status", "code", "The status of this document reference.", 0, 1, status);
        case -23496886: /*docStatus*/  return new Property("docStatus", "code", "The status of the underlying document.", 0, 1, docStatus);
        case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Specifies the particular kind of document referenced  (e.g. History and Physical, Discharge Summary, Progress Note). This usually equates to the purpose of making the document referenced.", 0, 1, type);
        case 94742904: /*class*/  return new Property("class", "CodeableConcept", "A categorization for the type of document referenced - helps for indexing and searching. This may be implied by or derived from the code specified in the DocumentReference.type.", 0, 1, class_);
        case -1867885268: /*subject*/  return new Property("subject", "Reference(Patient|Practitioner|Group|Device)", "Who or what the document is about. The document can be about a person, (patient or healthcare practitioner), a device (e.g. a machine) or even a group of subjects (such as a document about a herd of farm animals, or a set of patients that share a common exposure).", 0, 1, subject);
        case 1028554472: /*created*/  return new Property("created", "dateTime", "When the document was created.", 0, 1, created);
        case 1943292145: /*indexed*/  return new Property("indexed", "instant", "When the document reference was created.", 0, 1, indexed);
        case -1406328437: /*author*/  return new Property("author", "Reference(Practitioner|Organization|Device|Patient|RelatedPerson)", "Identifies who is responsible for adding the information to the document.", 0, java.lang.Integer.MAX_VALUE, author);
        case 1815000435: /*authenticator*/  return new Property("authenticator", "Reference(Practitioner|Organization)", "Which person or organization authenticates that this document is valid.", 0, 1, authenticator);
        case 1611297262: /*custodian*/  return new Property("custodian", "Reference(Organization)", "Identifies the organization or group who is responsible for ongoing maintenance of and access to the document.", 0, 1, custodian);
        case -7765931: /*relatesTo*/  return new Property("relatesTo", "", "Relationships that this document has with other document references that already exist.", 0, java.lang.Integer.MAX_VALUE, relatesTo);
        case -1724546052: /*description*/  return new Property("description", "string", "Human-readable description of the source document. This is sometimes known as the \"title\".", 0, 1, description);
        case -722296940: /*securityLabel*/  return new Property("securityLabel", "CodeableConcept", "A set of Security-Tag codes specifying the level of privacy/security of the Document. Note that DocumentReference.meta.security contains the security labels of the \"reference\" to the document, while DocumentReference.securityLabel contains a snapshot of the security labels on the document the reference refers to.", 0, java.lang.Integer.MAX_VALUE, securityLabel);
        case 951530617: /*content*/  return new Property("content", "", "The document and format referenced. There may be multiple content element repetitions, each with a different format.", 0, java.lang.Integer.MAX_VALUE, content);
        case 951530927: /*context*/  return new Property("context", "", "The clinical context in which the document was prepared.", 0, 1, context);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 243769515: /*masterIdentifier*/ return this.masterIdentifier == null ? new Base[0] : new Base[] {this.masterIdentifier}; // Identifier
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<DocumentReferenceStatus>
        case -23496886: /*docStatus*/ return this.docStatus == null ? new Base[0] : new Base[] {this.docStatus}; // Enumeration<ReferredDocumentStatus>
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case 94742904: /*class*/ return this.class_ == null ? new Base[0] : new Base[] {this.class_}; // CodeableConcept
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // Reference
        case 1028554472: /*created*/ return this.created == null ? new Base[0] : new Base[] {this.created}; // DateTimeType
        case 1943292145: /*indexed*/ return this.indexed == null ? new Base[0] : new Base[] {this.indexed}; // InstantType
        case -1406328437: /*author*/ return this.author == null ? new Base[0] : this.author.toArray(new Base[this.author.size()]); // Reference
        case 1815000435: /*authenticator*/ return this.authenticator == null ? new Base[0] : new Base[] {this.authenticator}; // Reference
        case 1611297262: /*custodian*/ return this.custodian == null ? new Base[0] : new Base[] {this.custodian}; // Reference
        case -7765931: /*relatesTo*/ return this.relatesTo == null ? new Base[0] : this.relatesTo.toArray(new Base[this.relatesTo.size()]); // DocumentReferenceRelatesToComponent
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // StringType
        case -722296940: /*securityLabel*/ return this.securityLabel == null ? new Base[0] : this.securityLabel.toArray(new Base[this.securityLabel.size()]); // CodeableConcept
        case 951530617: /*content*/ return this.content == null ? new Base[0] : this.content.toArray(new Base[this.content.size()]); // DocumentReferenceContentComponent
        case 951530927: /*context*/ return this.context == null ? new Base[0] : new Base[] {this.context}; // DocumentReferenceContextComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 243769515: // masterIdentifier
          this.masterIdentifier = castToIdentifier(value); // Identifier
          return value;
        case -1618432855: // identifier
          this.getIdentifier().add(castToIdentifier(value)); // Identifier
          return value;
        case -892481550: // status
          value = new DocumentReferenceStatusEnumFactory().fromType(castToCode(value));
          this.status = (Enumeration) value; // Enumeration<DocumentReferenceStatus>
          return value;
        case -23496886: // docStatus
          value = new ReferredDocumentStatusEnumFactory().fromType(castToCode(value));
          this.docStatus = (Enumeration) value; // Enumeration<ReferredDocumentStatus>
          return value;
        case 3575610: // type
          this.type = castToCodeableConcept(value); // CodeableConcept
          return value;
        case 94742904: // class
          this.class_ = castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1867885268: // subject
          this.subject = castToReference(value); // Reference
          return value;
        case 1028554472: // created
          this.created = castToDateTime(value); // DateTimeType
          return value;
        case 1943292145: // indexed
          this.indexed = castToInstant(value); // InstantType
          return value;
        case -1406328437: // author
          this.getAuthor().add(castToReference(value)); // Reference
          return value;
        case 1815000435: // authenticator
          this.authenticator = castToReference(value); // Reference
          return value;
        case 1611297262: // custodian
          this.custodian = castToReference(value); // Reference
          return value;
        case -7765931: // relatesTo
          this.getRelatesTo().add((DocumentReferenceRelatesToComponent) value); // DocumentReferenceRelatesToComponent
          return value;
        case -1724546052: // description
          this.description = castToString(value); // StringType
          return value;
        case -722296940: // securityLabel
          this.getSecurityLabel().add(castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 951530617: // content
          this.getContent().add((DocumentReferenceContentComponent) value); // DocumentReferenceContentComponent
          return value;
        case 951530927: // context
          this.context = (DocumentReferenceContextComponent) value; // DocumentReferenceContextComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("masterIdentifier")) {
          this.masterIdentifier = castToIdentifier(value); // Identifier
        } else if (name.equals("identifier")) {
          this.getIdentifier().add(castToIdentifier(value));
        } else if (name.equals("status")) {
          value = new DocumentReferenceStatusEnumFactory().fromType(castToCode(value));
          this.status = (Enumeration) value; // Enumeration<DocumentReferenceStatus>
        } else if (name.equals("docStatus")) {
          value = new ReferredDocumentStatusEnumFactory().fromType(castToCode(value));
          this.docStatus = (Enumeration) value; // Enumeration<ReferredDocumentStatus>
        } else if (name.equals("type")) {
          this.type = castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("class")) {
          this.class_ = castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("subject")) {
          this.subject = castToReference(value); // Reference
        } else if (name.equals("created")) {
          this.created = castToDateTime(value); // DateTimeType
        } else if (name.equals("indexed")) {
          this.indexed = castToInstant(value); // InstantType
        } else if (name.equals("author")) {
          this.getAuthor().add(castToReference(value));
        } else if (name.equals("authenticator")) {
          this.authenticator = castToReference(value); // Reference
        } else if (name.equals("custodian")) {
          this.custodian = castToReference(value); // Reference
        } else if (name.equals("relatesTo")) {
          this.getRelatesTo().add((DocumentReferenceRelatesToComponent) value);
        } else if (name.equals("description")) {
          this.description = castToString(value); // StringType
        } else if (name.equals("securityLabel")) {
          this.getSecurityLabel().add(castToCodeableConcept(value));
        } else if (name.equals("content")) {
          this.getContent().add((DocumentReferenceContentComponent) value);
        } else if (name.equals("context")) {
          this.context = (DocumentReferenceContextComponent) value; // DocumentReferenceContextComponent
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 243769515:  return getMasterIdentifier(); 
        case -1618432855:  return addIdentifier(); 
        case -892481550:  return getStatusElement();
        case -23496886:  return getDocStatusElement();
        case 3575610:  return getType(); 
        case 94742904:  return getClass_(); 
        case -1867885268:  return getSubject(); 
        case 1028554472:  return getCreatedElement();
        case 1943292145:  return getIndexedElement();
        case -1406328437:  return addAuthor(); 
        case 1815000435:  return getAuthenticator(); 
        case 1611297262:  return getCustodian(); 
        case -7765931:  return addRelatesTo(); 
        case -1724546052:  return getDescriptionElement();
        case -722296940:  return addSecurityLabel(); 
        case 951530617:  return addContent(); 
        case 951530927:  return getContext(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 243769515: /*masterIdentifier*/ return new String[] {"Identifier"};
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -892481550: /*status*/ return new String[] {"code"};
        case -23496886: /*docStatus*/ return new String[] {"code"};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case 94742904: /*class*/ return new String[] {"CodeableConcept"};
        case -1867885268: /*subject*/ return new String[] {"Reference"};
        case 1028554472: /*created*/ return new String[] {"dateTime"};
        case 1943292145: /*indexed*/ return new String[] {"instant"};
        case -1406328437: /*author*/ return new String[] {"Reference"};
        case 1815000435: /*authenticator*/ return new String[] {"Reference"};
        case 1611297262: /*custodian*/ return new String[] {"Reference"};
        case -7765931: /*relatesTo*/ return new String[] {};
        case -1724546052: /*description*/ return new String[] {"string"};
        case -722296940: /*securityLabel*/ return new String[] {"CodeableConcept"};
        case 951530617: /*content*/ return new String[] {};
        case 951530927: /*context*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("masterIdentifier")) {
          this.masterIdentifier = new Identifier();
          return this.masterIdentifier;
        }
        else if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a singleton property DocumentReference.status");
        }
        else if (name.equals("docStatus")) {
          throw new FHIRException("Cannot call addChild on a singleton property DocumentReference.docStatus");
        }
        else if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("class")) {
          this.class_ = new CodeableConcept();
          return this.class_;
        }
        else if (name.equals("subject")) {
          this.subject = new Reference();
          return this.subject;
        }
        else if (name.equals("created")) {
          throw new FHIRException("Cannot call addChild on a singleton property DocumentReference.created");
        }
        else if (name.equals("indexed")) {
          throw new FHIRException("Cannot call addChild on a singleton property DocumentReference.indexed");
        }
        else if (name.equals("author")) {
          return addAuthor();
        }
        else if (name.equals("authenticator")) {
          this.authenticator = new Reference();
          return this.authenticator;
        }
        else if (name.equals("custodian")) {
          this.custodian = new Reference();
          return this.custodian;
        }
        else if (name.equals("relatesTo")) {
          return addRelatesTo();
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a singleton property DocumentReference.description");
        }
        else if (name.equals("securityLabel")) {
          return addSecurityLabel();
        }
        else if (name.equals("content")) {
          return addContent();
        }
        else if (name.equals("context")) {
          this.context = new DocumentReferenceContextComponent();
          return this.context;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "DocumentReference";

  }

      public DocumentReference copy() {
        DocumentReference dst = new DocumentReference();
        copyValues(dst);
        dst.masterIdentifier = masterIdentifier == null ? null : masterIdentifier.copy();
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.status = status == null ? null : status.copy();
        dst.docStatus = docStatus == null ? null : docStatus.copy();
        dst.type = type == null ? null : type.copy();
        dst.class_ = class_ == null ? null : class_.copy();
        dst.subject = subject == null ? null : subject.copy();
        dst.created = created == null ? null : created.copy();
        dst.indexed = indexed == null ? null : indexed.copy();
        if (author != null) {
          dst.author = new ArrayList<Reference>();
          for (Reference i : author)
            dst.author.add(i.copy());
        };
        dst.authenticator = authenticator == null ? null : authenticator.copy();
        dst.custodian = custodian == null ? null : custodian.copy();
        if (relatesTo != null) {
          dst.relatesTo = new ArrayList<DocumentReferenceRelatesToComponent>();
          for (DocumentReferenceRelatesToComponent i : relatesTo)
            dst.relatesTo.add(i.copy());
        };
        dst.description = description == null ? null : description.copy();
        if (securityLabel != null) {
          dst.securityLabel = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : securityLabel)
            dst.securityLabel.add(i.copy());
        };
        if (content != null) {
          dst.content = new ArrayList<DocumentReferenceContentComponent>();
          for (DocumentReferenceContentComponent i : content)
            dst.content.add(i.copy());
        };
        dst.context = context == null ? null : context.copy();
        return dst;
      }

      protected DocumentReference typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DocumentReference))
          return false;
        DocumentReference o = (DocumentReference) other_;
        return compareDeep(masterIdentifier, o.masterIdentifier, true) && compareDeep(identifier, o.identifier, true)
           && compareDeep(status, o.status, true) && compareDeep(docStatus, o.docStatus, true) && compareDeep(type, o.type, true)
           && compareDeep(class_, o.class_, true) && compareDeep(subject, o.subject, true) && compareDeep(created, o.created, true)
           && compareDeep(indexed, o.indexed, true) && compareDeep(author, o.author, true) && compareDeep(authenticator, o.authenticator, true)
           && compareDeep(custodian, o.custodian, true) && compareDeep(relatesTo, o.relatesTo, true) && compareDeep(description, o.description, true)
           && compareDeep(securityLabel, o.securityLabel, true) && compareDeep(content, o.content, true) && compareDeep(context, o.context, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DocumentReference))
          return false;
        DocumentReference o = (DocumentReference) other_;
        return compareValues(status, o.status, true) && compareValues(docStatus, o.docStatus, true) && compareValues(created, o.created, true)
           && compareValues(indexed, o.indexed, true) && compareValues(description, o.description, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(masterIdentifier, identifier
          , status, docStatus, type, class_, subject, created, indexed, author, authenticator
          , custodian, relatesTo, description, securityLabel, content, context);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.DocumentReference;
   }

 /**
   * Search parameter: <b>securitylabel</b>
   * <p>
   * Description: <b>Document security-tags</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DocumentReference.securityLabel</b><br>
   * </p>
   */
  @SearchParamDefinition(name="securitylabel", path="DocumentReference.securityLabel", description="Document security-tags", type="token" )
  public static final String SP_SECURITYLABEL = "securitylabel";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>securitylabel</b>
   * <p>
   * Description: <b>Document security-tags</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DocumentReference.securityLabel</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam SECURITYLABEL = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_SECURITYLABEL);

 /**
   * Search parameter: <b>subject</b>
   * <p>
   * Description: <b>Who/what is the subject of the document</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DocumentReference.subject</b><br>
   * </p>
   */
  @SearchParamDefinition(name="subject", path="DocumentReference.subject", description="Who/what is the subject of the document", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Device"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Patient"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Practitioner") }, target={Device.class, Group.class, Patient.class, Practitioner.class } )
  public static final String SP_SUBJECT = "subject";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>subject</b>
   * <p>
   * Description: <b>Who/what is the subject of the document</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DocumentReference.subject</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SUBJECT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SUBJECT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>DocumentReference:subject</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SUBJECT = new ca.uhn.fhir.model.api.Include("DocumentReference:subject").toLocked();

 /**
   * Search parameter: <b>description</b>
   * <p>
   * Description: <b>Human-readable description (title)</b><br>
   * Type: <b>string</b><br>
   * Path: <b>DocumentReference.description</b><br>
   * </p>
   */
  @SearchParamDefinition(name="description", path="DocumentReference.description", description="Human-readable description (title)", type="string" )
  public static final String SP_DESCRIPTION = "description";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>description</b>
   * <p>
   * Description: <b>Human-readable description (title)</b><br>
   * Type: <b>string</b><br>
   * Path: <b>DocumentReference.description</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam DESCRIPTION = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_DESCRIPTION);

 /**
   * Search parameter: <b>language</b>
   * <p>
   * Description: <b>Human language of the content (BCP-47)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DocumentReference.content.attachment.language</b><br>
   * </p>
   */
  @SearchParamDefinition(name="language", path="DocumentReference.content.attachment.language", description="Human language of the content (BCP-47)", type="token" )
  public static final String SP_LANGUAGE = "language";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>language</b>
   * <p>
   * Description: <b>Human language of the content (BCP-47)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DocumentReference.content.attachment.language</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam LANGUAGE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_LANGUAGE);

 /**
   * Search parameter: <b>type</b>
   * <p>
   * Description: <b>Kind of document (LOINC if possible)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DocumentReference.type</b><br>
   * </p>
   */
  @SearchParamDefinition(name="type", path="DocumentReference.type", description="Kind of document (LOINC if possible)", type="token" )
  public static final String SP_TYPE = "type";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>type</b>
   * <p>
   * Description: <b>Kind of document (LOINC if possible)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DocumentReference.type</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_TYPE);

 /**
   * Search parameter: <b>relation</b>
   * <p>
   * Description: <b>replaces | transforms | signs | appends</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DocumentReference.relatesTo.code</b><br>
   * </p>
   */
  @SearchParamDefinition(name="relation", path="DocumentReference.relatesTo.code", description="replaces | transforms | signs | appends", type="token" )
  public static final String SP_RELATION = "relation";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>relation</b>
   * <p>
   * Description: <b>replaces | transforms | signs | appends</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DocumentReference.relatesTo.code</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam RELATION = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_RELATION);

 /**
   * Search parameter: <b>setting</b>
   * <p>
   * Description: <b>Additional details about where the content was created (e.g. clinical specialty)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DocumentReference.context.practiceSetting</b><br>
   * </p>
   */
  @SearchParamDefinition(name="setting", path="DocumentReference.context.practiceSetting", description="Additional details about where the content was created (e.g. clinical specialty)", type="token" )
  public static final String SP_SETTING = "setting";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>setting</b>
   * <p>
   * Description: <b>Additional details about where the content was created (e.g. clinical specialty)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DocumentReference.context.practiceSetting</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam SETTING = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_SETTING);

 /**
   * Search parameter: <b>patient</b>
   * <p>
   * Description: <b>Who/what is the subject of the document</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DocumentReference.subject</b><br>
   * </p>
   */
  @SearchParamDefinition(name="patient", path="DocumentReference.subject", description="Who/what is the subject of the document", type="reference", target={Patient.class } )
  public static final String SP_PATIENT = "patient";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>patient</b>
   * <p>
   * Description: <b>Who/what is the subject of the document</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DocumentReference.subject</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PATIENT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PATIENT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>DocumentReference:patient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PATIENT = new ca.uhn.fhir.model.api.Include("DocumentReference:patient").toLocked();

 /**
   * Search parameter: <b>relationship</b>
   * <p>
   * Description: <b>Combination of relation and relatesTo</b><br>
   * Type: <b>composite</b><br>
   * Path: <b></b><br>
   * </p>
   */
  @SearchParamDefinition(name="relationship", path="DocumentReference.relatesTo", description="Combination of relation and relatesTo", type="composite", compositeOf={"relatesto", "relation"} )
  public static final String SP_RELATIONSHIP = "relationship";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>relationship</b>
   * <p>
   * Description: <b>Combination of relation and relatesTo</b><br>
   * Type: <b>composite</b><br>
   * Path: <b></b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.ReferenceClientParam, ca.uhn.fhir.rest.gclient.TokenClientParam> RELATIONSHIP = new ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.ReferenceClientParam, ca.uhn.fhir.rest.gclient.TokenClientParam>(SP_RELATIONSHIP);

 /**
   * Search parameter: <b>event</b>
   * <p>
   * Description: <b>Main clinical acts documented</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DocumentReference.context.event</b><br>
   * </p>
   */
  @SearchParamDefinition(name="event", path="DocumentReference.context.event", description="Main clinical acts documented", type="token" )
  public static final String SP_EVENT = "event";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>event</b>
   * <p>
   * Description: <b>Main clinical acts documented</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DocumentReference.context.event</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam EVENT = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_EVENT);

 /**
   * Search parameter: <b>class</b>
   * <p>
   * Description: <b>Categorization of document</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DocumentReference.class</b><br>
   * </p>
   */
  @SearchParamDefinition(name="class", path="DocumentReference.class", description="Categorization of document", type="token" )
  public static final String SP_CLASS = "class";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>class</b>
   * <p>
   * Description: <b>Categorization of document</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DocumentReference.class</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CLASS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CLASS);

 /**
   * Search parameter: <b>authenticator</b>
   * <p>
   * Description: <b>Who/what authenticated the document</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DocumentReference.authenticator</b><br>
   * </p>
   */
  @SearchParamDefinition(name="authenticator", path="DocumentReference.authenticator", description="Who/what authenticated the document", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Practitioner") }, target={Organization.class, Practitioner.class } )
  public static final String SP_AUTHENTICATOR = "authenticator";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>authenticator</b>
   * <p>
   * Description: <b>Who/what authenticated the document</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DocumentReference.authenticator</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam AUTHENTICATOR = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_AUTHENTICATOR);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>DocumentReference:authenticator</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_AUTHENTICATOR = new ca.uhn.fhir.model.api.Include("DocumentReference:authenticator").toLocked();

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>Master Version Specific Identifier</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DocumentReference.masterIdentifier, DocumentReference.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="DocumentReference.masterIdentifier | DocumentReference.identifier", description="Master Version Specific Identifier", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>Master Version Specific Identifier</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DocumentReference.masterIdentifier, DocumentReference.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>period</b>
   * <p>
   * Description: <b>Time of service that is being documented</b><br>
   * Type: <b>date</b><br>
   * Path: <b>DocumentReference.context.period</b><br>
   * </p>
   */
  @SearchParamDefinition(name="period", path="DocumentReference.context.period", description="Time of service that is being documented", type="date" )
  public static final String SP_PERIOD = "period";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>period</b>
   * <p>
   * Description: <b>Time of service that is being documented</b><br>
   * Type: <b>date</b><br>
   * Path: <b>DocumentReference.context.period</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam PERIOD = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_PERIOD);

 /**
   * Search parameter: <b>related-id</b>
   * <p>
   * Description: <b>Identifier of related objects or events</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DocumentReference.context.related.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="related-id", path="DocumentReference.context.related.identifier", description="Identifier of related objects or events", type="token" )
  public static final String SP_RELATED_ID = "related-id";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>related-id</b>
   * <p>
   * Description: <b>Identifier of related objects or events</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DocumentReference.context.related.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam RELATED_ID = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_RELATED_ID);

 /**
   * Search parameter: <b>custodian</b>
   * <p>
   * Description: <b>Organization which maintains the document</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DocumentReference.custodian</b><br>
   * </p>
   */
  @SearchParamDefinition(name="custodian", path="DocumentReference.custodian", description="Organization which maintains the document", type="reference", target={Organization.class } )
  public static final String SP_CUSTODIAN = "custodian";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>custodian</b>
   * <p>
   * Description: <b>Organization which maintains the document</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DocumentReference.custodian</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam CUSTODIAN = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_CUSTODIAN);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>DocumentReference:custodian</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_CUSTODIAN = new ca.uhn.fhir.model.api.Include("DocumentReference:custodian").toLocked();

 /**
   * Search parameter: <b>indexed</b>
   * <p>
   * Description: <b>When this document reference was created</b><br>
   * Type: <b>date</b><br>
   * Path: <b>DocumentReference.indexed</b><br>
   * </p>
   */
  @SearchParamDefinition(name="indexed", path="DocumentReference.indexed", description="When this document reference was created", type="date" )
  public static final String SP_INDEXED = "indexed";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>indexed</b>
   * <p>
   * Description: <b>When this document reference was created</b><br>
   * Type: <b>date</b><br>
   * Path: <b>DocumentReference.indexed</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam INDEXED = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_INDEXED);

 /**
   * Search parameter: <b>author</b>
   * <p>
   * Description: <b>Who and/or what authored the document</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DocumentReference.author</b><br>
   * </p>
   */
  @SearchParamDefinition(name="author", path="DocumentReference.author", description="Who and/or what authored the document", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Device"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Patient"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Practitioner"), @ca.uhn.fhir.model.api.annotation.Compartment(name="RelatedPerson") }, target={Device.class, Organization.class, Patient.class, Practitioner.class, RelatedPerson.class } )
  public static final String SP_AUTHOR = "author";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>author</b>
   * <p>
   * Description: <b>Who and/or what authored the document</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DocumentReference.author</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam AUTHOR = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_AUTHOR);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>DocumentReference:author</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_AUTHOR = new ca.uhn.fhir.model.api.Include("DocumentReference:author").toLocked();

 /**
   * Search parameter: <b>created</b>
   * <p>
   * Description: <b>Document creation time</b><br>
   * Type: <b>date</b><br>
   * Path: <b>DocumentReference.created</b><br>
   * </p>
   */
  @SearchParamDefinition(name="created", path="DocumentReference.created", description="Document creation time", type="date" )
  public static final String SP_CREATED = "created";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>created</b>
   * <p>
   * Description: <b>Document creation time</b><br>
   * Type: <b>date</b><br>
   * Path: <b>DocumentReference.created</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam CREATED = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_CREATED);

 /**
   * Search parameter: <b>format</b>
   * <p>
   * Description: <b>Format/content rules for the document</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DocumentReference.content.format</b><br>
   * </p>
   */
  @SearchParamDefinition(name="format", path="DocumentReference.content.format", description="Format/content rules for the document", type="token" )
  public static final String SP_FORMAT = "format";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>format</b>
   * <p>
   * Description: <b>Format/content rules for the document</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DocumentReference.content.format</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam FORMAT = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_FORMAT);

 /**
   * Search parameter: <b>encounter</b>
   * <p>
   * Description: <b>Context of the document  content</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DocumentReference.context.encounter</b><br>
   * </p>
   */
  @SearchParamDefinition(name="encounter", path="DocumentReference.context.encounter", description="Context of the document  content", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Encounter") }, target={Encounter.class } )
  public static final String SP_ENCOUNTER = "encounter";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>encounter</b>
   * <p>
   * Description: <b>Context of the document  content</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DocumentReference.context.encounter</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam ENCOUNTER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_ENCOUNTER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>DocumentReference:encounter</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_ENCOUNTER = new ca.uhn.fhir.model.api.Include("DocumentReference:encounter").toLocked();

 /**
   * Search parameter: <b>related-ref</b>
   * <p>
   * Description: <b>Related Resource</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DocumentReference.context.related.ref</b><br>
   * </p>
   */
  @SearchParamDefinition(name="related-ref", path="DocumentReference.context.related.ref", description="Related Resource", type="reference" )
  public static final String SP_RELATED_REF = "related-ref";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>related-ref</b>
   * <p>
   * Description: <b>Related Resource</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DocumentReference.context.related.ref</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam RELATED_REF = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_RELATED_REF);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>DocumentReference:related-ref</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_RELATED_REF = new ca.uhn.fhir.model.api.Include("DocumentReference:related-ref").toLocked();

 /**
   * Search parameter: <b>location</b>
   * <p>
   * Description: <b>Uri where the data can be found</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>DocumentReference.content.attachment.url</b><br>
   * </p>
   */
  @SearchParamDefinition(name="location", path="DocumentReference.content.attachment.url", description="Uri where the data can be found", type="uri" )
  public static final String SP_LOCATION = "location";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>location</b>
   * <p>
   * Description: <b>Uri where the data can be found</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>DocumentReference.content.attachment.url</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.UriClientParam LOCATION = new ca.uhn.fhir.rest.gclient.UriClientParam(SP_LOCATION);

 /**
   * Search parameter: <b>relatesto</b>
   * <p>
   * Description: <b>Target of the relationship</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DocumentReference.relatesTo.target</b><br>
   * </p>
   */
  @SearchParamDefinition(name="relatesto", path="DocumentReference.relatesTo.target", description="Target of the relationship", type="reference", target={DocumentReference.class } )
  public static final String SP_RELATESTO = "relatesto";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>relatesto</b>
   * <p>
   * Description: <b>Target of the relationship</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DocumentReference.relatesTo.target</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam RELATESTO = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_RELATESTO);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>DocumentReference:relatesto</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_RELATESTO = new ca.uhn.fhir.model.api.Include("DocumentReference:relatesto").toLocked();

 /**
   * Search parameter: <b>facility</b>
   * <p>
   * Description: <b>Kind of facility where patient was seen</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DocumentReference.context.facilityType</b><br>
   * </p>
   */
  @SearchParamDefinition(name="facility", path="DocumentReference.context.facilityType", description="Kind of facility where patient was seen", type="token" )
  public static final String SP_FACILITY = "facility";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>facility</b>
   * <p>
   * Description: <b>Kind of facility where patient was seen</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DocumentReference.context.facilityType</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam FACILITY = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_FACILITY);

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>current | superseded | entered-in-error</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DocumentReference.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="DocumentReference.status", description="current | superseded | entered-in-error", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>current | superseded | entered-in-error</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DocumentReference.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);


}