package com.pelicanstroy.to;

import com.pelicanstroy.util.validation.NoHtml;
import lombok.Data;
import lombok.EqualsAndHashCode;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@EqualsAndHashCode(callSuper = true)
public class NamedTo extends BaseTo {
    @NotBlank
    @Size(min = 2, max = 100)
    @NoHtml
    protected String firstName;

    @NotBlank
    @Size(min = 2, max = 100)
    @NoHtml
    protected String middleName;

    @NotBlank
    @Size(min = 2, max = 100)
    @NoHtml
    protected String lastName;

    public NamedTo(Integer id, String firstName, String middleName, String lastName) {
        super(id);
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "NamedTo{" +
                "name='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}