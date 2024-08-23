package com.springpro.jpa.Repository;

import com.springpro.jpa.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsById(Integer id);
}
