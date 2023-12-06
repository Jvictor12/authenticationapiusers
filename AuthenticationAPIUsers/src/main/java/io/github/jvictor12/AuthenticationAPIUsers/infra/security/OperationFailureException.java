package io.github.jvictor12.AuthenticationAPIUsers.infra.security;

public class OperationFailureException extends RuntimeException{

    public OperationFailureException(String message, Throwable cause) {
        super(message, cause);
    }

    public OperationFailureException(String message) {
        super(message);
    }
}
