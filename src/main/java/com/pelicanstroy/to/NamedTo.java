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
    protected String fullName;

    public NamedTo(Integer id, String fullName) {
        super(id);
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "NamedTo{" +
                "name='" + fullName + '\'' +
                '}';
    }
}