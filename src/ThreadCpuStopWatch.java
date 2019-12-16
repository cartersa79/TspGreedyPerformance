import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class ThreadCpuStopWatch {

    private ThreadMXBean magicBean;
    private long stopWatchStartTimeNanoSecs;

    public ThreadCpuStopWatch(){
        magicBean = ManagementFactory.getThreadMXBean();
    }

    public void start(){
        // when stopwatch starts, get and save the current CPU time for the current thread
        // we can always call this to reset the stopwatch
        stopWatchStartTimeNanoSecs = magicBean.getCurrentThreadCpuTime();
    }
    // get elapsed time in nanoseconds
    // Note: this will includes some time for the overhead of calling & executing this method itself
    // as well as some of the time involved in executing and returning from the start() method
    public long elapsedTime(){
        // calculate elapsed time by getting current CPU time and substracting the CPU time from when we started the stopwatch
        // this does not stop the stopwatch
        return (magicBean.getCurrentThreadCpuTime() - stopWatchStartTimeNanoSecs);
    }
}