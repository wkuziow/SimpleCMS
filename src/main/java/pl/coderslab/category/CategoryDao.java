package pl.coderslab.category;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.Dao;

import javax.transaction.Transactional;

@Repository
@Transactional
public class CategoryDao extends Dao {
}
