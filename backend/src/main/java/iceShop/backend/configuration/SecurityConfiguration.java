// package iceShop.backend.configuration;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;
// import static org.springframework.security.config.Customizer.withDefaults;

// @Configuration
// @EnableMethodSecurity(securedEnabled = true)
// public class SecurityConfiguration {

//   @Bean
//   public PasswordEncoder passwordEncoder(){
//     return new BCryptPasswordEncoder();
//   }

//   @Bean
//   public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//     http
//       .cors(withDefaults())
//       .csrf(AbstractHttpConfigurer::disable)
//       .authorizeHttpRequests(
//         au -> au
//                 .requestMatchers("/", "/hello").permitAll()
//                 .anyRequest().authenticated()
//                 //.anyRequest().permitAll() 
//       )
//       .formLogin(withDefaults());;
//     return http.build();
//   }
// }
