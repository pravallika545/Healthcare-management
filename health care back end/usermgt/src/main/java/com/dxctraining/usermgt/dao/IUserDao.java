package com.dxctraining.usermgt.dao;

import com.dxctraining.usermgt.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserDao extends JpaRepository<User,Integer> {

    User findByUsername(String username) ;
}
