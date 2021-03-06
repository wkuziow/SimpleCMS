package pl.coderslab.author;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/author")
@RequiredArgsConstructor
public class AuthorController {
    @Autowired
    AuthorRepository authorRepository;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getAllAuthors(Model model) {
        model.addAttribute("authors", authorRepository.findAll());
        return "author/authorList";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addAuthorGetForm(Model model) {
        model.addAttribute("author", new Author());
        return "author/addAuthor";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addAuthorProcessForm(@ModelAttribute @Validated Author author,
                                       BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "author/addAuthor";
        }

        authorRepository.save(author);
        return "redirect:all";
    }

    @GetMapping("/update/{id}")
    public String updateAuthorGet(@PathVariable Long id, Model model) {
        Author author = authorRepository.findAuthorById(id);
        model.addAttribute("author", author);
        return "author/addAuthor";
    }

    @PostMapping("/update/{id}")
    public String updateAuthorPost(@PathVariable Long id, @ModelAttribute @Validated Author author,
                                   BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "author/addAuthor";
        }

        authorRepository.save(author);
        return "redirect:../all";
    }

    @GetMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable Long id) {
        authorRepository.delete(authorRepository.findAuthorById(id));

        return "redirect:../all";
    }
}
