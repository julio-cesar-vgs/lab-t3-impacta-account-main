package br.com.lab.impacta.account.domain.service.impl;

import br.com.lab.impacta.account.domain.exception.AccountNotFoundException;
import br.com.lab.impacta.account.domain.model.Account;
import br.com.lab.impacta.account.domain.service.AccountService;
import br.com.lab.impacta.account.infrastructure.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Value("${lab.account.exceptions.account-dont-exists-message}")
    private String messageExceptionAccountNotFound;
    @Value("${lab.account.exceptions.account-without-balance-description}")
    private String descriptionExceptionAccountNotFound;

    @Value("${lab.account.exceptions.account-dont-exists-description}")
    private String descriptionExceptionWithoutBalanceExceptions;
    @Value("${lab.account.exceptions.account-without-balance-message}")
    private String messageExceptionAccountWithoutBalanceExceptions;


    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account find(Long accountId) {
        Optional<Account> account = accountRepository.findById(accountId);

        if (account.isEmpty()) {
            throw new AccountNotFoundException(descriptionExceptionAccountNotFound, messageExceptionAccountNotFound);
        }

        return account.get();
    }

    @Override
    public void debit(Long accountId, Double valueOfDebit) {
        Account account = this.find(accountId);

        account.debit(valueOfDebit);

        accountRepository.save(account);
    }
}
