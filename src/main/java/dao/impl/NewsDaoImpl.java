package dao.impl;

import dao.INewsDAO;
import mapper.NewsMapper;
import model.NewsModel;

import java.util.List;

public class NewsDaoImpl extends AbtractDAO<NewsModel> implements INewsDAO {

    public void insertNews(NewsModel model) {
        String sql = "INSERT INTO news(title, shortDescription, content, createdBy, createdDate, thumbnail, status, categoryID) VALUES(?,?,?,?,?,?,?,?)";
        insert(
                sql, model.getTitle(),
                model.getShortDescription(), model.getContent(),
                model.getCreatedBy(), model.getCreatedDate(), model.getThumbnail(),
                model.getStatus(), model.getCategoryId()
        );
    }

    public void updateNews(Long id, NewsModel updateModel) {
        String sql = "UPDATE news\n" +
                "SET title            = ?,\n" +
                "    shortDescription = ?,\n" +
                "    content          = ?,\n" +
                "    createdBy        = ?,\n" +
                "    createdDate      = ?,\n" +
                "    modifiedBy       = ?,\n" +
                "    modifiedDate     = ?, \n" +
                "    thumbnail = ?,\n" +
                "    status = ?,\n" +
                "    categoryID = ?\n" +
                "WHERE id = ?";
        insert(
                sql, updateModel.getTitle(), updateModel.getShortDescription(),
                updateModel.getContent(), updateModel.getCreatedBy(), updateModel.getCreatedDate(),
                updateModel.getModifiedBy(), updateModel.getModifiedDate(), updateModel.getThumbnail(),
                updateModel.getStatus(), updateModel.getCategoryId(), id
        );
    }

    public List<NewsModel> getAll() {
        String sql = "SELECT * FROM news";
        return findByProperties(sql, new NewsMapper());
    }

    @Override
    public NewsModel findNewsById(Long id) {
        String sql = "SELECT * FROM news WHERE id = ?";
        List<NewsModel> newsModels = findByProperties(sql, new NewsMapper(), id);
        return newsModels.isEmpty() ? null : newsModels.get(0);
    }
}
