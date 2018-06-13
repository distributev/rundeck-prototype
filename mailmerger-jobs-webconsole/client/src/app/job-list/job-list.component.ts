import { Component, OnInit } from '@angular/core';
import {Job} from '../job';
import {JobService} from '../job.service';

@Component({
  selector: 'app-job-list',
  templateUrl: './job-list.component.html',
  styleUrls: ['./job-list.component.css']
})
export class JobListComponent implements OnInit {

  displayedColumns = ['fileName', 'date', 'start', 'duration', 'status', 'code'];
  jobs: Job[];
  selectedJob: Job;

  fileToUpload: File = null;
  handleFileInput(files: FileList) {
      this.fileToUpload = files.item(0);
  }

  uploadFileToActivity() {
      console.log('sending file...');
  }

  constructor(private jobService: JobService) { }

  ngOnInit() {
      this.getJobs();
  }

  onSelect(job: Job): void {
      console.log('selected job: ' + job);
      this.selectedJob = job;
  }

  getJobs(): void {
      this.jobService.getJobs()
          .subscribe(job => this.jobs = job);
  }


}

export interface PeriodicElement {
    fileName: string;
    date: string;
    start: string;
    duration: string;
    status: string;
    code: string;
}
