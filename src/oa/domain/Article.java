package oa.domain;

import java.sql.Date;

public class Article {

	Long id;
    String title;
    String type;
    String content;
    String author;
    Date pubDate;
    String note;
    public Long getId() {    return id; }
    public void setId(Long id) {    this.id = id; }
    public String getTitle() {   return title;  }
    public void setTitle(String title) {    this.title = title;   }
    public String getType() {    return type;   }
    public void setType(String type) {  this.type = type; }
    public String getContent() { return content;    }
    public void setContent(String content) {    this.content = content;   }
    public String getAuthor() {  return author; }
    public void setAuthor(String author) {  this.author = author; }
    public Date getPubDate() {   return pubDate;    }
    public void setPubDate(Date pubDate) {  this.pubDate = pubDate;   }
    public String getNote() {    return note;   }
    public void setNote(String note) {  this.note = note; }  
}

