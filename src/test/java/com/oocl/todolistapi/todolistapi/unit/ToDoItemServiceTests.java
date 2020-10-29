package com.oocl.todolistapi.todolistapi.unit;

import com.oocl.todolistapi.todolistapi.entity.ToDoItem;
import com.oocl.todolistapi.todolistapi.repositories.ToDoItemRepository;
import com.oocl.todolistapi.todolistapi.services.ToDoItemService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
    void should_return_created_toDo_Item_when_create_toDoItem_given_toDo_item_id() {
        //given
        ToDoItemRepository toDoItemRepository = Mockito.mock(ToDoItemRepository.class);
        ToDoItem expectedToDoItem = new ToDoItem(1,"Finish Exercise");
        ToDoItemService toDoItemService = new ToDoItemService(toDoItemRepository);

        //when
        when(toDoItemRepository.save(expectedToDoItem)).thenReturn(expectedToDoItem);
        ToDoItem actualToDoItem = toDoItemService.createToDoItem(expectedToDoItem);

        //then
        assertEquals(expectedToDoItem.getText(), actualToDoItem.getText());
    }

    @Test
    void should_return_updated_toDo_Item_when_update_toDoItem_given_toDo_item_id() {
        //given
        ToDoItemRepository toDoItemRepository = Mockito.mock(ToDoItemRepository.class);
        ToDoItem expectedToDoItem = new ToDoItem(1,"Finish Exercise");
        ToDoItem updatedToDoItem = new ToDoItem(1,"Finish Exercise");
        updatedToDoItem.setDone(!updatedToDoItem.isDone());
        ToDoItemService toDoItemService = new ToDoItemService(toDoItemRepository);

        //when
        when(toDoItemRepository.findById(expectedToDoItem.getId())).thenReturn(java.util.Optional.of(expectedToDoItem));
        when(toDoItemRepository.save(expectedToDoItem)).thenReturn(updatedToDoItem);
        ToDoItem actualToDoItem = toDoItemService.updateToDoItem(expectedToDoItem.getId());

        //then
        assertTrue(actualToDoItem.isDone());
    }

    @Test
    void should_return_when_delete_toDoItem_given_toDo_item_id() {
        //given
        ToDoItemRepository toDoItemRepository = Mockito.mock(ToDoItemRepository.class);
        ToDoItem expectedToDoItem = new ToDoItem(1,"Finish Exercise");
        ToDoItemService toDoItemService = new ToDoItemService(toDoItemRepository);

        //when
        toDoItemService.deleteToDoItem(expectedToDoItem.getId());

        //then
        Mockito.verify(toDoItemRepository).deleteById(expectedToDoItem.getId());
    }

    @Test
    void should_return_toDo_Items_when_get_toDoItem_given_toDo_item_id() {
        //given
        ToDoItemRepository toDoItemRepository = Mockito.mock(ToDoItemRepository.class);
        ToDoItem expectedToDoItem = new ToDoItem(1,"Finish Exercise");
        ToDoItemService toDoItemService = new ToDoItemService(toDoItemRepository);

        //when
        when(toDoItemRepository.findById(expectedToDoItem.getId())).thenReturn(java.util.Optional.of(expectedToDoItem));
        ToDoItem actualToDoItem = toDoItemService.getToDoItemById(expectedToDoItem.getId());

        //then
        assertEquals(expectedToDoItem.getText(), actualToDoItem.getText());
        assertEquals(expectedToDoItem.isDone(), actualToDoItem.isDone());
    }
}
