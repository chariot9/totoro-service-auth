package com.chariot.totoro.service;

import com.chariot.totoro.domain.User;
import com.chariot.totoro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * Created by Trung Vu on 2018/03/28.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    /**
     * Generate new hash as a new password and store user with username and password to DB.
     *
     * @param user
     */
    @Override
    public void createUser(User user) {
        User existingUser = userRepository.findOne(user.getUsername());

        Assert.isNull(existingUser, "User already exists: " + user.getUsername());

        String hash = encoder.encode(user.getPassword());
        user.setPassword(hash);
        userRepository.save(user);
    }
}
