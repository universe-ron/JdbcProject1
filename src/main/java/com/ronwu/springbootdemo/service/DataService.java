package com.ronwu.springbootdemo.service;
import com.ronwu.springbootdemo.dto.DataQueryParams;
import com.ronwu.springbootdemo.dto.DataRequest;
import com.ronwu.springbootdemo.model.Data;

import java.util.List;

public interface DataService {
//    List<Data> getData(DataQueryParams dataQueryParams);
    Data getDataById(Integer id);
    Integer createData(DataRequest dataRequest);
    void updateData(Integer id, DataRequest dataRequest);
    void deleteDataById(Integer id);
}
