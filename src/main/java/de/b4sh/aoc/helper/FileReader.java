package de.b4sh.aoc.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileReader {

    private final Logger log = Logger.getLogger(FileReader.class.getName());

    public List<String> readLinesOfFile(final File file){
        List<String> lines = new ArrayList<>();
        Charset charset = StandardCharsets.UTF_8;
        log.log(Level.INFO, String.format("Reading lines from: %s",file.getPath()));
        try (BufferedReader bufferedReader = Files.newBufferedReader(file.toPath(), charset)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException ex) {
            log.log(Level.WARNING, String.format("Exception: %s",ex.getCause()));
        }
        log.log(Level.INFO, "Done reading lines");
        return lines;
    }

}
