package com.cosci141;

/**
 * DiningPhilosophers.java
 *
 * This program starts the dining philosophers problem.
 *
 */


public class DiningPhilosophers
{  
   public static void main(String args[]) {
      final int NUMBER_OF_PHILOSOPHERS = 5;                                            // number of philosophers
      final Philosopher[] philosophers = new Philosopher[NUMBER_OF_PHILOSOPHERS];      // Creating an array of 5 Philosopher objects
      Object[] forks = new Object[NUMBER_OF_PHILOSOPHERS];                             // Creating an array of 5 forks

      for (int i = 0; i < forks.length; i++) {                                         // instantiating each fork
         forks[i] = new Object();                                                      // fork is a new object
      }

      for (int index = 0; index < philosophers.length; index++) {                       // for loop to assign each philosopher an action
         Object leftFork = forks[index];                                                // to assign the left fork
         Object rightFork = forks[(index + 1) % forks.length];                          // to assign the right fork

         if (index == philosophers.length - 1) {                                        // if it's the turn of the last philosopher, then
            philosophers[index] = new Philosopher(rightFork, leftFork);                 // last philosopher picks up the right fork first
         } else {                                                                       // if it's not the turn of the last philosopher, then
            philosophers[index] = new Philosopher(leftFork, rightFork);                 // philosopher picks up the left fork first
         }

         Thread thread = new Thread(philosophers[index], "Philosopher " + index); // philosopher index is assigned to the thread
         thread.start();                                                                 // starts thread

      }

   }
}
