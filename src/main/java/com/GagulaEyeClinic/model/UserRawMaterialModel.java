package com.GagulaEyeClinic.model;

import com.GagulaEyeClinic.dto.UserRawMaterialDTO;
import com.GagulaEyeClinic.util.CrudUtil;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserRawMaterialModel{
    public static boolean save(UserRawMaterialDTO UserRawMaterialDTO) throws SQLException {

        String sql = "INSERT INTO rawMaterial(rawId,name,qty,category,supId) VALUES(?,?,?,?,?)";

        boolean isSaved = CrudUtil.execute(sql, UserRawMaterialDTO.getRawId(),UserRawMaterialDTO.getName(),UserRawMaterialDTO.getQty(),UserRawMaterialDTO.getCategory(),UserRawMaterialDTO.getSupId());
        return isSaved;
    }

    public static UserRawMaterialDTO search(String rawId) throws SQLException {
        String sql = "SELECT * FROM rawMaterial where rawId = ?";

        ResultSet resultSet = CrudUtil.execute(sql, rawId);

        if (resultSet.next()){
            UserRawMaterialDTO userRawMaterialDTO= new UserRawMaterialDTO();
            userRawMaterialDTO.setRawId(resultSet.getString(1));
            userRawMaterialDTO.setName(resultSet.getString(2));
            userRawMaterialDTO.setQty(resultSet.getInt(3));
            userRawMaterialDTO.setCategory(resultSet.getString(4));
            userRawMaterialDTO.setSupId(resultSet.getString(5));

            return userRawMaterialDTO;
        }
        return null;
    }

    public static boolean update(UserRawMaterialDTO userRawMaterialDTO) throws SQLException {
        String sql = "UPDATE rawMaterial SET name=?, qty=?, category=?, supId=? WHERE rawId=?";
        return CrudUtil.execute(sql,userRawMaterialDTO.getName(),userRawMaterialDTO.getQty(),userRawMaterialDTO.getCategory(),userRawMaterialDTO.getSupId(),userRawMaterialDTO.getRawId());

    }


    public static boolean remove(String rawId) throws SQLException {
        String sql = "DELETE FROM rawMaterial WHERE rawId = ?";
        return CrudUtil.execute(sql,rawId);
    }

    public static List<UserRawMaterialDTO> getAll() throws SQLException {
        String sql = "SELECT * FROM rawMaterial";
        ResultSet resultSet = CrudUtil.execute(sql);
        List<UserRawMaterialDTO> data = new ArrayList<>();
        while (resultSet.next()) {
            UserRawMaterialDTO userRawMaterialDTO = new UserRawMaterialDTO(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getString(4),
                    resultSet.getString(5)

            );
            data.add(userRawMaterialDTO);
        }
        return data;
    }

}

