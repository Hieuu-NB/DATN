package com.example.authorizationservice.service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Component("userDetailsService")
@Service
public class UserDetailsCustom implements UserDetailsService {
    private final PasswordEncoder passwordEncoder;

    public UserDetailsCustom(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // lấy tk, mk ở db ra để set vào
        String pw = this.passwordEncoder.encode("123456");
        return new User(
                "hieu2002",
                pw,// mật khẩu này là 123456 đã mã hóa, rồi spring sẽ check cái mk truyền vào với thằng này
                // mật khẩu truyền vào là "123456" , việc so sánh spring làm =))
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))
        );
    }


}
