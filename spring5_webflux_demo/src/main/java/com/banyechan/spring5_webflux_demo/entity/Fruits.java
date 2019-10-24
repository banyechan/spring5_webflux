package com.banyechan.spring5_webflux_demo.entity;

public enum Fruits {

    Apple(1,"苹果"),
    Grape(2,"葡萄"),
    Peach(3,"桃子"),
    Pear(4,"梨子");


    private int id;
    private String name;

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    Fruits(int id, String name) {
        this.id = id;
        this.name = name;
    }



    //通过Id 获得 名称
    public static String getNameById(int id){
        String result = null;
        for(Fruits tem : Fruits.values()) {
            if(tem.id == id){
                result = tem.name;

            }
        }
        Fruits a = Fruits.values()[id];
        return result;
    }


    public static void main(String[] args) {


        for(Fruits tem : Fruits.values()) {
            System.out.println(tem + "---"+ tem.ordinal() );//输出的是整个对象
        }

        String name = Fruits.getNameById(3);

        System.out.println("----2---" + name);





    }


}
