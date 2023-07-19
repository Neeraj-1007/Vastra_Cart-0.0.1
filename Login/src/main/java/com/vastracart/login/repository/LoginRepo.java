package com.vastracart.login.repository;

import com.vastracart.login.Entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepo extends JpaRepository<Login,Long> {
}
