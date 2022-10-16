package com.fortlom.account.application.service;
import com.fortlom.account.domain.UserAggregate.entity.UserAccount;
import com.fortlom.account.domain.UserAggregate.service.UserAccountService;
import com.fortlom.account.domain.UserAggregate.valueobject.PrincipalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsImpl implements UserDetailsService{


    @Autowired
    UserAccountService userAccountService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserAccount>value=userAccountService.getbyNombreUsuarioOrEmail(username);
        if (value.isPresent()){
            return PrincipalUser.build(value.get());
        }
        throw new UsernameNotFoundException("Error");
    }
}
