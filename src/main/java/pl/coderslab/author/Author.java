package pl.coderslab.author;

import lombok.*;
import pl.coderslab.article.Article;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;

    //    @OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE)
//    private List<Article> articles = new ArrayList<>();
    public String getFullName() {
        return firstName + " " + lastName;
    }
}
