package ru.netology.javaqa.domain;
public class AlreadyExistsException extends RuntimeException{
    public AlreadyExistsException(String msg) {
        super(msg);
    }

}
