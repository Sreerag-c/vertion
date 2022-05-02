package com.ayata.ayatamart.service.serviceimpl;

import com.ayata.ayatamart.authentication.RandomToken;
import com.ayata.ayatamart.dto.response.UserResponse;
import com.ayata.ayatamart.dto.response.UserRoleResponse;
import com.ayata.ayatamart.model.Role;
import com.ayata.ayatamart.model.Token;
import com.ayata.ayatamart.model.User;
import com.ayata.ayatamart.model.UserRole;
import com.ayata.ayatamart.repository.AuthRepository;
import com.ayata.ayatamart.repository.RoleRepository;
import com.ayata.ayatamart.repository.UserRepository;
import com.ayata.ayatamart.repository.UserRoleRepository;
import com.ayata.ayatamart.service.UserService;
import com.ayata.ayatamart.timestamp.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

import static com.ayata.ayatamart.dto.constant.Status.FAILURE;
import static com.ayata.ayatamart.dto.constant.Status.SUCCESS;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthRepository authRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Autowired
    RoleRepository roleRepository;



    public UserResponse currentLoginStatus(User user) {
        UserResponse userResponse = new UserResponse();
        RandomToken randomtoken = new RandomToken();
        DateTime datetime = new DateTime();

        Optional<User> loggedUser = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (!loggedUser.isPresent()) {
            userResponse.setStatus(FAILURE);
            userResponse.setToken(null);
            return userResponse;
        }
        String random = randomtoken.generatedToken();
        long timestamp = datetime.timeStamp();

        authRepository.save(Token.builder()
                .token(random)
                .employeeId(loggedUser.get().getEmployeeId())
                .timestamp(timestamp)
                .build());
        int employeeId=loggedUser.get().getEmployeeId();
        Optional<UserRole> optionalUserRoleRepository = userRoleRepository.findByEmployeeId(employeeId);
        Optional<Role> optionalRole = roleRepository.findByRoleId(optionalUserRoleRepository.get().getRoleId());
        userResponse.setRole(optionalRole.get().getRole());
        userResponse.setStatus(SUCCESS);
        userResponse.setEmployeeName(loggedUser.get().getEmployeeName());
        userResponse.setToken(random);
        return userResponse;

    }

    public UserRoleResponse isValidUser(String token) {
       UserRoleResponse  userRoleResponse= new UserRoleResponse();
        Optional<Token> authToken = authRepository.selectByToken(token);
        if (authToken.isPresent()) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            long currentTimeStamp = timestamp.toInstant().toEpochMilli();
            long expireAt = authToken.get().getTimestamp();
            if (currentTimeStamp < expireAt) {
                userRoleResponse.setEmployeeId(authToken.get().getEmployeeId());
                Optional<UserRole> optionalUserRoleRepository = userRoleRepository.findByEmployeeId(userRoleResponse.getEmployeeId());
              Optional<Role>  optionalRole = roleRepository.findByRoleId(optionalUserRoleRepository.get().getRoleId());
                userRoleResponse.setRole(optionalRole.get().getRole());

            }
            return userRoleResponse;
        }else {
            return null;
        }

    }
}
