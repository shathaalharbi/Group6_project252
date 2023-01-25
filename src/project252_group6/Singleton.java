package project252_group6;

// Singleton Design Pattern

import java.io.File;

public class Singleton { 
    
    private static Singleton DBfile = null;
    private File DB;
    
    private Singleton(String fileName) {
        this.DB = new File(fileName);
    }

    public static Singleton getInstance(String fileName) {
        if (DBfile == null) 
            DBfile = new Singleton(fileName);
        return DBfile;
    }

    public File getDBfile(){
        return this.DB;
    }
    
    
}
