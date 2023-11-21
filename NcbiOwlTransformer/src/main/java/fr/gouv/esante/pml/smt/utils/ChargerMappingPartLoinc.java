package fr.gouv.esante.pml.smt.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ChargerMappingPartLoinc {
	
	 public static HashMap<String, Set<String>> listConcepts = new HashMap<String, Set<String>>();


	//public static void main(String[] args) throws IOException {
		
		public static  void convertFile(final String xlsFile) throws Exception {
		

		
		String csvFile = PropertiesUtil.getProperties("partLoincCsvFile");
		
		
		
		
	    // File file = new File("D:\\NCBI\\Livraison_ROUEN\\Livraison_ROUEN\\append.txt");
		//FileWriter fr = new FileWriter(file, true);
		//BufferedWriter br = new BufferedWriter(fr);
		//PrintWriter pr = new PrintWriter(br);
		
		BufferedReader csvReader = new BufferedReader(new InputStreamReader(new FileInputStream(csvFile),"UTF-8"));
	    String row = csvReader.readLine();
	    while ((row = csvReader.readLine()) != null) {
	    	
	    	row = row.replaceAll(", ","").replaceAll(",[1-9]", "").replaceAll(",[a-z]", "").
	    			//replace(",d", "")
	    			//.replace(",t", "")
	    			//.replace(",I", "")
	    			//.replace(",p", "").
	    			//replaceAll(",w", "").
	    			replaceAll("[1-9],", "").replaceAll("[A-Z],", "").replaceAll("[10-19],", "");
	    			
	    	String[] data = row.split(",");
	    	
	    	String key0 = data[0].replaceAll("\"", "");// code Loinc
	    	String key1 = data[2].replaceAll("\"", ""); // code Part
	    	
	    	//System.out.println(key0 + "****"+ key1);
	    	//pr.println(key0 + "****"+ key1);
	    	
	    	//System.out.println("key1 "+key1);
	    	//System.out.println("key0 "+key0);
	    	
	    	//List<String> listeCodeLoinc = new Set<>();
	    	//System.out.println("test1");
	    
	    	Set<String> listeCodeLoinc = new HashSet<String>();
	    			
	    	listeCodeLoinc = listConcepts.get(key1);
	    	
	    	
	    	

	        
	    	
	    try {
	    	if(listeCodeLoinc.size()==0) {
	    		
	    		//System.out.println("eeee");
	    		//System.out.println("test4");
	    		
	    		
	    	}else {
	    		//System.out.println("test5");
	    		//System.out.println(key0);
	    		//System.out.println(key1);
	    		//newList.add(key0);
	    		
	    		Set<String> newlist = new HashSet<String>();
	    		newlist.addAll(listConcepts.get(key1));
	    		newlist.add(key0);
	    		
	    		listConcepts.put(key1, newlist);
	    	}
	    	
	    }catch(NullPointerException e) {
	    	//System.out.println("test6");
	    	listConcepts.put(key1, new HashSet<>(Arrays.asList(key0)));
	    }
	    	
	    	
	    	//listConcepts.put(key1, Arrays.asList(key0));
	    	
	    	
	    	
	    	
	        
	    	 
	        
	        
	        
	       
	        
	    }
	 //   System.out.println( listConcepts.size());
	    csvReader.close();
	    //pr.close();
	    //br.close();
	    //fr.close();
	   
	  //System.out.println(listConcepts.get("\"22\"").);
	  
	 // Iterator<String> it = listConcepts.get("LP430721-3").iterator();
	  //while(it.hasNext()) {
	    //String value = it.next();
	    //System.out.println(value);   
	   //}
	  
	   
	   

	    
	}

}
