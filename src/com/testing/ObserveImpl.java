package com.testing;

import java.util.Observable;
import java.util.Observer;

class NoticeBoard  extends Observable
{
    public void changeMessage(String message)
    {
        setChanged();
        notifyObservers(message);
    }

}

class Student implements Observer
{
    @Override
    public void update(Observable o, Object arg)
    {
        System.out.println("Notice board message added: " + arg);
    }
}

public class ObserveImpl
{
    public static void main(String[] args)
    {
        NoticeBoard board = new NoticeBoard();
        Student jim = new Student();
        Student casey = new Student();
        board.addObserver(jim);
        board.addObserver(casey);
        board.changeMessage("Result declared");
    }
}