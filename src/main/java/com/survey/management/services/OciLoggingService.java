package com.survey.management.services;

import com.oracle.bmc.ConfigFileReader;
import com.oracle.bmc.auth.AbstractAuthenticationDetailsProvider;
import com.oracle.bmc.auth.ConfigFileAuthenticationDetailsProvider;
import com.oracle.bmc.loggingingestion.LoggingClient;
import com.oracle.bmc.loggingingestion.model.LogEntry;
import com.oracle.bmc.loggingingestion.model.LogEntryBatch;
import com.oracle.bmc.loggingingestion.model.PutLogsDetails;
import com.oracle.bmc.loggingingestion.requests.PutLogsRequest;

import java.time.Instant;
import java.util.Date;
import java.util.List;

public class OciLoggingService {

    private final LoggingClient loggingClient;
    private final String logId ;

    public OciLoggingService(String ociConfigPath, String logId) {
        try {
            System.out.println(ociConfigPath);
            ConfigFileReader.ConfigFile config = ConfigFileReader.parse(ociConfigPath, "DEFAULT");
            AbstractAuthenticationDetailsProvider provider = new ConfigFileAuthenticationDetailsProvider(config);
            this.loggingClient = LoggingClient.builder().build(provider);
            this.logId=logId;
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize OCI Logging client", e);
        }

    }


    public void sendToOci(String payload) {


        LogEntry entry = LogEntry.builder()
                .data(payload)
                .build();


        PutLogsDetails logsDetails = PutLogsDetails.builder()
                .specversion("1.0")
                .logEntryBatches(List.of(LogEntryBatch.builder()
                        .entries(List.of(entry))
                        .source("survey-management-api")
                        .type("survey-entry")
                        .defaultlogentrytime(Date.from(Instant.now()))
                        .build()))
                .build();

        PutLogsRequest request = PutLogsRequest.builder()
                .logId(logId)
                .putLogsDetails(logsDetails)
                .build();

        loggingClient.putLogs(request);
    }
}

