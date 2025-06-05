package com.alam.Airbnb.Entity;

import com.alam.Airbnb.Enums.Gender;
import com.alam.Airbnb.Enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @Column(unique = true,nullable = false)
    private String email;

    @Transient  // Not stored in the database (temporary field)
    @Size(min = 8, message = "Password must be at least 8 characters")
    private String rawPassword;  // For validation before encoding

    @Column(nullable = false)
    private String Password;  // Actual stored hashed password

    @NotBlank(message = "Name cannot be blank")
    @Pattern(regexp = "^[a-zA-Z ]*$", message = "Name should contain only letters")
    private String name;

    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ElementCollection(fetch = FetchType.EAGER) //JPA will create new table
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Guest> guests = new ArrayList<>();
    //==================================OVERRIDED METHODS============================================

    // Converts the user's roles into Spring Security's GrantedAuthority objects
    // Required by UserDetails interface to determine what permissions the user has

    @Override
    public Collection<? extends  GrantedAuthority> getAuthorities(){
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_"+role.name()))
                .collect(Collectors.toSet());
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User user)) return false;
        return Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}