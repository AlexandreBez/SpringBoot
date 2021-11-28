package basico.springboot.api;

import java.util.Arrays;
import java.util.List;

import lombok.Data;
import lombok.Getter;

@Data
public class ApiErrors {

    @Getter
    private List<String> errors;

    public ApiErrors(List<String> errors){
        this.errors = errors;
    }

    public ApiErrors(String string){
        this.errors = Arrays.asList(string);
    }

}