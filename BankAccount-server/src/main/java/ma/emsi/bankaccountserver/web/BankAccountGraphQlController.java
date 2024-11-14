package ma.emsi.bankaccountserver.web;

import ma.emsi.bankaccountserver.dto.BankAccountRequestDTO;
import ma.emsi.bankaccountserver.dto.BankAccountResponseDTO;
import ma.emsi.bankaccountserver.entities.BankAccount;
import ma.emsi.bankaccountserver.entities.Customer;
import ma.emsi.bankaccountserver.repositories.BankAccountRepository;
import ma.emsi.bankaccountserver.repositories.CustomerRepository;
import ma.emsi.bankaccountserver.services.AccountService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphQlController {
    private BankAccountRepository bankAccountRepository;
    private AccountService accountService;
    private CustomerRepository customerRepository;

    public BankAccountGraphQlController(BankAccountRepository bankAccountRepository, AccountService accountService, CustomerRepository customerRepository) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountService = accountService;
        this.customerRepository = customerRepository;
    }
    @QueryMapping
    public List<BankAccount> accountsList(){
        return bankAccountRepository.findAll();
    }
    @QueryMapping
    public BankAccount BankAccountById(@Argument  String id){
        return bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
    }
    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount){
        return accountService.addAccount(bankAccount);
    }
    @MutationMapping
    public BankAccountResponseDTO UpdateAccount(@Argument String id, @Argument BankAccountRequestDTO bankAccount){
        return accountService.UpdateAccount(id,bankAccount);
    }
    @MutationMapping
    public void deleteAccount(@Argument String id){
        bankAccountRepository.deleteById(id);
    }
    @QueryMapping
    public List<Customer> customers(){
        return customerRepository.findAll();
    }
}

record BankAccountDTO(Double balance, String type, String currency){
}
