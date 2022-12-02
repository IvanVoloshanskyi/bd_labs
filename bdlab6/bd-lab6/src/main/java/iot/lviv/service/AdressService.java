package iot.lviv.service;

import iot.lviv.domain.AdressEntity;

public interface AdressService extends GeneralService<AdressEntity, Integer> {
    void insertTenAdress(String adress, String street, String build);
}
