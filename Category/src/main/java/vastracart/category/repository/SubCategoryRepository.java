package vastracart.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vastracart.category.entity.SubCategory;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory,Long> {
}
