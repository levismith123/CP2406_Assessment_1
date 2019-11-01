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

    public void memoryWrite(String fileName, int start, int end, Road road) throws IOException{


        this.fileName = fileName;
        csvWriter = new FileWriter(this.fileName);
        String message = start + ", " + end + ", " + road.isVertical();
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
}
