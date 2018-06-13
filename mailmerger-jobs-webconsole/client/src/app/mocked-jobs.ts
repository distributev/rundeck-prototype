import {Job} from './job';
import {JobDetails} from './job-details';

export const JOBS: Job[] = [
    {id: 1, fileName: 'Payslips.csv', date: '2011-11-23', start: '13:36:12', duration: '00:00:18', status: 'STARTED', code: 'UNKNOWN'}
];
export const JOB_DETAILS: JobDetails[] = [
    {id: 1, fileName: 'Payslips.csv', date: '2011-11-23', start: '13:36:12', duration: '00:00:18', status: 'STARTED', code: 'UNKNOWN',
    files: [''], exitMessage: ''}
];
