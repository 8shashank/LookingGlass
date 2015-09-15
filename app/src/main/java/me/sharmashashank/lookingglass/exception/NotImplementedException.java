package me.sharmashashank.lookingglass.exception;

/*
Thrown if function has not been implemented yet
 */
public class NotImplementedException extends Throwable {
    public NotImplementedException() {
        super();
    }

    public NotImplementedException(String message) {
        super(message);
    }
}
