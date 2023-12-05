package com.example.Scraper.scrappers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class BookScrapper {
    String url;
    public BookScrapper() {
        url = "https://books.toscrape.com/"; //im setting this here bcs im lazy
    }

    public Elements scrapAll(String elementIdOrSomething){ //function that return all Elements form given id or something (html tag for example)
        try {

            Document document = Jsoup.connect(this.url).get(); //connecting to website
            return document.select(elementIdOrSomething); // returning all elements

        }catch (IOException e){

            e.printStackTrace();
        }
        return null; // isn't optimal (probably) but it is what it is
    }

    public void printAll(){
        Elements elementsToPrint = scrapAll(".product_pod");

        for(Element el: elementsToPrint){
            String title = el.select("h3 > a").attr("title"); //printing using title attribute
            String price = el.select(".price_color").text(); //printing flat price (i should substring it to remove £, but that isn't important now

            System.out.println(title + ": " + price);

        }
    }
}
