package com.zzh.testService;

import com.zzh.service.IBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class testIBookService {

    @Autowired
    private IBookService iBookService;

    @Test
    void selectById(){
        System.out.println(iBookService.getById(1));
    }
}
