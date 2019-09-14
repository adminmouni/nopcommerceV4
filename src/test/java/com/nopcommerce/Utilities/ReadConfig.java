package com.nopcommerce.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig 
{
	Properties pro;
	
	public ReadConfig()
	{
		File src = new File ("./Configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro =  new Properties();
			pro.load(fis);
		} 
		catch (FileNotFoundException e)
		{
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	public String getApplicationURL()
	{
		String url = pro.getProperty("baseurl");
		return url;
	}
	public String getUsername()
	{
		String Uname = pro.getProperty("Username");
		return Uname;
				
	}
	public String getPassword()
	{
		String Pwd = pro.getProperty("Password");
		return Pwd;
	}
	public String getChromepath()
	{
		String Chromepath = pro.getProperty("chromepath");
		return Chromepath;
	}
	public String getFirefoxpath()
	{
		String Firefoxpath = pro.getProperty("firefoxpath");
		return Firefoxpath;
	}
	public String getIEpath()
	{
		String Iepath = pro.getProperty("iepath");
		return Iepath;
	}

}
