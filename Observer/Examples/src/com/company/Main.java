package com.company;


import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        YoutubeChannel youtubeChannel = new YoutubeChannel();
        YoutubeSubscriber subscriberA = new YoutubeSubscriber(youtubeChannel);
        YoutubeSubscriber subscriberB = new   YoutubeSubscriber(youtubeChannel);
        YoutubeSubscriber subscriberC = new YoutubeSubscriber(youtubeChannel);
        youtubeChannel.addObserver(subscriberA);
        youtubeChannel.addObserver(subscriberB);
        youtubeChannel.addObserver(subscriberC);
        youtubeChannel.releaseNewVideo("Design Patterns : Factory Method");
        youtubeChannel.releaseNewVideo("Design Patterns : Proxy");
        youtubeChannel.releaseNewVideo("Design Patterns : Visitor");
    }
}
interface Observable {
    public void addObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObserver();
}

class YoutubeChannel implements Observable {
    private ArrayList<Observer> observers = new ArrayList<Observer>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void releaseNewVideo(String video) {
        System.out.println("Release new video : " + video);
        notifyObserver();
    }

    @Override
    public void notifyObserver() {
        for(Observer observer: observers) {
            observer.update();
        }
    }
}

interface Observer {
    public void update();
}

class YoutubeSubscriber implements Observer {

    private Observable observable;

    public YoutubeSubscriber(Observable observable) {
        this.observable = observable;
    }

    @Override
    public void update() {
        System.out.println("New video on channel!");
    }
}