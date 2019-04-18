package dao.impl;

import dao.IRoleDAO;
import mapper.RoleMapper;
import model.RoleModel;

import java.util.List;

public class RoleDaoImpl extends AbtractDAO<RoleModel> implements IRoleDAO {
    @Override
    public RoleModel findRoleById(long id) {
        String sql = "SELECT * FROM role WHERE roleid = ?";

        List<RoleModel> list = findByProperties(sql, new RoleMapper(), id);

        return list.isEmpty() ? null : list.get(0);
    }
}
