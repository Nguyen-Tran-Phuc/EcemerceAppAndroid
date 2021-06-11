package hcmute.edu.vn.id18110339.DTO;

import hcmute.edu.vn.id18110339.DAO.CategoryDAO;

public class CategoryDTO {
    int Category_Id;
    String CategoryName;

    public CategoryDTO(){ }
    public CategoryDTO(String categoryName) {
        CategoryName = categoryName;
    }

    public int getCategory_Id() {
        return Category_Id;
    }

    public void setCategory_Id(int category_Id) {
        Category_Id = category_Id;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }
}
