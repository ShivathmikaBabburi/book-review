package com.book_management.book_management.security;


import com.book_management.book_management.security.jwt.AuthEntryPointJwt;
import com.book_management.book_management.security.jwt.AuthTokenFilter;
import com.book_management.book_management.security.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Set;


@Configuration
@EnableWebSecurity
//@EnableMethodSecurity
public class WebSecurityConfig {
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;
    //@Autowired
    //private RoleRepository roleRepository;

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }


    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedHandler))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers("/api/auth/**").permitAll()
                                .requestMatchers("/v3/api-docs/**").permitAll()
                                //.requestMatchers("/api/admin/**").permitAll()
                                //.requestMatchers("/api/public/**").permitAll()
                                .requestMatchers("/swagger-ui/**").permitAll()
                                .requestMatchers("/api/test/**").permitAll()
                                .requestMatchers("/images/**").permitAll()
                                .requestMatchers("/h2-console/**").permitAll()
                                .anyRequest().authenticated()
                );

        http.authenticationProvider(authenticationProvider());

        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        http.headers(headers->headers.frameOptions(frameOptions->frameOptions.sameOrigin()));

        return http.build();
    }
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web -> web.ignoring().requestMatchers("/v2/api-docs",
                "/configuration/ui",
                "/swagger-resources/**",
                "/configuration/security",
                "/swagger-ui.html",
                "/webjars/**"));
    }


//    @Bean
//    public CommandLineRunner initData(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
//        return args -> {
//            // Retrieve or create roles
//            Role userRole = roleRepository.findByRoleName(AppRole.ROLE_USER)
//                    .orElseGet(() -> {
//                        Role newUserRole = new Role(AppRole.ROLE_USER);
//                        return roleRepository.save(newUserRole);
//                    });
//
//            Role sellerRole = roleRepository.findByRoleName(AppRole.ROLE_SELLER)
//                    .orElseGet(() -> {
//                        Role newSellerRole = new Role(AppRole.ROLE_SELLER);
//                        return roleRepository.save(newSellerRole);
//                    });
//
//            Role adminRole = roleRepository.findByRoleName(AppRole.ROLE_ADMIN)
//                    .orElseGet(() -> {
//                        Role newAdminRole = new Role(AppRole.ROLE_ADMIN);
//                        return roleRepository.save(newAdminRole);
//                    });
//
//            Set<Role> userRoles = Set.of(userRole);
//            Set<Role> sellerRoles = Set.of(sellerRole);
//            Set<Role> adminRoles = Set.of(userRole, sellerRole, adminRole);
//
//
//            // Create users if not already present
//            if (!userRepository.existsByUserName("user1")) {
//                User user1 = new User("user1", "user1@example.com", passwordEncoder.encode("password1"));
//                userRepository.save(user1);
//            }
//
//            if (!userRepository.existsByUserName("seller1")) {
//                User seller1 = new User("seller1", "seller1@example.com", passwordEncoder.encode("password2"));
//                userRepository.save(seller1);
//            }
//
//            if (!userRepository.existsByUserName("admin")) {
//                User admin = new User("admin", "admin@example.com", passwordEncoder.encode("adminPass"));
//                userRepository.save(admin);
//            }
//
//            // Update roles for existing users
//            userRepository.findByUserName("user1").ifPresent(user -> {
//                user.setRoles(userRoles);
//                userRepository.save(user);
//            });
//
//            userRepository.findByUserName("seller1").ifPresent(seller -> {
//                seller.setRoles(sellerRoles);
//                userRepository.save(seller);
//            });
//
//            userRepository.findByUserName("admin").ifPresent(admin -> {
//                admin.setRoles(adminRoles);
//                userRepository.save(admin);
//            });
//        };
//    }
}