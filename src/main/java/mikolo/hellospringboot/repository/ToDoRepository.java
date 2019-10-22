package mikolo.hellospringboot.repository;

import mikolo.hellospringboot.model.ToDoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDoItem, Long> {
}
