/**
 * @(#)Main1.java
 *
 *
 * @author 
 * @version 1.00 2016/10/21
 */
import java.io.*;
import java.util.*;
public class Main0 {
        
    /**
     * Creates a new instance of <code>Main1</code>.
     */
    public Main0() {
    }
    
	
        public static void main(String args[]) throws IOException {
    	Scanner scanner = new Scanner(new File("sms.txt"));
    	String telephone ="";
    	String response = "";
    	while(scanner.hasNextLine())
    	{
    		String line = scanner.nextLine();
			if(line.indexOf("BEGIN:VMSG")!=-1)
			{
				System.out.println();
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
    				System.out.println("From "+telephone+" to you");
    			}
    			else
    			{
    				System.out.println("To "+telephone+" from you");
    			}
    		}
    		else if(line.indexOf("Date:")!=-1)
    		{
    			System.out.println(line.substring(5));
    		}
    		
    		else if (line.indexOf("UTF-8:")!=-1)
    		{
    			line = line.substring(line.indexOf("UTF-8:")+6);
    			
    			while(line.charAt(line.length()-1)=='=')
    			{    			
    				line = line.substring(0,line.length()-1);
    				line += scanner.nextLine();
    					
    			}
    			System.out.println(line);
    		}
    		else if (line.indexOf("END:VMSG")!=-1)
    		{
    			System.out.println();
    		}
    		
    	}
         }
    
   	
   	/*
   	    public static void main(String args[]) throws IOException {
    	Scanner scanner = new Scanner(new File("dryrun.dat"));
    	int num = scanner.nextInt(); scanner.nextLine();
    	for(int n = 0; n<num;n++)
    	{
    		String line = scanner.nextLine();
    		Problem0 bob = new Problem0(line);
    	}
    
    }
    */ 
}
