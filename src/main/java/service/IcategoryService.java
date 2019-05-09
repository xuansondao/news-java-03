package service;

import model.CategoryModel;

import java.util.List;

public interface IcategoryService {
    List<CategoryModel> findAll();
}
