package ru.nik;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger {
    private String filename;
    private String data;
    private File file;
    public FileEventLogger(String name)
    {
        this.filename=name;
    }
    public  void init() throws IOException
    {
        this.file = new File(filename);
        file.canWrite();
        System.out.println("It Works!");
    }

    public void logEvent(String data)
    {
        this.file = new File(filename);
        FileUtils fileUtils = new FileUtils();

        try
        {
            fileUtils.writeStringToFile(file, data);
        }
        catch(IOException ex){

            System.out.println("Error");
        }
    }

}
