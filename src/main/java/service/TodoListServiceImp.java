package service;

import entity.TodoList;
import repository.TodoListRepository;

public class TodoListServiceImp implements TodoListService{

    private TodoListRepository todoListRepository;

    public TodoListServiceImp(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public void showTodoList() {
        TodoList[] model = todoListRepository.getAll();

        System.out.println("TODOLIST" );
        for (var i = 0;i < model.length;i++) {
            var todoList = model[i];
            var no = i +1;

            if (todoList != null) {
                System.out.println(no + ". " + todoList.getTodo());
                }


        }
    }


    @Override
    public void addTodoList(String todo) {

        TodoList todoList = new TodoList(todo);
        todoListRepository.add(todoList);
        System.out.println("Sukses Menambahkan todo " +todo);

    }

    @Override
    public void removeTodoList(Integer number) {
        boolean succes = todoListRepository.remove(number);

        if (succes){
            System.out.println("Berhasil menghapus todo : "+number);
        } else {
            System.out.println("Gagal menghalus todo : "+number);
        }
    }
}
