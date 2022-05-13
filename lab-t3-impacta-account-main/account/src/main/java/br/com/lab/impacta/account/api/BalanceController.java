package br.com.lab.impacta.account.api;


import br.com.lab.impacta.account.application.AccountApplication;
import br.com.lab.impacta.account.application.dto.request.DebitAccountRequest;
import br.com.lab.impacta.account.application.dto.response.AccountBalanceResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/accounts")
@AllArgsConstructor
public class BalanceController {
    private final AccountApplication accountApplication;

    @GetMapping("/{accountId}/balance")
    public ResponseEntity<AccountBalanceResponse> getBalance(@PathVariable Long accountId){
        var accountBalanceResponse =  accountApplication.getBalance(accountId);

        return ResponseEntity.ok(accountBalanceResponse);

    }
}
