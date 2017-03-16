package ru.relex.practice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import ru.relex.practice.enumeration.LogCategory;
import ru.relex.practice.service.LoggingService;

import java.util.Base64;

/**
 * Провайдер для аутентификации пользователя
 */
public class PracticeAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    private static final String NO_USER_EXISTS_STRING = Base64.getEncoder().encodeToString("noUserPresentedString".getBytes());
    private final PasswordEncoder passwordEncoder = new PracticePasswordEncoder();
    private final UserDetailsService userDetailsService;

    @Autowired
    private LoggingService loggingService;

    @Autowired
    PracticeAuthenticationProvider(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken token) throws AuthenticationException {

        if (token.getCredentials() == null) {
            this.logger.debug("Authentication failed: no credentials provided");
            throw new BadCredentialsException(this.messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"));
        } else {
            String presentedPassword = token.getCredentials().toString();
            if (!this.passwordEncoder.matches(presentedPassword, userDetails.getPassword())) {
                this.logger.debug("Authentication failed: password does not match stored value");
                throw new BadCredentialsException(this.messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"));
            }
        }
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken token) throws AuthenticationException {
        UserDetails loadedUser;
        try {
            loadedUser = this.getUserDetailsService().loadUserByUsername(username);
        } catch (UsernameNotFoundException var6) {
            // Всё равно хэшируем фейковые данные
            if (token.getCredentials() != null) {
                String presentedPassword = token.getCredentials().toString();
                this.passwordEncoder.matches(presentedPassword, NO_USER_EXISTS_STRING);
            }
            throw var6;
        } catch (Exception var7) {
            throw new InternalAuthenticationServiceException(var7.getMessage(), var7);
        }

        if (loadedUser == null) {
            throw new InternalAuthenticationServiceException("UserDetailsService returned null, which is an interface contract violation");
        } else {
            return loadedUser;
        }
    }

    public UserDetailsService getUserDetailsService() {
        return userDetailsService;
    }

    @Override
    @Transactional
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Authentication successAuth = super.authenticate(authentication);
        loggingService.logEvent(LogCategory.LOGIN, ((PracticeUser) successAuth.getPrincipal()).getCurrentUser(), null);
        logger.info("User " + successAuth.getName() + " successfully authenticated!");
        return successAuth;
    }
}
