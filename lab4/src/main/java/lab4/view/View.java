package lab4.view;

import lab4.controller.*;
import lab4.model.entity.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class View {


    private static final Scanner SCANNER = new Scanner(System.in);
    private final Map<String, Printable> menu = new LinkedHashMap<>();

    private final ComputerController computerController = new ComputerController();
    private final IrPhonesController irPhonesController = new IrPhonesController();
    private final ITCompanyController itCompanyController = new ITCompanyController();
    private final MonitorController monitorController = new MonitorController();
    private final ServerController serverController = new ServerController();
    private final WorkerController workerController = new WorkerController();


    public View() {

        menu.put("11", this::getAllComputers);
        menu.put("12", this::getComputerById);
        menu.put("13", this::createComputer);
        menu.put("14", this::updateComputer);
        menu.put("15", this::deleteComputer);

        menu.put("21", this::getAllIrPhones);
        menu.put("22", this::getIrPhonesById);
        menu.put("23", this::createIrPhones);
        menu.put("24", this::updateIrPhones);
        menu.put("25", this::deleteIrPhones);

        menu.put("31", this::getAllCompanies);
        menu.put("32", this::getCompanyById);
        menu.put("33", this::createCompany);
        menu.put("34", this::updateCompany);
        menu.put("35", this::deleteCompany);

        menu.put("41", this::getAllMonitors);
        menu.put("42", this::getMonitorById);
        menu.put("43", this::createMonitor);
        menu.put("44", this::updateMonitor);
        menu.put("45", this::deleteMonitor);

        menu.put("51", this::getAllServers);
        menu.put("52", this::getServerById);
        menu.put("53", this::createServer);
        menu.put("54", this::updateServer);
        menu.put("55", this::deleteServer);

        menu.put("61", this::getAllWorkers);
        menu.put("62", this::getWorkerById);
        menu.put("63", this::createWorker);
        menu.put("64", this::updateWorker);
        menu.put("65", this::deleteWorker);
    }

    public final void show() {
        String input;
        Menu showMenu = new Menu();
        showMenu.displayMenu();
        System.out.println("\nEnter combination:\n");
        do {
            try {
                input = SCANNER.next();
                menu.get(input).print();
            } catch (Exception ignored) {
            }
        } while (SCANNER.hasNext());
    }

    //========================== COMPUTER =================================

    private void getAllComputers() {
        System.out.println("\nGetting computers...");
        System.out.println(computerController.findAll() + "\n");
    }

    private void getComputerById() {
        System.out.println("\nEnter computer ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(computerController.findOne(id) + "\n");
    }

    private static Computer getComputerInputs() {
        System.out.println("\nEnter amount: ");
        Integer amount = SCANNER.nextInt();
        System.out.println("Enter manufacturer: ");
        String manufacturer = SCANNER.next();
        System.out.println("Enter monitors_id: ");
        Integer monitorsId = SCANNER.nextInt();
        return new Computer(amount, manufacturer, monitorsId);
    }

    private void createComputer() {
        System.out.println("\nCreating...");
        Computer user = getComputerInputs();
        computerController.create(user);
        System.out.println("Computer has been created!\n");
    }

    private void updateComputer() {
        System.out.println("\nUpdating computer... Enter ID: ");
        Integer id = SCANNER.nextInt();
        Computer computer = getComputerInputs()
                .setId(id);

        computerController.update(computer.getId(), computer);
        System.out.println("Computer with Id=" + id + " has been updated\n");
    }

    private void deleteComputer() {
        System.out.println("\nDeleting... Enter ID: ");
        int id = SCANNER.nextInt();

        computerController.delete(id);
        System.out.println("Computer with ID=" + id + " has been deleted\n");
    }


    //========================== IRPHONES =================================

    private void getAllIrPhones() {
        System.out.println("\nGetting...");
        System.out.println(irPhonesController.findAll() + "\n");
    }

    private void getIrPhonesById() {
        System.out.println("\nEnter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(irPhonesController.findOne(id) + "\n");
    }

    private IrPhones getIrPhonesInputs() {
        System.out.println("\nEnter phone_types: ");
        String phoneTypes = SCANNER.next();
        System.out.println("Enter phone_model: ");
        String manufacturer = SCANNER.next();
        return new IrPhones(phoneTypes, manufacturer);
    }

    private void createIrPhones() {
        System.out.println("\nCreating...");
        IrPhones irPhones = getIrPhonesInputs();
        irPhonesController.create(irPhones);
        System.out.println("IrPhones has been created!\n");
    }

    private void updateIrPhones() {
        System.out.println("\nUpdating... Enter ID: ");
        Integer id = SCANNER.nextInt();
        IrPhones irPhones = getIrPhonesInputs()
                .setId(id);

        irPhonesController.update(irPhones.getId(), irPhones);
        System.out.println("IrPhones with Id=" + id + " has been updated\n");
    }

    private void deleteIrPhones() {
        System.out.println("\nDeleting... Enter ID: ");
        int id = SCANNER.nextInt();

        irPhonesController.delete(id);
        System.out.println("IrPhones with ID=" + id + " has been deleted\n");
    }

    //========================== IT COMPANIES =================================

    private void getAllCompanies() {
        System.out.println("\nGetting...");
        System.out.println(itCompanyController.findAll() + "\n");
    }

    private void getCompanyById() {
        System.out.println("\nEnter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(itCompanyController.findOne(id) + "\n");
    }

    private ITCompany getCompanyInputs() {
        System.out.println("\nEnter company_configuration: ");
        String companyConfiguration = SCANNER.next();
        System.out.println("Enter type: ");
        String type = SCANNER.next();
        System.out.println("\nEnter server_id: ");
        Integer serverId = SCANNER.nextInt();
        System.out.println("Enter worker_id: ");
        Integer workersId = SCANNER.nextInt();
        return new ITCompany(companyConfiguration, type, serverId, workersId);
    }

    private void createCompany() {
        System.out.println("\nCreating...");
        ITCompany itCompany = getCompanyInputs();
        itCompanyController.create(itCompany);
        System.out.println("Company has been created!\n");
    }

    private void updateCompany() {
        System.out.println("\nUpdating... Enter ID: ");
        Integer id = SCANNER.nextInt();
        ITCompany itCompany = getCompanyInputs()
                .setId(id);

        itCompanyController.update(itCompany.getId(), itCompany);
        System.out.println("Company with Id=" + id + " has been updated\n");
    }

    private void deleteCompany() {
        System.out.println("\nDeleting... Enter ID: ");
        int id = SCANNER.nextInt();

        itCompanyController.delete(id);
        System.out.println("Company with ID=" + id + " has been deleted\n");
    }

    //========================== MONITORS =================================

    private void getAllMonitors() {
        System.out.println("\nGetting...");
        System.out.println(monitorController.findAll() + "\n");
    }

    private void getMonitorById() {
        System.out.println("\nEnter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(monitorController.findOne(id) + "\n");
    }

    private Monitor getMonitorInputs() {
        System.out.println("\nEnter company_configuration: ");
        String companyConfiguration = SCANNER.next();
        System.out.println("Enter model: ");
        String model = SCANNER.next();
        return new Monitor(companyConfiguration, model);
    }

    private void createMonitor() {
        System.out.println("\nCreating...");
        Monitor monitor = getMonitorInputs();
        monitorController.create(monitor);
        System.out.println("Monitor has been created!\n");
    }

    private void updateMonitor() {
        System.out.println("\nUpdating... Enter ID: ");
        Integer id = SCANNER.nextInt();
        Monitor monitor = getMonitorInputs()
                .setId(id);

        monitorController.update(monitor.getId(), monitor);
        System.out.println("Monitor with Id=" + id + " has been updated\n");
    }

    private void deleteMonitor() {
        System.out.println("\nDeleting... Enter ID: ");
        int id = SCANNER.nextInt();

        monitorController.delete(id);
        System.out.println("Monitor with ID=" + id + " has been deleted\n");
    }


    //========================== SERVERS =================================

    private void getAllServers() {
        System.out.println("\nGetting...");
        System.out.println(serverController.findAll() + "\n");
    }

    private void getServerById() {
        System.out.println("\nEnter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(serverController.findOne(id) + "\n");
    }

    private Server getServerInputs() {
        System.out.println("\nEnter company_configuration: ");
        String onlineNow = SCANNER.next();
        System.out.println("Enter model: ");
        Integer monitorsId = SCANNER.nextInt();
        return new Server(onlineNow, monitorsId);
    }

    private void createServer() {
        System.out.println("\nCreating...");
        Server server = getServerInputs();
        serverController.create(server);
        System.out.println("Server has been created!\n");
    }

    private void updateServer() {
        System.out.println("\nUpdating... Enter ID: ");
        Integer id = SCANNER.nextInt();
        Server server = getServerInputs()
                .setId(id);

        serverController.update(server.getId(), server);
        System.out.println("Server with Id=" + id + " has been updated\n");
    }

    private void deleteServer() {
        System.out.println("\nDeleting... Enter ID: ");
        int id = SCANNER.nextInt();

        serverController.delete(id);
        System.out.println("Server with ID=" + id + " has been deleted\n");
    }

    //========================== WORKERS =================================

    private void getAllWorkers() {
        System.out.println("\nGetting...");
        System.out.println(workerController.findAll() + "\n");
    }

    private void getWorkerById() {
        System.out.println("\nEnter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(workerController.findOne(id) + "\n");
    }

    private Worker getWorkerInputs() {
        System.out.println("\nEnter full_name: ");
        String fullName = SCANNER.next();
        System.out.println("Enter amount: ");
        Integer amount = SCANNER.nextInt();
        System.out.println("\nEnter ir_phones_id: ");
        Integer irPhonesId = SCANNER.nextInt();
        return new Worker(fullName, amount, irPhonesId);
    }

    private void createWorker() {
        System.out.println("\nCreating...");
        Worker worker = getWorkerInputs();
        workerController.create(worker);
        System.out.println("Worker has been created!\n");
    }

    private void updateWorker() {
        System.out.println("\nUpdating... Enter ID: ");
        Integer id = SCANNER.nextInt();
        Worker worker = getWorkerInputs()
                .setId(id);

        workerController.update(worker.getId(), worker);
        System.out.println("Worker with Id=" + id + " has been updated\n");
    }

    private void deleteWorker() {
        System.out.println("\nDeleting... Enter ID: ");
        int id = SCANNER.nextInt();

        workerController.delete(id);
        System.out.println("Worker with ID=" + id + " has been deleted\n");
    }
}
