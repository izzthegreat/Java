package com.win.blog.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BlogPost {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long iD;
    private String title, author, blogEntry;

    private BlogPost(){}

    public BlogPost( String title, String author, String blogEntry ) {
        this.title = title;
        this.author = author;
        this.blogEntry = blogEntry;
    }

    public Long getiD() { return iD; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public String getBlogEntry() { return blogEntry; }
    public void setBlogEntry(String blogEntry) { this.blogEntry = blogEntry; }

    @Override
    public String toString() {
        return "BlogPosts{" +
                "id=" + iD +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", blogEntry='" + blogEntry + '\'' +
                '}';
    }
}
