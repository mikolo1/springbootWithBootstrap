package mikolo.hellospringboot.controller;

import lombok.RequiredArgsConstructor;
import mikolo.hellospringboot.model.ToDoItem;
import mikolo.hellospringboot.service.ToDoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final ToDoService toDoService;

    @GetMapping({"/", "/index"})
    public String showMainpage(Model model){
        List<ToDoItem> all = toDoService.findAll();
        model.addAttribute("allTasks", all);
//        model.addAttribute("toDoItem", new ToDoItem());
        return "index";
    }

    @PostMapping("/addtask")
    public String addTask(@ModelAttribute ToDoItem toDoItem){
        toDoService.addItem(toDoItem);
        return "redirect:index";
    }

    @GetMapping("/delete")
    public String deleteTask(@RequestParam Long id){
        toDoService.deleteItemById(id);
        return "redirect:index";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam Long id, Model model){
        ToDoItem toDoItemToEdit = toDoService.findById(id);
        model.addAttribute("toDoItem", toDoItemToEdit);
        return "edit";
    }

    @PostMapping("/edit")
    public String editTask(@ModelAttribute ToDoItem toDoItem){
        toDoService.updateItem(toDoItem);
        return "redirect:index";
    }

    @ModelAttribute
    public ToDoItem toDoItem(){
        return new ToDoItem();
    }
}
