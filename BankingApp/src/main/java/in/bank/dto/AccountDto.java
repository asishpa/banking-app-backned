package in.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDto {
	private Integer accId;
	private String accName;
	private Double balance;
}
