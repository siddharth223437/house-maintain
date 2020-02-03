package com.house.maintain.housemaintain.vo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "users")
public class UserVO extends Persistent implements UserDetails {


    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private LocalDate dateOfBirth;
    private String password;
    @ManyToMany(mappedBy = "userVO", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<RolesVO> rolesVO = new HashSet<>();
    @OneToOne(mappedBy = "userVO", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private AddressVO addressVO;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorityList = this.rolesVO.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName().name())).collect(Collectors.toList());
        return grantedAuthorityList;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<RolesVO> getRolesVO() {
        return rolesVO;
    }

    public void addRolesVO(RolesVO rolesVO) {
        this.rolesVO.add(rolesVO);
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public AddressVO getAddressVO() {
        return addressVO;
    }

    public void setAddressVO(AddressVO addressVO) {
        this.addressVO = addressVO;
    }
}
