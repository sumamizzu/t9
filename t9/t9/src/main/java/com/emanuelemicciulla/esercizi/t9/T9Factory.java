package com.emanuelemicciulla.esercizi.t9;

import java.io.IOException;
import java.net.URISyntaxException;

public class T9Factory {

	public T9 getEngT9() throws Exception {
		T9Concrete t9 = new T9Concrete();
		TextResourceLinesStreamer textResourceLinesStreamer = new TextResourceLinesStreamer();
		try {
			textResourceLinesStreamer.streamWords("/dictionary.eng", t -> {
				if (t.matches("^[a-zA-Z]+$"))
					t9.addWord(t.toLowerCase());
				else
					System.err.println("ERROR - Invalid entry: " + t);
			});
		} catch (URISyntaxException | IOException e) {
			throw new Exception("Error loading dictionary", e);
		}
		System.out.println("T9 Lingua inglese pronto!");
		return t9;
	};

}
