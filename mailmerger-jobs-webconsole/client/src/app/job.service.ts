import {Injectable} from '@angular/core';

import {Observable, of} from 'rxjs';

import {Job} from './job';
import {JOB_DETAILS, JOBS} from './mocked-jobs';
import {JobDetails} from './job-details';

@Injectable({
    providedIn: 'root',
})
export class JobService {

    constructor() { }

    getJobs(): Observable<Job[]> {
        return of(JOBS);
    }

    getJobDetails(id: number): JobDetails {
        console.log('Loading job details by id: ' + id);
        return JOB_DETAILS[0];
    }
}
