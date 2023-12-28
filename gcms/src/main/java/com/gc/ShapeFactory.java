package com.gc;

//创建一个工厂
public class ShapeFactory {
    //普通模式
    //使用 getShape 方法获取形状类型的对象
    public Shape getShape(String shapeType){
        if (shapeType==null) {
            return null;
        }
        if(shapeType.equals("CIRCLE")){
            return new Circle();
        }else if(shapeType.equals("RECTANGLE")){
            return new Rectangle();
        }else if(shapeType.equals("SQUARE")){
            return new Square();
        }
        return null;
    }

    //反射
    //Class<?extends Shape> clazz 拿到的是Shape的子类
    public static Object getClass(Class<?extends Shape> clazz) {
        Object obj = null;

        try {
            obj = Class.forName(clazz.getName()).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return obj;
    }
}
