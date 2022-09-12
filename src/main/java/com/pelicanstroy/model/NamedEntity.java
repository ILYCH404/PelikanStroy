package com.pelicanstroy.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public abstract class NamedEntity extends BaseEntity {

    @NotBlank
    @Size(min = 2, max = 100)
    @Column(name = "firstName", nullable = false)
    protected String firstName;

    @NotBlank
    @Size(min = 2, max = 100)
    @Column(name = "middleName", nullable = false)
    protected String middleName;

    @NotBlank
    @Size(min = 2, max = 100)
    @Column(name = "lastName")
    protected String lastName;

    public NamedEntity(Integer id, String firstName, String middleName, String lastName) {
        super(id);
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return super.toString() + "[" + firstName + " " + middleName + " " + lastName + "]";
     }
}
