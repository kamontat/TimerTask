package kamontat.object;

import kamontat.task.TaskFactory;
import kamontat.main.Main;
import kamontat.timer.StopWatch;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Time how long it takes to perform some tasks
 * using different programming constructs.
 * <p>
 * Created by kamontat on 5/5/59.
 */
public class TaskTimer {
	/**
	 * number of String that want to concat. <br>
	 * Default is 10000
	 */
	public static int numString = 10000;

	/**
	 * number of array that want to sort. <br>
	 * Default is 50000
	 */
	public static int numArray = 50000;

	public static void execAndPrint(Runnable task) {
		StopWatch watch = new StopWatch();
		System.out.println("Starting Task: " + task.toString());

		watch.start();
		task.run();
		watch.stop();

		System.out.printf("Elapsed time is %.5f sec\n\n", watch.getElapsed());
		watch.reset();
	}

	public static void execAndPrint() {
		//add element in array
		Arrays.parallelSetAll(Main.arrays, value -> ThreadLocalRandom.current().nextInt(1000000));
		Runnable task = null;
		StopWatch watch = new StopWatch();

		for (int i = 0; i < TaskFactory.values().length; i++) {
			task = TaskFactory.values()[i].getTask();

			System.out.println("Starting Task: " + task.toString());

			watch.start();
			task.run();
			watch.stop();

			System.out.printf("Elapsed time is %.5f sec\n\n", watch.getElapsed());

			watch.reset();
		}


	}
}
