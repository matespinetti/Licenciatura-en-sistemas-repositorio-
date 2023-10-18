package ar.edu.unlp.info.oo1.ej10_jobScheduler;

public class LifoJobScheduler extends JobScheduler {
    public JobDescription next() {
        JobDescription nextJob = jobs.get(jobs.size() - 1);
        this.unschedule(nextJob);
        return nextJob;

    }

}
