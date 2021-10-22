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
                doAction("--> Thinking");                                    // Philosopher is thinking
                synchronized (leftFork) {                                                   // To prevent other threads(philosopher) from getting the same fork
                    doAction("--> Picked up left fork");                     // Philosopher picked up left fork
                    synchronized (rightFork) {                                              // To prevent other threads(philosopher) from getting the same fork
                        // eating
                        doAction("--> Picked up right fork" +                // Philosopher picked up right fork
                                " --> starts eating");

                        doAction("--> Put down right fork");                 // Philosopher put down right fork
                    }
                    doAction("--> Put down left fork and finished eating" +  // Philosopher resume to thinking
                            "--> Now thinking again");
                }
            }
        } catch (InterruptedException e) {                                                  // in case there is an error, to catch the exception
            Thread.currentThread().interrupt();
            return;
        }
    }
}
