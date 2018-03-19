import      java.io.FileInputStream;
import      java.io.FileNotFoundException;
import      java.io.IOException;
import      java.io.Exception;
import      java.io.File;

public class    RFile
{
    protected String                m_strFile;
    protected FileInputStream       m_fis;
    protected byte[]                m_buf;
    protected boolean               m_isSet;

    public      RFile()
    {   
        this.m_strFile = new String("");
        this.m_fis = null;
        this.m_buf = new byte[8];
        this.m_isSet = false;
    }   

    public      RFile(String p_strFile)
    {   
        this();
        this.m_strFile = new String("p_strFile");
    }   

    public boolean  setupShowAndCloseFile(String p_strFile)
    {   
        this.setupFile(p_strFile);
        this.showFile();
        this.closeFile();

        return (this.m_isSet);
    }   

    public String   setupReadAndCloseFile(String p_strFile)
    {   
        String  ret;

        this.setupFile(p_strFile);
        ret = this.readFile();
        this.closeFile();

        return (ret);
    }   

    public void     showFile()
    {   
        this.parseFile(true);
    }

    public String   readFile()
    {
        String ret;

        ret = this.parseFile(false);
        return (ret);
    }

    public boolean  setupFile(String p_strFile)
    {
        this.setStrFile(p_strFile);
        return (this.setupFile());
    }

    public boolean  setupFile()
    {
        try
        {
            m_fis = new FileInputStream(new File(this.m_strFile));
            this.m_isSet = true;
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Method Information: File Not Found.");
        }

        return (this.m_isSet);
    }

    private String  parseFile(boolean p_show)
    {
        String  ret = new String("");

        if (!(this.m_isSet))
        {
            try
            {
                while ((this.m_fis.read(m_buf)) >= 0)
                {
                    for (byte c : m_buf)
                    {
                        if (p_show)
                            System.out.print((char)(c));

                        else
                            ret += ((char)(c));
                    }

                    m_buf = new byte[8];
                }
            }
            catch (IOException e)
            {
                System.out.println("Method Information: IOException while fis.read()");
            }
        }
        else
        {
            System.out.println("File not Setup().");
        }

        return (ret);
    }

    public boolean closeFile()
    {
        boolean     ret;

        ret = false;
        if (this.m_isSet)
        {
            try
            {
                if (m_fis != null)
                {
                    m_fis.close();
                    ret = true;
                }
            }
            catch (IOException e)
            {
                System.out.println("Method Information: IOException while fis.close().");
            }
        }

        return (ret);
    }

    public String   getStrFile()
    {
        return (this.m_strFile);
    }

    public void     setStrFile(String p_strFile)
    {
        this.m_strFile = p_strFile;
        this.m_isSet = false;
    }

    public boolean  isOk()
    {
        return (m_isSet);
    }
}
