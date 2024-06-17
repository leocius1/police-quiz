package org.example;
import org.example.models.Game;
import org.example.models.GameFrame;
import org.example.models.GameScreen;
import org.example.models.Suspect;
import org.example.services.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final CrawlAndScraper crawlAndScraper = new CrawlAndScraperImpl();

    private static final CrimeListManagerImpl crimeListManager = new CrimeListManagerImpl();
    private static final SuspectManager suspectListManager = new SuspectManagerImpl();

    public static void main(String[] args) {
        List<Suspect> suspects = new ArrayList<>();
        List<String> crimes = new ArrayList<>();
        crawlAndScraper.crawlAndScrape(suspects, crimes);

        suspectListManager.deleteSuspectsWithoutImg(suspects);
        crimes = crimeListManager.removeDuplicates(crimes);
        suspects = suspectListManager.removeDuplicates(suspects);


        Game game = new Game(suspects,crimes);

        System.out.println("hi");
    }

}