package com.fastcampus.ch3.di3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class Car {
    Engine engine;
    Door door;

    @Override
    public String toString() {
        return "Car{" +
                "engine=" + engine +
                ", door=" + door +
                '}';
    }
}

//@Component
class Engine {}

//@Component("superEngine")
//@Component
//class SuperEngine extends Engine {}

@Component
class TubroEngine extends Engine {}

@Component
class Door {}
public class Main {
    public static void main(String[] args) {
        // AC를 생성 - AC의 설정파일은 AppConfig.class 자바설정
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        Car car = (Car)ac.getBean("car"); // byName 객체(빈)을 조회
        System.out.println("car = " + car);
    }
}
