package org.hl7.fhir.validation.cli.tasks;

import org.hl7.fhir.utilities.TimeTracker;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.service.model.ValidationContext;
import org.hl7.fhir.validation.service.ValidationService;
import org.hl7.fhir.validation.cli.Display;
import org.hl7.fhir.validation.service.utils.EngineMode;
import org.slf4j.Logger;

public class ConvertTask extends ValidationEngineTask {

  @Override
  public String getName() {
    return "convert";
  }

  @Override
  public String getDisplayName() {
    return "Conversion";
  }

  @Override
  public boolean isHidden() {
    return false;
  }

  @Override
  public boolean shouldExecuteTask(ValidationContext validationContext, String[] args) {
    return validationContext.getMode() == EngineMode.CONVERT;
  }

  @Override
  public void logHelp(Logger logger) {
    Display.displayHelpDetails(logger,"help/convert.txt");
  }

  @Override
  public void executeTask(ValidationService validationService, ValidationEngine validationEngine, ValidationContext validationContext, String[] args, TimeTracker tt, TimeTracker.Session tts) throws Exception {
    validationService.convertSources(validationContext, validationEngine);
  }

}
