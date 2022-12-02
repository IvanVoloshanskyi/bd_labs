package iot.lviv.service;

import iot.lviv.domain.DeveloperEntity;

public interface DeveloperService extends GeneralService<DeveloperEntity, Integer>{
    void createTablesWithCursor();
}
