package com.cosci141;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * DiningPhilosophers.java
 *
 * This program starts the dining philosophers problem.
 *
 */


public class DiningPhilosophers
{  
   public static void main(String args[])
   {
     // Here your code

      final Philosopher[] philosophers = new Philosopher[5];
      Object[] forks = new Object[philosophers.length];

      for (int i = 0; i < forks.length; i++) {
         forks[i] = new Object();
      }

      for (int i = 0; i < philosophers.length; i++) {
         Object leftFork = forks[i];
         Object rightFork = forks[(i + 1) % forks.length];

         if (i == philosophers.length - 1) {

            // The last philosopher picks up the right fork first
            philosophers[i] = new Philosopher(rightFork, leftFork);
         } else {
            philosophers[i] = new Philosopher(leftFork, rightFork);
         }

         Thread t
                 = new Thread(philosophers[i], "Philosopher " + i);
         t.start();

      }

   }
}
