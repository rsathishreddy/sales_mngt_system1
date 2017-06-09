import java.io.*;
import java.util.Properties;

import org.xml.sax.*;

import javax.swing.JTextField;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.sax.*;

public class ToXML{

    BufferedReader in;
    StreamResult out;
    TransformerHandler th;
    //read textfield values from one class to another class
    // private Home h1;
    Home h1=new Home();
    public static void main(String args[]) {
       
    	new ToXML().begin();
    	
    	//h1.trans1.getText();
    	
    }
    String st=h1.trans1.getText();
//    Object obj=h1.shop.getSelectedItem();
    String shp=h1.sk;
    public void begin() {
        try {
            in = new BufferedReader(new FileReader("C:\\Users\\sathi\\workspace\\sales_mngt_system1\\src\\table_data2.txt"));
            out = new StreamResult("D:\\Data2.xml");
            
          // String st=h1.getTextFieldValue();
            System.out.println(st);
            System.out.println(shp);
           
            
            Properties prop = new Properties();
        	InputStream input = null;
        try
        {
        	input = new FileInputStream("mydata.properties");

        	prop.load(input);

        	} catch (IOException ex1) {
        		ex1.printStackTrace();
        	} finally {
        		if (input != null) {
        			try {
        				input.close();
        			} catch (IOException e) {
        				e.printStackTrace();
        			}
        		}
        	}
            
         
            
            String shops[]={prop.getProperty("shopid1"),prop.getProperty("shopid2"),prop.getProperty("shopid3"),prop.getProperty("shopid4"),prop.getProperty("shopid5")}; 
           //for(int i=0;i<shops.length;i++)
           //{
            
            String itemid[]={prop.getProperty("itemid"),prop.getProperty("shopid1"),prop.getProperty("shopid2")};
            
            openXml(shops[2]);
            
            String str;
            
          //  for(int i=0;i<3;i++)
            //{
            
            while ((str = in.readLine()) != null) {
            	String[] words=str.split("\\s");//splits the string based on whitespace  
            	//using java foreach loop to print elements of string array  
            	for(String sh:shops)
            	{
            	for(String w:words){  
            		System.out.println(w);
            		process(w,sh); 
            	} 
            	}
                
            }
            //}
           
            closeXml("sales");
          // }
           in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openXml(String k) throws ParserConfigurationException, TransformerConfigurationException, SAXException {

        SAXTransformerFactory tf = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
        th = tf.newTransformerHandler();

        // pretty XML output
        Transformer serializer = th.getTransformer();
        serializer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        serializer.setOutputProperty(OutputKeys.INDENT, "yes");
             
        th.setResult(out);
        th.startDocument();
        th.startElement(null, null, k, null);
    }

    public void process(String s,String id) throws SAXException {
        th.startElement(null, null, id, null);
        th.characters(s.toCharArray(), 0, s.length());
        th.endElement(null, null, id);

    }

    public void closeXml(String k) throws SAXException {
        th.endElement(null, null, k);
        th.endDocument();
    }
}