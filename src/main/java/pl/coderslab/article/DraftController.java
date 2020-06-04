package pl.coderslab.article;

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

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/article/draft")
public class DraftController {

    @Autowired
    ArticleRepository articleRepository;
    AuthorRepository authorRepository;
    CategoryRepository categoryRepository;

    public DraftController(AuthorRepository authorRepository, CategoryRepository categoryRepository) {
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
    public String deleteDraft(@PathVariable Long id) {
        articleRepository.delete(articleRepository.findArticleById(id));
        return "redirect:../all";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addDraftGetForm(Model model) {
        model.addAttribute("article", new Article());
        return "article/addArticle";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addDraftProcessForm(@ModelAttribute @Validated(DraftValidationGroup.class) Article article,
                                        BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "article/addArticle";
        }
        article.setDraft(true);
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
    public String updateArticlePost(@PathVariable Long id, @ModelAttribute @Validated(DraftValidationGroup.class) Article article,
                                    BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "article/addArticle";
        }

        LocalDateTime created = articleRepository.findByIdAndAuthorAndCategories(id).getCreated();
        article.setCreated(created);
        article.setDraft(true);
        articleRepository.save(article);
        return "redirect:../all";
    }
}
