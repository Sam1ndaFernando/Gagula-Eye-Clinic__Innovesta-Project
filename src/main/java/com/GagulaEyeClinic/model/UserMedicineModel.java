package com.GagulaEyeClinic.model;

import com.GagulaEyeClinic.util.CrudUtil;
import com.GagulaEyeClinic.dto.UserMedicineDTO;
import com.GagulaEyeClinic.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserMedicineModel {
    public static boolean save(UserMedicineDTO UserMedicineDTO) throws SQLException {

        String sql = "INSERT INTO customer(medId,name,description) VALUES(?,?,?)";

        boolean isSaved = CrudUtil.execute(sql, UserMedicineDTO.getMedId(), UserMedicineDTO.getName(), UserMedicineDTO.getDescription());
        return isSaved;
    }
}
