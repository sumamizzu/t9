package com.emanuelemicciulla.esercizi.t9;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Consumer;

public class TextResourceLinesStreamer {

	public void streamWords(String fileName, Consumer<? super String> callback) throws URISyntaxException, IOException {
		URI path = this.getClass().getResource( fileName ).toURI();
		Files.lines(Paths.get(path)).forEach(callback);
	}

}
