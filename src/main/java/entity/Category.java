package entity;

/**
 * Created by employee on 7/21/16.
 */


import java.util.List;
import java.util.Set;


public class Category {
    private Integer categoryId;
    private String categoryName;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        return categoryName.equals(category.categoryName);

    }

    @Override
    public int hashCode() {
        return categoryName.hashCode();
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


}
