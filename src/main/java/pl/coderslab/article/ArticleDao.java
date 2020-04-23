package pl.coderslab.article;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.Dao;

import javax.transaction.Transactional;

@Repository
@Transactional
public class ArticleDao extends Dao {
}
