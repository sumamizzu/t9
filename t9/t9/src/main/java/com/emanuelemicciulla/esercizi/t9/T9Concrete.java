package com.emanuelemicciulla.esercizi.t9;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class T9Concrete implements T9 {

	private Map<String, Set<String>> dictionary = new HashMap<String, Set<String>>();

	private static Map<Character, String> numberEncodedCharacters = new HashMap<Character, String>();
	static {
		numberEncodedCharacters.put('a', "2");
		numberEncodedCharacters.put('b', "2");
		numberEncodedCharacters.put('c', "2");
		numberEncodedCharacters.put('d', "3");
		numberEncodedCharacters.put('e', "3");
		numberEncodedCharacters.put('f', "3");
		numberEncodedCharacters.put('g', "4");
		numberEncodedCharacters.put('h', "4");
		numberEncodedCharacters.put('i', "4");
		numberEncodedCharacters.put('j', "5");
		numberEncodedCharacters.put('k', "5");
		numberEncodedCharacters.put('l', "5");
		numberEncodedCharacters.put('m', "6");
		numberEncodedCharacters.put('n', "6");
		numberEncodedCharacters.put('o', "6");
		numberEncodedCharacters.put('p', "7");
		numberEncodedCharacters.put('q', "7");
		numberEncodedCharacters.put('r', "7");
		numberEncodedCharacters.put('s', "7");
		numberEncodedCharacters.put('t', "8");
		numberEncodedCharacters.put('u', "8");
		numberEncodedCharacters.put('v', "8");
		numberEncodedCharacters.put('w', "9");
		numberEncodedCharacters.put('x', "9");
		numberEncodedCharacters.put('y', "9");
		numberEncodedCharacters.put('z', "9");
	}

	void addWord(String word) {
		String code = encode(word.toLowerCase());
		if (!dictionary.containsKey(code)) {
			dictionary.put(code, new HashSet<String>());
		}
		dictionary.get(code).add(word);
	}

	/* (non-Javadoc)
	 * @see com.emanuelemicciulla.esercizi.t9.T9#encode(java.lang.String)
	 */
	@Override
	public String encode(String word) {

		return word.chars()
				.mapToObj(c -> numberEncodedCharacters.get((char)c))
					//.reduce("",String::concat);
					.collect(StringBuilder::new,StringBuilder::append,StringBuilder::append).toString();
	}

	/* (non-Javadoc)
	 * @see com.emanuelemicciulla.esercizi.t9.T9#decode(java.lang.String)
	 */
	@Override
	public Set<String> decode(String code) {
		Set<String> set = dictionary.get(code);
		return set == null ? Collections.emptySet() : set;
	}

}
