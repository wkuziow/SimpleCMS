package pl.coderslab.category;

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
    @ManyToMany (mappedBy = "categories")
    private List<Article> articles = new ArrayList<>();



    public Category() {
    }
}
