package SchoolProject;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static String menu(){
        String menu = "1)SignIn\n2)SignUp\n3)Exit";
        return menu;
    }
    public static String DonSection(){
        String DonSection =("1)Donate to School\n2)Take a test\n3)Delete Account\n4)Log Out");
        return DonSection;
    }
    public static String AdminSection(){
        String AdminSection =("1)Inspect Donations\n2)Student's List\n3)Professor's List\n4)Fire a professor\n5)Suspend a Student\n6)Unsuspend a Student\n7)Delete Account\n8)Log Out");
        return AdminSection;
    }
    public static String ProfessorSection(){
        String ProfessorSection = ("1)Create Test\n2)Check Test Results\n3)Remove a test\n4)Delete Account\n5)Log Out");
        return ProfessorSection;
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        MethodsSection class1 = new MethodsSection();

        while (true) {
            System.out.println(menu());
            int choice = sc.nextInt();
            while (choice != 0) {
                switch (choice) {
                    case 1:
                        System.out.println("SignIn");
                        class1.Signin();
                        if(!class1.getFile().exists()){
                            System.out.println("You haven't signed up!");
                            System.out.println("-----------------------------");

                            break;
                        }

                        class1.ACCVerification();
                        if(!class1.isAccexists()&&class1.isSuspention()){
                                break;
                        }
                        if(!class1.isAccexists()&&!class1.isSuspention()){
                            break;
                        }
                        if(class1.isSuspention()){
                            System.out.println("Your account is suspended contact the admin for further information!");
                            System.out.println("--------------------------------------------------------------------");
                            class1.delTempVal();
                            break;
                        }
                        while(true) {
                            if(class1.isAccexists()!=true){
                                break;
                            }
                            if (class1.isAccexists()) {
                                if (class1.isStudentExists()) {
                                    System.out.println(DonSection());
                                    int pick = sc.nextInt();
                                    if (pick == 1) {
                                        class1.donate();

                                        System.out.println(class1.getUsername() + " " + "has donated " + class1.getSumStud() + "$");
                                        System.out.println("-----------------------------");
                                        continue;
                                    }
                                    if (pick == 2) {
                                        if(!class1.getTestFile().exists()){
                                            System.out.println("There are no available tests!");
                                            System.out.println("-----------------------------");
                                            continue;
                                        }
                                        class1.takeTest();
                                        if(class1.isSubEx()){
                                            System.out.println("Final score is "+class1.getOverallscore()+"/"+class1.getQuestions());
                                            System.out.println("--------------------------");
                                            class1.SaveStudentScores();
                                            class1.delTempTestVals();
                                        } else{
                                            continue;
                                        }
                                        continue;
                                    }
                                    if (pick == 3) {
                                        class1.deleteAccount();
                                        System.out.println("Your account just got Deleted!");
                                        System.out.println("-------------------------------");
                                        class1.delTempVal();
                                        continue;
                                    }
                                    if (pick == 4) {
                                        System.out.println("You have logged out " + class1.getUsername());
                                        System.out.println("--------------------------");
                                        class1.delTempVal();
                                        class1.delTempTestVals();
                                        break;
                                    }
                                    else{
                                        System.out.println("This option doesn't exists");
                                        System.out.println("--------------------------");
                                        continue;
                                    }
                                }
                                if (class1.isAdminExists()) {
                                    System.out.println(AdminSection());
                                    int pick = sc.nextInt();
                                    if (pick == 1) {
                                        class1.inspectDons();
                                        System.out.println("-------------------------------");
                                        continue;
                                    }
                                    if(pick==2){
                                        System.out.println("The student's list");
                                        class1.checkStudents();
                                        continue;
                                    }
                                    if(pick==3){
                                        System.out.println("The professor's list");
                                        class1.checkProfessors();
                                        continue;
                                    }
                                    if(pick==4){
                                        class1.fireProf();
                                        class1.fireProfessor();
                                        continue;
                                    }
                                    if(pick==5){
                                        System.out.println("Which student you want to suspend?");
                                        class1.suspendStud();
                                        class1.suspendStudent();
                                        continue;
                                    }
                                    if(pick==6){
                                        System.out.println("Which student you want to unsuspend?");
                                        class1.suspendStud();
                                        class1.unsuspendStudent();
                                        continue;
                                    }
                                    if (pick == 7) {
                                        class1.deleteAccount();
                                        System.out.println("Your account just got Deleted!");
                                        System.out.println("-------------------------------");
                                        class1.delTempVal();
                                        break;
                                    }
                                    if (pick == 8) {
                                        System.out.println("You have logged out " + class1.getUsername());
                                        System.out.println("-------------------------------");
                                        class1.delTempVal();
                                        break;
                                    }
                                    else{
                                        System.out.println("This option doesn't exists");
                                        System.out.println("--------------------------");
                                        continue;
                                    }
                                }
                                if (class1.isProfessorExists()) {
                                    System.out.println(ProfessorSection());
                                    int c = sc.nextInt();
                                    if (c == 1) {
                                        class1.createTest();
                                        System.out.println("-------------------------------");
                                        continue;
                                    }
                                    if (c == 2) {
                                        class1.openStudentScores();
                                        System.out.println("-------------------------------");
                                        continue;

                                    }
                                    if (c == 3) {
                                        class1.removeTest();
                                        System.out.println("-------------------------------");
                                        continue;

                                    }
                                    if (c == 4) {
                                        class1.deleteAccount();
                                        System.out.println("Your account just got Deleted!");
                                        System.out.println("-------------------------------");
                                        continue;
                                    }
                                    if (c == 5) {
                                        System.out.println("You have logged out " + class1.getUsername());
                                        System.out.println("---------------------------------------");
                                        class1.delTempVal();
                                        break;
                                    }
                                    else{
                                        System.out.println("This option doesn't exists");
                                        System.out.println("--------------------------");
                                        continue;

                                    }
                                }
                            }
                        }
                        break;
                    case 2:
                        System.out.println("SignUp");
                        class1.Signup();
                        class1.accOrder();
                        System.out.println("-----------------------");
                        break;
                    case 3:
                        System.out.println("Goodbye");
                        System.exit(0);
                        break;
                }
                break;
            }
        }
    }
}
