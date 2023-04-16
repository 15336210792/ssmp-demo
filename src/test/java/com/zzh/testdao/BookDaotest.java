package com.zzh.testdao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzh.dao.BookDao;
import org.apache.ibatis.logging.stdout.StdOutImpl;
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
    //分页
    @Test
    void testSelectPage(){
        IPage page = new Page(1,5);
        bookDao.selectPage(page,null);

        System.out.println(page.getCurrent());  //当前第几页
        System.out.println(page.getSize());     //一页显示几个数据
        System.out.println(page.getTotal());    //一共多少条数据
        System.out.println(page.getPages());    //能分多少页
        System.out.println(page.getRecords());  //当前页的具体数据
    }

}
