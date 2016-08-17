package kamontat.task.sortarray;

import java.util.*;

/**
 * Sort array using Arrays.sort Method
 *
 * @author kamontat
 * @since 10/5/59 - 00:29
 */
public class TaskArraySort implements Runnable {
	private long[] array;

	public TaskArraySort(long[] array) {
		this.array = array.clone();
	}

	@Override
	public void run() {
		Arrays.sort(array);
	}

	@Override
	public String toString() {
		return "sort long number in array using Arrays.sort";
	}
}
