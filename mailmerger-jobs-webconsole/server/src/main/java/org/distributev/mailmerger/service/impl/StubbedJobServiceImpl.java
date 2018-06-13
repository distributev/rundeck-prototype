package org.distributev.mailmerger.service.impl;

import com.google.common.collect.Lists;
import org.distributev.mailmerger.dto.JobDetailsDto;
import org.distributev.mailmerger.dto.JobDto;
import org.distributev.mailmerger.service.JobService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class StubbedJobServiceImpl implements JobService {

    private static final List<JobDto> JOBS = Lists.newArrayList(
            new JobDto(1, "STARTED", "Payslips.csv", "2011-11-23", "11:36:12", "00:00:18", "UNKNOWN"),
            new JobDto(2, "COMPLETED", "Payslips.csv", "2011-11-18", "11:36:12", "00:00:18", "COMPLETED"),
            new JobDto(3, "FAILED", "Payslips.csv", "2011-01-28", "11:36:12", "00:00:18", "FAILED")
    );

    private static final List<JobDetailsDto> JOB_DETAILS = Lists.newArrayList(
            new JobDetailsDto(1, "STARTED", "Payslips.csv", "2011-11-23", "11:36:12", "00:00:18", "",
                    Collections.emptyList()),
            new JobDetailsDto(2, "COMPLETED", "Payslips.csv", "2011-11-18", "11:36:12", "00:00:18", "",
                    Collections.singletonList("file.csv")),
            new JobDetailsDto(3, "FAILED", "Payslips.csv", "2011-01-28", "11:36:12", "00:00:18",
                    "Exception stack trace", Collections.emptyList())
    );

    @Override
    public List<JobDto> getAllJobs() {
        return JOBS;
    }

    @Override
    // todo: should return 404 status
    public JobDetailsDto getJob(final long id) {
        return JOB_DETAILS.stream()
                .filter(job -> job.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
