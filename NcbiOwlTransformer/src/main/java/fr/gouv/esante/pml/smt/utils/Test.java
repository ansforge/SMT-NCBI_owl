package fr.gouv.esante.pml.smt.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test {

	public static void main(String[] args) throws IOException {
		
		
		
		
		FileInputStream file = new FileInputStream(new File("D:\\\\cladimed\\\\Cladimed_v15_Adherents.xlsx"));
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		XSSFSheet sheet = workbook.getSheetAt(3);
		
		Iterator<Row> rowIterator = sheet.iterator();
		
		rowIterator.next();
		 List<String> listeRef= new ArrayList<>();
		
		 while (rowIterator.hasNext()) {
	    	 
	    	 Row row = rowIterator.next();
	    	 Cell c2 = row.getCell(5); //get Ref Code
		     //Cell c3 = row.getCell(6); // get Libelle
		     
		      //Calcul Ref Parent
		      
		       
		       //String codeParent = getCodeParent(c2.getStringCellValue());
		     
				
				//List<String> listeRef= new ArrayList<>();
				//listeRef.add(codeParent);
				//listeRef.add(c3.getStringCellValue());
				
				//listConcepts.put(c2.getStringCellValue(), listeRef);
	    	 
	    	 
	    	 listeRef.add(c2.getStringCellValue());
				
	   }
		 
		 for(int i=0; i<listeRef.size();i++) {
			 System.out.println("*** "+listeRef.get(i));
			 
		 }

		 file.close();

	}

}
