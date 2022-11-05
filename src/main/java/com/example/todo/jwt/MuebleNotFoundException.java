package com.example.todo.jwt;

public class MuebleNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public MuebleNotFoundException(String message) {
    super(message);
    }
}
