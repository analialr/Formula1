package com.ironhack.f1dataserver.repository;

import com.ironhack.f1dataserver.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DriverRepository extends JpaRepository<Driver, String> {
}


