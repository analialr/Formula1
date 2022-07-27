package com.ironhack.edgeservice.repository;

import com.ironhack.edgeservice.model.Follow;
import com.ironhack.edgeservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Long> {
    Optional<Follow> findByUserAndDriver(User user, String driver);

    //@Query(value = "DELETE * FROM follow f WHERE f.id = ?1")
    void deleteById(Long id);
}