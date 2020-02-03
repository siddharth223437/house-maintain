package com.house.maintain.housemaintain.service.security;

import com.house.maintain.housemaintain.vo.enums.RoleEnum;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class AuditAwareService implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return Optional.of(RoleEnum.HOUSEHOLD_MANAGE_APP.name());
        }
        String currentLoggedInUser = authentication.getName();
        return Optional.of(currentLoggedInUser);
    }
}
