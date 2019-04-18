package dao.impl;

import dao.IUserDAO;
import mapper.UserMapper;
import model.UserModel;

import java.util.List;

public class UserDaoImpl extends AbtractDAO<UserModel> implements IUserDAO {
    @Override
    public UserModel findUserByUserNameAndPassword(String userName, String password) {
        String sql = "SELECT * FROM user Where username = ? AND password = ?";
        List<UserModel> userModels = findByProperties(sql, new UserMapper(), userName, password);
        return userModels.isEmpty() ? null : userModels.get(0);
    }
}
