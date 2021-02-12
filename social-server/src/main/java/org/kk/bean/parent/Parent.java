package org.kk.bean.parent;

public class Parent {
    protected Integer id;
    public Parent(){

    }
    protected Parent(Integer id){
        this.id = id;
    }
    public Integer getId() {
        return id;
    }

    protected void setId(Integer id) {
        this.id = id;
    }
}
