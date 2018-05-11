
package finder4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Checker {
    FileIO f = new FileIO();
    Email mail = new Email();
    public void readFile(ArrayList s, String fname, String finalSendString)
    {

        String input = ""; 
        int ch; 
        boolean newStuff = false;
        FileInputStream fs = null; 
        try { 
            fs = new FileInputStream(fname); 
            while ((ch = fs.read()) != -1)
                input += (char) ch; // cast byte to char

            //System.out.println(input); //prints the current saved id's
        }
        catch(FileNotFoundException e) 
        { 
            System.out.println("Error opening file\n"); 
        } 
        catch (IOException ie) 
        { 
            System.out.println("Error reading file\n"); 
        } 
        finally 
        { 
            try //we have to put a try around the close also 
            { 
                if(fs != null) 
                    fs.close(); // Close the file 
            } 
            catch(IOException ie) 
            { 
                System.out.println(ie.getMessage());   
            }
        }
        for (int i = 0; i < s.size(); i++)
        {
            if(!input.contains((String)s.get(i)))
            {
                newStuff = true;
            }
        } 
        if (newStuff)
        {
            f.FileIO(s, "savedDealID.txt");
            mail.sendEmail("Found Sale Item", finalSendString);
        }
        else
        {
            System.out.println("Nothing new on here");
        }
    }
}
