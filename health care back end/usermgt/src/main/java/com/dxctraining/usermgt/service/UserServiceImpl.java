package com.dxctraining.usermgt.service;

import com.dxctraining.usermgt.dao.IUserDao;
import com.dxctraining.usermgt.entities.User;
import com.dxctraining.usermgt.exceptions.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
    private IUserDao customerDao;

    public IUserDao getCustomerDao() {
        return customerDao;
    }

    @Autowired
    public void setCustomerDao(IUserDao dao) {
        this.customerDao = dao;
    }

    @Override
    public User findById(int id) {
        Optional<User> optional = customerDao.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new CustomerNotFoundException("customer not found for id=" + id);
    }

    @Override
    public User findByUsername(String username) {
        User user = customerDao.findByUsername(username);
        return user;
    }

    @Override
    public List<User> fetchAll() {
        List<User> users = customerDao.findAll();
        return users;
    }

    @Override
    public User save(User user) {
        user = customerDao.save(user);
        return user;
    }

    @Override
    public boolean credentialsCorrect(int id, String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }
        User user = findById(id);
        if (user == null) {
            return false;
        }
        boolean passwordEquals = user.getPassword().equals(password);
        return passwordEquals;
    }


    @Override
    public void remove(int id) {
        customerDao.deleteById(id);
    }
}
