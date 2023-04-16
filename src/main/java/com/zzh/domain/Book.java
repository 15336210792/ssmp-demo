package com.zzh.domain;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private Integer id;
    private String type;
    private String name;
    private String description;
    @TableLogic
    private Integer deleted;

}
