
package finder4;

import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Finder4 
{

    public static void main(String[] args) throws Exception
    {
        Email mail = new Email();
        final Document document = Jsoup.connect("https://slickdeals.net/").get();
        ArrayList s = new ArrayList();
        FileIO f = new FileIO();
        Checker c = new Checker();
        int counter = 0;
        String itemName = "Charger";///************
            
            for (Element row : document.select("ul.dealTiles.gridDeals li"))
            {
                final String title = row.select(".itemTitle").text();
                Element link = row.select("a").last();
                String price = row.select(".itemPrice").text();
                final String secondPrice = row.select(".itemPrice div").text();
                String threadID = "";
                price = price.replace((" " + secondPrice), "");
                //System.out.println(title + " ||| " + price);
                try
                {
                threadID = link.attr("href");
                //System.out.println(threadID);
                }
                catch(Exception e)
                {
                    //System.out.println("Couldn't find link");
                }
                if (title.contains(itemName))
                {
                    boolean new1 = true;
                    for (int i = 0; i < s.size(); i++)
                    {
                        if (itemName == s.get(i))
                        {
                            new1 = false;
                        }                            
                    }
                    if(new1)
                    {
                        //<a href = "https://slickdeals.net\" + threadID>"https://slickdeals.net" + threadID</a>
                        //String finalCopy = ("<br />" + "<a href = " + "'https://slickdeals.net" + threadID + "'" + " target = \'_blank\'>" + "https://slickdeals.net" + threadID + "</a>");
                        String finalCopy = "https://slickdeals.net" + threadID;
                        s.add(finalCopy);
                        counter++;
                    }
                }
            }
            if (counter > 0)
            {
                String bigString = "";
                for (int i = 0; i < s.size(); i++)
                {
                    bigString = bigString + s.get(i) + "\r" + "\n";
                } 
                System.out.println("Found " + counter + " deals on " + itemName + " on slickdeals!");
                System.out.println(bigString);
                String finalSendString = "Found " + counter + " deals on " + itemName + " on slickdeals!" + "\r" + "\n" + bigString;
                //mail.sendEmail("Found Sale Item", finalSendString);
                //f.FileIO(s, "savedDealID.txt");
                c.readFile(s, "savedDealID.txt", finalSendString);
                
            }
            else
            {
                System.out.println("No deals on " + itemName + " found.");
            }
            
    }
    
}
