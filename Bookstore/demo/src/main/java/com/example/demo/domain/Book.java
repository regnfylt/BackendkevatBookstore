package com.example.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String nimi;
    private String kirjailija;
    private int vuosi;
    private String isbn;
    private int hinta;
    
    public Book() {}
    
    public Book(Long id, String nimi, String kirjailija, int vuosi, String isbn, int hinta) {
        super();
        this.id = id;
        this.nimi = nimi;
        this.kirjailija = kirjailija;
        this.vuosi = vuosi;
        this.isbn = isbn;
        this.hinta = hinta;
    }
    
    public String getNimi() {
        return nimi;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public int getHinta() {
        return hinta;
    }
    
    public void setHinta(int hinta) {
        this.hinta = hinta;
    }
    
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }
    
    public String getKirjailija() {
        return kirjailija;
    }
    
    public void setKirjailija(String kirjailija) {
        this.kirjailija = kirjailija;
    }
    
    public int getVuosi() {
        return vuosi;
    }
    
    public void setVuosi(int vuosi) {
        this.vuosi = vuosi;
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    }
