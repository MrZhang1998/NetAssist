package core.task;

/**
 *
 */
public class MyTask {
    public static void main(String[] args) {
        // 单位: 毫秒
        final long timeInterval = 1000;//参数有textfield传入
        Runnable runnable = new Runnable() {
            public void run() {
                while (true) {
                    // ------- code for task to run
                    System.out.println("send data ...");
                    // ------- ends here
                    try {
                        Thread.sleep(timeInterval);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

}
