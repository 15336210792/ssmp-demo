package com.zzh.testService;

import com.zzh.service.IBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServicetest {

    @Autowired
    private IBookService bookService;
/*
    @Test
    void testGetById(){
        System.out.println( bookService.getById(1));
    }

    @Test
    void testGetAll(){
        System.out.println( bookService.getAll());
    }*/

}