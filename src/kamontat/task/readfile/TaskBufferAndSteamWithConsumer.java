package kamontat.task.readfile;

import kamontat.object.Dictionary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;

/**
 * Process all the words in a file (one word per line) using BufferedReader
 * and the lines() method which creates a Stream of Strings (one item per line).
 * Then use the stream to compute summary statistics.
 * This is same as task3, except we use a Collector instead of Consumer.
 * <p>
 * Created by kamontat on 5/5/59.
 */
public class TaskBufferAndSteamWithConsumer implements Runnable {
	private BufferedReader br;

	public TaskBufferAndSteamWithConsumer() {
		try {
			br = new BufferedReader(new InputStreamReader(Dictionary.getWordsAsStream()));
		} catch (Exception ex) {
			System.out.println("Could not open dictionary: " + ex.getMessage());
		}
	}

	/**
	 * run this task (4)
	 */
	@Override
	public void run() {
		// We want the Consumer to add to the count and total length,
		// but a Lambda can only access local variables (from surrounding scope) if
		// they are final.  That means, we can't use an int, long, or double variable.
		// So, use AtomicInteger and AtomicLong, which are mutable objects.
		final AtomicLong total = new AtomicLong();
		final AtomicInteger counter = new AtomicInteger();

		//TODO Use a Collector instead of Consumer
		Consumer<String> consumer = word -> {
			total.getAndAdd(word.length());
			counter.incrementAndGet();
		};

		br.lines().forEach(consumer);  // Ha! No loop.
		// close the input
		try {
			br.close();
		} catch (IOException ex) { /* ignore it */ }

		int count = counter.intValue();
		double averageLength = (count > 0) ? total.doubleValue() / count: 0.0;
		System.out.printf("Average length of %,d words is %.2f\n", count, averageLength);
	}

	/**
	 * return String that explain this task (4)
	 *
	 * @return String
	 */
	@Override
	public String toString() {
		return "read words using BufferedReader and Stream with Consumer";
	}
}
