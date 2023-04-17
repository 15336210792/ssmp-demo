package com.zzh.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zzh.domain.Book;
import com.zzh.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 本控制器
 *
 * @author 周智海
 * @date 2023/04/17
 */
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService iBookService;

    /**
     * 得到所有
     *
     * @return {@link List}<{@link Book}>
     */
    @GetMapping
    public List<Book> getAll() {
        return iBookService.list();
    }

    /**
     * 通过id
     *
     * @param id id
     * @return {@link Book}
     */
    @GetMapping("/{id}")
    public Book getById(@PathVariable Integer id){
        return iBookService.getById(id);
    }

    /**
     * 获取页面
     *
     * @param currentPage 当前页面
     * @param pageSize    页面大小
     * @return {@link IPage}<{@link Book}>
     */
    @GetMapping("{currentPage}/{pageSize}")
    public IPage<Book> getPage(@PathVariable int currentPage,@PathVariable int pageSize){
        return iBookService.getPage(currentPage,pageSize);
    }

    /**
     * 保存
     *
     * @param book 书
     * @return boolean
     */
    @PostMapping
    public boolean save(@RequestBody Book book) {
        return iBookService.save(book);
    }

    /**
     * 更新
     *
     * @param book 书
     * @return boolean
     */
    @PutMapping
    public boolean update(@RequestBody Book book) {
        return iBookService.update(book);
    }

    /**
     * 删除通过id
     *
     * @param id id
     * @return boolean
     */
    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable Integer id){
        return iBookService.delete(id);
    }

}
