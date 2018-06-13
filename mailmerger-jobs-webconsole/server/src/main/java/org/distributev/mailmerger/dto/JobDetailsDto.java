package org.distributev.mailmerger.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.util.List;

@Value
public class JobDetailsDto {

    @JsonProperty("id")
    private long id;

    @JsonProperty("status")
    private String status;

    @JsonProperty("inputFileName")
    private String inputFileName;

    @JsonProperty("startDate")
    private String startDate;

    @JsonProperty("startTime")
    private String startTime;

    @JsonProperty("duration")
    private String duration;

    @JsonProperty("exitMessage")
    private String exitMessage;

    @JsonProperty("output")
    private List<String> outputFiles;


}
