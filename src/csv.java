
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.io.*;
import java.util.Date;
public class csv {
  public static void main(String args[]) throws Exception
  {

		FileReader f=new FileReader("C:\\Users\\sathi\\workspace\\sales_mngt_system1\\src\\myjdbc.properties");
 
		Properties prop=new Properties();
		prop.load(f);
  
  
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con  = DriverManager.getConnection(prop.getProperty("durl"),prop.getProperty("user"),prop.getProperty("password"));


		//PreparedStatement pst = con.prepareStatement("insert into Country(id, name) values(?,?)");
		PreparedStatement pst = con.prepareStatement(prop.getProperty("insert"));
	
		PreparedStatement pst1 = con.prepareStatement(prop.getProperty("retrieve"));
        String csvFile = "C:\\Users\\sathi\\workspace\\sales_mngt_system1\\src\\Data.csv";
        String line = "";
        String cvsSplitBy = ",";
        String shopid;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
        	
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] sales1 = line.split(cvsSplitBy);
			    String shopid1 = sales1[0];
				String userid1 = sales1[1];
				String date1 = sales1[2];
				String transactionid1 = sales1[3];
				String itemtype1=sales1[4];
				String itemid1=sales1[5];
				String itemdescription1=sales1[6];
				String unitprice1=sales1[7];
				String totalprice1=sales1[8];
				
                //System.out.println("Country [code= " + country[4] + " , name=" + country[5] + "]");
				pst.setString(1, shopid1);
				pst.setString(2, userid1);
				pst.setString(3, date1);
				pst.setString(4, transactionid1);
				pst.setString(5, itemtype1);
				pst.setString(6, itemid1);
				pst.setString(7, itemdescription1);
				pst.setString(8, unitprice1);
				pst.setString(9, totalprice1);

			     pst.executeUpdate();  // this executes the prepared statement and inserts the values

				System.out.println(userid1 + " Record is inserted");

				//pst.getResultSet();
				
				 
				
            }
           
            
        } catch (IOException e) {
            e.printStackTrace();
        }

				pst.close();
				con.close();
    }

}