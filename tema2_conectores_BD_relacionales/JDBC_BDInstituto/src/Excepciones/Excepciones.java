package Excepciones;

public class Excepciones extends Exception {

    private String error;

    public Excepciones() {
    }

    public Excepciones(String message) {
        super(message);
        this.error = message;
    }

    public String getError() {
        return error;
    }

}
