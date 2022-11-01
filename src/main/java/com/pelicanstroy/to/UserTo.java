package com.pelicanstroy.to;

import com.pelicanstroy.HasIdAndEmail;
import com.pelicanstroy.util.validation.NoHtml;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Value
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UserTo extends NamedTo implements HasIdAndEmail {

    @Size(max = 11)
    @NotBlank
    String phone;

    @Email
    @NotBlank
    @Size(max = 100)
    @NoHtml
    String email;

    @NotBlank
    @Size(min = 5, max = 32)
    String password;

    public UserTo(Integer id, String fullName, String phone,  String email, String password) {
        super(id, fullName);
        this.phone = phone;
        this.email = email;
        this.password = password;
    }
}
