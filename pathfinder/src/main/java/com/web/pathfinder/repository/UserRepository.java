package com.web.pathfinder.repository;

import com.web.pathfinder.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String email);

    Optional<UserEntity> findByUsernameAndPassword(String username, String password);
}
