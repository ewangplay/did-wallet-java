package com.gfacloud.did;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class FileSystemStore implements Store {

    static private final String fileExtension = ".id";

    private String path;

    public FileSystemStore(String path) {
        File f = new File(path);
        f.mkdirs();

        this.path = path;
    }

    @Override
    public boolean put(String label, String content) {
        boolean ret = false;
        OutputStream out = null;
        try {
            out = new FileOutputStream(getFilename(label));
            out.write(content.getBytes());
            ret = true;
        } catch (IOException e) {
            e.printStackTrace();
            ret = false;
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }

    @Override
    public String get(String label) {
        return readToString(getFilename(label));
    }

    @Override
    public ArrayList<String> list() {
        ArrayList<String> labels = new ArrayList<String>();

        File d = new File(this.path);
        if (d.isDirectory()) {
            String files[] = d.list();
            for (String f : files) {
                System.out.println("file: " + f);
                // Because the parameter of String.split is regular expression,
                // if dot(.) passed directly, it will match any char in the string,
                // so here must use Escape character.
                String[] strArray = f.split("\\.");
                if (strArray.length == 2) {
                    String filename = strArray[0];
                    String extension = "." + strArray[1];
                    System.out.println("filename: " + filename + ", ext: " + extension);
                    if (extension.equals(fileExtension)) {
                        labels.add(filename);
                    }
                }
            }
        }

        Collections.sort(labels);
        return labels;
    }

    @Override
    public boolean exists(String label) {
        File f = new File(getFilename(label));
        return f.exists();
    }

    @Override
    public boolean remove(String label) {
        File f = new File(getFilename(label));
        return f.delete();
    } 

    private static String readToString(String fileName) {  
        String encoding = "UTF-8";  
        File file = new File(fileName);  
        Long filelength = file.length();  
        byte[] filecontent = new byte[filelength.intValue()];  
        try {  
            FileInputStream in = new FileInputStream(file);  
            in.read(filecontent);  
            in.close();  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  

        try {  
            return new String(filecontent, encoding);  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
            return null;  
        }  
    }

    private String getFilename(String label) {
        return Paths.get(this.path, label).toString() + fileExtension;
    }

}
