package org.distributev.mailmerger.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class JobDto {

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

    @JsonProperty("exitCode")
    private String exitCode;

}
