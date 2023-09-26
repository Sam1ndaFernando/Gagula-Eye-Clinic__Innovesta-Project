package com.GagulaEyeClinic.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class DocPatientDTO {
    private String patId;
    private String name;
    private String address;
    private Integer age;
    private String nic;
    private String contactNum;
    private String gender;
}
