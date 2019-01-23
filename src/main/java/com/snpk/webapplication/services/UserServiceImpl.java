package com.snpk.webapplication.services;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.snpk.webapplication.model.Privilege;
import com.snpk.webapplication.model.Role;
import com.snpk.webapplication.model.User;
import com.snpk.webapplication.repository.PrivilegeRepository;
import com.snpk.webapplication.repository.RoleRepository;
import com.snpk.webapplication.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PrivilegeRepository privilegeRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        Role userRole = roleRepository.findByRole("USER");
        Set<Privilege> userPrivs = new HashSet<Privilege>(Arrays.asList(privilegeRepository.findByName("WRITE"), privilegeRepository.findByName("READ")));
        userRole.setPrivileges(userPrivs);
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
