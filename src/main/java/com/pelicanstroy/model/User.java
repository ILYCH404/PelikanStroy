package com.pelicanstroy.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@ToString(callSuper = true, exclude = {"password"})
public class User extends NamedEntity {
    @Column(name = "phone", nullable = false)
    @Size(max = 11)
    @NotBlank
    private String phone;
    @Column(name = "email", nullable = false)
    @Size(max = 100)
    @NotBlank
    private String email;
    @Column(name = "password", nullable = false)
    @NotBlank
    @Size(min = 5, max = 100)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @Column(name = "enabled", nullable = false, columnDefinition = "bool default true")
    private boolean enabled = true;
    @Column(name = "registered", nullable = false, columnDefinition = "timestamp default now()", updatable = false)
    @NotNull
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date registered = new Date();

    @OneToMany
    @JoinColumn(name = "user_id")//создает колонку user_id в таблице с заявками
    private List<Statement> statementList;

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "role"}, name = "uk_user_roles"))
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Role> roles;

    public User(User u) {
        this(u.id, u.firstName, u.middleName, u.lastName, u.phone, u.email, u.password, u.enabled, u.registered, u.roles);
    }

    public User(Integer id, String firstName, String middleName, String lastName, String phone, String email, String password, boolean enabled, Date registred, Role role, Role... roles) {
        this(id, firstName, middleName, lastName, phone, email, password, enabled, registred, EnumSet.of(role, roles));
    }

    public User(Integer id, String firstName, String middleName, String lastName, String phone, String email, String password, boolean enabled, Date registered, Set<Role> roles) {
        super(id, firstName, middleName, lastName);
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.registered = registered;
        setRoles(roles);
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = CollectionUtils.isEmpty(roles) ? EnumSet.noneOf(Role.class) : EnumSet.copyOf(roles);
    }
}
