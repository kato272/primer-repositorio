public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        boolean running = true;
        while (running) {
            view.showMenu();
            String option = view.getUserOpt();
            switch (option) {
                case "1":
                    int num1 = view.getNumberInput("Ingrese el primer número: ");
                    int num2 = view.getNumberInput("Ingrese el segundo número: ");
                    model.setNum1(num1);
                    model.setNum2(num2);
                    view.showMessage("Números leídos correctamente.");
                    break;
                case "2":
                    model.calculateSum();
                    view.showMessage("Suma calculada correctamente.");
                    break;
                case "3":
                    int result = model.getSum();
                    view.showResult(result);
                    break;
                case "q":
                    running = false;
                    view.showMessage("Saliendo del programa. Adiós");
                    break;
                default:
                    view.showMessage("Opción inválida, intente nuevamente.");
                    break;
            }
        }
    }
}
