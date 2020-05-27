package pl.coderslab.home;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.article.Article;
import pl.coderslab.article.ArticleRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class HomePageController {
    @Autowired
    private final ArticleRepository articleRepository;

    @RequestMapping("/")
    public String home(Model model) {
        List<Article> articles = articleRepository.findAll().subList(1,5);
        List<Article> newList = articles.stream().
                sorted(Comparator.comparing(Article::getCreated).reversed()).
                map(x->{Article newArticle = new Article();
                newArticle.setTitle(x.getTitle());
                newArticle.setCreated(x.getCreated());
                newArticle.setContent(x.getContent().substring(0,200));
                return newArticle;
                }).
                collect(Collectors.toList());
        model.addAttribute("articles", newList);
        return "home/home";
    }
}
