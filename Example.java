import  java.io.File;
import  java.io.FileInputStream;
import  java.io.FileNotFoundException;
import  java.io.IOException;

public class Main
{
    public static void main(String[] args)
    {   
        RFile   rf = new RFile();
        String  test;

        rf.setupShowAndCloseFile("./fichier.txt");
        test = rf.setupReadAndCloseFile("./RFile.java");
        System.out.println("\n\n\n======\n" + test);
    }   
}
