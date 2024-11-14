package ma.emsi.bankaccountserver.web;

import ma.emsi.bankaccountserver.dto.BankAccountRequestDTO;
import ma.emsi.bankaccountserver.dto.BankAccountResponseDTO;
import ma.emsi.bankaccountserver.entities.BankAccount;
import ma.emsi.bankaccountserver.mappers.AccountMapper;
import ma.emsi.bankaccountserver.repositories.BankAccountRepository;
import ma.emsi.bankaccountserver.services.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AccountRestController {
    private BankAccountRepository bankAccountRepository;
    private AccountService accountService;
    private AccountMapper accountMapper;

    public AccountRestController(BankAccountRepository bankAccountRepository, AccountService accountService, AccountMapper accountMapper) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }
    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts(){
        return bankAccountRepository.findAll();
    }
    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccount(@PathVariable String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Account %s is not Found", id)));
    }
    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO bankAccountRequestDTO){
        return accountService.addAccount(bankAccountRequestDTO);
    }
    @PutMapping("/bankAccounts/{id}")
    public BankAccount update(@PathVariable String id, @RequestBody BankAccount bankAccount){
        BankAccount account = bankAccountRepository.findById(id).orElseThrow();
        if (bankAccount.getBalance()!= null) account.setBalance(bankAccount.getBalance());
        if (bankAccount.getCreatedAt()!= null) account.setCreatedAt(new Date());
        if (bankAccount.getType()!= null) account.setType(bankAccount.getType());
        if (bankAccount.getCurrency()!= null) account.setCurrency(bankAccount.getCurrency());
        return bankAccountRepository.save(account);
    }
    @DeleteMapping("/bankAccounts")
    public void delete(@PathVariable String id){
        bankAccountRepository.deleteById(id);
    }
}
