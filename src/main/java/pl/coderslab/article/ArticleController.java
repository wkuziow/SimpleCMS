package pl.coderslab.article;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.author.Author;
import pl.coderslab.author.AuthorRepository;
import pl.coderslab.category.Category;
import pl.coderslab.category.CategoryRepository;

import java.awt.print.Book;
import java.time.LocalDateTime;
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

    @GetMapping("/delete/{id}")
    public String deleteArticle(@PathVariable Long id) {
        articleRepository.delete(articleRepository.findArticleById(id));
        return "redirect:../all";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addArticleGetForm(Model model) {
        model.addAttribute("article", new Article());
        return "article/addArticle";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addArticleProcessForm(@ModelAttribute Article article) {
        articleRepository.save(article);
        return "redirect:all";
    }

    @GetMapping("/update/{id}")
    public String updateArticleGet(@PathVariable Long id, Model model) {
        Article article = articleRepository.findByIdAndAuthorAndCategories(id);
        LocalDateTime created = article.getCreated();
        model.addAttribute("article", article);
        return "article/addArticle";
    }

    @PostMapping("/update/{id}")
    public String updateArticlePost(@PathVariable Long id, @ModelAttribute Article article) {
        LocalDateTime created = articleRepository.findByIdAndAuthorAndCategories(id).getCreated();
        article.setCreated(created);
        articleRepository.save(article);
        return "redirect:../all";
    }
}
