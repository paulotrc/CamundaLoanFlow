package br.paulotrc.svcautomovel.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter @Setter
public class GeneralError {

    private HttpStatus code;
    private String message;

}
