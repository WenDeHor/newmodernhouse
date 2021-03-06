package com.example.newmodernhouse.service;

import com.example.newmodernhouse.forms.UserForm;
import com.example.newmodernhouse.models.Role;
import com.example.newmodernhouse.models.State;
import com.example.newmodernhouse.models.User;
import com.example.newmodernhouse.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class SignUpServiceImpl implements SignUpService {

    private final UserRepository usersRepository;

    private final PasswordEncoder passwordEncoder;

    public SignUpServiceImpl(UserRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void signUp(UserForm userForm) {
        String hashPassword = passwordEncoder.encode(userForm.getPassword());

        User user = User.builder()
                .password(hashPassword)
                .login(userForm.getLogin())
                .email(userForm.getEmail())
                .role(Role.USER)
                .state(State.ACTIVE)
                .build();
        usersRepository.save(user);
    }
//    @Override
//    public void signUp(User newuser) {
//        String hashPassword = passwordEncoder.encode(newuser.getPassword());
//
//        User user = User.builder()
//                .password(hashPassword)
//                .login(newuser.getLogin())
//                .email(newuser.getEmail())
//                .role(Role.USER)
//                .state(State.ACTIVE)
//                .build();
//        usersRepository.save(user);
//    }
}
