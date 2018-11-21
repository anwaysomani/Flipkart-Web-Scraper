import java.io.*;
import java.io.FileWriter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class amazonscrape {
    public static void main(String args[]) {
        try {
            FileWriter fw = new FileWriter("amazontest.txt");
            Document doc = Jsoup.connect("https://www.amazon.in/Samsung-On5-Gold-16GB-Storage/product-reviews/B01FM7GGFI/ref=cm_cr_dp_d_show_all_top?ie=UTF8&reviewerType=all_reviews").userAgent("Mozilla/17.0").get();
            Elements temp = doc.select("a.a-link-normal");
            String block;

            int i=0;
            for(Element topic:temp) {
                i++;
                // block = topic.getElementsByTag("a").first().text();
                //block = topic.getElementsByTag("a-size-base review-text");//.text();
                fw.write(temp + " \n");
            }
            fw.close();
        }
        catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
