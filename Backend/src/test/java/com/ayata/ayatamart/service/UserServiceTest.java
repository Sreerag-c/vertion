package com.ayata.ayatamart.service;

import com.ayata.ayatamart.dto.constant.Status;
import com.ayata.ayatamart.dto.response.UserResponse;
import com.ayata.ayatamart.model.Role;
import com.ayata.ayatamart.model.Token;
import com.ayata.ayatamart.model.User;
import com.ayata.ayatamart.model.UserRole;
import com.ayata.ayatamart.repository.AuthRepository;
import com.ayata.ayatamart.repository.RoleRepository;
import com.ayata.ayatamart.repository.UserRepository;
import com.ayata.ayatamart.repository.UserRoleRepository;
import com.ayata.ayatamart.service.serviceimpl.UserServiceImpl;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.util.ReflectionTestUtils;

import java.sql.Timestamp;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserServiceTest {
    @Autowired
    private UserService userService;
    @MockBean
    private UserRepository userRepository;
    @MockBean
    private AuthRepository authRepository;
    @MockBean
    private UserRoleRepository userRoleRepository;
    @MockBean
    private RoleRepository roleRepository;


    @BeforeEach
    public void beforeEach() {
        userRepository = Mockito.mock(UserRepository.class);
        authRepository = Mockito.mock(AuthRepository.class);
        userRoleRepository = Mockito.mock(UserRoleRepository.class);
        roleRepository = Mockito.mock(RoleRepository.class);
        userService = new UserServiceImpl();
        ReflectionTestUtils.setField(userService, "userRepository", userRepository);
        ReflectionTestUtils.setField(userService, "authRepository", authRepository);
        ReflectionTestUtils.setField(userService,"userRoleRepository",userRoleRepository);
        ReflectionTestUtils.setField(userService,"roleRepository",roleRepository);
    }

    @Test
    void currentLoginStatus() {
        User user = new User("sreerag.c@ayatacommerce.com", "123");
        UserRole userRole = new UserRole(0,123,1);
        Role role = new Role(1,"user");
        Optional<User> opUser = Optional.of(user);
        Optional<UserRole> opUserRole = Optional.of(userRole);
        Optional<Role> opRole = Optional.of(role);
//        Mockito.when(userRepository.findByUsernameAndPassword(Mockito.anyString(), Mockito.anyString()))
//                .thenReturn(opUser);
        Mockito.doReturn(opUser).when(userRepository).findByUsernameAndPassword(Mockito.anyString(), Mockito.anyString());
        Mockito.doReturn(opUserRole).when(userRoleRepository).findByEmployeeId(Mockito.anyInt());
        Mockito.doReturn(opRole).when(roleRepository).findByRoleId(Mockito.anyInt());
        UserResponse userResponse = userService.currentLoginStatus(user);
        assertEquals(userResponse.status, Status.SUCCESS);
    }

    @Test
    public void currentLoginStatusNegativeTest() {
        User user = new User("sreeragc@ayatacommerce.com", "123");
        UserResponse userResponse = userService.currentLoginStatus(user);
        assertEquals(userResponse.status, Status.FAILURE);
    }

    @Test
    public void isValidUserTest() {
        Optional<Token> token = Optional
                .of(new Token(1, "abcdefghij", new Timestamp(System.currentTimeMillis()).toInstant().toEpochMilli()));
        Mockito.when(authRepository.selectByToken(Mockito.anyString())).thenReturn(token);
        userService.isValidUser("abcdefghij");
    }
}