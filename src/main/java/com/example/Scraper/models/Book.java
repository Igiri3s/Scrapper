package com.example.Scraper.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Books")
public class Book {   // I placed this in models, but it will be also dto, is more convenient for demonstration

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int bookId;

    private String title;
    private Double price;
    private Boolean isAvailable;

    public Book(String title, Double price, Boolean isAvailable) {
        this.title = title;
        this.price = price;
        this.isAvailable = isAvailable;
    }

}
