package kamontat.main;

import kamontat.object.TaskTimer;

/**
 * @author kamontat
 * @since 5/5/59
 */
public class Main {
	// create new long[] with numArray element
	public static long[] arrays = new long[TaskTimer.numArray];

	public static void main(String[] args) {
		TaskTimer.execAndPrint();
	}
}
