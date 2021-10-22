package com.cosci141;

/**
 * Philosopher.java
 *
 * This class represents each philosopher thread.
 * Philosophers alternate between eating and thinking.
 *
 */


public class Philosopher implements Runnable
{


    private void doAction(String philosopherAction) throws InterruptedException {          // Philosophers to perform an action
        System.out.println(Thread.currentThread().getName() + " " + philosopherAction);    // prints Philosopher's number and action
        Thread.sleep(((int) (Math.random() * 2000) + 1000));                               // waits 1 to 3 seconds
    }

    private Object leftFork;                                                                // fork on the left side of Philosopher
    private Object rightFork;                                                               // fork on the right side of Philosopher

    public Philosopher(Object leftFork, Object rightFork) {                                 // Philosopher constructor
        this.leftFork = leftFork;                                                           // left fork
        this.rightFork = rightFork;                                                         // right fork
    }

    @Override
    public void run() {

        try {
            while (true) {

                // thinking
                doAction("--> Thinking");                                   // Philosopher is thinking
                synchronized (leftFork) {
                    doAction("--> Picked up left fork");                    // Philosopher picked up left fork
                    synchronized (rightFork) {
                        // eating
                        doAction("--> Picked up right fork - eating");      // Philosopher picked up left fork

                        doAction("--> Put down right fork");
                    }

                    // Back to thinking
                    doAction("--> Put down left fork. Back to thinking");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }
    //Your code here
}
