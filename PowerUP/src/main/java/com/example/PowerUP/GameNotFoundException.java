package com.example.PowerUP;

public class GameNotFoundException extends RuntimeException{

    public GameNotFoundException(String Name) { super("Could not find game " + Name );}

    public GameNotFoundException(Integer Id) { super("Could not find game with id" + Id );}
}
