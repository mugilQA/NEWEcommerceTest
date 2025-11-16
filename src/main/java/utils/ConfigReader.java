package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	Properties prop;
	
	public ConfigReader() {
		prop = new Properties();
	
	try {
		FileInputStream fs=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\config.properties");
		prop.load(fs);
	}catch(IOException e)
	{
		e.printStackTrace();
	}
	}
	public String getProperty(String key) {
		return prop.getProperty(key);
	}
}
