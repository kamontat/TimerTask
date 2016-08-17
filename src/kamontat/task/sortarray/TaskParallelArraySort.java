package kamontat.task.sortarray;

import java.util.*;

/**
 * @author kamontat
 * @since 10/5/59 - 00:29
 */
public class TaskParallelArraySort implements Runnable {
	private long[] array;

	public TaskParallelArraySort(long[] array) {
		this.array = array.clone();
	}

	@Override
	public void run() {
		Arrays.parallelSort(array);
	}

	@Override
	public String toString() {
		return "sort long number in array using Arrays.parallelSort";
	}
}
