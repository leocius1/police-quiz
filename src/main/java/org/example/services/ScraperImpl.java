package org.example.services;

import org.example.models.Suspect;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class ScraperImpl implements Scraper {

    private static final String CRIME_DETAIL_BEGINNING = "Körözés jogalapja, bűncselekmény megnevezése, minősítése";

    private static final String SURNAME_DETAIL_BEGINNING = "Viselt vezetéknév";

    private static final String FIRSTNAME_DETAIL_BEGINNING = "Viselt utónév 1";

    private static final String CLASS_NAME = "overlay";

    @Override
    public List<String> scrapeSuspectUrls(Document doc) {
        List<String> listOfUrls = new ArrayList<>();
        for (Element elem : getListOfOverlayElements(getDivElements(doc))) {
            listOfUrls.add(getUrl(elem));
        }
        return listOfUrls;
    }

    public void scrapeCrimesAndSuspects(Document doc, List<String> crimes, List<Suspect> suspects) {
        Element metaTag = getMetaTag(doc);
        String crime = getCrime(metaTag);
        addCrimeToList(crime,crimes);
        String surName = getName(metaTag,SURNAME_DETAIL_BEGINNING);
        String firstName = getName(metaTag,FIRSTNAME_DETAIL_BEGINNING);
        System.out.println(surName + "" + firstName);
//        suspects.add(
//                SuspectBuilder.builder()
//                        .crime(crime)
//                        .surName(getName(metaTag, SURNAME_DETAIL_BEGINNING))
//                        .firstName(getName(metaTag, FIRSTNAME_DETAIL_BEGINNING))
//                        .imgURL()
//                        .build();
//        )
    }

    private String[] getDescriptionContentDetails(Element metaTag) {
        if (metaTag == null) {
            throw new RuntimeException("Meta tag not found");
        }
        String content = metaTag.attr("content");
        return content.split(";");
    }

    private String getName(Element metaTag, String nameDetail) {
        return extractNameFromDetails(getDescriptionContentDetails(metaTag),nameDetail);
    }

    private String extractNameFromDetails(String[] details, String nameDetail) {
        for (String detail : details) {

            if (detail.startsWith(nameDetail)) {
                return extractName(detail);
            }
        }
        throw new RuntimeException("Crime not found");
    }

    private String extractName(String detail) {
        String[] parts = detail.split(":", 2);
        if (parts.length > 1) {
            return parts[1];
        }
        throw new RuntimeException("Name detail format is incorrect");
    }

    private String getCrime(Element metaTag) {
        return extractCrimeFromDetails(getDescriptionContentDetails(metaTag));
    }

    private String extractCrimeFromDetails(String[] details) {
        for (String detail : details) {
            if (detail.startsWith(CRIME_DETAIL_BEGINNING)) {
                return extractCrime(detail);
            }
        }
        throw new RuntimeException("Crime not found");
    }

    private String extractCrime(String detail) {
        String[] parts = detail.split(": ", 2);
        if (parts.length > 1) {
            return parts[1].split("-", 2)[0];
        }
        throw new RuntimeException("Crime detail format is incorrect");
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
