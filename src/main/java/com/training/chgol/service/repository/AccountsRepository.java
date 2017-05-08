package com.training.chgol.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.training.chgol.entity.Account;

public interface AccountsRepository extends JpaRepository<Account, Long>, AccountsRepositoryCustom {
}
