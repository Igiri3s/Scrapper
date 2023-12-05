package com.example.Scraper;

import com.example.Scraper.scrappers.BookScrapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScraperApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScraperApplication.class, args);
		BookScrapper test = new BookScrapper();
		test.printAll();
	}

}
