package cz.etn.emailvalidator;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by tomaspavel on 13.2.17.
 */
public class Utils {

	/**
	 * Constructs map from given array.
	 * @param array array to convert. Each inner array must contain 2 elements
	 * (if less, an ArrayIndexOutOfBoundsException is thrown,
	 * if more, extra elements are ignored).
	 * @return new map containing the same key-value pairs as given array
	 */
	@SuppressWarnings("unchecked")
	public static <K,V> Map<K,V> toMap(Object array[][]) {
		Map<K,V> retval = new HashMap<>();
		for (Object pair[] : array) {
			K key = (K) pair[0];
			V value = (V) pair[1];
			retval.put(key,value);
		}
		return retval;
	}

	/**
	 * Constructs map from given array.
	 * The iterator of the map preserves ordering of elements in array.
	 * @param array array to convert. Each inner array must contain 2 elements
	 * (if less, an ArrayIndexOutOfBoundsException is thrown,
	 * if more, extra elements are ignored).
	 * @return new map (LinkedHashMap implementation)
	 * containing the same key-value pairs as given array
	 */
	@SuppressWarnings("unchecked")
	public static <K,V> Map<K,V> toOrderedMap(Object array[][]) {
		Map<K,V> retval = new LinkedHashMap<>();
		for (Object pair[] : array) {
			K key = (K) pair[0];
			V value = (V) pair[1];
			retval.put(key,value);
		}
		return retval;
	}


	public static String exceptionToString(Throwable e) {
		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw));
		return sw.getBuffer().toString();
	}

	/**
	 * @param lhs
	 * @param rhs
	 * @return
	 */
	static int levenshteinDistance(CharSequence lhs, CharSequence rhs) {
		int len0 = lhs.length() + 1;
		int len1 = rhs.length() + 1;

		// the array of distances
		int[] cost = new int[len0];
		int[] newcost = new int[len0];

		// initial cost of skipping prefix in String s0
		for (int i = 0; i < len0; i++) cost[i] = i;

		// dynamically computing the array of distances

		// transformation cost for each letter in s1
		for (int j = 1; j < len1; j++) {
			// initial cost of skipping prefix in String s1
			newcost[0] = j;

			// transformation cost for each letter in s0
			for (int i = 1; i < len0; i++) {
				// matching current letters in both strings
				int match = (lhs.charAt(i - 1) == rhs.charAt(j - 1)) ? 0 : 1;

				// computing cost for each transformation
				int cost_replace = cost[i - 1] + match;
				int cost_insert = cost[i] + 1;
				int cost_delete = newcost[i - 1] + 1;

				// keep minimum cost
				newcost[i] = Math.min(Math.min(cost_insert, cost_delete), cost_replace);
			}

			// swap cost/newcost arrays
			int[] swap = cost;
			cost = newcost;
			newcost = swap;
		}

		// the distance is the cost for transforming all letters in both strings
		return cost[len0 - 1];
	}
}
