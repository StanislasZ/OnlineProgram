package com.stan.design_pattern.observer;


//观察者
public class CurrentConditionDisplay implements Observer {

    public CurrentConditionDisplay(Subject weatherData) {
        //把自己注册到 被观察者的 observers中
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        System.out.println("CurrentConditionDisplay.update: " + temp + " " + humidity + " " + pressure);

    }
}
