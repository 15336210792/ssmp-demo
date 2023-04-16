package com.zzh.testdao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzh.dao.BookDao;
import com.zzh.domain.Book;
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


    /**
     *
     * 条件查询
     */
    @Test
    void testGetCondition(){
        //方法一
        /*QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name","Spring");
        bookDao.selectList(queryWrapper);*/

        //方法二
        /*String name = "Spring";
        LambdaQueryWrapper<Book> lambdaQueryWrapper = new LambdaQueryWrapper<Book>();
        lambdaQueryWrapper.like(Book::getName,name);
        bookDao.selectList(lambdaQueryWrapper);*/

        //方法三
        String name = null;
        LambdaQueryWrapper<Book> lambdaQueryWrapper = new LambdaQueryWrapper<Book>();
        lambdaQueryWrapper.like(name != null,Book::getName,name);
        bookDao.selectList(lambdaQueryWrapper);
    }
}
