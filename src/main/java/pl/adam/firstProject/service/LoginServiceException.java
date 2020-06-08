package pl.adam.firstProject.service;

public class LoginServiceException extends RuntimeException {

    private String forField;

    public LoginServiceException(String message, String forField) {
        super(message);
        this.forField = forField;
    }

    public String getForField() {
        return forField;
    }
}
