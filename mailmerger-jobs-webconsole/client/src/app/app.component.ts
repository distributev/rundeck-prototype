import {Component, OnInit} from '@angular/core';
import {JobService} from './job.service';
import {Job} from './job';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit {
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
