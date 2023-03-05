import java.util.LinkedList;
import java.util.List;

public class Counter implements Runnable{
    private volatile Thread control;
    private int value;
    private volatile boolean suspended;
    private List<CounterListener> listeners;

    public Counter(CounterFrame counterFrame){
        this.listeners = new LinkedList<>();
    }

    public synchronized void addCounterListener(CounterListener counterListener){
        listeners.add(counterListener);
    }

    public synchronized void removeCounterListener(CounterListener counterListener){
        listeners.remove(counterListener);
    }

    public void start(){
        this.control = new Thread(this);
        value = 0;
        suspended = false;
        control.start();
    }

    public void stop(){
        Thread tmp = control;
        control = null;
        tmp.interrupt();
    }

    public void suspend(){
        suspended = true;
    }

    public synchronized void resume(){
        suspended =false;
        notifyAll();
    }
    @Override
    public void run() {
        Thread current = Thread.currentThread();
        while (current == control){
            while (suspended){
                try {
                    synchronized (this) {
                        wait();
                    }
                } catch (InterruptedException e) {
                    break;
                }
            }
            try {
                Thread.sleep(1000);
                value++;
                CounterEvent ce = new CounterEvent(this, value);
                synchronized (this){
                    for (CounterListener cl: listeners) {
                        cl.counterValueChange(ce);
                    }
                }
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
