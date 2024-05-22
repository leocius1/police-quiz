package org.example;
import org.example.models.Suspect;
import org.example.services.*;

import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    private static final CrawlAndScraper crawlAndScraper = new CrawlAndScraperImpl();


    public static void main(String[] args) {
        List<Suspect> suspects = new ArrayList<>();
        List<String> crimes = new ArrayList<>();
        crawlAndScraper.crawlAndScrape(suspects, crimes);
        for (String c : crimes) {
            System.out.println(c + "\n");
        }



//
//        try {
//            Document document = Jsoup.connect("https://www.police.hu/hu/koral/elfogatoparancs-alapjan-korozott-szemelyek").get();
//            Elements testElements = document.select("div");
//            List<Element> listOfElements = new ArrayList<>();
//
//            for (Element elem : testElements) {
//                if (elem.hasClass("overlay")) {
//                    listOfElements.add(elem);
//                }
//            }
//
//            List<String> listOfLinks = new ArrayList<>();
//
//            for (Element elem : listOfElements) {
//                listOfLinks.add(elem.select("a[href]").first().attr("href"));
//            }
//
//            List<Document> documents = new ArrayList<>();
//
//            for (String link : listOfLinks) {
//                documents.add(Jsoup.connect(link).get());
//            }
//
//
////
//        } catch (IOException e) {
//            throw new RuntimeException(e.getMessage());
//        }

    }

}