package de.b4sh.aoc.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    public List<String> readLinesOfFile(final File file){
        List<String> lines = new ArrayList<>();
        final BufferedReader reader;
        try {
            reader = new BufferedReader(new java.io.FileReader(file.getAbsolutePath()));
            String line = reader.readLine();
            while (line != null) {
                lines.add(reader.readLine());
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

}
