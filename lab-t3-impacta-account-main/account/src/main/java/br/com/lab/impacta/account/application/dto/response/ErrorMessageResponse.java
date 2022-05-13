package br.com.lab.impacta.account.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
public class ErrorMessageResponse {

    private LocalDateTime timestamp;
    private String message;
    private String description;
}
