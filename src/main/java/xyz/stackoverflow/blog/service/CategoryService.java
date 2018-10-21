package xyz.stackoverflow.blog.service;

import xyz.stackoverflow.blog.pojo.entity.Category;
import xyz.stackoverflow.blog.util.PageParameter;

import java.util.List;

/**
 * @Author: 凉衫薄
 * @Date: 2018-10-21
 * @Description: 分类服务接口
 */
public interface CategoryService {

    Category insertCategory(Category category);

    boolean isExistName(String categoryName);

    boolean isExistCode(String categoryCode);

    boolean isExist(String id);

    int getCategoryCount();

    Category getCategoryByCode(String categoryCode);

    Category getCategoryById(String id);

    List<Category> getAllCategory();

    List<Category> getLimitCategory(PageParameter pageParameter);

    Category deleteCategoryById(String id);

    Category updateCategory(Category category);
}
