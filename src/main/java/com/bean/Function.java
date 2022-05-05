package com.bean;

/*功能类——管理、增删改查功能*/
public class Function {

    private int funId;
    private String funName;
    private String funUrl;
    private int funParent;


    public Function() {
    }

    public Function(int funId, String funName, String funUrl, int funParent) {
        this.funId = funId;
        this.funName = funName;
        this.funUrl = funUrl;
        this.funParent = funParent;
    }

    public int getFunId() {
        return funId;
    }

    public void setFunId(int funId) {
        this.funId = funId;
    }

    public String getFunName() {
        return funName;
    }

    public void setFunName(String funName) {
        this.funName = funName;
    }

    public String getFunUrl() {
        return funUrl;
    }

    public void setFunUrl(String funUrl) {
        this.funUrl = funUrl;
    }

    public int getFunParent() {
        return funParent;
    }

    public void setFunParent(int funParent) {
        this.funParent = funParent;
    }
}
