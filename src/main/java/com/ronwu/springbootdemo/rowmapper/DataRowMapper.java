package com.ronwu.springbootdemo.rowmapper;


import com.ronwu.springbootdemo.model.Data;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DataRowMapper implements RowMapper<Data> {
    @Override
    public Data mapRow(ResultSet rs, int rowNum) throws SQLException {
        Data data = new Data();
        data.setId((rs.getInt("id")));
        data.setFarmnm_ch(rs.getString("farmnm_ch"));
        data.setTel(rs.getString("tel"));
        data.setFax(rs.getString("fax"));
        data.setPcode(rs.getString("pcode"));
        data.setCounty(rs.getString("county"));
        data.setTownship(rs.getString("township"));
        data.setAddress_ch(rs.getString("address_ch"));
        data.setAddress_en(rs.getString("address_en"));
        data.setWeburl(rs.getString("weburl"));
        data.setLongitude(rs.getFloat("longitude"));
        data.setLatitude(rs.getFloat("latitude"));
        data.setServeitem(rs.getString("serveitem"));
        data.setFacebook(rs.getString("facebook"));

        return data;
    }
}
