package com.flightbooking.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  // Ensure this annotation is present!
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}

