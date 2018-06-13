package org.distributev.mailmerger.service.impl;

import org.distributev.mailmerger.dto.JobDetailsDto;
import org.distributev.mailmerger.dto.JobDto;
import org.distributev.mailmerger.service.JobService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    @Override
    public List<JobDto> getAllJobs() {
        return null;
    }

    @Override
    public JobDetailsDto getJob(long id) {
        return null;
    }
}
