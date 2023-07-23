package vastracart.category.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.persistence.*;

@Entity
@Table(name="SubCategory")
public class SubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="SUB_CATEGORY_ID",nullable = false,unique = true)
    private Long subCategoryId;

    @Column(name="SUB_CATEGORY_NAME",length = 150,nullable = false,unique = true)
    private String subCategoryName;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="CATEGORY_ID",nullable = false)
    @JsonBackReference
    private Category category;

    public Long getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(Long subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "SubCategory{" +
                "subCategoryId=" + subCategoryId +
                ", subCategoryName='" + subCategoryName + '\'' +
                ", category=" + category +
                '}';
    }
}
