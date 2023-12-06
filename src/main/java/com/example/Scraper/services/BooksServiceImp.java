package com.example.Scraper.services;

import com.example.Scraper.models.Book;
import com.example.Scraper.repositories.BookRepository;
import com.example.Scraper.scrappers.BookScrapper;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
@AllArgsConstructor
public class BooksServiceImp implements BooksService {

    private BookRepository bookRepository;

    @Override
    public List<Book> returnAllBooks() {

        return bookRepository.findAll();
    }

    @PostConstruct
    public void saveAllBooksToDb(){

        BookScrapper scrapper  = new BookScrapper();
        Elements elementsToPrint = scrapper.scrapAll(".product_pod");

        for(Element el: elementsToPrint){

            String title = el.select("h3 > a").attr("title"); //printing using title attribute
            String fullPrice = el.select(".price_color").text();
            double purePrice = Double.parseDouble(fullPrice.substring(1));
            boolean availability = el.select(".instock.availability").text().equals("In stock");

            Book book = new Book(title,purePrice,availability);
            bookRepository.save(book);

        }
    }
}
