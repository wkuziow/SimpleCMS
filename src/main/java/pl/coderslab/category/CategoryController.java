package pl.coderslab.category;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.transaction.Transactional;

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
    public String addCategoryGetForm(Model model) {
        model.addAttribute("category", new Category());
        return "category/addCategory";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addCategoryProcessForm(@ModelAttribute Category category) {
        categoryRepository.save(category);
        return "redirect:all";
    }
}
