package org.example.services;

import org.example.models.Suspect;

import java.util.List;

public interface CrawlAndScraper {

    void crawlAndScrape(List<Suspect> suspect, List<String> crimes);

}
