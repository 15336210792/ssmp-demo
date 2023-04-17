package com.zzh.controller.util;

import lombok.Data;

@Data
public class R {

    private Boolean flag;
    private Object data;

    public R(){}

    public R(Boolean flag,Object data){
        this.flag=flag;
        this.data = data;
    }

    public R(Boolean flag){
        this.flag=flag;
    }
}
