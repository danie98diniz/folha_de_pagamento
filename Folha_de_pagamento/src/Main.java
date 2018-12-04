import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {
//-----------------------------------------------     menu     ---------------------------------------------------------
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        ArrayList<Employee> EmployeeList = new ArrayList<>();
        ArrayList<Employee> HourlyList = new ArrayList<>();

        while(true){

            System.out.println("type 0 to exit");
            System.out.println("type 1 to register a new employee");
            System.out.println("type 2 to remove a employee");
            System.out.println("type 3 to submit a point card(cartao de ponto)");

            int option = scan.nextInt();
            scan.nextLine();

            if(option == 0){
                break;
            }
            else if(option == 1){
                Create_new_employee(EmployeeList, HourlyList);
            }
            else if(option == 2){
                Remove_a_employee(EmployeeList);
            }
            else if(option == 3){
                EmployeeCard(HourlyList);
            }
        }

    }
//------------------------------------------------ Create employee -----------------------------------------------------
    public static void Create_new_employee(ArrayList<Employee> EmployeeList, ArrayList<Employee> HourlyList){
        Scanner scan = new Scanner(System.in);

        String name;
        String address;
        String employee_type;
        employee_type = "unknown(not been chosen)";

        System.out.println("please type the name of the employee:");
        name = scan.nextLine();
        System.out.println("please type the employee´s address:");
        address = scan.nextLine();
        System.out.println("type 1 if the employee is in a sindicate");
        System.out.println("or 0 if it is not");
        int choice = scan.nextInt();
        scan.nextLine();
        double sindicate = 0;
        if(choice == 1){
            System.out.println("please type the tax (in %)of the sindicate that will be discounted from the employees account");
            sindicate = scan.nextDouble();
        }

        System.out.println("type 1 if the employee is an hourly employee (horista)");
        System.out.println("type 2 if the employee is a wage earner (assalariado)");
        System.out.println("type 3 if the employee is a comissioned wage earner (comissionado)");
        int option = scan.nextInt();
        scan.nextLine();
        double value_per_hour = 0;
        double wage = 0;
        double comission = 0;
        if(option == 1){
            employee_type = "hourly";
            System.out.println("type the value per hour that the worker will earn");
            value_per_hour = scan.nextDouble();
            scan.nextLine();
        }
        else if(option == 2){
            employee_type = "wage";
            System.out.println("type the value of employee´s wage");
            wage = scan.nextDouble();
            scan.nextLine();

        }
        else if(option == 3){
            employee_type = "comissioned";
            System.out.println("type the value of employee´s wage");
            wage = scan.nextDouble();
            scan.nextLine();
            System.out.println("type the % of the comission per sale");
            comission = scan.nextDouble();
            scan.nextLine();
        }
        System.out.println("How your worker would like to receive his/her payment?");
        System.out.println("type 1 receive a check delivered by mail");
        System.out.println("type 2 to receive a check delivered directly to the worker");
        System.out.println("type 3 to receive deposit into worker´s bank account");
        option = scan.nextInt();
        scan.nextLine();
        String payment_method;
        if(option == 1){
            payment_method = "check by mail";
        }
        else if(option == 2){
            payment_method = "check to worker";
        }
        else{
            payment_method = "deposit to bank account";
        }

        int id;
        Generate_id:
        while(true){
            Random rand = new Random();
            int n = rand.nextInt(1000) + 1;
            for(int i = 0; i < EmployeeList.size(); i++){
                if(n == EmployeeList.get(i).employee_id){
                    continue Generate_id;
                }
            }
            id = n;
            System.out.println("id of employee: "+id);
            break;
        }

        Employee new_employee = new Employee(name, address, employee_type, id, payment_method, value_per_hour, wage, comission, sindicate);
        if(value_per_hour > 0){
            HourlyList.add(new_employee);
        }
        EmployeeList.add(new_employee);
    }//register a new employee
//------------------------------------------------ Remove employee -----------------------------------------------------
    public static void Remove_a_employee(ArrayList<Employee> EmployeeList){
        Scanner scan = new Scanner(System.in);
        int option;

        while(true){
            for(int i = 0; i < EmployeeList.size(); i++){
                System.out.println(i+". "+EmployeeList.get(i).getName()+" - ID: "+EmployeeList.get(i).getEmployee_id());
            }
            System.out.println("choose a employee to remove");
            System.out.println("or type -1 to go back");
            option = scan.nextInt();
            scan.nextLine();
            if(option == -1){
                break;
            }
            else if(option >= 0 && option < EmployeeList.size()){
                EmployeeList.remove(option);
                System.out.println("employee removed with success");
            }
        }
    }//removes a employee
//---------------------------------------- employee card(cartao de ponto) ----------------------------------------------
    public static void EmployeeCard(ArrayList<Employee> HourlyList){
        Scanner scan = new Scanner(System.in);

        while(true){
            System.out.println("Hourly employees:");
            for(int i = 0; i < HourlyList.size(); i++){
                System.out.println(i+". "+HourlyList.get(i).getName());
            }
            System.out.println("choose a employee to submit a point card");
            System.out.println("or type -1 to go back: ");
            int option = scan.nextInt();
            scan.nextLine();

            if(option >= 0 && option < HourlyList.size()){
                System.out.println("employee´s earnings: "+HourlyList.get(option).getMoney());
                System.out.println("type how many hours "+HourlyList.get(option).getName()+" worked today");
                double hours = scan.nextDouble();
                if(hours > 8){
                    hours = hours - 8;
                    double money = HourlyList.get(option).getMoney();
                    money = money + (8 * HourlyList.get(option).getValue_per_hour());
                    double extrahours = HourlyList.get(option).getValue_per_hour() * 1.5;
                    extrahours = extrahours * hours;
                    money = money + extrahours;
                    HourlyList.get(option).setMoney(money);
                }
                else{
                    double money_made = hours * HourlyList.get(option).getValue_per_hour();
                    money_made = money_made + HourlyList.get(option).getMoney();
                    HourlyList.get(option).setMoney(money_made);
                }
            }
            else{
                break;
            }
        }


    }
}
