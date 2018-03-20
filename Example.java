
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
