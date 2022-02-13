package com.hruser;

import com.hruser.entitys.Users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long>{
    
    Users findByEmail(String email);
}