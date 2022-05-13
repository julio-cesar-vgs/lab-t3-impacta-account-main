package br.com.lab.impacta.account.domain.exception;


import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AccountWithoutBalanceNotFoundException extends RuntimeException{

    private String description;

    public AccountWithoutBalanceNotFoundException(String message){
        super(message);
    }


}
