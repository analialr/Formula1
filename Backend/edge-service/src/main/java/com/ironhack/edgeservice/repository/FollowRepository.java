package com.ironhack.edgeservice.repository;

import com.ironhack.edgeservice.model.Follow;
import com.ironhack.edgeservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Long> {
    Optional<Follow> findByUserAndDriver(User user, String driver);

    //@Query("SELECT * FROM follow WHERE user_id")
    //Optional<Follow> findByUserAndDriverId();
}