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
	 *
	 * @param array array to convert. Each inner array must contain 2 elements
	 *              (if less, an ArrayIndexOutOfBoundsException is thrown,
	 *              if more, extra elements are ignored).
	 * @return new map containing the same key-value pairs as given array
	 */
	@SuppressWarnings("unchecked")
	public static <K, V> Map<K, V> toMap(Object array[][]) {
		Map<K, V> retval = new HashMap<>();
		for (Object pair[] : array) {
			K key = (K) pair[0];
			V value = (V) pair[1];
			retval.put(key, value);
		}
		return retval;
	}

	/**
	 * Constructs map from given array.
	 * The iterator of the map preserves ordering of elements in array.
	 *
	 * @param array array to convert. Each inner array must contain 2 elements
	 *              (if less, an ArrayIndexOutOfBoundsException is thrown,
	 *              if more, extra elements are ignored).
	 * @return new map (LinkedHashMap implementation)
	 * containing the same key-value pairs as given array
	 */
	@SuppressWarnings("unchecked")
	public static <K, V> Map<K, V> toOrderedMap(Object array[][]) {
		Map<K, V> retval = new LinkedHashMap<>();
		for (Object pair[] : array) {
			K key = (K) pair[0];
			V value = (V) pair[1];
			retval.put(key, value);
		}
		return retval;
	}


	public static String exceptionToString(Throwable e) {
		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw));
		return sw.getBuffer().toString();
	}

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


	//*******************************************************************************************/
	//*** detekce znaku **** http://www.ascii.cl/htmlcodes.htm **********************************/
	//*******************************************************************************************/

	/**
	 * mezera/space
	 */
	static boolean isSpace(char ch) {
		return ch == 32;
	}

	/**
	 * ! vykricnik ASCII 33
	 */
	private static boolean isExclamationPoint(char ch) {
		return ch == 33;
	}

	/**
	 * "
	 */
	static boolean isDoubleQuote(char ch) {
		return ch == 34;
	}

	/**
	 * #
	 */
	@SuppressWarnings("unused")
	public boolean isNumberSign(char ch) {
		return ch == 35;
	}

	@SuppressWarnings("unused")
	public boolean isDollarSign(char ch) {
		return ch == 36;
	}

	@SuppressWarnings("unused")
	public boolean isPercentSign(char ch) {
		return ch == 37;
	}

	@SuppressWarnings("unused")
	public boolean isAmpersand(char ch) {
		return ch == 38;
	}

	/**
	 * (
	 */
	private static boolean isOpeningParenthesis(char ch) {
		return ch == 40;
	}

	/**
	 * )
	 */
	private static boolean isClosingParenthesis(char ch) {
		return ch == 41;
	}

	private static boolean isAsterisk(char ch) {
		return ch == 42;
	}

	private static boolean isPlusSign(char ch) {
		return ch == 43;
	}

	/**
	 * ,
	 */
	private static boolean isComma(char ch) {
		return ch == 44;
	}

	/**
	 * Character - (minus, hyphen, spojovnik) (ASCII: 45)
	 */
	static boolean isHyphen(char ch) {
		return ch == 45;
	}

	/**
	 * Character . (dot, period, full stop, tecka) (ASCII: 46)
	 */
	static boolean isDot(char ch) {
		return ch == 46;
	}

	private static boolean isSlash(char ch) {
		return ch == 47;
	}

	/**
	 * Digits 0 to 9 (ASCII: 48-57)
	 */
	static boolean isNumber(char ch) {
		return ch >= 48 && ch <= 57;
	}

	private static boolean isColon(char ch) {
		return ch == 58;
	}

	private static boolean isSemicolon(char ch) {
		return ch == 59;
	}

	private static boolean isLessThanSign(char ch) {
		return ch == 60;
	}

	private static boolean isEqualSign(char ch) {
		return ch == 61;
	}

	private static boolean isGreaterThanSign(char ch) {
		return ch == 62;
	}

	private static boolean isQuestionMark(char ch) {
		return ch == 63;
	}

	static boolean isAt(char ch) {
		return ch == 64;
	}

	/**
	 * (a-z) (ASCII: 65-90)
	 */
	private static boolean isAsciiLowerCaseDigit(char ch) {
		return ch >= 65 && ch <= 90;
	}

	private static boolean isOpeningBracket(char ch) {
		return ch == 91;
	}

	static boolean isBackSlash(char ch) {
		return ch == 92;
	}

	private static boolean isClosingBracket(char ch) {
		return ch == 93;
	}

	/**
	 * (A-Z) (ASCII: 97-122)
	 */
	private static boolean isAsciiUpperCaseDigit(char ch) {
		return ch >= 97 && ch <= 122;
	}

	@SuppressWarnings("unused")
	public boolean isDomainAllowedCharacter(char ch) {
		return isAsciiDigit(ch) || isNumber(ch) || isDot(ch) || isHyphen(ch);
	}

	/**
	 * (a–z, A–Z) (ASCII: 65-90, 97-122)
	 */
	static boolean isAsciiDigit(char ch) {
		return isAsciiLowerCaseDigit(ch) || isAsciiUpperCaseDigit(ch);
	}


	/**
	 * Characters !#$%&'*+-/=?^_`{|}~ (ASCII: 33, 35-39, 42, 43, 45, 47, 61, 63, 94-96, 123-126)
	 */
	static boolean isNameSpecialCharacter(char ch) {
		return isHyphen(ch)//'-'
				|| isExclamationPoint(ch)//'!'
				|| (ch >= 35 && ch <= 39)//#$%&' 35-39
				|| isAsterisk(ch)//'*'
				|| isPlusSign(ch)//'+'
				|| isSlash(ch)//'/'
				|| isEqualSign(ch)//'='
				|| isQuestionMark(ch)//'?'
				|| (ch >= 94 && ch <= 96)//^_` 94-96
				|| (ch >= 123 && ch <= 126);//{|}~ 123-126
	}

	/**
	 * space and "(),:;<>@[\]  (ASCII: 34, 40-41, 44, 58-59, 60, 62, 64, 91-93)
	 */
	static boolean isNameQuotedSpecialCharacter(char ch) {
		return isSpace(ch)
				|| isOpeningParenthesis(ch)
				|| isClosingParenthesis(ch)
				|| isComma(ch)
				|| isColon(ch)
				|| isSemicolon(ch)
				|| isLessThanSign(ch)
				|| isGreaterThanSign(ch)
				|| isAt(ch)
				|| isOpeningBracket(ch)
				|| isBackSlash(ch)
				|| isClosingBracket(ch);
	}

}
