package org.example;

import org.jsoup.nodes.Document;

public interface Crawler {
    Document crawl(String url);
}
