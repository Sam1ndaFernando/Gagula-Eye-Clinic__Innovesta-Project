package com.GagulaEyeClinic.dto;


import lombok.*;

import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString


public class UserAppoinmentDTO {
    private String appId;
    private String date;
    private String time;
    private String purpose;
    private String docid;
    private String patId;


    public UserAppoinmentDTO(String appId, String date, String purpose, String docId, String patId) {
    }


}
