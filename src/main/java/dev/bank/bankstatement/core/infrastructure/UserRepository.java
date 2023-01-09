package dev.bank.bankstatement.core.infrastructure;

import dev.bank.bankstatement.core.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> { // JpaRepository는 Generic type이라 <>가 가능함
    // <>안에는 1. 반환 타입과, 2. 기본 key의 타입을 써주면 됨.
}
