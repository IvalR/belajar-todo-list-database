import entity.TodoList;
import repository.TodoListRepository;
import repository.TodoListRepositoryImp;
import service.TodoListService;
import service.TodoListServiceImp;
import util.DatabaseUtil;
import view.TodoListView;

import javax.sql.DataSource;

public class AplikasiTodoListV2OOP {

    public static void main(String[] args) {

        DataSource dataSource = DatabaseUtil.getHikariDataSource();
        TodoListRepository todoListRepository = new TodoListRepositoryImp(dataSource);
        TodoListService todoListService = new TodoListServiceImp(todoListRepository);
        TodoListView todoListView = new TodoListView(todoListService);

        todoListView.showTodoList();

    }

}
