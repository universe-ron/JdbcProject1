package com.ronwu.springbootdemo.service.impl;

import com.ronwu.springbootdemo.dao.DataDao;
import com.ronwu.springbootdemo.dto.DataQueryParams;
import com.ronwu.springbootdemo.dto.DataRequest;
import com.ronwu.springbootdemo.model.Data;
import com.ronwu.springbootdemo.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataServiceImpl implements DataService {
//    @Override
//    public List<Data> getData(DataQueryParams dataQueryParams) {
//        return dataDao.getData(dataQueryParams);
//    }
    @Autowired
    private DataDao dataDao;
    @Override
    public Data getDataById(Integer id) {
        return dataDao.getDataById(id);
    }
    @Override
    public Integer createData(DataRequest dataRequest) {
        return dataDao.createData(dataRequest);
    }
    @Override
    public void updateData(Integer id, DataRequest dataRequest) {
        dataDao.updateData(id, dataRequest);
    }
    @Override
    public void deleteDataById(Integer id) {
        dataDao.deleteDataById(id);
    }
}
