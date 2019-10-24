package mikolo.hellospringboot.repository;

import mikolo.hellospringboot.model.ToDoItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToDoRepository extends JpaRepository<ToDoItem, Long> {
    public List<ToDoItem>findAllByDescriptionLike(String searchText);
}
