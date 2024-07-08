package com.vvsk.ecommerce.ecommerceapi.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.vvsk.ecommerce.ecommerceapi.entity.UserEntity;
import com.vvsk.ecommerce.ecommerceapi.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class LoginServiceTest {

    @Mock
    UserRepository userRepository;

    @Mock
    BCryptPasswordEncoder encoder;

    @Mock
    JwtTokenService tokenService;

    @InjectMocks
    LoginService loginService;


    @Test
    void testAuthenticate_Success() {
        // Given
        UserEntity userEntity = new UserEntity();
		userEntity.setId(1);
		userEntity.setName("siva");
		userEntity.setPassword("$2a$10$VWizXq9/uhlbTq8Qp8B72ORbQCAR7wbduTqMW2IkPe0SzkdDrHSre");
		userEntity.setRole("USER");
		
        Mockito.when(userRepository.findByName("siva")).thenReturn(List.of(userEntity));

        Mockito.when(encoder.matches(Mockito.anyString(),Mockito.anyString())).thenReturn(true);

        Mockito.when(tokenService.generateToken(Mockito.anyString(),Mockito.anyString())).thenReturn("MyAwesomeToken");

        // When
        String token = loginService.authenticate("siva", "mypassword");

        // Then
        Assertions.assertEquals("MyAwesomeToken", token);

    }
}
