package pl.coderslab.article;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
//@Query("select a from Article a order by a.created desc")
//List<Article> getFirstFive();





}
