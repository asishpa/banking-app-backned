package in.bank.service.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import in.bank.dto.AccountDto;
import in.bank.entity.Account;
import in.bank.mapper.AccountMapper;
import in.bank.repo.AccountRepository;
import in.bank.service.AccountService;
@Service
public class AccountServiceImpl implements AccountService{

	private AccountRepository accountRepository;
	public AccountServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		Account account = AccountMapper.mapToAccount(accountDto);
		Account savedAccount = accountRepository.save(account);
		return AccountMapper.maptoAccountDto(savedAccount);
	}
	
	public AccountDto getAccountById(Integer id) {
		 Account account = accountRepository
	                .findById(id)
	                .orElseThrow(() -> new RuntimeException("Account not found"));
	        return AccountMapper.maptoAccountDto(account);
	}

	@Override
	public AccountDto deposit(Integer id, Double amount) {
		Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
		double total = account.getBalance()+amount;
		account.setBalance(total);
		Account savedAccount = accountRepository.save(account);
		return AccountMapper.maptoAccountDto(savedAccount);
		
	}

	@Override
	public AccountDto withdrawal(Integer id, Double amount) {
		Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
		double total = account.getBalance()-amount;
		account.setBalance(total);
		Account savedAccount = accountRepository.save(account);
		return AccountMapper.maptoAccountDto(savedAccount);
		
	}

	@Override
	public List<AccountDto> getAllAccounts() {
		List<Account> accounts = accountRepository.findAll();
		return accounts.stream().map((account) -> AccountMapper.maptoAccountDto(account))
												.collect(Collectors.toList());
		
	}

	@Override
	public void deleteAccount(Integer id) {
		Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
		accountRepository.deleteById(id);
	}

}
