package com.sk.user.service.exception;

public class ResourceNotFoundException extends  RuntimeException{

   public ResourceNotFoundException()
    {
        super("Resource not found server");
    }
    public ResourceNotFoundException(String msg)
    {
        super(msg);
    }
}
