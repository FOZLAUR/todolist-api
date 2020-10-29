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

    @Test
    void should_return_updated_toDo_Item_when_update_toDoItem_given_toDo_item_id() {
        //given
        ToDoItemRepository toDoItemRepository = Mockito.mock(ToDoItemRepository.class);
        ToDoItem expectedToDoItem = new ToDoItem(1,"Finish Exercise", false);
        ToDoItem updatedToDoItem = new ToDoItem(1,"Finish Exercise", true);
        ToDoItemService toDoItemService = new ToDoItemService(toDoItemRepository);

        //when
        when(toDoItemRepository.findById(expectedToDoItem.getToDoId())).thenReturn(java.util.Optional.of(expectedToDoItem));
        when(toDoItemRepository.save(expectedToDoItem)).thenReturn(updatedToDoItem);
        ToDoItem actualToDoItem = toDoItemService.updateToDoItem(expectedToDoItem.getToDoId());

        //then
        assertEquals(true, actualToDoItem.isDone());
    }

    @Test
    void should_return_toDo_Items_when_get_toDoItem_given_toDo_item_id() {
        //given
        ToDoItemRepository toDoItemRepository = Mockito.mock(ToDoItemRepository.class);
        ToDoItem expectedToDoItem = new ToDoItem(1,"Finish Exercise", false);
        ToDoItemService toDoItemService = new ToDoItemService(toDoItemRepository);

        //when
        when(toDoItemRepository.findById(expectedToDoItem.getToDoId())).thenReturn(java.util.Optional.of(expectedToDoItem));
        ToDoItem actualToDoItem = toDoItemService.getToDoItemById(expectedToDoItem.getToDoId());

        //then
        assertEquals(expectedToDoItem.getText(), actualToDoItem.getText());
        assertEquals(expectedToDoItem.isDone(), actualToDoItem.isDone());
    }
}
