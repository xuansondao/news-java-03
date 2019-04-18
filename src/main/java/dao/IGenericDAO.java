package dao;

import dao.impl.AbtractDAO;
import mapper.RowMapper;

import java.util.List;

public interface IGenericDAO<T extends Object> {

    static <T1> T1 getInstance(Class<T1> tClass) throws IllegalAccessException, InstantiationException {
        return tClass.newInstance();
    }

    void insert(String sql, Object...parameters);

    void update(String sql, Object...parameters);

    List<T> findByProperties(String sql, RowMapper<T> mapper, Object...parameters);
}
