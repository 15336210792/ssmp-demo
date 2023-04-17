package com.zzh.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zzh.domain.Book;


public interface IBookService extends IService<Book> {

    boolean update(Book book);
    boolean delete(Integer id);

    IPage<Book> getPage(int currentPage, int pageSize, Book book);
}
