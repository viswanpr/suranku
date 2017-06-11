package com.suranku.users.dao;

import java.util.List;

import com.suranku.users.dao.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsersRepository extends JpaRepository<Users, Integer> {
    List<Users> findAllByOrderByDisplayOrder();
}
