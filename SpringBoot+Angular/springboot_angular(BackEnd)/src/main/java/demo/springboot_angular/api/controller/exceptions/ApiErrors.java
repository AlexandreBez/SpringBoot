package demo.springboot_angular.api.controller.exceptions;

public class ApiErrors {
    
    
    private List<String> errors;

    public List<String> getErrors() {
        return errors;
    }

    public ApiErrors(List<String> errors){
        this.errors = errors;
    }

    public ApiErrors(String message){
        this.errors = Arrays.asList(message);
    }

    
}