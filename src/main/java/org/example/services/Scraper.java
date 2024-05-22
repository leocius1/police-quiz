package org.example.services;

import org.example.models.Suspect;
import org.jsoup.nodes.Document;

import java.util.List;

public interface Scraper {
    List<String> scrapeSuspectUrls (Document doc);

    void scrapeCrimesAndSuspects(Document doc, List<String> crimes, List<Suspect> suspects);
}
