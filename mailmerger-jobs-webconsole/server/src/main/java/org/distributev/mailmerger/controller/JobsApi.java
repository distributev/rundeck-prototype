package org.distributev.mailmerger.controller;

import org.distributev.mailmerger.dto.JobDetailsDto;
import org.distributev.mailmerger.dto.JobDto;
import org.distributev.mailmerger.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/job")
public class JobsApi {

    @Autowired
    private JobService jobService;

    @GetMapping
    public List<JobDto> getAllJobs() {
        return jobService.getAllJobs();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public JobDetailsDto getJobDetails(@PathVariable("id") long id) {
        return jobService.getJob(id);
    }
}
