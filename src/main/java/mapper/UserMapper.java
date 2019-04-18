package mapper;

import model.UserModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<UserModel> {
    @Override
    public UserModel map(ResultSet rs) throws SQLException {
        UserModel user = new UserModel();
        user.setId(rs.getLong("id"));
        user.setUserName(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setFirstName(rs.getString("firstname"));
        user.setLastName(rs.getString("lastname"));
        user.setEmail(rs.getString("email"));
        user.setSex(rs.getInt("sex"));
        user.setRoleId(rs.getLong("roleid"));
        try {
            user.setCreatedDate(rs.getTimestamp("createddate"));

        } catch (SQLException e){
            return user;
        }

        return user;
    }
}
