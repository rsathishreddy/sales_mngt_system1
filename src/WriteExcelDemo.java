import java.io.FileOutputStream;
import java.io.IOException;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
/**
 * A very simple program that writes some data to an Excel file
 * using the Apache POI library.
 * @author www.codejava.net
 *
 */
public class WriteExcelDemo {
	
    public void Excel()
    {
    	
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sales Management System");
         
        String id1[]=new String[10];
        String user[]=new String[10];
        String date[]=new String[20];
        String transaction[]=new String[10];
        String itemtype[]=new String[10];
        String itemid[]=new String[10];
        String description[]=new String[10];
        String quantity[]=new String[10];
        String price[]=new String[10];
        String totalprice[]=new String[10];
        //code to read xml
        try {

        	File fXmlFile = new File("D:\\Data1.xml");
        	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        	Document doc = dBuilder.parse(fXmlFile);

        	//optional, but recommended
        	//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
        	doc.getDocumentElement().normalize();

        	System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

        	NodeList nList = doc.getElementsByTagName("shop");

        	System.out.println("----------------------------");

        	for (int temp = 0; temp < nList.getLength(); temp++) {

        		Node nNode = nList.item(temp);

        		System.out.println("\nCurrent Element :" + nNode.getNodeName());

        		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

        		     Element eElement = (Element) nNode;
        		     //dfs
        		     
        		     id1[temp]=eElement.getAttribute("id");
        		     
                     user[temp]=eElement.getElementsByTagName("user").item(0).getTextContent();
                    date[temp] =eElement.getElementsByTagName("date").item(0).getTextContent();
                     transaction[temp]=eElement.getElementsByTagName("transaction").item(0).getTextContent();
                     itemtype[temp]=eElement.getElementsByTagName("itemtype").item(0).getTextContent();
                     itemid[temp]=eElement.getElementsByTagName("itemid").item(0).getTextContent();
                     description[temp]=eElement.getElementsByTagName("description").item(0).getTextContent();
                     quantity[temp]=eElement.getElementsByTagName("quantity").item(0).getTextContent();
                     price[temp]=eElement.getElementsByTagName("price").item(0).getTextContent();
                     totalprice[temp]=eElement.getElementsByTagName("totalprice").item(0).getTextContent();
                   /*  
        			System.out.println("firstname : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
        			System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
        			System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
        			System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());
        			*/
        			
        		}//if
        	}
        	
        	
        			
        			   Object[][] saleData = {
        					    {id1[0], user[0], date[0],transaction[0],itemtype[0],itemid[0],description[0],quantity[0],price[0],totalprice[0]},
        		                {id1[1], user[1], date[1],transaction[1],itemtype[1],itemid[1],description[1],quantity[1],price[1],totalprice[1]},
        		                {id1[2], user[2], date[2],transaction[2],itemtype[2],itemid[2],description[2],quantity[2],price[2],totalprice[2]},
        		                {id1[3], user[3], date[3],transaction[3],itemtype[3],itemid[3],description[3],quantity[3],price[3],totalprice[3]},
        		                {id1[4], user[4], date[4],transaction[4],itemtype[4],itemid[4],description[4],quantity[4],price[4],totalprice[4]},
        		                {id1[5], user[5], date[5],transaction[5],itemtype[5],itemid[5],description[5],quantity[5],price[5],totalprice[5]},
        		                
        		        };
        	 	 
        		        int rowCount = 0;
        		         
        		        for (Object[] sale : saleData) {
        		            Row row = sheet.createRow(++rowCount);
        		             
        		            int columnCount = 0;
        		             
        		            for (Object field : sale) {
        		                Cell cell = row.createCell(++columnCount);
        		                if (field instanceof String) {
        		                    cell.setCellValue((String) field);
        		                } else if (field instanceof Integer) {
        		                    cell.setCellValue((Integer) field);
        		                }
        		               /* try (FileOutputStream outputStream = new FileOutputStream("D:\\howtodoinjava_demo.xlsx")) {
                		            workbook.write(outputStream);
                		        }catch (Exception e){
                		        	e.printStackTrace();
                		        }*/
        		            }
        		            
        		             
        		        }
        	
        		         
        		       try (FileOutputStream outputStream = new FileOutputStream("C:\\Users\\sathi\\workspace\\sales_mngt_system1\\src\\howtodoinjava_demo.xlsx")) {
        		            workbook.write(outputStream);
        		        }catch (Exception e){
        		        	e.printStackTrace();
        		        }

        		//}//if
        	//}//loop
            } catch (Exception e) {
        	e.printStackTrace();
            }
        
    }
	
    public static void main(String[] args) throws IOException {
    	
        
    	WriteExcelDemo we=new WriteExcelDemo();
    }
 
}