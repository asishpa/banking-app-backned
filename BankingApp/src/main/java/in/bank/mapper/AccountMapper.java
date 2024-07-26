package in.bank.mapper;

import in.bank.dto.AccountDto;
import in.bank.entity.Account;

public class AccountMapper{
	public static Account mapToAccount(AccountDto accountDto) {
		Account account = new Account(
				accountDto.getAccId(),
				accountDto.getAccName(),
				accountDto.getBalance()
			);
			return account;
	}
	public static AccountDto maptoAccountDto(Account account) {
		AccountDto accountDto = new AccountDto(
					account.getAccId(),
					account.getAccName(),
					account.getBalance()
			);
		return accountDto;
		
	}

}
