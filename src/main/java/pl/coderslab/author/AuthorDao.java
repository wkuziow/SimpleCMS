package pl.coderslab.author;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.Dao;

import javax.transaction.Transactional;

@Repository
@Transactional
public class AuthorDao extends Dao {
}
