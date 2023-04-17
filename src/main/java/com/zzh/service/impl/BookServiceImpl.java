package com.zzh.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzh.dao.BookDao;
import com.zzh.domain.Book;
import com.zzh.service.IBookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*@Service*/
/*public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public boolean save(Book book) {
        return bookDao.insert(book) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return bookDao.deleteById(id) > 0;
    }

    @Override
    public boolean update(Book book) {
        return bookDao.updateById(book) > 0;
    }

    @Override
    public Book getById(Integer id) {
        return bookDao.selectById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.selectList(null);
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        Page<Book> page = new Page<>(currentPage,pageSize);
        return bookDao.selectPage(page,null);
    }
}*/
@Service
public class BookServiceImpl extends ServiceImpl<BookDao, Book> implements IBookService {

    @Autowired
    private BookDao bookDao;

    /**
     * 更新
     *
     * @param book 书
     * @return boolean
     */
    @Override
    public boolean update(Book book) {
        return bookDao.updateById(book) > 0;
    }

    /**
     * 删除
     *
     * @param id id
     * @return boolean
     */
    @Override
    public boolean delete(Integer id) {
        return bookDao.deleteById(id)>0;
    }

    /**
     * 获取页面
     *
     * @param currentPage 当前页面
     * @param pageSize    页面大小
     * @param book
     * @return {@link IPage}<{@link Book}>
     */
    @Override
    public IPage<Book> getPage(int currentPage, int pageSize, Book book) {
        LambdaQueryWrapper<Book> wrapper = new LambdaQueryWrapper<Book>();
        wrapper.like(Strings.isNotEmpty(book.getName()),Book::getName,book.getName());
        wrapper.like(Strings.isNotEmpty(book.getType()),Book::getType,book.getType());
        wrapper.like(Strings.isNotEmpty(book.getDescription()),Book::getDescription,book.getDescription());
        IPage page =new Page(currentPage,pageSize);
        bookDao.selectPage(page,wrapper);
        return page;
    }


    /**
     * 获取页面
     *
     * @param currentPage 当前页面
     * @param pageSize    页面大小
     * @return {@link IPage}<{@link Book}>
     */
    public IPage<Book> getPage(int currentPage, int pageSize) {

        IPage page =new Page(currentPage,pageSize);
        bookDao.selectPage(page,null);
        return page;
    }
}
