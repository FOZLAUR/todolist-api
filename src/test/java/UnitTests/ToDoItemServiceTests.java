package UnitTests;

import com.oocl.todolistapi.todolistapi.models.ToDoItem;
import com.oocl.todolistapi.todolistapi.repositories.ToDoItemRepository;
import com.oocl.todolistapi.todolistapi.services.ToDoItemService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class ToDoItemServiceTests {

    @Test
    void should_return_all_toDo_Items_when_get_all_toDoItems_given() {
        //given
        ToDoItemRepository toDoItemRepository = Mockito.mock(ToDoItemRepository.class);
        List<ToDoItem> expectedToDoList = asList(new ToDoItem(), new ToDoItem());
        ToDoItemService toDoItemService = new ToDoItemService(toDoItemRepository);

        //when
        when(toDoItemRepository.findAll()).thenReturn(expectedToDoList);
        List<ToDoItem> actualToDoItemList = toDoItemService.getAllToDoItems();

        //then
        assertEquals(expectedToDoList.size(), actualToDoItemList.size());
    }
}
