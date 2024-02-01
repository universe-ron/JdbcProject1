package com.ronwu.springbootdemo.dao;
import com.ronwu.springbootdemo.dto.DataRequest;
import com.ronwu.springbootdemo.model.Data;

import java.util.List;

public interface DataDao {
    Data getDataById(Integer id);
    Integer createData(DataRequest dataRequest);
//    List<Data> getData(DataQueryParams dataQueryParams);
    void updateData(Integer id, DataRequest productRequest);
    void deleteDataById(Integer productId);
}
