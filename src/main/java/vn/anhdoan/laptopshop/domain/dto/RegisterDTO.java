package vn.anhdoan.laptopshop.domain.dto;

import jakarta.validation.constraints.Email;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import vn.anhdoan.laptopshop.service.validator.RegisterChecked;
import vn.anhdoan.laptopshop.service.validator.StrongPassword;

@FieldDefaults(level = AccessLevel.PRIVATE)
@RegisterChecked
public class RegisterDTO {
    String firstName;
    String lastName;

    // @StrongPassword
    String password;

    @Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    String email;
    String confirmPassword;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

}
