package com.exampleUserApplication.UserApplication.Repository;

import com.exampleUserApplication.UserApplication.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
