package me.sharmashashank.lookingglass.exception;

/*
Thrown if program metadata such as client key could not be found
 */
public class MetadataNotFoundException extends Throwable {
    public MetadataNotFoundException() {
        super();
    }

    public MetadataNotFoundException(String message) {
        super(message);
    }
}
