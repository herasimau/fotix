package com.fotix.api.service;

import com.fotix.api.dto.UserDTO;
import com.fotix.api.entities.authority.Authority;
import com.fotix.api.entities.authority.AuthorityName;
import com.fotix.api.entities.group.Group;
import com.fotix.api.entities.group.GroupName;
import com.fotix.api.entities.user.User;
import com.fotix.api.entities.verification.VerificationToken;
import com.fotix.api.repository.AuthorityRepository;
import com.fotix.api.repository.GroupsRepository;
import com.fotix.api.repository.UserRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by herasimau on 26/09/16.
 */
@Service
public class UserRegistrationService {

    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private GroupsRepository groupsRepository;

    private List<Authority> authorities;
    private List<Group> groups;

    @PostConstruct
    public void init(){
        this.authorities = Lists.newArrayList(authorityRepository.findAll())
                .stream().filter(e-> e.getName().equals(AuthorityName.ROLE_USER))
                .collect(Collectors.toList());

        this.groups = Lists.newArrayList(groupsRepository.findAll());
    }

    public User createAndSaveUser(UserDTO user){
        User newUser = new User();
        List<Group> groups = filterGroup(GroupName.valueOf(user.getUserGroup().toUpperCase()));
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setEmail(user.getEmail());
        newUser.setUsername(user.getUsername());
        newUser.setGroups(groups);
        newUser.setAuthorities(authorities);
        newUser.setRegisterDate(LocalDateTime.now());
        newUser.setEnabled(false);
        newUser.setLastPasswordResetDate(LocalDateTime.now());
        newUser.setLastOnlineDate(LocalDateTime.now());
        saveUserAsync(newUser);
        return newUser;
    }

    @Async
    public void saveUserAsync(User user){
        userRepository.save(user);
    }

    public  boolean canRegister(UserDTO user){

        if(usernameExists(user.getUsername())||emailExists(user.getEmail())){
            return false;
        }
        else if(!isGroup(user.getUserGroup())){
            return false;
        }
        return true;

    }

    public List<Group> filterGroup(GroupName name){
        return groups.stream().filter(e->e.getName().equals(name))
                .collect(Collectors.toList());
    }

    public  boolean usernameExists(String username){

       return userRepository.findByUsername(username).isPresent();

    }
    public  boolean emailExists(String email){
        return userRepository.findByEmail(email).isPresent();

    }

    public  boolean isGroup(String group){

        for (GroupName g : GroupName.values()) {
            if (g.name().equalsIgnoreCase(group)) {
                return true;
            }
        }
        return false;
    }

    @Async
    public void confirmUser(Optional<VerificationToken> verificationToken) {
      verificationToken.ifPresent(t->{
          Optional<User>  user = userRepository.findById(t.getUser().getId());
          user.ifPresent(u-> u.setEnabled(true));
          userRepository.save(user.get());
      });
    }
}
