package com.zzh.testdao;

import com.zzh.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookDaotest {

    @Autowired
    private BookDao bookDao;

    @Test
    void testSelectList(){
       bookDao.selectList(null);
    }
    @Test
    void testDeleteById(){
        System.out.println(bookDao.deleteById(2));
    }
}
