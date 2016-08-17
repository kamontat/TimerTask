package kamontat.task;

import kamontat.object.TaskTimer;
import kamontat.task.concatstring.TaskAppendByPlus;
import kamontat.task.concatstring.TaskStringBuilder;
import kamontat.task.readfile.*;
import kamontat.task.sortarray.TaskArraySort;
import kamontat.task.sortarray.TaskParallelArraySort;
import kamontat.main.Main;

/**
 * create on 5/5/59.
 *
 * @author kamontat
 */
public enum TaskFactory {
	// read from file
	TASK01(new TaskScanAndParse()),
	TASK02(new TaskBufferAndReadLine()),
	TASK03(new TaskBufferAndSteam()),
	TASK04(new TaskBufferAndSteamWithConsumer()),
	TASK05(new TaskSteam()),
	// concat String
	TASK11(new TaskAppendByPlus(TaskTimer.numString)),
	TASK12(new TaskStringBuilder(TaskTimer.numString)),
	// sort array
	TASK21(new TaskArraySort(Main.arrays)),
	TASK22(new TaskParallelArraySort(Main.arrays));

	private Runnable runnable;

	private TaskFactory(Runnable runnable) {
		this.runnable = runnable;
	}

	public Runnable getTask() {
		return runnable;
	}
}
