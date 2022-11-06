package test.view;

import repository.TodoListRepository;
import repository.TodoListRepositoryImp;
import service.TodoListService;
import service.TodoListServiceImp;
import view.TodoListView;

public class TodoListViewTest {
    public static void main(String[] args) {
        showTodoList();;
    }

    public static void showTodoList(){

        TodoListRepository todoListRepository = new TodoListRepositoryImp();
        TodoListService todoListService = new TodoListServiceImp(todoListRepository);
        TodoListView todoListView = new TodoListView(todoListService);

        todoListService.addTodoList("Belajar Java Dasar");
        todoListService.addTodoList("Belajar Java OOP");
        todoListService.addTodoList("Belajar Java Standard Clasees");

        todoListView.showTodoList();


    }
}
