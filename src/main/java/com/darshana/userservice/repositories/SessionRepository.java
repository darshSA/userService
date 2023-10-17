package com.darshana.userservice.repositories;

import com.darshana.userservice.models.Session;
import com.darshana.userservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
    @Override
    <S extends Session> S save(S entity);

    Optional<Session> findByTokenAndUser_Id(String token, Long userId);
}
