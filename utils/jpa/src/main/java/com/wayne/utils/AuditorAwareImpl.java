package com.wayne.utils;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
//        return ofNullable(SecurityContextHolder.getContext().getAuthentication())
//                .map(Authentication::getPrincipal)
//                .filter(UserDetails.class::isInstance)
//                .map(UserDetails.class::cast)
//                .map(UserDetails::getUsername);
        return Optional.of("Wayne");
    }
}
