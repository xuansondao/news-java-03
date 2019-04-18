package dao;

import model.RoleModel;

public interface IRoleDAO extends IGenericDAO<RoleModel>{
    RoleModel findRoleById(long id);
}
