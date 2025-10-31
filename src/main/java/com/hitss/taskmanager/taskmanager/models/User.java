package com.hitss.taskmanager.taskmanager.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name="users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)
    @NotBlank
    @Size(min=3,max=200)
    //@ExistByUsername
    private String username;

    @NotBlank
    @JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
    private String password;

    
    public User() {
    }
    
    public List<Role> getRoles() {
        return roles;
    }

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany
    @JoinTable(
        name="user_roles"
        ,joinColumns=@JoinColumn(name="user_id")
        ,inverseJoinColumns=@JoinColumn(name="role_id")
        ,uniqueConstraints=@UniqueConstraint(columnNames={"user_id","role_id"})
        )
        private List<Role> roles = new ArrayList<>();
        
        
        @jakarta.persistence.Transient
        private boolean admin;

        private boolean enabled;
        @PrePersist
        private void prePersist(){
            enabled=true;
        }

}
