package pl.coderslab.article;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.author.Author;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ArticleRepository extends JpaRepository<Article, Long> {

    Article findArticleById(long l);
    @Query("select a from Article a join fetch a.author join fetch a.categories where a.id = ?1")
    Article findByIdAndAuthorAndCategories(long l);
}
