package com.GagulaEyeClinic.model;

import com.GagulaEyeClinic.util.CrudUtil;
import com.GagulaEyeClinic.dto.UserSupplierDTO;
import com.GagulaEyeClinic.db.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserSupplierModel {

    public static boolean update(UserSupplierDTO userSupplierDTO) throws SQLException {
        String sql = "UPDATE supplier set name=?,address=?,nic=?,email=?,contactNum=? WHERE supId = ?";
        return CrudUtil.execute(sql,userSupplierDTO.getName(),userSupplierDTO.getAddress(),userSupplierDTO.getNic(), userSupplierDTO.getContactNum(),userSupplierDTO.getEmail(),userSupplierDTO.getSupId());
    }

    public static UserSupplierDTO search(String supId) throws SQLException {
        String sql = "SELECT * FROM supplier WHERE supId = ?";
        ResultSet resultSet = CrudUtil.execute(sql, supId);

        if (resultSet.next()) {
            UserSupplierDTO userSupplierDTO = new UserSupplierDTO(
                    resultSet.getString("supId"),
                    resultSet.getString("name"),
                    resultSet.getString("address"),
                    resultSet.getString("nic"),
                    resultSet.getString("email"),
                    resultSet.getString("contactNum")
            );
            return userSupplierDTO;
        }
        return null;
    }

    public static boolean remove(String supId) throws SQLException {
        String sql = "DELETE FROM supplier WHERE supId = ?";
        return CrudUtil.execute(sql,supId);
    }

    public static List<UserSupplierDTO> getAll() throws SQLException {
        String sql = "SELECT * FROM supplier";
        ResultSet resultSet = CrudUtil.execute(sql);
        List<UserSupplierDTO> data = new ArrayList<>();
        while (resultSet.next()) {
            UserSupplierDTO userSupplierDTO = new UserSupplierDTO(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6)
            );
            data.add(userSupplierDTO);
        }
        return data;
    }

    public static boolean save(UserSupplierDTO userSupplierDTO) throws SQLException {
        String sql = "INSERT INTO supplier(supId,name,address,nic,email,contactNum) VALUES(?,?,?,?,?,?)";

        return CrudUtil.execute(sql, userSupplierDTO.getSupId(), userSupplierDTO.getName(), userSupplierDTO.getAddress(), userSupplierDTO.getNic(),userSupplierDTO.getEmail(), userSupplierDTO.getContactNum());

    }

    public static List<String> getAllSupplierIDs() throws SQLException {
        List<String> supplierIDs = new ArrayList<>();

        String sqlQuery = "SELECT supId FROM supplier";

        try {
            // Execute the SQL query and get the results
            ResultSet resultSet = CrudUtil.execute(sqlQuery);

            while (resultSet.next()) {
                String supplierID = resultSet.getString("supId");
                supplierIDs.add(supplierID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return supplierIDs;

    }
}





