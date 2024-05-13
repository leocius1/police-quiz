package org.example.services;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class ScraperImpl implements Scraper {

    private static final String DETAIL_BEGINNING = "Körözés jogalapja, bűncselekmény megnevezése, minősítése";

    private static final String CLASS_NAME = "overlay";

    @Override
    public List<String> scrapeSuspectUrls(Document doc) {
        List<String> listOfUrls = new ArrayList<>();
        for (Element elem : getListOfOverlayElements(getDivElements(doc))) {
            listOfUrls.add(getUrl(elem));
        }
        return listOfUrls;
    }

    @Override
    public void scrapeCrimes(Document doc, List<String> crimes) {
         getCrime(getMetaTag(doc),crimes);
    }

    private void getCrime (Element metaTag, List<String> crimes) {
        if (metaTag != null) {
            String content = metaTag.attr("content");
            String[] details = content.split(";");
            for (String detail : details) {
                if (detail.startsWith(DETAIL_BEGINNING)) {
                    addCrimeToList(detail.split(": ", 2)[1],crimes);
                }
            }
        }
        throw new RuntimeException("Crime not found");
    }

    private void addCrimeToList(String crime, List<String> crimes) {
        crimes.add(crime);
    }

    private Element getMetaTag(Document doc) {
        return doc.select("meta[property=og:description]").first();
    }

    private String getUrl(Element elem) {
        return elem.select("a[href]").first().attr("href");
    }

    private Elements getDivElements(Document doc) {
        return doc.select("div");
    }

    private List<Element> getListOfOverlayElements(Elements divs) {
        List<Element> listOfOverlayElements = new ArrayList<>();
        for (Element elem : divs) {
            if (elem.hasClass(CLASS_NAME)) {
                listOfOverlayElements.add(elem);
            }
        }
        return listOfOverlayElements;
    }
}
