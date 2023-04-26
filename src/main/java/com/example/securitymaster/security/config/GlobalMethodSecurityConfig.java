package com.example.securitymaster.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.RoleHierarchyVoter;
import org.springframework.security.authorization.AuthorityAuthorizationManager;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class GlobalMethodSecurityConfig extends GlobalMethodSecurityConfiguration {
    @Autowired
    private RoleHierarchy roleHierarchy;

    @Override
    protected AccessDecisionManager accessDecisionManager() {
        AffirmativeBased affirmativeBased=(AffirmativeBased) super.accessDecisionManager();
        affirmativeBased.getDecisionVoters().add(new RoleHierarchyVoter(roleHierarchy));
        return affirmativeBased;
    }
}
