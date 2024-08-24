package unidue.de;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Parkplatz {
    private int kapazitaet;
    private final Deque<Auto> autos = new LinkedList<>();
    private final Lock lock = new ReentrantLock();
    private final Condition nicht_voll = lock.newCondition();
    private final Condition nicht_leer = lock.newCondition();

    public Parkplatz(int kapazitaet) {
        this.kapazitaet = kapazitaet;
    }

    public void autoParken(Auto auto) throws InterruptedException {
        lock.lock();
        try {
            while(autos.size() == kapazitaet ) {
                nicht_voll.await();
            }
            autos.addLast(auto);
            System.out.println(auto + " wurde produziert und geparkt.");
            nicht_leer.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public Auto autoAbholen() throws InterruptedException {
        lock.lock();
        try {
            while(autos.isEmpty()) {
                nicht_leer.await();
            }
            Auto erste = autos.removeFirst();
            nicht_voll.signalAll();
            return erste;
        } finally {
            lock.unlock();
        }
    }

    public boolean isFull() {
        return autos.size() == kapazitaet;
    }
}
