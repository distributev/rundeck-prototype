package org.distributev.mailmerger.service;

import org.distributev.mailmerger.dto.JobDetailsDto;
import org.distributev.mailmerger.dto.JobDto;

import java.util.List;

public interface JobService {

    List<JobDto> getAllJobs();

    JobDetailsDto getJob(long id);
}
