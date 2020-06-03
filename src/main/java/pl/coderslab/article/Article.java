package pl.coderslab.article;

import lombok.*;
import pl.coderslab.author.Author;
import pl.coderslab.category.Category;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
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
    @Column(length = 2)
    @NotNull
    @Min(2)
    private String title;

    @ManyToOne
    private Author author;


    //@NotNull
    //@Min(1)
    @ManyToMany( fetch = FetchType.EAGER)
    private List<Category> categories = new ArrayList<>();

    @Column(length = 10000)
    @NotNull
    @Min(5)
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
