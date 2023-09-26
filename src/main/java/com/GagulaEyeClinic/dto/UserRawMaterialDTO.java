package com.GagulaEyeClinic.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString


public class UserRawMaterialDTO {
    private String rawId;
    private String name;
    private int qty;
    private String category;
    private String supId;

}
