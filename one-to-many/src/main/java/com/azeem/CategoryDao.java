package com.azeem;

import com.azeem.entity.CategoriesEntity;

public interface CategoryDao {


    void saveCategory(CategoriesEntity categoriesEntity);

    CategoriesEntity fetchCtegory(Integer categoryId);

    void removeCategory(Integer categoryId);


}
