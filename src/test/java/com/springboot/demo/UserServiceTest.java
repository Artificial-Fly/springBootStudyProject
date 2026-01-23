package com.springboot.demo;

import com.springboot.demo.repository.User;
import com.springboot.demo.repository.UserRepository;
import com.springboot.demo.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserService userService;
    @Test
    void createUserTest(){
        Long userId = 1L;
        User user = new User(userId,"John Doe", "jd@mail.com", LocalDate.now(),0);

        when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.empty());
        when(userRepository.save(user)).thenReturn(user);

        Optional<User> result = Optional.ofNullable(userService.create(user));

        Assertions.assertNotNull(result);
        //Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(user, result.get());

    }
}
