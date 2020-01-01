package basic;

public class WorkService {
    WorkManager aWorkManager;

    public void setWorkManager(WorkManager aWorkManager) {
        this.aWorkManager = aWorkManager;
    }

    public void askWork() {
        System.out.println(aWorkManager.doIt());
    }
}
