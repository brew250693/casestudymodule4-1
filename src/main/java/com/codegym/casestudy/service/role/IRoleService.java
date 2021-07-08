package com.codegym.casestudy.service.role;

import com.codegym.casestudy.entity.AppRole;
import com.codegym.casestudy.service.IGeneralService;

public interface IRoleService extends IGeneralService<AppRole> {
    AppRole findByName(String name);
}
