package com.darshana.userservice.repositories;

import com.darshana.userservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Override
    <S extends User> S save(S entity);
    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);
}
