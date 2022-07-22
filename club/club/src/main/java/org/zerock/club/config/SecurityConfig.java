package org.zerock.club.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Log4j2
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //특정 URL 접근제한 (permitAll : 모든사용자에게 허락)
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/sample/all").permitAll()
                .antMatchers("/sample/member").hasRole("USER");
        
        http.formLogin(); // 인가/인증에 문제시 로그인 화면
        http.csrf().disable(); //csrf 토근 비활성화
        http.oauth2Login();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        //사종가 계정은 user1
//        auth.inMemoryAuthentication().withUser("user1")
//        //1111 패스워드 인코딩 결과
//                .password("$2a$10$CtnGTM6HymPqPUaLc0zpVeQC9fbp/EoKktn9iQVLqEwI1zVvA7vPu")
//                .roles("USER");
//    }
}
