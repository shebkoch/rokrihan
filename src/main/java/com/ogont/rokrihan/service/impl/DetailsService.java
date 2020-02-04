package com.ogont.rokrihan.service.impl;

import com.ogont.rokrihan.model.player.PlayerEntity;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class DetailsService implements UserDetailsService {

    @Resource
    PlayerService playerService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        PlayerEntity player = playerService.getByName(username);
        if (player == null){
            throw new UsernameNotFoundException(username + " was not found");
        }
        return new org.springframework.security.core.userdetails.User(
                player.getName(),
                player.getPassword(),
                AuthorityUtils.createAuthorityList("ROLE_USER")
        );
    }
}
