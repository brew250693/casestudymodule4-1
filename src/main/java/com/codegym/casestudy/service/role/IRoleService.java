package com.codegym.casestudy.service.role;

import com.codegym.casestudy.entity.Role;
import com.codegym.casestudy.service.IGeneralService;

public interface IRoleService extends IGeneralService<Role> {
    Role findByName(String name);
}
