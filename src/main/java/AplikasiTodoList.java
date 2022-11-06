import java.util.Scanner;

public class AplikasiTodoList {
   public static String[] model = new String[10];

   public static java.util.Scanner scanner = new java.util.Scanner(System.in);

   public static void main(String[] args) {
   viewShowTodoList();
    }

    /**
     * Menampilkan todo list
     */
    public static void showTodoList(){
        System.out.println("TODOLIST");
        for (var i = 0;i < model.length;i++) {
        var todo = model[i];
        var no = i +1;

        if (todo != null){
            System.out.println(no+". "+todo);
        }
    }
    }
    public static void testShowTodoList(){
        model[0] = "Belajar java dasar";
        model[1] = "Belajar todoList";
        showTodoList();
    }
    /**
     * menambahkan todo list
     */
    public static void addTodoList(String todo){
        //cek apakah array penuh?
        var isFull = true;
        for (int i = 0; i < model.length ; i++) {
          if (model[i]==null){
              isFull = false;
              break;
          }
        }
        //jika sudah penuh, kita resize array
        if (isFull){
        //menaruh data lama,karna meresize sama dengan mereset isi array
            var temp = model;
            model = new String[model.length*2];

            //memindahkan dari temporary ke model
            for (int i = 0; i < temp.length; i++) {
                model[i]=temp[i];
            }


        }
        //tambah ke posisi yang data arraynya NULL
        for (var i =0;i< model.length;i++){
            if (model[i]==null){
                model[i]=todo;
                break;
            }
        }
    }

    public static void testAddTodoList(){
        for (int i = 0; i < 25; i++) {
            System.out.println("Contoh Todo List ke-"+i);
        }
        showTodoList();
    }
    /**
     * menaghapus todo list
     */
    public static boolean removeTodoList(Integer number) {
        if ((number - 1) >= model.length) {
            return false;
        } else if (model[number - 1] == null) {
            return false;
        } else {
            for (int i = (number-1); i < model.length; i++) {
                if (i == (model.length - 1)) {
                    model[i] = null;
                } else {
                    model[i] = model[i +1];
                }
            }
        return true;
        }
    }

    public static void testRemoveTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");

        var result = removeTodoList(20);
        System.out.println(result);

        result=removeTodoList(4);
        System.out.println(result);

        result= removeTodoList(2);
        System.out.println(result);

        showTodoList();
    }

    public static String input(String info){
        System.out.print(info +" : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput(){
        var name = input("Nama");
        System.out.println("Hi " +name);
    }

    /**
     * menampilkan view todo List
     */

    public static void viewShowTodoList(){
    while (true){
        showTodoList();

        System.out.println("MENU :");
        System.out.println("1. Tambah");
        System.out.println("2. Hapus");
        System.out.println("x. Keluar");

        var input = input("Pilih");

        if (input.equals("1")){
            viewAddTodolist();
        } else if (input.equals("2")){
            viewRemoveTodoList();
        } else if (input.equals("x")) {
            break;
        } else {
            System.out.println("Pilihan tidak ditemukan");
        }
    }
    }

    public static void testViewShowTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");

        viewShowTodoList();
    }

    /**
     * Menampilkan view menambahkan todo list
     */
    public static void viewAddTodolist(){
        System.out.println("MENAMBAH TODOLIST");

        var todo = input("todo (x Jika Batal )");

        if (todo.equals("x")){
            //batal
        } else {
            addTodoList(todo);
        }
    }

    public static void testViewAddTodoLists(){
        addTodoList("Satu");
        addTodoList("Dua");

        viewAddTodolist();
        showTodoList();
    }
    /**
     * menampilkan view hapus todo list
     */
    public static void viewRemoveTodoList(){
        System.out.println("MENGHAPUS TODOLIST");

        var number = input("todo (x Jika Batal )");

        if (number.equals("x")){
            //batal
        } else {
            var succes = removeTodoList(Integer.valueOf(number));
            if (!succes) {
                System.out.println("Gagal menghapus )"+number);
            }
        }
    }
    public static void testViewRemoveTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("tiga");

        showTodoList();

        viewRemoveTodoList();

        showTodoList();
    }
}
