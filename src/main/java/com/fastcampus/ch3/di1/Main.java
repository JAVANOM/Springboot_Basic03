package com.fastcampus.ch3.di1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.w3c.dom.ranges.DocumentRange;

import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.util.Properties;

class Car {
    @Autowired
    Engine engine;
    @Autowired
    Door door;

    @Override
    public String toString() {
        return "Car{" +
                "engine=" + engine +
                ", door=" + door +
                '}';
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Door getDoor() {
        return door;
    }

    public void setDoor(Door door) {
        this.door = door;
    }
}
class SportsCar extends Car{}

class Truck extends Car{}

class Engine{
}
class Door{}

public class Main {
    public static void main(String[] args) throws Exception{
        Car car = (Car)getObject("car");
        System.out.println(" =" +car);
    }

    static Object getObject(String key) throws Exception{
        Properties prop = new Properties();
        Class<?> clazz = null; //지정된 클래스이름에 해당하는 클래스 객체를 얻는다

        prop.load(new FileReader("config.txt"));
        String className = prop.getProperty(key); // 지정한 key의 value 값 반환

        clazz = Class.forName(className);
        return clazz.newInstance();
    }

    static Car getCar(){
        return new SportsCar();
    }
}
