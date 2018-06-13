import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {MatButtonModule, MatTableModule} from '@angular/material';

import {AppComponent} from './app.component';
import {CommonModule} from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {JobListComponent} from './job-list/job-list.component';
import {JobDetailsComponent} from './job-details/job-details.component';

const appRoutes: Routes = [
    { path: '', component: JobListComponent, pathMatch: 'full' },
    { path: 'job/:id', component: JobDetailsComponent }
];

@NgModule({
    declarations: [AppComponent, JobListComponent, JobDetailsComponent],
    imports: [
        RouterModule.forRoot(appRoutes), BrowserModule, CommonModule, MatTableModule, MatButtonModule
    ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule {
}
