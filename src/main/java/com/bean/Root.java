package com.bean;
/*权限类*/
public class Root {
    private int rootId;
    /*角色*/
    private Role role;
    /*功能*/
    private Function function;

    public Root() {
    }

    public Root(Role role, Function function) {
        this.role = role;
        this.function = function;
    }

    public int getRootId() {
        return rootId;
    }

    public void setRootId(int rootId) {
        this.rootId = rootId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }
}
