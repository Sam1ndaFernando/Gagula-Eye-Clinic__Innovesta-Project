package com.GagulaEyeClinic.model;

import com.GagulaEyeClinic.dto.DocPatientDTO;
import com.GagulaEyeClinic.dto.UserPatientDTO;
import com.GagulaEyeClinic.dto.UserSupplierDTO;
import com.GagulaEyeClinic.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DocPatientModel {

    public static DocPatientDTO search(String patId) throws SQLException {
        String sql = "SELECT * FROM patient where patId = ?";

        ResultSet resultSet = CrudUtil.execute(sql, patId);

        if (resultSet.next()) {
            DocPatientDTO docPatientDTO = new DocPatientDTO();
            docPatientDTO.setPatId(resultSet.getString(1));
            docPatientDTO.setName(resultSet.getString(2));
            docPatientDTO.setAddress(resultSet.getString(3));
            docPatientDTO.setAge(resultSet.getInt(4));
            docPatientDTO.setNic(resultSet.getString(5));
            docPatientDTO.setContactNum(resultSet.getString(6));
            docPatientDTO.setGender(resultSet.getString(7));

            return docPatientDTO;
        }
        return null;
    }
}
