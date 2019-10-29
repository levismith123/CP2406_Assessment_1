package model;

import java.io.FileWriter;
import java.io.IOException;

public class memory {

    public memory(String title) throws IOException {

        FileWriter csvWriter = new FileWriter(title);
    }
}
