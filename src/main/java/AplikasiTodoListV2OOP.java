import entity.TodoList;
import repository.TodoListRepository;
import repository.TodoListRepositoryImp;
import service.TodoListService;
import service.TodoListServiceImp;
import view.TodoListView;

public class AplikasiTodoListV2OOP {

    public static void main(String[] args) {
        TodoListRepository todoListRepository = new TodoListRepositoryImp();
        TodoListService todoListService = new TodoListServiceImp(todoListRepository);
        TodoListView todoListView = new TodoListView(todoListService);

        todoListView.showTodoList();

    }

}
