package com.crio.codingame.exceptions;

public class NoSuchCommandException extends RuntimeException{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public NoSuchCommandException()
    {
     super();
    }
    public NoSuchCommandException(String msg)
    {
     super(msg);
    }
}
