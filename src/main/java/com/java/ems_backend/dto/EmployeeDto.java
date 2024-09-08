package com.java.ems_backend.dto;


import lombok.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class EmployeeDto {

    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String mobileNumber;
    private String dateofbirth;
    private String gender;
    private String country;
    private String picture;
}
