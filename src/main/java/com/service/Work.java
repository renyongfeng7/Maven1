package com.service;

/*模拟事务操作*/
public class Work {

    public void start (){
        System.out.println("开启事务");
    }
    public void commit (){
        System.out.println("提交事务");
    }
    public void rollback (){System.out.println("回滚事务"); }
    public void close (){
        System.out.println("关闭事务");
    }

}
