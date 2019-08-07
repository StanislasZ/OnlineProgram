package com.stan.公司笔试;

public class 长方形香蕉 {

    public static void main(String[] args) {



    }
}


class Rectangle {
    float x;  //左下角横坐标
    float y;  //左下角纵坐标
    float width;  //宽
    float height;  //高

    private static Rectangle singleton;

    public Rectangle(){}
    public Rectangle(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean overlap(Rectangle r) {
        boolean height_overlap = (this.y > r.y && this.y < r.y + r.height)
                                ||  (this.y + this.height > r.y && this.y + this.height < r.y + r.height);
        boolean width_overlap = (this.x > r.x && this.x < r.x + r.width)
                                || (this.x + this.width > r.x && this.x + r.width < r.x + r.width);
        return height_overlap || width_overlap;
    }

    //返回单例
    public static Rectangle getInstance() {
        if (singleton == null) {
            synchronized (Rectangle.class) {
                if (singleton == null) {
                    singleton = new Rectangle();
                }
            }
        }
        return singleton;
    }


}