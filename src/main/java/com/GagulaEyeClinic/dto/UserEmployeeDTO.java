package com.GagulaEyeClinic.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class UserEmployeeDTO {
    private String empId;
    private String name;
    private String address;
    private String jobRole;
    private String contactNum;
    private String joinedDate;

}
