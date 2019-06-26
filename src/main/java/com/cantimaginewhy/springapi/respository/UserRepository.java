package com.cantimaginewhy.springapi.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cantimaginewhy.springapi.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {}
