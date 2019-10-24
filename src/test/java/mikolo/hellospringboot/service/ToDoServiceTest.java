package mikolo.hellospringboot.service;

import mikolo.hellospringboot.model.ToDoItem;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class ToDoServiceTest {

    @Test
    void findAll() {
        //given
        ToDoService toDoService = mock(ToDoService.class);
        given(toDoService.findAll("")).willReturn(prepareMockData());
        //when
        List<ToDoItem> all = toDoService.findAll("");
        //then
        Assert.assertThat(all, Matchers.hasSize(2));
    }

    private List<ToDoItem> prepareMockData() {
        List<ToDoItem> items = new ArrayList<>();
        ToDoItem toDoItem1 = new ToDoItem();
        toDoItem1.setPriority(1);
        toDoItem1.setDescription("Zadanie 1");
        toDoItem1.setDeadLine(LocalDate.of(2019, 12, 12));
        toDoItem1.setId(1);
        ToDoItem toDoItem2 = new ToDoItem();
        toDoItem2.setPriority(1);
        toDoItem2.setDescription("Zadanie 2");
        toDoItem2.setDeadLine(LocalDate.of(2020, 1, 11));
        toDoItem2.setId(2);
        items.add(toDoItem1);
        items.add(toDoItem2);
        return items;
    }
}