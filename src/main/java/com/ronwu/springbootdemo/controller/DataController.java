package com.ronwu.springbootdemo.controller;

import com.ronwu.springbootdemo.dto.DataRequest;
import com.ronwu.springbootdemo.model.Data;
import com.ronwu.springbootdemo.service.DataService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DataController {

    @Autowired
    private DataService dataService;

    @GetMapping("/data/{id}")
    public ResponseEntity<Data> getData(@PathVariable Integer id){
        Data data = dataService.getDataById(id);
        if(data!=null){
            return ResponseEntity.status(HttpStatus.OK).body(data);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PostMapping("/data")
    public ResponseEntity<Data> createData(@RequestBody @Valid DataRequest dataRequest){
        Integer id = dataService.createData(dataRequest);
        Data data = dataService.getDataById(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(data);
    }
    @PutMapping("/data/{id}")
    public ResponseEntity<Data> updateData(@PathVariable Integer id,
                                           @RequestBody @Valid DataRequest dataRequest){
        Data data = dataService.getDataById(id);
        if(data == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        dataService.updateData(id,dataRequest);

        Data updatedData = dataService.getDataById(id);
        return ResponseEntity.status(HttpStatus.OK).body(updatedData);
    }

    @DeleteMapping("/data/{id}")
    public ResponseEntity<?> deleteData(@PathVariable Integer id){
        dataService.deleteDataById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
