import java.io.*;
import java.io.FileWriter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class scrape {
    public static void main(String args[]) {
        try {
            FileWriter fw = new FileWriter("testout.txt");
            Document doc = Jsoup.connect("https://www.ets.org/gre/revised_general/prepare/analytical_writing/issue/pool").userAgent("Mozilla/17.0").get();
            Elements temp = doc.select("p");
            String block;

            int i=0;
            for(Element topic:temp) {
                i++;
                block = topic.getElementsByTag("p").first().text();
                fw.write(i + " -  " +  block + " \n");
            }
            fw.close();
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}
