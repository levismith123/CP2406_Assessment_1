package model;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class memory {

    private FileWriter csvWriter;
    private FileReader csvReader;
    private String fileName;
    File folder = new File("CP2406_Assessment_1/maps");

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void memoryWrite(String message, String fileName) throws IOException{

        this.fileName = fileName;
        csvWriter = new FileWriter(this.fileName);
        csvWriter.write(message);
        csvWriter.flush();
        csvWriter.close();
    }

    public void memoryRead(String fileName) throws IOException{

        this.fileName = fileName;
        csvReader = new FileReader(this.fileName);
        char[] line = new char[50];
        csvReader.read(line);
        System.out.println(line);

    }

    public static void main(String[] args) throws IOException {
        memory example = new memory();
        example.setFileName("maps/example.txt");
        example.memoryWrite("test\ntest", example.getFileName());
        example.memoryRead(example.fileName);
    }
}
