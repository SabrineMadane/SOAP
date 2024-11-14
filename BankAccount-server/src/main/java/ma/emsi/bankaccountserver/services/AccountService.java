package ma.emsi.bankaccountserver.services;

import ma.emsi.bankaccountserver.dto.BankAccountRequestDTO;
import ma.emsi.bankaccountserver.dto.BankAccountResponseDTO;
import ma.emsi.bankaccountserver.entities.BankAccount;

public interface AccountService {
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO);

    BankAccountResponseDTO UpdateAccount(String id, BankAccountRequestDTO bankAccountRequestDTO);
}
