package com.douane.security;

import java.util.*;

import javax.faces.bean.ManagedProperty;

import com.douane.entite.Useri;
import com.douane.metier.user.UserMetier;
import com.douane.model.UserRole;
import com.douane.requesthttp.RequestFilter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.douane.entite.Agent;
import com.douane.metier.user.IUserMetier;

@Service("customAuthenticationProvider")
@Transactional
public class CustomAuthenticationProvider implements AuthenticationProvider {
    private Logger log = Logger.getLogger(this.getClass().getName());

    @ManagedProperty(value="#{usermetier}")
    @Autowired
    private IUserMetier usermetier;


    /*@ManagedProperty(value="#{usermetier}")
    @Autowired
    private IUserMetier usermetierimpl;*/

    static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String immatriculation = authentication.getName();
        String password = authentication.getCredentials().toString();
        //Agent user = null;
        Agent user = usermetier.findAgentByIm(Long.parseLong(immatriculation));
        user.setIp("IP default");

        //RequestFilter.getSession().setAttribute("agent",usermetier.findAgentByIm(Long.parseLong(immatriculation)));
        RequestFilter.getSession().setAttribute("agent",user);


        if (user == null) {
            log.info("username not found " + immatriculation);
            throw new SecurityExecption("user " + immatriculation + " tidak ditemukan");
        }

        if (!passwordEncoder.matches(password, user.getPassword())) {
            log.info("invalid passpord for " + immatriculation);
            throw new BadCredentialsException("tidak berhasil login dengan user " + immatriculation);
        }
        /*
        * List<GrantedAuthority> authorities =
                    buildUserAuthority(user.getUserRole());

            return buildUserForAuthentication(user, authorities);
        * */
        List<GrantedAuthority> authorities =
                buildUserAuthority(user.getRoleAgent());
        //Collection<? extends GrantedAuthority> authorities =  getAuthorities();


        return new UsernamePasswordAuthenticationToken(immatriculation, password, authorities);

    }


    //MANAGE LOGIN
    private User buildUserForAuthentication(com.douane.model.User user,
                                            List<GrantedAuthority> authorities) {
        return new User(user.getUsername(), user.getPassword(),
                user.isEnabled(), true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Useri userRoles) {

        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        // Build user's authorities
        setAuths.add(new SimpleGrantedAuthority(userRoles.getRole()));


        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

        return Result;
    }



    public boolean supports(Class<?> authentication) {
        // TODO Auto-generated method stub
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authList = getGrantedAuthorities("ROLE_ADMIN");
        return authList;
    }
    public static List<GrantedAuthority> getGrantedAuthorities(String role) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();


        authorities.add(new SimpleGrantedAuthority(role));

        return authorities;
    }

}
