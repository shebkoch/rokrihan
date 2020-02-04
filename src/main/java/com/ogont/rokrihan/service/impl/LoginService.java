package com.ogont.rokrihan.service.impl;

import com.ogont.rokrihan.model.player.LoginUser;
import com.ogont.rokrihan.model.player.PlayerEntity;
import com.ogont.rokrihan.model.util.Key;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.security.auth.login.LoginException;
import java.util.HashSet;
import java.util.Set;

@Component
public class LoginService {
    public static final String USER_ROLE = "USER_ROLE";

    @Resource
    private PlayerService playerService;
    @Resource
    private KeyService keyService;

    public void registerUser(LoginUser user) throws LoginException {
        Key key = keyService.getFirstByKey(user.getKey());
        if(key.getCount() == 0) throw new LoginException(String.format("key %s has expired", key.getKey()));

        key.setCount(key.getCount()-1);
        PlayerEntity playerEntity = new PlayerEntity(user.getLogin(), user.getPassword());
        playerService.save(playerEntity);
        keyService.save(key);
    }


    public void autoLogin(String username, String password) {
        UserDetails userDetails = loadUserByUsername(username);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());

//        authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        if (usernamePasswordAuthenticationToken.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }
    }

    public UserDetails loadUserByUsername(String username) {
        PlayerEntity player = playerService.getByName(username);
        if (player == null) throw new UsernameNotFoundException(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(USER_ROLE));


        return new org.springframework.security.core.userdetails.User(player.getName(), player.getPassword(), grantedAuthorities);
    }
}
