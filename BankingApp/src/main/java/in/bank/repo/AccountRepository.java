package in.bank.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.bank.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{
	

}
