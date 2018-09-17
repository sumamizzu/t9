/**
 * 
 */
package com.emanuelemicciulla.esercizi.t9;

import java.util.Set;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * @author Emanuele
 *
 */
public class T9Test extends TestCase {

	@Test
	public void test() {
		T9Concrete t9 = new T9Concrete();
		t9.addWord("ciao");
		t9.addWord("tree");
		t9.addWord("used");
		Set<String> words = t9.decode("8733");
		assertFalse(words.contains("ciao"));
		assertTrue(words.contains("tree"));
		assertTrue(words.contains("used"));
	}

	@Test
	public void testFull() throws Exception {
		T9 engT9 = new T9Factory().getEngT9();
		engT9.decode("8733").forEach(System.out::println);
	}
}
