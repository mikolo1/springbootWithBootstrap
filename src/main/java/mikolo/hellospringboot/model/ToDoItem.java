package mikolo.hellospringboot.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tasklist")
@Data
public class ToDoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    @Column(name = "deadline")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate deadLine;
    private int priority;
}
