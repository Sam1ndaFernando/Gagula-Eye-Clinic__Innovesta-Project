package com.GagulaEyeClinic.model;

import com.GagulaEyeClinic.dto.UserAppoinmentDTO;
import com.GagulaEyeClinic.util.CrudUtil;

import java.sql.SQLException;

public class UserAppoinmetModel {

    public static boolean save(UserAppoinmentDTO UserAppoinmentDTO) throws SQLException {


        String sql = "INSERT INTO appoinment(appId,date,time,purpose,docId,patId) VALUES(?,?,?,?,?,?)";
        boolean isSaved = CrudUtil.execute(sql, UserAppoinmentDTO.getAppId(),UserAppoinmentDTO.getDate(),UserAppoinmentDTO.getTime(),UserAppoinmentDTO.getPurpose(),UserAppoinmentDTO.getDocid(),UserAppoinmentDTO.getPatId());
        return isSaved;
    }
}
