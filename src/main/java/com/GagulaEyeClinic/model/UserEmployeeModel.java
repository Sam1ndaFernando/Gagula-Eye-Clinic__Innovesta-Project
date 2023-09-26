package com.GagulaEyeClinic.model;


import com.GagulaEyeClinic.dto.UserPatientDTO;
import com.GagulaEyeClinic.dto.UserRawMaterialDTO;
import com.GagulaEyeClinic.util.CrudUtil;
import com.GagulaEyeClinic.dto.UserEmployeeDTO;
import com.GagulaEyeClinic.db.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserEmployeeModel {


    public static boolean save(UserEmployeeDTO userEmployeeDTO) throws SQLException {
        String sql = "INSERT INTO employee(empId,name,address,contactNum,jobRole,joinedDate) VALUES(?,?,?,?,?,?)";

        boolean isSaved = CrudUtil.execute(sql, userEmployeeDTO.getEmpId(), userEmployeeDTO.getName(), userEmployeeDTO.getAddress(), userEmployeeDTO.getContactNum(), userEmployeeDTO.getJobRole(), userEmployeeDTO.getJoinedDate());
        return isSaved;
    }


    public static UserEmployeeDTO search(String empId) throws SQLException {
        try {
            String sql = "SELECT * FROM employee WHERE empId = ?";
            ResultSet resultSet = CrudUtil.execute(sql, empId);

            if (resultSet.next()) {
                UserEmployeeDTO userEmployeeDTO = new UserEmployeeDTO();
                userEmployeeDTO.setEmpId(resultSet.getString("empId"));
                userEmployeeDTO.setName(resultSet.getString("name"));
                userEmployeeDTO.setAddress(resultSet.getString("address"));
                userEmployeeDTO.setJobRole(resultSet.getString("jobRole"));
                userEmployeeDTO.setContactNum(resultSet.getString("contactNum"));
                userEmployeeDTO.setJoinedDate(String.valueOf(resultSet.getDate("joinedDate")));

                return userEmployeeDTO;
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace(); // Log the exception for debugging purposes
            throw new RuntimeException("Error while searching for employee by empId: " + empId, e);
        }
    }


    public static boolean update(UserEmployeeDTO userEmployeeDTO) throws SQLException {
        String sql = "UPDATE employee SET name=?, address=?, contactNum=?, jobRole=?, joinedDate=? WHERE empId=?";
        return CrudUtil.execute(sql, userEmployeeDTO.getName(), userEmployeeDTO.getAddress(), userEmployeeDTO.getContactNum(), userEmployeeDTO.getJobRole(), userEmployeeDTO.getJoinedDate(),userEmployeeDTO.getEmpId());
    }

    public static boolean remove(String empId) throws SQLException {
        String sql = "DELETE FROM employee WHERE empId = ?";
        return CrudUtil.execute(sql,empId);
    }

    public static List<UserEmployeeDTO> getAll() throws SQLException {
        String sql = "SELECT * FROM employee";
        ResultSet resultSet = CrudUtil.execute(sql);
        List<UserEmployeeDTO> data = new ArrayList<>();
        while (resultSet.next()) {
            UserEmployeeDTO userEmployeeDTO = new UserEmployeeDTO(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6)
            );
            data.add(userEmployeeDTO);
        }
        return data;
    }


}
