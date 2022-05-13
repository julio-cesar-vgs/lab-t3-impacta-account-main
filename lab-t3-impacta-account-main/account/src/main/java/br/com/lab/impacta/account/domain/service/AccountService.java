package br.com.lab.impacta.account.domain.service;

import br.com.lab.impacta.account.domain.model.Account;
import org.springframework.stereotype.Service;

public interface AccountService {
    Account find(Long accountId);

    void debit(Long accountId, Double valueOfDebit);
}
