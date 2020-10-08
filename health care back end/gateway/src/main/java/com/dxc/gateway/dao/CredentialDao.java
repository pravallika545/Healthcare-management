package com.dxc.gateway.dao;

import com.dxc.gateway.entities.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredentialDao extends JpaRepository<UserCredential,String> {

}
