package it.ternali.biblioteca.security.service;

import it.ternali.biblioteca.security.data.UserData;
import it.ternali.biblioteca.security.exception.UserAlreadyExistException;
import it.ternali.biblioteca.security.entity.CustomUserDetail;
import it.ternali.biblioteca.security.entity.User;
import it.ternali.biblioteca.security.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomDetailsService implements UserDetailsService{

    @Autowired
    private UserRepository testUserRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public void register(UserData user) {
        if (checkExist(user.getEmail())) {
            throw new UserAlreadyExistException("User already exist");
        } else {
            User user1 = new User();
            BeanUtils.copyProperties(user, user1);
            cryptPassword(user1, user);
            testUserRepository.save(user1);
        }
    }

    public boolean checkExist(String email) {
        return testUserRepository.findByEmail(email) != null;
    }

    private void cryptPassword(User testUser, UserData testUserData) {
        testUser.setPassword(passwordEncoder.encode(testUserData.getPassword()));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User testUser = testUserRepository.findTestUserByUsername(username);
        if(testUser==null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetail(testUser);
    }

}
