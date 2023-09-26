import controller.TareaController;
import model.Tarea;

public class Entrada {
    public static void main(String[] args) {
        Tarea t1 = new Tarea("papa","PewA","PO",false);

        TareaController tareaController = new TareaController();
        tareaController.insertarTarea(t1);
        //tareaController.eliminarTarea(1);
        //tareaController.updateTarea("piolin");
        tareaController.selectTarea();
    }
}
