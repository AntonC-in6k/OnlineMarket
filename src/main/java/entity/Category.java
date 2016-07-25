package entity;

/**
 * Created by employee on 7/21/16.
 */
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Categories")
public class Category {

    private Integer categoryId;
    private String categoryName;
    @OneToMany(targetEntity=Item.class, mappedBy="Category", fetch=FetchType.EAGER)
    private List<Item> items;

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

    @Id
    @GeneratedValue
    @Column(name="CategoryId", unique = true, nullable = false)
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Column(name="CategoryName")
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}
