package com.pelicanstroy.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class NamedEntity extends BaseEntity {

    @NotBlank
    @Size(min = 2, max = 100)
    @Column(name = "fullName", nullable = false)
    protected String fullName;

    public NamedEntity(Integer id, String fullName) {
        super(id);
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return super.toString() + "[" + fullName + "]";
     }
}
