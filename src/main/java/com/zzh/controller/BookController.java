package com.zzh.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zzh.controller.util.R;
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
    public R getAll() {
        return new R(true,iBookService.list());
    }

    /**
     * 通过id
     *
     * @param id id
     * @return {@link Book}
     */
    @GetMapping("/{id}")
    public R getById(@PathVariable Integer id){
        return new R(true,iBookService.getById(id));
    }

    /**
     * 获取页面
     *
     * @param currentPage 当前页面
     * @param pageSize    页面大小
     * @return {@link IPage}<{@link Book}>
     */
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize){
        //问题：当前页码大于总的页码，
        //使用最大页码当做当前页码进行重新查询
        IPage<Book> page = iBookService.getPage(currentPage, pageSize);
        if(currentPage> page.getPages()){
            page = iBookService.getPage((int) page.getPages(), pageSize);
        }

        return new R(true,page);
    }

    /**
     * 保存
     *
     * @param book 书
     * @return boolean
     */
    @PostMapping
    public R save(@RequestBody Book book) {
        boolean flag = iBookService.save(book);
        return new R(flag,flag?"保存成功":"保存失败");
    }

    /**
     * 更新
     *
     * @param book 书
     * @return boolean
     */
    @PutMapping
    public R update(@RequestBody Book book) {
        boolean flag = iBookService.update(book);
        return new R(flag,flag?"修改成功":"修改成功");
    }

    /**
     * 删除通过id
     *
     * @param id id
     * @return boolean
     */
    @DeleteMapping("/{id}")
    public R deleteById(@PathVariable Integer id){
        boolean flag = iBookService.delete(id);
        return new R(flag,flag?"删除成功":"删除失败");
    }

}
