package com.ayata.ayatamart.repository;

import com.ayata.ayatamart.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepository extends JpaRepository<Token, Integer> {

    @Query("SELECT t FROM Token t WHERE token = (:token)")
    public Optional<Token> selectByToken(String token);
}