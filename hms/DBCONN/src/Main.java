import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HospitalDAO dao = new HospitalDAO();

        while (true) {

            System.out.println("\n===== HOSPITAL MENU =====");
            System.out.println("1. Add Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Get Patient by ID");
            System.out.println("4. Delete Patient");
            System.out.println("5. Update Patient");
            System.out.println("6. Add Bill");
            System.out.println("7. Pay Bill");
            System.out.println("8. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // FIX

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Age: ");
                    int age = sc.nextInt();
                    sc.nextLine(); // FIX

                    System.out.print("Disease: ");
                    String disease = sc.nextLine();

                    System.out.print("Doctor: ");
                    String doctor = sc.nextLine();

                    System.out.print("Bill Amount: ");
                    double bill = sc.nextDouble();

                    dao.addPatient(new Hospital(id, name, age, disease, doctor, bill));
                    break;

                case 2:
                    dao.viewPatients();
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    int vid = sc.nextInt();
                    dao.getPatientById(vid);
                    break;

                case 4:
                    System.out.print("Enter ID: ");
                    int did = sc.nextInt();
                    dao.deletePatient(did);
                    break;

                case 5:
                    System.out.println("1. Update Disease");
                    System.out.println("2. Update Doctor");
                    System.out.println("3. Update Bill");

                    int ch = sc.nextInt();

                    System.out.print("Enter ID: ");
                    int uid = sc.nextInt();
                    sc.nextLine(); // FIX

                    if (ch == 1) {
                        System.out.print("New Disease: ");
                        String nd = sc.nextLine();
                        dao.updateDisease(uid, nd);

                    } else if (ch == 2) {
                        System.out.print("New Doctor: ");
                        String ndoc = sc.nextLine();
                        dao.updateDoctor(uid, ndoc);

                    } else if (ch == 3) {
                        System.out.print("New Bill: ");
                        double nb = sc.nextDouble();
                        dao.updateBill(uid, nb);
                    } else {
                        System.out.println("Invalid choice");
                    }
                    break;

                case 6:
                    System.out.print("Enter ID: ");
                    int aid = sc.nextInt();

                    System.out.print("Amount to Add: ");
                    double add = sc.nextDouble();

                    dao.addBill(aid, add);
                    break;

                case 7:
                    System.out.print("Enter ID: ");
                    int pid = sc.nextInt();

                    System.out.print("Amount to Pay: ");
                    double pay = sc.nextDouble();

                    dao.payBill(pid, pay);
                    break;

                case 8:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice ❌");
            }
        }
    }
}