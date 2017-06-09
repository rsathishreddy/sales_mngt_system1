
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class SetPropertyFile {
  public static void main(String[] args) {

	Properties prop = new Properties();
	OutputStream output = null;

	try {

		output = new FileOutputStream("mydata.properties");

		// set the properties values for shopid
		prop.setProperty("shopid1", "shp0001");
		prop.setProperty("shopid2", "shp0002");
		prop.setProperty("shopid3", "shp0003");
		prop.setProperty("shopid4", "shp0004");
		prop.setProperty("shopid5", "shp0005");
		
		//set the properties values for userid
		prop.setProperty("userid1", "user0001");
	    prop.setProperty("userid2", "user0002");
	    prop.setProperty("userid3", "user0003");
	    prop.setProperty("userid4", "user0004");
	    prop.setProperty("userid5", "user0005");
	    
	    //set property value for Transactionid
	    prop.setProperty("invoice", "INV");
	    
	  //set property value for Transactionid
	    prop.setProperty("itemid", "ID");
	    
	    //set property value for typeid
	    prop.setProperty("item1", "ACC");
	    prop.setProperty("item2", "FRN");
	    prop.setProperty("item3", "HRW");
	    prop.setProperty("item4", "PTI");
	    prop.setProperty("item5", "FDI");
	    prop.setProperty("item6", "ELE");
	    
	    
	    //for xml
	    

		// save properties to project root folder
		prop.store(output, null);
		

	} catch (IOException io) {
		io.printStackTrace();
	} finally {
		if (output != null) {
			try {
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
  }
}