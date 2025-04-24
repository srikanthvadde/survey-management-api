package com.survey.management;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.survey.management.resources.SurveyManagementResource;
import com.survey.management.services.OciLoggingService;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

class SurveyManagementApplication extends Application<SurveyManagementConfiguration> {
    public static void main(String[] args) throws Exception {
        new SurveyManagementApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<SurveyManagementConfiguration> bootstrap) {}

    @Override
    public void run(SurveyManagementConfiguration configuration, Environment environment) {
        ObjectMapper objectMapper = environment.getObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        OciLoggingService logService = new OciLoggingService(
                configuration.getOciConfigPath(),
                configuration.getLogId()
        );

        final SurveyManagementResource resource = new SurveyManagementResource(logService, objectMapper);
        environment.jersey().register(resource);
    }


}
