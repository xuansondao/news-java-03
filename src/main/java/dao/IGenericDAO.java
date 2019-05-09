package dao;

import dao.impl.AbtractDAO;
import mapper.RowMapper;

import java.util.List;

public interface IGenericDAO<T extends Object> {

    void insert(String sql, Object...parameters);

    void update(String sql, Object...parameters);

    List<T> findByProperties(String sql, RowMapper<T> mapper, Object...parameters);

    long countAll(String sql, Object...parameters);
}
