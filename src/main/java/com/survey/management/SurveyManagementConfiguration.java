package com.survey.management;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

import javax.validation.constraints.NotEmpty;

public class SurveyManagementConfiguration  extends Configuration {

    @NotEmpty
    private String logId;


    @NotEmpty
    private String ociConfigPath;

    @JsonProperty
    public String getOciConfigPath() {
        return ociConfigPath;
    }

    @JsonProperty
    public void setOciConfigPath(String ociConfigPath) {
        this.ociConfigPath = ociConfigPath;
    }

    @JsonProperty
    public String getLogId() {
        return logId;
    }

    @JsonProperty
    public void setLogId(String logId) {
        this.logId = logId;
    }

}

