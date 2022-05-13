package br.com.lab.impacta.account.domain.exception;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;


public class AccountNotFoundException extends RuntimeException {

    private String description;


    public AccountNotFoundException(String description, String message) {
        super(message);

        this.description = description;
    }


}
