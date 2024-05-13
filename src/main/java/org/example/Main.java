package org.example;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        try {
            Document document = Jsoup.connect("https://www.police.hu/hu/koral/elfogatoparancs-alapjan-korozott-szemelyek").get();
            Elements testElements = document.select("div");
            List<Element> listOfElements = new ArrayList<>();

            for (Element elem : testElements) {
                if (elem.hasClass("overlay")) {
                    listOfElements.add(elem);
                }
            }

            List<String> listOfLinks = new ArrayList<>();

            for (Element elem : listOfElements) {
                listOfLinks.add(elem.select("a[href]").first().attr("href"));
            }

            List<Document> documents = new ArrayList<>();

            for (String link : listOfLinks) {
                documents.add(Jsoup.connect(link).get());
            }


//                System.out.println(document.outerHtml());
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

    }
}