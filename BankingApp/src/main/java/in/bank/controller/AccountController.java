package in.bank.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.bank.dto.AccountDto;
import in.bank.entity.Account;
import in.bank.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	private AccountService accountService;
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	@PostMapping
	public ResponseEntity<AccountDto>addAccount(@RequestBody AccountDto accountDto){
		return new ResponseEntity<>(accountService.createAccount(accountDto),HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<AccountDto>findAccount(@PathVariable Integer id){
		return new ResponseEntity<>(accountService.getAccountById(id),HttpStatus.OK);
	}
	@PutMapping("/{id}/deposit")
	public ResponseEntity<AccountDto>deposit(@PathVariable Integer id,@RequestBody Map<String, Double> request){
		Double amount = request.get("amount");
		AccountDto accountDto = accountService.deposit(id, amount);
		return ResponseEntity.ok(accountDto);
	}
	@PutMapping("/{id}/withdraw")
	public ResponseEntity<AccountDto>withdraw(@PathVariable Integer id,@RequestBody Map<String, Double> request){
		Double amount = request.get("amount");
		AccountDto accountDto = accountService.withdrawal(id, amount);
		return ResponseEntity.ok(accountDto);
	}
	@GetMapping
	public ResponseEntity<List<AccountDto>> listAllAccounts() {
	    List<AccountDto> allAccounts = accountService.getAllAccounts();
	    return ResponseEntity.ok(allAccounts);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable Integer id){
		accountService.deleteAccount(id);
		return ResponseEntity.ok("Account deleted successfully");
		
	}
}
