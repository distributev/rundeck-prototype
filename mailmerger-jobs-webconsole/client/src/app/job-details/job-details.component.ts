import {Component, OnInit} from '@angular/core';
import {JobDetails} from '../job-details';
import {JobService} from '../job.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-job-details',
  templateUrl: './job-details.component.html',
  styleUrls: ['./job-details.component.css']
})
export class JobDetailsComponent implements OnInit {

  selectedJob: JobDetails;

  constructor(private jobService: JobService,
              private route: ActivatedRoute) { }

  ngOnInit() {
    this.loadJobDetails();
  }

  loadJobDetails() {
      const id = +this.route.snapshot.paramMap.get('id');
      this.jobService.getJobDetails(id)
          .subscribe(job => this.selectedJob = job);
  }

  isSucess(): boolean {
    return this.selectedJob.status === 'COMPLETED';
  }

}
