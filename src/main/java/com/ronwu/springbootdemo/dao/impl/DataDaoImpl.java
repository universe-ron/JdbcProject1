package com.ronwu.springbootdemo.dao.impl;
import com.ronwu.springbootdemo.dao.DataDao;
import com.ronwu.springbootdemo.dto.DataRequest;
import com.ronwu.springbootdemo.model.Data;
import com.ronwu.springbootdemo.rowmapper.DataRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DataDaoImpl implements DataDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
//    @Override
//    public List<Data> getData(DataQueryParams dataQueryParams) {
//        String sql = "SELECT id,farmnm_ch, tel, fax, pcode, county, township, address_ch, address_en, weburl, longitude, latitude, serveitem, facebook" +
//                "FROM data WHERE 1=1";
//        Map<String, Object> map = new HashMap<>();
//        //查詢條件
//        sql = addFilteringSql(sql,map,dataQueryParams);
//
//        //排序
//        sql = sql + " ORDER BY " + dataQueryParams.getOrderBy() + " " + dataQueryParams.getSort();
//
//        //分頁
//        sql = sql + " LIMIT :limit OFFSET :offset";
//        map.put("limit", dataQueryParams.getLimit());
//        map.put("offset", dataQueryParams.getOffset());
//
//        List<Data> dataList = namedParameterJdbcTemplate.query(sql, map, new DataRowMapper());
//
//        return dataList;
//    }
    @Override
    public Data getDataById(Integer id) {
        String sql = "SELECT id,farmnm_ch, tel, fax, pcode, county, township, address_ch, address_en, weburl, longitude, latitude, serveitem, facebook FROM data WHERE id = :id";
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);

        List<Data> dataList = namedParameterJdbcTemplate.query(sql, map, new DataRowMapper());
        if(dataList.size()>0){
            return dataList.get(0);
        }else{
            return null;
        }
    }

    @Override
    public Integer createData(DataRequest dataRequest) {
        String sql = "INSERT INTO data(farmnm_ch, tel, fax, pcode, county, township, address_ch, address_en, weburl, longitude, latitude, serveitem, facebook) VALUES (:farmnm_ch, :tel, :fax, :pcode, :county, :township, :address_ch, :address_en, :weburl, :longitude, :latitude, :serveitem, :facebook)";
        Map<String, Object> map = new HashMap<>();
        map.put("farmnm_ch",dataRequest.getFarmnm_ch());
        map.put("tel",dataRequest.getTel());
        map.put("fax",dataRequest.getFax());
        map.put("pcode",dataRequest.getPcode());
        map.put("county",dataRequest.getCounty());
        map.put("township",dataRequest.getTownship());
        map.put("address_ch",dataRequest.getAddress_ch());
        map.put("address_en",dataRequest.getAddress_en());
        map.put("weburl",dataRequest.getWeburl());
        map.put("longitude",dataRequest.getLongitude());
        map.put("latitude",dataRequest.getLatitude());
        map.put("serveitem",dataRequest.getServeitem());
        map.put("facebook",dataRequest.getFacebook());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map),keyHolder);
        int id = keyHolder.getKey().intValue();
        return id;
    }
    @Override
    public void updateData(Integer id, DataRequest dataRequest) {
        String sql = "UPDATE data SET farmnm_ch=:farmnm_ch,tel=:tel,fax=:fax, " +
                "pcode=:pcode,county=:county,township=:township,address_ch=:address_ch,address_en=:address_en," +
                "weburl=:weburl,longitude:=longitude,latitude:=latitude,serveitem=:serveitem,facebook=:facebook" +
                " WHERE id = :id";

        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("farmnm_ch",dataRequest.getFarmnm_ch());
        map.put("tel",dataRequest.getTel());
        map.put("fax",dataRequest.getFax());
        map.put("pcode",dataRequest.getPcode());
        map.put("county",dataRequest.getCounty());
        map.put("township",dataRequest.getTownship());
        map.put("address_ch",dataRequest.getAddress_ch());
        map.put("address_en",dataRequest.getAddress_en());
        map.put("weburl",dataRequest.getWeburl());
        map.put("longitude",dataRequest.getLongitude());
        map.put("latitude",dataRequest.getLatitude());
        map.put("serveitem",dataRequest.getServeitem());
        map.put("facebook",dataRequest.getFacebook());
        namedParameterJdbcTemplate.update(sql,map);
    }
    @Override
    public void deleteDataById(Integer id) {
        String sql = "DELETE FROM data WHERE id = :id";
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        namedParameterJdbcTemplate.update(sql,map);
    }
}
