package mikolo.hellospringboot.service;

import lombok.RequiredArgsConstructor;
import mikolo.hellospringboot.exception.EntityNotFoundException;
import mikolo.hellospringboot.model.ToDoItem;
import mikolo.hellospringboot.repository.ToDoRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

//@SessionScope
@Service
@RequiredArgsConstructor
public class ToDoService {

    private final ToDoRepository toDoRepository;

    public List<ToDoItem> findAll(String filter) {
        return StringUtils.isEmpty(filter) ? toDoRepository.findAll() : toDoRepository.findAllByDescriptionLike("%" + filter + "%");
    }

    public ToDoItem findById(Long id) {
        return toDoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
    }

    public ToDoItem addItem(ToDoItem toDoItem) {
        return toDoRepository.save(toDoItem);
    }

    public ToDoItem updateItem(ToDoItem toDoItem) {
        ToDoItem item = toDoRepository.findById(toDoItem.getId()).orElseThrow(() -> new EntityNotFoundException(toDoItem.getId()));
        item.setDeadLine(toDoItem.getDeadLine());
        item.setDescription(toDoItem.getDescription());
        item.setPriority(toDoItem.getPriority());
        return toDoRepository.save(item);
    }

    public void deleteItemById(Long id) {
        ToDoItem item = toDoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
        toDoRepository.delete(item);
    }
}
