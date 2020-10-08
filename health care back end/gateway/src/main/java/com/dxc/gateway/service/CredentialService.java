package com.dxc.gateway.service;

import com.dxc.gateway.entities.UserCredential;

public interface CredentialService {

    boolean checkCredentials(String username, String password);

    UserCredential findByUsername(String username);

    UserCredential save(UserCredential user);

    boolean isAdmin(String username);

}
