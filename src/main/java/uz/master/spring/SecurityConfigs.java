package uz.master.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        jsr250Enabled = true,
        securedEnabled = true,
        prePostEnabled = true
)
public class SecurityConfigs extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final UserDetailService service;

    private static final String[] SecURL = {
            "/login", "/panel" , "/cabinet"
    };

    private static final String[] resources = {
            "/css/**", "/js/**" , "/images/**", "/file/**"
    };

    public SecurityConfigs(PasswordEncoder passwordEncoder, UserDetailService service) {
        this.passwordEncoder = passwordEncoder;
        this.service = service;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(expressionInterceptUrlRegistry -> expressionInterceptUrlRegistry
                        .antMatchers(SecURL).authenticated()
                        .anyRequest().permitAll())
                .formLogin(httpSecurityFormLoginConfigurer -> httpSecurityFormLoginConfigurer
                        .permitAll()
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .defaultSuccessUrl("/cabinet", true)
                )
                .rememberMe(httpSecurityRememberMeConfigurer -> httpSecurityRememberMeConfigurer
                        .key("bsiudbhdsfsdfsfsdhbf")
                        .rememberMeParameter("remember-me")
                        .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(40))
                ).logout(httpSecurityLogoutConfigurer -> httpSecurityLogoutConfigurer
                        .logoutUrl("/logout")
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout","GET"))
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .deleteCookies("JSESSIONID", "remember-me")
                );
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(service).passwordEncoder(passwordEncoder);
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(resources);
    }

    public PasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }
}
