package com.mycompany.webapp.security;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
   private static final Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);
   
   @Autowired
   private DataSource dataSource;
   @Autowired
   private UserDetailsService userDetailsService;
   
   @Override
   protected void configure(HttpSecurity http) throws Exception {
      //폼 인증을 비활성화
      http.httpBasic().disable();
      //서버 세션 비활성화
      http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
      //사이트간 요청 위조 방지 비활성화
      http.csrf().disable();
      //CORS 설정(다른 도메인에서 요청을 허가)
      http.cors();
      //JWT 인증 필터 추가
      http.addFilterBefore(new JwtAuthenticationFilter(userDetailsService), UsernamePasswordAuthenticationFilter.class);
      //요청 경로 권한 추가
      http.authorizeRequests()
         //권한 계층 설정
         .expressionHandler(securityExpressionHandler())
         //요청 경로 권한 설정
         
         //커뮤니티 qna
         .antMatchers(HttpMethod.GET, "/community/communityqna/*").hasAnyRole("ADMIN")
         .antMatchers(HttpMethod.POST, "/community/communityqna/*").hasAnyRole("ADMIN")
         .antMatchers(HttpMethod.PUT, "/community/communityqna/*").hasAnyRole("ADMIN")
         .antMatchers(HttpMethod.DELETE, "/community/communityqna/*").hasAnyRole("ADMIN")
         
         //공지사항
         .antMatchers(HttpMethod.GET, "/community/notice").hasAnyRole("ADMIN")
         .antMatchers(HttpMethod.POST, "/community/notice").hasAnyRole("ADMIN")
         .antMatchers(HttpMethod.PUT, "/community/notice").hasAnyRole("ADMIN")
         .antMatchers(HttpMethod.DELETE, "/community/notice/*").hasAnyRole("ADMIN")
         
         //그 외
         .antMatchers("/**").permitAll();
      
   }
   
   /*
       JDBC를 이용해 사용자 저장소를 만드는 방식
      auth.jdbcAuthentication().dataSource(dataSource)
   */
   @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.jdbcAuthentication()
           .dataSource(dataSource)
           .usersByUsernameQuery("select userid, upassword, uenabled from users where userid=?")
           .authoritiesByUsernameQuery("select userid, uauthority from users where userid=? and uauthority='ROLE_ADMIN'")

           .passwordEncoder(new BCryptPasswordEncoder());
   }
   
   //사용자의 상세 정보를 가져오는 서비스 객체를 관리 객체로 등록
   //JwtAuthentificationFilter에서 사용
   @Bean
   @Override
   public UserDetailsService userDetailsServiceBean() throws Exception {
      return super.userDetailsServiceBean();
   }
   
   //인증된 정보를 관리하는 객체를 Spring 관리 객체로 등록
   //AuthController에서 사용
   @Bean
   @Override
   public AuthenticationManager authenticationManagerBean() throws Exception {
      return super.authenticationManagerBean();
   }
   
   //권한 계층 설정
   public RoleHierarchyImpl roleHierarchyImpl() {
      RoleHierarchyImpl roleHierarchyImpl = new RoleHierarchyImpl();
      roleHierarchyImpl.setHierarchy("ROLE_ADMIN > ROLE_MANAGER > ROLE_USER");
      
      return roleHierarchyImpl;
   }
   
   //권한 계층 객체를 이용한 웹 시큐리티 처리 객체 생성
   public SecurityExpressionHandler<FilterInvocation> securityExpressionHandler(){
      DefaultWebSecurityExpressionHandler defaultWebSecurityExpressionHandler = new DefaultWebSecurityExpressionHandler();
        defaultWebSecurityExpressionHandler.setRoleHierarchy(roleHierarchyImpl());
        return defaultWebSecurityExpressionHandler;
   }
   
   //다른 도메인의 접근을 허용하는 객체를 Spring 관리 객체 등록
   @Bean
   public CorsConfigurationSource corsConfigurationSource() {
      CorsConfiguration configuration = new CorsConfiguration();
      //모든 요청 사이트 허용
      configuration.addAllowedOrigin("*");
      //모든 요청 방식 허용(GET, POST, PUT, DELETE...)
      configuration.addAllowedMethod("*");
      //모든 요청 헤더 허용
      configuration.addAllowedHeader("*");
      //요청 헤더의 Authorization을 이용해서 사용자 인증(로그인 처리)을 하지 않음
      configuration.setAllowCredentials(false);
      
      //모든 URL 요청에 대해서 위 내용을 적용
      UrlBasedCorsConfigurationSource ccs = new UrlBasedCorsConfigurationSource();
      ccs.registerCorsConfiguration("/**", configuration);
      
      return ccs;
   }
   
   
   
}





