package in.bank.service;

import java.util.List;

import in.bank.dto.AccountDto;

public interface AccountService {
	AccountDto createAccount(AccountDto accountDto);
	AccountDto getAccountById(Integer id);
	AccountDto deposit(Integer id,Double amount);
	AccountDto withdrawal(Integer id,Double amount);
	List<AccountDto> getAllAccounts();
	void deleteAccount(Integer id);
}
