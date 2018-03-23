package cn.dao;

import cn.entity.Book;

import java.util.List;

public interface IBookDAO {
    public List<cn.spring.day014.entity.Book> findAIIBooks();
    //添加图书
    public int addBook(Book book);

    List<cn.spring.day014.entity.Book> findAllBooks();
}
