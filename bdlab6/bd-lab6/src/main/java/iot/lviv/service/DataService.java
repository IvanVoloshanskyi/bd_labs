package iot.lviv.service;

import iot.lviv.domain.DataEntity;

import java.math.BigDecimal;

public interface DataService extends GeneralService<DataEntity, Integer>{
    BigDecimal CalcMinTemperature();
}
