package pl.coderslab.category;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.author.Author;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Controller
@RequestMapping("/category")
@RequiredArgsConstructor
@Transactional
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getAllCategories(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "category/categoryList";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addCategoryGetForm( Model model) {
        model.addAttribute("category", new Category());
        return "category/addCategory";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addCategoryProcessForm(@ModelAttribute @Validated Category category,
                                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "category/addCategory";
        }

        categoryRepository.save(category);
        return "redirect:all";
    }

    @GetMapping("/update/{id}")
    public String updateCategoryGet(@PathVariable Long id, Model model) {
        Category category = categoryRepository.findCategoryById(id);
        model.addAttribute("category", category);
        return "category/addCategory";
    }

    @PostMapping("/update/{id}")
    public String updatecategoryPost(@PathVariable Long id, @ModelAttribute @Validated Category category,
                                     BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "category/addCategory";
        }

        categoryRepository.save(category);
        return "redirect:../all";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Long id) {
        categoryRepository.delete(categoryRepository.findCategoryById(id));

        return "redirect:../all";
    }
}
