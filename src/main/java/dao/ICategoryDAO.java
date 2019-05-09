package dao;

import model.CategoryModel;

import java.util.List;

public interface ICategoryDAO extends IGenericDAO<CategoryModel> {

    List<CategoryModel> findAll();
}
