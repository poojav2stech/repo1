package Group1.Groupcsv;
import java.util.*;

import com.opencsv.CSVReader;
import com.opencsv.bean.*;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;



import java.io.*;

public class DentistManagementSystem {


	public static void main(String[] args)throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException, IOException
	{

ArrayList<Patients> a=new ArrayList();
		Scanner sc = new Scanner(System.in);
		System.out.print("DENTAL MANAGEMENT SYSTEM \n");
		int ch;
		String fileName = "src/main/resources/eventsadd.csv";
		String fileName1 = "src/main/resources/eventsadd1.csv";
		do {
			
			System.out.println("\n\n1.read patient data in to list from file \n" + "2.display all the patient id and names from list\n" + "3.Delete for patient details from list based on appointment number\n"
					+ "4.Display all appointments of the entered date\n" + "5.update appointment based on date and display in csv file\n" + "0.Exit");
			System.out.println("enter choice");
            ch=sc.nextInt();
			switch(ch)
			{
			case 1:
					

					 try {
						 
							
					        FileReader filereader = new FileReader(fileName);
					 
					        CSVReader csvReader = new CSVReader(filereader);
					       
					   String[] nextRecord;
					while ((nextRecord = ( csvReader.readNext())) != null) 
					{
						Patients p=new Patients(nextRecord[0],nextRecord[1],nextRecord[2],nextRecord[3]);
						a.add(p);
		
						 
					         
					        }
					 }
					    
					    catch (Exception e) {
					        e.printStackTrace();
					    }
				
					 
				 System.out.println("data read from file successfully");
				
				
			break;
			
			
			
			case 2:
			
				System.out.println("list all the appointment");
				for(Patients p:a)
				{
					System.out.println("id="+p.getPid()+" "+"name="+p.getName()+" "+"address="+p.getAddress()+" "+"date="+p.getDate());
				}
			
				break;
			case 3:
				System.out.println("enter appointment number  of the patient of which the appointment is to be deleted ");
				String appno=sc.next();
				try
				{
				
				
				for(Patients p:a)
				{
					if(appno.equals(p.getPid()))
					{
						System.out.println(p.getPid());
						a.remove(p);
					}
				

				}
				}
				catch(Exception e)
				{
					System.out.println(" Record removed successfully");
					
				}
				
				
				System.out.println("list of remaining record appointment after deletion of particular record \n");
				for(Patients p:a)
				{
					System.out.println("id="+p.getPid()+" "+"name="+p.getName()+" "+"address="+p.getAddress()+" "+"date="+p.getDate());
				}
			
				
			
				break;
			case 4:
				System.out.println("enter date on which the appointment details is to be displayed\n");
				String searchdate=sc.next();
				System.out.println("list of patients which have taken appointment on given date\n");
				for(Patients p:a)
				{
					if(searchdate.equals(p.getDate()))
					{
						
						System.out.println("id="+p.getPid()+" "+"name="+p.getName()+" "+"address="+p.getAddress()+" "+"date="+p.getDate());
					}
					
				}
				
				break;
			case 5:
				System.out.println("enter the appointment number of which the date of appointment is to be changed");
				String newid=sc.next();
				System.out.println("enter the updated date");
				String date=sc.next();
				for(Patients p:a)
				{
					if(newid.equals(p.getPid()))
					{
					p.setDate(date);
					
					
					try
					{
					
					
					 FileWriter writer = new FileWriter(fileName1);
						ColumnPositionMappingStrategy mappingStrategy= new ColumnPositionMappingStrategy();
			            mappingStrategy.setType(Patients.class);
			            String[] columns = new String[] { "pid","name","address","date"};
						mappingStrategy.setColumnMapping(columns);
						StatefulBeanToCsvBuilder<Patients> builder = new StatefulBeanToCsvBuilder(writer);
						StatefulBeanToCsv<Patients> beanWriter = builder.withMappingStrategy(mappingStrategy).build();
						beanWriter.write(a);
						System.out.println("data saved in csv file successfully");
						writer.close();
						
					
				}
					catch(Exception e)
					{
						System.out.println("data not saved");
					}
				}
					
					
				}
				
				break;
				
			case 0:

				System.exit(ch);
				break; 
				

				default:
					System.out.println("invalid choice");
				
			}


		} while (ch>0);
		System.out.println(" \n EXITED FROM DENTAL MANAGEMENT SYSTEM \n");
		
	}
		}


