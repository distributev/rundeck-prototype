import {Injectable} from '@angular/core';

import {Observable} from 'rxjs';

import {Job} from './job';
import {environment} from '../environments/environment';
import {HttpClient} from '@angular/common/http';
import {JobDetails} from './job-details';

@Injectable({
    providedIn: 'root',
})
export class JobService {

    host = environment.hostUrl;

    constructor(private http: HttpClient) { }

    getJobs(): Observable<Array<Job>> {
        return this.http.get<Array<Job>>(this.host + '/job');
    }

    getJobDetails(id: number): Observable<JobDetails> {
        return this.http.get<JobDetails>(this.host + '/job/' + id);
    }

    private handleError (error: Response | any) {
        console.error('JobService::handleError', error);
        return Observable.throw(error);
    }
}
