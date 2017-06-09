
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.*;    
import java.awt.event.*;
import java.awt.Color;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.FlowLayout;
import java.awt.Font;

public class Home  {    
JFrame f; 
 JTextField trans1;
 JComboBox shop;
 String sk;
//final JComboBox shop1;f

Home(){    
    f=new JFrame("Sales Management System");  
    JTable table=new JTable();
    JScrollPane pane=new JScrollPane(table);
    pane.setBounds(0,180,600,200);
   
    
    
    //read values from properties
    Properties prop = new Properties();
	InputStream input = null;
try
{
	input = new FileInputStream("mydata.properties");

	prop.load(input);

		// get the property value and print it out
		//System.out.println(prop.getProperty("lux"));
		//System.out.println(prop.getProperty("en"));
	/*	String shop1=prop.getProperty("shopid1");
		String shop2=prop.getProperty("shopid2");
		String shop3=prop.getProperty("shopid3");
		String shop4=prop.getProperty("shopid4");
		String shop5=prop.getProperty("shopid5");*/
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
 
    String users[]={prop.getProperty("userid1"),prop.getProperty("userid2"),prop.getProperty("userid3"),prop.getProperty("userid4"),prop.getProperty("userid5")};
     shop=new JComboBox(shops); 
    //test
     
      sk=shop.getSelectedItem().toString();
    //shop1=new JComboBox(shops); 
    final JComboBox user=new JComboBox(users); 
    shop.setBounds(20,40,120,20);   
    user.setBounds(160,40,120,20);
    f.add(shop);
    f.add(user);
    
  //date and time
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    String date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
    JLabel d = new JLabel(date);
    d.setPreferredSize(new Dimension(20,20));
    d.setVisible(true);
    f.getContentPane().add(d);
    f.pack();
    f.setLocationRelativeTo(null);
    
    
    //label
    JLabel l1=new JLabel("Enter the TransationID:");
    l1.setBounds(10,50, 160, 90);
    f.add(l1);  
    
    
   
    //textfield1 for transactionid
    trans1 = new JTextField();
    f.add(trans1);
   trans1.setText(prop.getProperty("invoice")+"");
    trans1.setBounds(140,85, 160, 20);
    
    
    
    //label for itemtype
    JLabel l2=new JLabel("Item Type:");
    l2.setBounds(30,80, 90, 90);
    f.add(l2);
    //itemtype
    String itemids[]={prop.getProperty("item1"),prop.getProperty("item2"),prop.getProperty("item3"),prop.getProperty("item4"),prop.getProperty("item5"),prop.getProperty("item6")};
    final JComboBox item=new JComboBox(itemids);
    //final JList<String> jList1 = new JList<String>(itemids);
    item.setBounds(20,140,70,20); 
    f.add(item);
    
    //itemid
    JLabel l3=new JLabel("Item ID:");
    l3.setBounds(120,80, 90, 90);
    f.add(l3);
    
    //textfield2 for itemid
    JTextField tx2 = new JTextField(8);
    f.add(tx2);
    tx2.setText(prop.getProperty("itemid")+"");
    tx2.setBounds(120,140, 65, 20);
    
    //label for item description
    JLabel l4=new JLabel("Description:");
    l4.setBounds(200,80, 90, 90);
    f.add(l4);
    
  //textfield3 for itemdescription
    JTextField tx3 = new JTextField(18);
    f.add(tx3);
    tx3.setBounds(200,140, 80, 20);
    
    //label for quantity
    JLabel l5=new JLabel("Quantity:");
    l5.setBounds(300,80, 90, 90);
    f.add(l5);
    
  //textfield4 for quantity
    JTextField tx4 = new JTextField(5);
    f.add(tx4);
    tx4.setBounds(300,140, 50, 20);
    
    
  //label for unit price
    JLabel l6=new JLabel("Unit Price:");
    l6.setBounds(385,80, 90, 90);
    f.add(l6);
    
    
    
    
  //textfield5 for price
    JTextField tx5 = new JTextField(5);
    f.add(tx5);
    tx5.setBounds(385,140, 50, 20);
    
  //multiplication of quantity and price
   // int pric=Integer.valueOf(tx5.getText());
 /*  int quantity1=Integer.parseInt(tx5.getText());
    int price1=Integer.parseInt(tx4.getText());
    int mul1=price1*quantity1;
    
    String mul=String.valueOf(mul1);*/
    
  //label for total price
    JLabel l7=new JLabel("Total price:");
    l7.setBounds(450,80, 90, 90);
    f.add(l7);
    
  //textfield6 for total price
    JTextField tx6 = new JTextField(6);
   // tx6.setText(""+mul);
    f.add(tx6);
    tx6.setBounds(450,140, 50, 20);
    
    //button for inserting
    JButton ok1=new JButton("OK");
    ok1.setBounds(520,135, 70, 30);
    
    //Jbutton for Bill
    JButton ok2=new JButton("Bill");
    ok2.setBounds(500,400, 70, 30);
    
    //button for xml to excel
    JButton b1=new JButton("XML TO EXCEL");  
    b1.setBounds(250,500,150,30);
    
    //button for convert to xml
    JButton ok3=new JButton("TEXT TO XML");
    ok3.setBounds(100,500, 150, 30);
    
    //button for email
    JButton email = new JButton("SEND EMAIL"); 
    email.setBounds(450, 500, 150, 30);
   //email.setBounds(50,100,95,30);  
    f.add(email);
    
    //tabledefault
    Object[] columns={"ItemType:","ItemID:","Description:","Quantity:","UnitPrice:","TotalPrice:"};
    DefaultTableModel model=new DefaultTableModel();
    model.setColumnIdentifiers(columns);
    table.setModel(model);
    
    //font for table
    table.setBackground(Color.GRAY);
    table.setForeground(Color.CYAN);
    Font font=new Font("",1,22);
    table.setFont(font);
    table.setRowHeight(30);
    
    f.add(ok3);
    f.add(ok2);
    f.add(ok1);
    Object[] row=new Object[10];
    
    ok1.addActionListener(new ActionListener() 
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		//Object contents = jList1.getSelectedValue();
    		int quantity = Integer.parseInt(tx4.getText());
    		int up = Integer.parseInt(tx5.getText());
    		int result = quantity*up;
    		tx6.setText(Integer.toString(result));
    		Object obj=item.getSelectedItem();
    		row[0]=obj;
    		row[1]=tx2.getText();
    		row[2]=tx3.getText();
    		row[3]=tx4.getText();
    		row[4]=tx5.getText();
    		row[5]=tx6.getText();
    		
    		model.addRow(row);
    }
});
    
    //button for bill
    int k,l;
    ok2.addActionListener(new ActionListener() 
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		try{
    			File f1=new File("C:\\Users\\sathi\\workspace\\sales_mngt_system1\\src\\table_data.txt");
    			if(!f1.exists()){
    				f1.createNewFile();
    			}
    			File f2=new File("C:\\Users\\sathi\\workspace\\sales_mngt_system1\\src\\table_data2.txt");
    			if(!f2.exists()){
    				f2.createNewFile();
    			}
    			
    			FileWriter fw=new FileWriter(f1.getAbsoluteFile());
    			BufferedWriter bw=new BufferedWriter(fw);
    			FileWriter fw1=new FileWriter(f2.getAbsoluteFile());
    			BufferedWriter bw1=new BufferedWriter(fw1);
    			
    			
    			//user valuesS
    			for(int i=0;i<table.getRowCount();i++)
    			{
    				
    				//shop values
    			Object obj=shop.getSelectedItem();
    			String sh1=obj.toString();
				
				//validation for shop
				if((sh1.length())<=8)
						{
					int len=8-(sh1.length());
					for(int m=0;m<len;m++)
					  {
						 sh1 = sh1.concat("0"); 
					  }
    			bw.write(sh1);
    			bw1.write(sh1+" ");
						}
       			 
       			   //user values
    				Object obj1=user.getSelectedItem();
    				String sh2=obj1.toString();
    				
    				//validation for user
    				if((sh2.length())<=8)
    						{
    					int len=8-(sh2.length());
    					for(int m=0;m<len;m++)
    					  {
    						 sh2 = sh2.concat("0"); 
    					  }
        			bw.write(sh2);
        			bw1.write(sh2+" ");
    						}
    				
    				
        			//date
        			 bw.write(date);
        			 bw1.write(date+" ");
        			 //invoice or transaction
        			 String invo=trans1.getText();
        			 
        			//validation for transaction 
     				if((invo.length())<=8)
     						{
     					int len=8-(invo.length());
     					for(int m=0;m<len;m++)
     					  {
     						 invo = invo.concat("0"); 
     					  }
         			bw.write(invo);
         			bw1.write(invo+" ");
     						}
     				
     				
    				for(int j=0;j<table.getColumnCount();j++)
    				{
    					if(j<1)
    					{
    						for(int k=0;k<2;k++)
    						{
    					String s1=(String) table.getModel().getValueAt(i, k);
    					
    					bw.write(s1);
    					//bw1.write(s1+" ");
    						}
    						bw.write("\t");
    						//bw1.write("\t");
    					}
    				     
    					String s2=(String) table.getModel().getValueAt(i,j);
    					bw.write(s2);
    					bw1.write(s2+" ");
    					
    				}
    				bw1.write("\n");
    				bw.write("\n");
    				
    			
    			}
    			
    			bw.close();
    			bw1.close();
    			fw.close();
    			fw1.close();
    			JOptionPane.showMessageDialog(null,"Data Exported");
    		}
    		catch(Exception ex)
    		{
    			ex.printStackTrace();
    		}
    }
});
    
    ok3.addActionListener(new ActionListener() 
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		ToXML xmlcon=new ToXML();
    		xmlcon.begin();
    		
    }
});
    
    
    email.addActionListener(new ActionListener() 
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		sendEmailTo sm=new sendEmailTo();
    		sm.sendEmail();
    		
    }
});
    
    
    b1.addActionListener(new ActionListener() 
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		
    		WriteExcelDemo d1;
    		d1=new WriteExcelDemo();
    		d1.Excel();
    		
    		
    }
});
    
    
    //f.add(jList1);
    f.add(pane);
    f.add(b1);    
   f.setLayout(null);
    f.setSize(600,600);    
    f.setVisible(true);
}
/*public void send()
{
	String name;
	ToXML tx=new ToXML();
	tx.display();

}*/
public static void main(String[] args) {    
    new Home();   
   
} 
}