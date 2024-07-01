import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Scheduler {
    public static void main(String[] args) {
        // create a a thread pool of size 1
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        Runnable task = new Runnable() {
            public void run() {
                System.out.println("Executed at : " + System.currentTimeMillis());
            }
        };

        scheduler.schedule(task, 5, TimeUnit.SECONDS); // runns onetime after a delay 5 seconds

        scheduler.scheduleAtFixedRate(task, 0, 10, TimeUnit.SECONDS); // runs every 10 seconds

        scheduler.schedule(() -> scheduler.shutdown(), 30, TimeUnit.SECONDS); // shutdown the scheduler after 30 sec
    }
}
