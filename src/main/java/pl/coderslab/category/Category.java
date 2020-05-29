package pl.coderslab.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import pl.coderslab.article.Article;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100)
    private String name;
    @Column(nullable = true)
    private String description;
    @ManyToMany (mappedBy = "categories", cascade = CascadeType.REMOVE)
    private List<Article> articles = new ArrayList<>();

    public Category(String name, String description, List<Article> articles) {
        this.name = name;
        this.description = description;
        this.articles = articles;
    }
    public Category() {
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
}
