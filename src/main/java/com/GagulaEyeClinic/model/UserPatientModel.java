package com.GagulaEyeClinic.model;

import com.GagulaEyeClinic.util.CrudUtil;
import com.GagulaEyeClinic.dto.UserPatientDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserPatientModel {
    public static boolean save(UserPatientDTO UserPatientDTO) throws SQLException {

        String sql = "INSERT INTO patient(patId,name,address,age,nic,contactNum,gender,docId) VALUES(?,?,?,?,?,?,?,?)";

        boolean isSaved = CrudUtil.execute(sql, UserPatientDTO.getPatId(), UserPatientDTO.getName(), UserPatientDTO.getAddress(),UserPatientDTO.getAge(),UserPatientDTO.getNic(), UserPatientDTO.getContactNum(), UserPatientDTO.getGender(),UserPatientDTO.getDocId());
        return isSaved;
    }

    public static UserPatientDTO search(String patId) throws SQLException {
        String sql = "SELECT * FROM patient where patId = ?";

        ResultSet resultSet = CrudUtil.execute(sql, patId);

        if (resultSet.next()) {
           UserPatientDTO userPatientDTO = new UserPatientDTO();


            userPatientDTO.setName(resultSet.getString(2));
            userPatientDTO.setAddress(resultSet.getString(3));
            userPatientDTO.setAge(resultSet.getInt(4));
            userPatientDTO.setNic(resultSet.getString(5));
            userPatientDTO.setContactNum(resultSet.getString(6));
            userPatientDTO.setGender(resultSet.getString(7));
            userPatientDTO.setDocId(resultSet.getString(8));


            return userPatientDTO;
        }
        return null;
    }

    public static boolean update(UserPatientDTO userPatientDTO) throws SQLException {
        String sql = "UPDATE patient set name=?,address=?,age=?,nic=?,contactNum=?,gender=?,docId=? WHERE patId = ?";
        return CrudUtil.execute(sql,userPatientDTO.getName(),userPatientDTO.getAddress(),userPatientDTO.getAge(),userPatientDTO.getNic(),userPatientDTO.getContactNum(),userPatientDTO.getGender(),userPatientDTO.getDocId(),userPatientDTO.getPatId());
    }

    public static boolean remove(String patId) throws SQLException {
        String sql = "DELETE FROM patient WHERE patId = ?";
        return CrudUtil.execute(sql,patId);
    }

    public static List<UserPatientDTO> getAll() throws SQLException {
        String sql = "SELECT * FROM patient";
        ResultSet resultSet = CrudUtil.execute(sql);
        List<UserPatientDTO> data = new ArrayList<>();
        while (resultSet.next()) {
            UserPatientDTO userPatientDTO = new UserPatientDTO(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getString(8)
            );
            data.add(userPatientDTO);
        }
        return data;
    }
}