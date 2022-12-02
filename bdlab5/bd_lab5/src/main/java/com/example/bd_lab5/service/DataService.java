package com.example.bd_lab5.service;

import com.example.bd_lab5.DTO.DataDTO;
import com.example.bd_lab5.domain.Data;
import com.example.bd_lab5.mapper.DataMapper;
import com.example.bd_lab5.repository.DataRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.List;


@AllArgsConstructor
@Service
public class DataService {

    private final DataRepository dataRepository;

    public List<Data> getAllData() {
        return dataRepository.findAll();
    }

    public Data getDataById(Integer id) {
        return dataRepository.findById(id).orElse(null);
    }

    public Data createData(DataDTO dataDTO) {
        return dataRepository.save(DataMapper.mapDTOToData(dataDTO));
    }

    public Data updateData(DataDTO dataDTO) {
        if (getDataById(dataDTO.getId()) != null) {
            return dataRepository.save(DataMapper.mapDTOToData(dataDTO));
        }
        return null;
    }

    public Data deleteDataById(Integer id) {
        Data data = getDataById(id);
        if (data != null) {
            dataRepository.deleteById(id);
            return data;
        }
        return null;
    }
}
