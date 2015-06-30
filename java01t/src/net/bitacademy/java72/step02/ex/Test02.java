package net.bitacademy.java72.step02.ex;

import java.util.ArrayList;
import java.util.Date;

public class Test02 {
  static class Book {
    String  title;
    String  press;
    String  author;
    int     pageSize;
    Date    outDate;
    
    public Book(String title, String press, 
        String author, int pageSize, Date outDate) {
      this.title = title;
      this.press = press;
      this.author = author;
      this.pageSize = pageSize;
      this.outDate = outDate;
    }

    @Override
    public String toString() {
      return "Book [title=" + title + ", press=" + press + ", author=" + author
          + ", pageSize=" + pageSize + ", outDate=" + outDate + "]";
    }
  }
  
  public static void main(String[] args) {
    Book b1 = new Book("aaa", "aaa", "aaaa", 20, null);
    Book b2 = new Book("bbb", "aaa", "aaaa", 20, null);
    Book b3 = new Book("ccc", "aaa", "aaaa", 20, null);
    Book b4 = new Book("ddd", "aaa", "aaaa", 20, null);
    
    ArrayList<Book> list = new ArrayList<Book>();
    list.add(b1);
    list.add(b2);
    list.add(b3);
    list.add(b4);
    
    for (Book b : list) {
      System.out.println(b);
    }
  }
}











