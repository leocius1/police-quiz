package org.example.services;

import org.jsoup.nodes.Document;

import java.util.List;

public interface Scraper {
    List<String> scrapeSuspectUrls (Document doc);

    void scrapeCrimes (Document doc, List<String> crimes);
}
