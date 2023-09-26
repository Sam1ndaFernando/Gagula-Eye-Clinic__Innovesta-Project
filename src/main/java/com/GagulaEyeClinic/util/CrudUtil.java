package com.GagulaEyeClinic.util;

import com.GagulaEyeClinic.db.DBConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CrudUtil {
    public static <T> T execute(String sql,Object...args) throws SQLException {
        PreparedStatement pstm= null;
        try {
            pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < args.length;i++) {
            pstm.setObject((i+1),(args[i]));
        }

        if(sql.startsWith("SELECT") || sql.startsWith("select")){
            return(T) pstm.executeQuery();
        }
        return(T)(Boolean)(pstm.executeUpdate()>0);

    }


}
