package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PoliceCrawler implements Crawler {

    private static final String ROOT_URL = "https://www.police.hu/hu/koral/elfogatoparancs-alapjan-korozott-szemelyek";

    private static final String CLASS_NAME = "overlay";

    @Override
    public Document crawl(String url) {
        try {
            return Jsoup.connect(url).get();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private List<String> retrieveLinks(Document doc) {
        List<String> listOfLinks = new ArrayList<>();
        for (Element elem : retrieveOverlayElements(doc)) {
            listOfLinks.add(elem.select("a[href]").first().attr("href"));
        }
        return listOfLinks;
    }

    private List<Element> retrieveOverlayElements(Document doc) {
        Elements divElements = doc.select("div");
        List<Element> overlayElements = new ArrayList<>();
        for (Element elem : divElements) {
            if (elem.hasClass("overlay")) {
                overlayElements.add(elem);
            }
        }
        return overlayElements;
    }
}
