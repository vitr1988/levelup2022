package ru.levelup.lesson2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Report<T> {

    private int id;
    private T type;
    //    private String type;
    private String name;
    private Author author;


//    public Report() {
//
//    }
//
//    public Report(int id, String type, String name, Author author) {
//        this.id = id;
//        this.type = type;
//        this.name = name;
//        this.author = author;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Author getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(Author author) {
//        this.author = author;
//    }
}
