package service.impl;

import dao.ICategoryDAO;
import dao.impl.CategoryDaoImpl;
import model.CategoryModel;
import service.IcategoryService;

import java.util.List;

public class CategoryService implements IcategoryService {
    private ICategoryDAO categoryDAO;

    public CategoryService(){
        this.categoryDAO = new CategoryDaoImpl();
    }

    @Override
    public List<CategoryModel> findAll() {
        return categoryDAO.findAll();
    }
}
