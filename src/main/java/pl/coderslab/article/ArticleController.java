package pl.coderslab.article;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.author.Author;
import pl.coderslab.author.AuthorRepository;
import pl.coderslab.category.Category;
import pl.coderslab.category.CategoryRepository;

import java.util.List;

@Controller
@RequestMapping("/article")

public class ArticleController {
    @Autowired
    ArticleRepository articleRepository;
    AuthorRepository authorRepository;
    CategoryRepository categoryRepository;

    public ArticleController(AuthorRepository authorRepository, CategoryRepository categoryRepository) {
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
    }

    @ModelAttribute("categoryList")
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    @ModelAttribute("authorsList")
    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getAllAuthors(Model model) {
        model.addAttribute("articlesList", articleRepository.findAll());
        return "article/articleList";
    }
}
