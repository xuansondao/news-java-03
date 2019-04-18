package service.impl;

import dao.IRoleDAO;
import dao.impl.RoleDaoImpl;
import model.RoleModel;
import service.IRoleService;

public class RoleServiceImpl implements IRoleService {

    private IRoleDAO roleDAO;

    public RoleServiceImpl(){
       this.roleDAO = new RoleDaoImpl();
   }

    @Override
    public RoleModel findRoleById(long id) {
        return roleDAO.findRoleById(id);
    }
}
