package com.simplerssreader;

/**
 * A representation of an rss item from the list.
 *
 * @author Veaceslav Grec
 */
public class RssItem {

    private final String title;
    private final String link;
    private final String dateTime;

    public RssItem(String title, String link, String dateTime) {
        this.title = title;
        this.link = link;
        this.dateTime = dateTime;
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }
}
