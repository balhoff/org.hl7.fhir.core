package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Annotation43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Boolean43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.DateTime43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.Reference43_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableReference;
import org.hl7.fhir.r5.model.Enumeration;
import org.hl7.fhir.r5.model.Enumerations;

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
// Generated on Sun, Feb 24, 2019 11:37+1100 for FHIR v4.0.0
public class CommunicationRequest43_50 {

  public static org.hl7.fhir.r5.model.CommunicationRequest convertCommunicationRequest(org.hl7.fhir.r4b.model.CommunicationRequest src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CommunicationRequest tgt = new org.hl7.fhir.r5.model.CommunicationRequest();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getReplaces()) tgt.addReplaces(Reference43_50.convertReference(t));
    if (src.hasGroupIdentifier())
      tgt.setGroupIdentifier(Identifier43_50.convertIdentifier(src.getGroupIdentifier()));
    if (src.hasStatus())
      tgt.setStatusElement(convertCommunicationRequestStatus(src.getStatusElement()));
    if (src.hasStatusReason())
      tgt.setStatusReason(CodeableConcept43_50.convertCodeableConcept(src.getStatusReason()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasPriority())
      tgt.setPriorityElement(convertCommunicationPriority(src.getPriorityElement()));
    if (src.hasDoNotPerform())
      tgt.setDoNotPerformElement(Boolean43_50.convertBoolean(src.getDoNotPerformElement()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getMedium())
      tgt.addMedium(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasSubject())
      tgt.setSubject(Reference43_50.convertReference(src.getSubject()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getAbout()) tgt.addAbout(Reference43_50.convertReference(t));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_50.convertReference(src.getEncounter()));
    for (org.hl7.fhir.r4b.model.CommunicationRequest.CommunicationRequestPayloadComponent t : src.getPayload())
      tgt.addPayload(convertCommunicationRequestPayloadComponent(t));
    if (src.hasOccurrence())
      tgt.setOccurrence(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getOccurrence()));
    if (src.hasAuthoredOn())
      tgt.setAuthoredOnElement(DateTime43_50.convertDateTime(src.getAuthoredOnElement()));
    if (src.hasRequester())
      tgt.setRequester(Reference43_50.convertReference(src.getRequester()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getRecipient()) tgt.addRecipient(Reference43_50.convertReference(t));
    if (src.hasSender())
      tgt.addInformationProvider(Reference43_50.convertReference(src.getSender()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getReasonCode())
      tgt.addReason(CodeableConcept43_50.convertCodeableConceptToCodeableReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getReasonReference())
      tgt.addReason(Reference43_50.convertReferenceToCodeableReference(t));
    for (org.hl7.fhir.r4b.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_50.convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.CommunicationRequest convertCommunicationRequest(org.hl7.fhir.r5.model.CommunicationRequest src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.CommunicationRequest tgt = new org.hl7.fhir.r4b.model.CommunicationRequest();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getReplaces()) tgt.addReplaces(Reference43_50.convertReference(t));
    if (src.hasGroupIdentifier())
      tgt.setGroupIdentifier(Identifier43_50.convertIdentifier(src.getGroupIdentifier()));
    if (src.hasStatus())
      tgt.setStatusElement(convertCommunicationRequestStatus(src.getStatusElement()));
    if (src.hasStatusReason())
      tgt.setStatusReason(CodeableConcept43_50.convertCodeableConcept(src.getStatusReason()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasPriority())
      tgt.setPriorityElement(convertCommunicationPriority(src.getPriorityElement()));
    if (src.hasDoNotPerform())
      tgt.setDoNotPerformElement(Boolean43_50.convertBoolean(src.getDoNotPerformElement()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getMedium())
      tgt.addMedium(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasSubject())
      tgt.setSubject(Reference43_50.convertReference(src.getSubject()));
    for (org.hl7.fhir.r5.model.Reference t : src.getAbout()) tgt.addAbout(Reference43_50.convertReference(t));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_50.convertReference(src.getEncounter()));
    for (org.hl7.fhir.r5.model.CommunicationRequest.CommunicationRequestPayloadComponent t : src.getPayload())
      tgt.addPayload(convertCommunicationRequestPayloadComponent(t));
    if (src.hasOccurrence())
      tgt.setOccurrence(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getOccurrence()));
    if (src.hasAuthoredOn())
      tgt.setAuthoredOnElement(DateTime43_50.convertDateTime(src.getAuthoredOnElement()));
    if (src.hasRequester())
      tgt.setRequester(Reference43_50.convertReference(src.getRequester()));
    for (org.hl7.fhir.r5.model.Reference t : src.getRecipient()) tgt.addRecipient(Reference43_50.convertReference(t));
    if (src.hasInformationProvider())
      tgt.setSender(Reference43_50.convertReference(src.getInformationProviderFirstRep()));
    for (CodeableReference t : src.getReason())
      if (t.hasConcept())
        tgt.addReasonCode(CodeableConcept43_50.convertCodeableConcept(t.getConcept()));
    for (CodeableReference t : src.getReason())
      if (t.hasReference())
        tgt.addReasonReference(Reference43_50.convertReference(t.getReference()));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_50.convertAnnotation(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestStatus> convertCommunicationRequestStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.RequestStatus> tgt = new Enumeration<>(new Enumerations.RequestStatusEnumFactory());
      ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case DRAFT:
                  tgt.setValue(Enumerations.RequestStatus.DRAFT);
                  break;
              case ACTIVE:
                  tgt.setValue(Enumerations.RequestStatus.ACTIVE);
                  break;
              case ONHOLD:
                  tgt.setValue(Enumerations.RequestStatus.ONHOLD);
                  break;
              case REVOKED:
                  tgt.setValue(Enumerations.RequestStatus.REVOKED);
                  break;
              case COMPLETED:
                  tgt.setValue(Enumerations.RequestStatus.COMPLETED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(Enumerations.RequestStatus.ENTEREDINERROR);
                  break;
              case UNKNOWN:
                  tgt.setValue(Enumerations.RequestStatus.UNKNOWN);
                  break;
              default:
                  tgt.setValue(Enumerations.RequestStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestStatus> convertCommunicationRequestStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.RequestStatusEnumFactory());
      ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case DRAFT:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestStatus.DRAFT);
                  break;
              case ACTIVE:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestStatus.ACTIVE);
                  break;
              case ONHOLD:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestStatus.ONHOLD);
                  break;
              case REVOKED:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestStatus.REVOKED);
                  break;
              case COMPLETED:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestStatus.COMPLETED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestStatus.ENTEREDINERROR);
                  break;
              case UNKNOWN:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestStatus.UNKNOWN);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestPriority> convertCommunicationPriority(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestPriority> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.RequestPriority> tgt = new Enumeration<>(new Enumerations.RequestPriorityEnumFactory());
      ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ROUTINE:
                  tgt.setValue(Enumerations.RequestPriority.ROUTINE);
                  break;
              case URGENT:
                  tgt.setValue(Enumerations.RequestPriority.URGENT);
                  break;
              case ASAP:
                  tgt.setValue(Enumerations.RequestPriority.ASAP);
                  break;
              case STAT:
                  tgt.setValue(Enumerations.RequestPriority.STAT);
                  break;
              default:
                  tgt.setValue(Enumerations.RequestPriority.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestPriority> convertCommunicationPriority(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestPriority> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestPriority> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.RequestPriorityEnumFactory());
      ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ROUTINE:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestPriority.ROUTINE);
                  break;
              case URGENT:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestPriority.URGENT);
                  break;
              case ASAP:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestPriority.ASAP);
                  break;
              case STAT:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestPriority.STAT);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestPriority.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.r5.model.CommunicationRequest.CommunicationRequestPayloadComponent convertCommunicationRequestPayloadComponent(org.hl7.fhir.r4b.model.CommunicationRequest.CommunicationRequestPayloadComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CommunicationRequest.CommunicationRequestPayloadComponent tgt = new org.hl7.fhir.r5.model.CommunicationRequest.CommunicationRequestPayloadComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (org.hl7.fhir.r4b.utils.ToolingExtensions.hasExtension(src, VersionConvertorConstants.EXT_PAYLOAD_CONTENT)) {
      org.hl7.fhir.r4b.model.Extension e = org.hl7.fhir.r4b.utils.ToolingExtensions.getExtension(src, VersionConvertorConstants.EXT_PAYLOAD_CONTENT);
      tgt.setContent(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(e.getValue()));
      org.hl7.fhir.r5.extensions.ExtensionUtilities.removeExtension(tgt, VersionConvertorConstants.EXT_PAYLOAD_CONTENT);
    } else if (src.hasContent()) {
      org.hl7.fhir.r4b.model.DataType content = src.getContent();
      if (content instanceof org.hl7.fhir.r4b.model.StringType) {
        org.hl7.fhir.r4b.model.StringType string = (org.hl7.fhir.r4b.model.StringType) content;
        org.hl7.fhir.r5.model.CodeableConcept code = new org.hl7.fhir.r5.model.CodeableConcept();
        code.setTextElement((org.hl7.fhir.r5.model.StringType) ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(string));
        tgt.setContent(code);
      } else
        tgt.setContent(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(content));
    }
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.CommunicationRequest.CommunicationRequestPayloadComponent convertCommunicationRequestPayloadComponent(org.hl7.fhir.r5.model.CommunicationRequest.CommunicationRequestPayloadComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.CommunicationRequest.CommunicationRequestPayloadComponent tgt = new org.hl7.fhir.r4b.model.CommunicationRequest.CommunicationRequestPayloadComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasContent()) {
      org.hl7.fhir.r5.model.DataType content = src.getContent();
      if (content instanceof org.hl7.fhir.r5.model.CodeableConcept) {
        org.hl7.fhir.r5.model.CodeableConcept code = (org.hl7.fhir.r5.model.CodeableConcept) content;
        if (code.hasText())
          tgt.setContent(new org.hl7.fhir.r4b.model.StringType(code.getText()));
        if (code.hasCoding() || code.hasExtension()) {
          org.hl7.fhir.r4b.model.Extension e = new org.hl7.fhir.r4b.model.Extension(VersionConvertorConstants.EXT_PAYLOAD_CONTENT);
          e.setValue(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(code));
          tgt.addExtension(e);
        }
      } else
        tgt.setContent(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(content));
    }
    return tgt;
  }
}