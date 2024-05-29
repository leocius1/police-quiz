package org.example;
import org.example.models.Suspect;
import org.example.services.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final CrawlAndScraper crawlAndScraper = new CrawlAndScraperImpl();
    private static final CrimeListManagerImpl crimeListManager = new CrimeListManagerImpl();

    public static void main(String[] args) {
        List<Suspect> suspects = new ArrayList<>();
        List<String> crimes = new ArrayList<>();
        crawlAndScraper.crawlAndScrape(suspects, crimes);

        crimeListManager.removeRepeatedCrimes(crimes);


    }

}