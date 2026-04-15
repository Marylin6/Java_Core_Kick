package main.java.com.javacore.arrays.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ArrayFileReader {

    public List<String> readLines(String path) throws IOException {
        return Files.readAllLines(Path.of(path));
    }
}
