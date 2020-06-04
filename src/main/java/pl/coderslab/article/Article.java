package pl.coderslab.article;

import lombok.*;
import pl.coderslab.author.Author;
import pl.coderslab.category.Category;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    @NotEmpty(groups = {DraftValidationGroup.class, ArticleValidationGroup.class})
    @Size(min = 5, groups = {ArticleValidationGroup.class})
    @Size(min = 1, groups = {DraftValidationGroup.class})
    private String title;

    @ManyToOne
    private Author author;

    //@NotNull
    //@Min(1)
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Category> categories = new ArrayList<>();

    @Column(length = 10000)
    @NotEmpty(groups = {DraftValidationGroup.class, ArticleValidationGroup.class})
    @Size(min = 5, groups = {ArticleValidationGroup.class})
    private String content;
    private LocalDateTime created;
    private LocalDateTime updated;

    private boolean draft;

    public boolean isDraft() {
        return draft;
    }

    public void setDraft(boolean draft) {
        this.draft = draft;
    }

    @PrePersist
    public void prePersist() {
        created = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updated = LocalDateTime.now();
    }
}
