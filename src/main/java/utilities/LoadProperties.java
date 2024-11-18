package utilities;

import java.io.FileReader;
import java.util.Properties;

public class LoadProperties {
	public Properties load() {
		//Loading data from data.properties file
		Properties dataPropertyObject = new Properties();
		FileReader dataPropertyObjectFile = null;
		try {
			dataPropertyObjectFile =new FileReader("Data.properties");
			dataPropertyObject.load(dataPropertyObjectFile);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return dataPropertyObject;		
	}
}
