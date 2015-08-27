package com.haha.splider.Utils;

public enum Type {
    
    BUSINESS(1,"业界"),MOBILE(1,"移动"),DEV(3,"研发"),PROGAMMER(4,"程序员杂志"),CLOUD(5,"云计算");
    
    private int id;
    private String name;
    
    Type(int id,String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    
    

}
