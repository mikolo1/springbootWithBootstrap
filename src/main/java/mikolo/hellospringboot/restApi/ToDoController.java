package mikolo.hellospringboot.restApi;

import lombok.RequiredArgsConstructor;
import mikolo.hellospringboot.model.ToDoItem;
import mikolo.hellospringboot.service.ToDoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/todo")
public class ToDoController {

    private final ToDoService toDoService;

    @GetMapping
    private List<ToDoItem> findAll(){
        return toDoService.findAll();
    }

    @GetMapping("/{id}")
    private ToDoItem findById(@PathVariable Long id){
        return toDoService.findById(id);
    }

    @PostMapping("/add")
    private ToDoItem addItem (@RequestBody final ToDoItem toDoItem){
        return toDoService.addItem(toDoItem);
    }

    @DeleteMapping("/delete/{id}")
    private void deleteItem(@PathVariable Long id){
        toDoService.deleteItemById(id);
    }

    @PutMapping("/update")
    private ToDoItem updateItem(@RequestBody final ToDoItem item){
        return toDoService.updateItem(item);
    }


}
