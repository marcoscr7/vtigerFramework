package comcast.vtiger.genericUtility;
import java.io.FileInputStream;
import java.util.Properties;

public class Property_Utility 
{
	public String getPropertyKeyValue(String Key) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./data/CommonFile.properties");
		Properties p=new Properties();
		p.load(fis);
		String value=p.getProperty(Key);
		return value;
	
	}

}
