package dao.impl;

import dao.ICategoryDAO;
import mapper.CategoryMapper;
import model.CategoryModel;

import java.util.List;

public class CategoryDaoImpl extends AbtractDAO<CategoryModel> implements ICategoryDAO {

    @Override
    public List<CategoryModel> findAll() {
        String  sql = "SELECT * FROM category";
        return findByProperties(sql, new CategoryMapper());
    }
}
