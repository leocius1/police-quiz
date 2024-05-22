package org.example.services;

import org.example.models.Suspect;
import org.jsoup.nodes.Document;

import java.util.ArrayList;
import java.util.List;

public class CrawlAndScraperImpl implements CrawlAndScraper {

    private static final String ROOT_URL = "https://www.police.hu/hu/koral/elfogatoparancs-alapjan-korozott-szemelyek";

    private static final Crawler crawler = new CrawlerServiceImpl();

    private static final Scraper scraper = new ScraperImpl();

    private static final Document rootDoc = crawler.crawl(ROOT_URL);


    @Override
    public void crawlAndScrape(List<Suspect> suspects, List<String> crimes) {
        for (Document doc : getAllSuspectDocs()) {
            scraper.scrapeCrimesAndSuspects(doc,crimes,suspects);
        }
    }

    private List<Document> getAllSuspectDocs() {
        List<Document> docs = new ArrayList<>();
        for (String url : scraper.scrapeSuspectUrls(rootDoc)) {
            docs.add(crawler.crawl(url));
        } return docs;
    }

}
