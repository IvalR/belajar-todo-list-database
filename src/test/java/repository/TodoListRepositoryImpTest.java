package repository;

import com.zaxxer.hikari.HikariDataSource;
import entity.TodoList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.DatabaseUtil;

import javax.sql.DataSource;

public class TodoListRepositoryImpTest {

    private HikariDataSource dataSource;
    private TodoListRepository todoListRepository;
    @BeforeEach
    void setUp() {
        dataSource = DatabaseUtil.getHikariDataSource();
        todoListRepository = new TodoListRepositoryImp(dataSource);
    }

    @Test
    void testAdd() {
        TodoList todoList = new TodoList();
        todoList.setTodo("Racha");

        todoListRepository.add(todoList);
    }

    @Test
    void testRemove() {

        System.out.println(todoListRepository.remove(1));
        System.out.println(todoListRepository.remove(2));
        System.out.println(todoListRepository.remove(3));
        System.out.println(todoListRepository.remove(4));
    }

    @Test
    void testGetAll() {
        todoListRepository.add(new TodoList("Ival"));
        todoListRepository.add(new TodoList("Racha"));
        todoListRepository.add(new TodoList("Pramatama"));

        TodoList[] todoLists = todoListRepository.getAll();

        for (var todo : todoLists){
            System.out.println(todo.getId() + " : " + todo.getTodo());
        }
    }

    @AfterEach
    void tearDown() {
        dataSource.close();
    }
}
