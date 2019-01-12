package com.mkyong;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import java.util.*;
public class WriteToFileExample1 {

	private static final String FILENAME = "C:\\Users\\varun\\OneDrive\\Documents\\Text Message Project\\filename.txt";

	public static void main(String[] args)throws IOException {

		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			String content = "This is the content to write into file\n";

			fw = new FileWriter(FILENAME);
			bw = new BufferedWriter(fw);
			
			   	Scanner scanner = new Scanner(new File("sms.txt"));
    	String telephone ="";
    	String response = "";
    	while(scanner.hasNextLine())
    	{
    		String line = scanner.nextLine();
			if(line.indexOf("BEGIN:VMSG")!=-1)
			{
				bw.write("");
				bw.newLine();
			}	
			else if(line.indexOf("TEL:")!=-1)
			{
				telephone = line.substring(line.indexOf("TEL:")+4);
			}
    		else if(line.indexOf("X-BOX:")!=-1)
    		{
    			response = line.substring(line.indexOf("X-BOX:")+6);
    			if(response.equals("INBOX"))
    			{
    				bw.write("From "+telephone+" to you");
    			}
    			else
    			{
    				bw.write("To "+telephone+" from you");
    			}
    			bw.newLine();
    		}
    		else if(line.indexOf("Date:")!=-1)
    		{
    			bw.write(line.substring(5));
    			bw.newLine();
    		}
    		
    		else if (line.indexOf("UTF-8:")!=-1)
    		{
    			line = line.substring(line.indexOf("UTF-8:")+6);
    			
    			while(line.charAt(line.length()-1)=='=')
    			{    			
    				line = line.substring(0,line.length()-1);
    				line += scanner.nextLine();
    					
    			}
    			bw.write(line);
    			bw.newLine();
    		}
    		else if (line.indexOf("END:VMSG")!=-1)
    		{
    			bw.write("");
    			bw.newLine();
    		}
    		
    	}
			
			
			bw.write(content);

			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}

	}

}