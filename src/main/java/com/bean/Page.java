package com.bean;

import java.util.List;

public class Page<T> {
    /*当前页码*/
    public int pageno;
    /*总条数*/
    public int count;
    /*总页数*/
    public int pagetotal;

    public List<Page> list;

    public Page() {
    }

    public Page(int pageno, int count, int pagetotal, List list) {
        this.pageno = pageno;
        this.count = count;
        this.pagetotal = pagetotal;
        this.list = list;
    }

    public int getPageno() {
        return pageno;
    }

    public void setPageno(int pageno) {
        this.pageno = pageno;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPagetotal() {
        return pagetotal;
    }

    public void setPagetotal(int pagetotal) {
        this.pagetotal = pagetotal;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }


}
