package com.example.springapi.repository;

import com.example.springapi.models.User;
import com.example.springapi.service.AppUer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<AppUer> findByEmail(String email);
}
