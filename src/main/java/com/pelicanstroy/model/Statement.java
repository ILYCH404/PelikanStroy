package com.pelicanstroy.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "statement")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@ToString
public class Statement extends BaseEntity {
    @Column(name = "text", nullable = false)
    @Size(min = 2, max = 1000)
    private String text;

    @Column(name = "create", nullable = false, columnDefinition = "timestamp default now()", updatable = false)
    @NotNull
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date create = new Date();

    public Statement(String text) {
        this.text = text;
    }

    public Statement(Integer id, String text) {
        super(id);
        this.text = text;
    }
}
