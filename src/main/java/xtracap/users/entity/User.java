package xtracap.users.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user",schema = "public")
@Data
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 3, message = "Name must be at least 3 characters long")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Name must contain only alphabetic characters")
    private String name;

    @NotBlank(message = "Mobile number is mandatory")
    @Pattern(regexp = "^[56789]\\d{9}$", message = "Mobile number must be 10 digits and start with 5, 6, 7, 8, or 9")
    private String mobileNumber;

    @NotBlank(message = "Email ID is mandatory")
    @Email(message = "Invalid email format")
    @Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$", message = "Invalid email format")
    private String emailId;

    @NotBlank(message = "Father's name is mandatory")
    @Size(min = 3, message = "Father's name must be at least 3 characters long")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Father's name must contain only alphabetic characters")
    private String fathersName;

    @NotBlank(message = "PAN number is mandatory")
    @Pattern(regexp = "^[A-Z a-z]{5}[0-9]{4}[A-Z a-z]$", message = "Invalid PAN number format")
    private String panNumber;

}
