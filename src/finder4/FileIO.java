
package finder4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
//class that includes all of the file input output and calls the palindrome class
public class FileIO 
{
    //function that takes a .txt input file and .txt output file, reads the input into a queue,
    //plugs that queue into the palindrome function which returns a queue of the ones that 
    //are actually a palinedrome, and then writes it to the the output .txt file.
    public void FileIO(ArrayList strings, String output) 
    {
        //ArrayList strings = new ArrayList();
        FileOutputStream fs2 = null;
        try{
            fs2 = new FileOutputStream(output);
            for(int i = 0; i < strings.size();  i++) {
                String currentString = (String)strings.get(i);
                for(int b = 0; b < currentString.length();  b++)
                {
                    fs2.write(currentString.charAt(b));
                }
                fs2.write('\r');
                fs2.write('\n');
                System.out.println((String)strings.get(i)); // prints line by line the string inputs
           }
        }
        catch(IOException ie){
              System.out.println("Error reading file");
        }
        finally{
           try{   //put a try around the call to close the file also
              if(fs2 != null)
                 fs2.close(); // close the file
           }
           catch(IOException ie){
              System.out.println(ie.getMessage());  
           }
        }
    }

}
