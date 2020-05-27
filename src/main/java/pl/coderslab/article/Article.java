package pl.coderslab.article;

import lombok.*;
import pl.coderslab.author.Author;
import pl.coderslab.category.Category;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor

public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 200)
    private String title;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
    @ManyToMany
    @JoinTable(name = "category_article")
    private List<Category> categories = new ArrayList<>();
    @Column(length = 10000)
    private String content;
    private LocalDateTime created;
    private LocalDateTime updated;

    @PrePersist
    public void prePersist() {
        created = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updated = LocalDateTime.now();
    }
}
