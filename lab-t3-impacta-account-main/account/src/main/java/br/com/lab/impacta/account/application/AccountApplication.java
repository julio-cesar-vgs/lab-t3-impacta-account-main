package br.com.lab.impacta.account.application;

import br.com.lab.impacta.account.application.dto.response.AccountBalanceResponse;
import br.com.lab.impacta.account.application.dto.response.DebitAccountResponse;
import br.com.lab.impacta.account.application.dto.request.DebitAccountRequest;

public interface AccountApplication {

     AccountBalanceResponse getBalance(Long accountId);

    DebitAccountResponse debit(Long accountId, DebitAccountRequest debitAccountRequest);
}
