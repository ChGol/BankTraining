package com.training.chgol.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.training.chgol.entity.User;

public interface UsersRepository extends JpaRepository<User, Long> {

    User getByLogin(String login);

}
