package xtracap.users.exception;

public class NoUsersFoundException extends RuntimeException {

    public NoUsersFoundException() {
        super("No users found in the database.");
    }
}

