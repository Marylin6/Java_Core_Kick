package com.javacore.infohandler.util;

import com.javacore.infohandler.exception.TextParseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReaderUtil {

    private static final Logger logger =
            LogManager.getLogger(FileReaderUtil.class);

    public static String readFile(String path)
            throws TextParseException {

        try {
            logger.info("Reading file: {}", path);
            return Files.readString(Path.of(path));

        } catch (IOException e) {
            logger.error("File reading failed", e);

            throw new TextParseException("Cannot read file", e, null, path);
        }
    }
}
