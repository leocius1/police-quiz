package org.example.services;

import org.example.models.Suspect;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;

public class CrawlAndScraperImpl implements CrawlAndScraper {

    private static final String ROOT_URL = "https://www.police.hu/hu/koral/elfogatoparancs-alapjan-korozott-szemelyek";

    private static final Crawler crawler = new CrawlerServiceImpl();

    private static final Scraper scraper = new ScraperImpl();

    private static final Document rootDoc = crawler.crawl(ROOT_URL);


    @Override
    public void crawlAndScrape(List<Suspect> suspect, List<String> crimes) {
        for (Document doc : getAllSuspectDocs()) {
            scraper.scrapeCrimes(doc,crimes);
        }
    }

    private void scrapeCrimes(List<String> crimes) {

    }

    private List<Document> getAllSuspectDocs() {
        List<Document> docs = new ArrayList<>();
        for (String url : scraper.scrapeSuspectUrls(rootDoc)) {
            docs.add(crawler.crawl(url));
        } return docs;
    }

    private String getDescriptionContent(Document doc, List<Suspect> suspect, List<String> crimes) {
        Element metaTag = doc.select("meta[property=og:description]").first();
        if (metaTag != null) {
            String content = metaTag.attr("content");
            String[] details = content.split(";");
            for (String detail : details) {
                if (detail.startsWith("Körözés jogalapja, bűncselekmény megnevezése, minősítése")) {
                    return detail.split(": ", 2)[1];
                }
            }
        }
        throw new RuntimeException("Crime not found");
    }


}
