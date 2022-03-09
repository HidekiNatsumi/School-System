package SchoolProject;

import java.io.*;
import java.util.Scanner;

public class MethodsSection {
    private String username;
    private String password;
    private String role;
    private boolean Accexists = false;
    private File file = new File("AccountsWithMethods.txt");
    private boolean ProfessorExists = false;
    private boolean StudentExists = false;
    private boolean AdminExists = false;
    private boolean suspention =false;
    private int sumStud;
    private File file1 = new File("Donationss.txt");
    private int donation;
    private File testFile = new File("Subjects.txt");
    private int questions;
    private int overallscore;
    private String subject;
    private File studScores = new File("StudentsTestScores.txt");
    private boolean fileEx = false;
    private boolean subEx = false;
    String profChoice, studChoice;

    public File getStudScores() {
        return studScores;
    }

    public void setStudScores(File studScores) {
        this.studScores = studScores;
    }

    public boolean isSuspention() {
        return suspention;
    }


    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public File getTestFile() {
        return testFile;
    }

    public void setTestFile(File testFile) {
        this.testFile = testFile;
    }

    public boolean isSubEx() {
        return subEx;
    }

    public boolean isFileEx() {
        return fileEx;
    }


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getOverallscore() {
        return overallscore;
    }

    public void setOverallscore(int overallscore) {
        this.overallscore = overallscore;
    }

    public int getQuestions() {
        return questions;
    }

    public void setQuestions(int questions) {
        this.questions = questions;
    }

    public MethodsSection() throws FileNotFoundException {
    }

    public String getUsername() {
        return username;
    }

    public int getSumStud() {
        return sumStud;
    }

    public void setSumStud(int sumStud) {
        this.sumStud = sumStud;
    }

    public int getDonation() {
        return donation;
    }

    public void setDonation(int donation) {
        this.donation = donation;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAccexists() {
        return Accexists;
    }

    public void setAccexists(boolean accexists) {
        Accexists = accexists;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isStudentExists() {
        return StudentExists;
    }

    public void setStudentExists(boolean studentExists) {
        StudentExists = studentExists;
    }

    public boolean isAdminExists() {
        return AdminExists;
    }

    public void setAdminExists(boolean adminExists) {
        AdminExists = adminExists;
    }

    public boolean isProfessorExists() {
        return ProfessorExists;
    }

    public void setProfessorExists(boolean professorExists) {
        ProfessorExists = professorExists;
    }

    public void Signup() throws IOException {

        FileWriter fw = new FileWriter(file, true);
        Scanner sc = new Scanner(System.in);
        System.out.println("Put your username:");
        username = sc.next();
        System.out.println("Put your Password:");
        password = sc.next();
        System.out.println("Add your role\n1-Admin\n2-Professor\n3-Student");
        role = sc.next();
        boolean ue = false;
        boolean pe = false;
        boolean re = false;
        Scanner read2 = new Scanner(file);
        String username1, password1, role1,sus;
        while (read2.hasNext()) {
            username1 = read2.next();
            password1 = read2.next();
            role1 = read2.next();
            sus= read2.next();
            if (username1.equals(username)) {
                ue = true;
                break;
            } else {
                ue = false;
            }
        }
        read2.close();
        if (ue) {
            System.out.println("Username Already Exists!");
            fw.close();

        } else {
            System.out.println("Username isn't occupied!");
            fw.append(username + " " + password + " " + role + " no\n");
            System.out.println("Account Created");
            fw.close();
        }
    }

    public void Signin() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Put your username:");
        username = sc.next();
        System.out.println("Put your Password:");
        password = sc.next();
    }

    public void ACCVerification() throws FileNotFoundException {
        Scanner x = new Scanner(file);

        String tempUsername, tempPassword, tempRole,tempSus;
        while (x.hasNext()) {
            tempUsername = x.next();
            tempPassword = x.next();
            tempRole = x.next();
            tempSus =x.next();
            if (tempRole.equals("1")) {

                AdminExists = true;

            } else {
                AdminExists = false;
            }
            if (tempRole.equals("2")) {
                ProfessorExists = true;
            } else {
                ProfessorExists = false;
            }
            if (tempRole.equals("3")) {

                StudentExists = true;

            } else {
                StudentExists = false;
            }
            if(tempSus.equals("no")){
                suspention=false;
            }
            if(tempSus.equals("sus")){
                suspention=true;
            }

            if (tempPassword.equals(password) && tempUsername.equals(username)) {
                Accexists = true;
                break;
            }
        }
        x.close();
        while (Accexists&&!suspention) {
            if (AdminExists) {
                System.out.println("Welcome back" + " " + username + "!");
                System.out.println("You have logged in as an Admin\n");
                break;
            }
            if (StudentExists) {
                System.out.println("Welcome back" + " " + username + "!");
                System.out.println("You have logged in as a Student\n");
                break;
            }
            if (ProfessorExists) {
                System.out.println("Welcome back" + " " + username + "!");
                System.out.println("You have logged in as a Professor\n");
                break;
            }
        }
        if (!Accexists) {
            System.out.println("Wrong Credentials!");
        }
    }

    public void accOrder() throws IOException {
        Scanner read3 = new Scanner(file);
        int count = 0;
        String username1, password1, role1,sus;
        while (read3.hasNextLine()) {
            read3.nextLine();
            count++;
        }
        read3.close();

        Scanner read1 = new Scanner(file);
        String[] arr = new String[count];
        for (int i = 0; i < count; i++) {
            username1 = read1.next();
            password1 = read1.next();
            role1 = read1.next();
            sus= read1.next();
            arr[i] = username1 +" "+ password1 +" "+ role1+" "+sus;

        }
        read1.close();
        String tempn;
        for (int i = 0; i < count; i++) {
            for (int j = i; j < count; j++) {
                if (arr[i].compareTo(arr[j]) > 0) { //sorting the passwords and usernames in the note file in order
                    tempn = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tempn;
                }
            }
        }
        PrintWriter writer = new PrintWriter(file);
        writer.print("");
        writer.close();
        FileWriter fw = new FileWriter(file, true);
        for (int i = 0; i < arr.length; i++) {

            fw.append(arr[i] + "\n");

        }
        fw.close();
    }

    public void deleteAccount() throws IOException {
        if (Accexists) {
            Scanner read3 = new Scanner(file);
            int count = 0;
            String username1, password1, role1,sus;
            while (read3.hasNextLine()) {
                read3.nextLine();
                count++;
            }
            read3.close();
            Scanner read1 = new Scanner(file);
            String[] arr = new String[count];
            for (int i = 0; i < count; i++) {
                username1 = read1.next();
                password1 = read1.next();
                role1 = read1.next();
                sus= read1.next();
                arr[i] = username1 + " " + password1 + " " + role1+ " "+sus;
            }
            read1.close();
            int count1 = 0;
            boolean ue = false;
            boolean pe = false;
            boolean studentExs = false;
            Scanner read2 = new Scanner(file);
            while (read2.hasNext()) {
                username1 = read2.next();
                password1 = read2.next();
                role1 = read2.next();
                sus= read2.next();
                if (!ue) {
                    count1++;
                }
                if (ue) {
                    if (pe) {
                        break;
                    }
                }
                if (username1.equals(username)) {
                    ue = true;
                } else {
                    ue = false;
                }
                if (password1.equals(password)) {
                    pe = true;
                } else {
                    pe = false;
                }
                if (role1.equals("3")) {
                    studentExs = true;
                } else {
                    studentExs = false;
                }
            }
            read2.close();
            for (int o = 0; o < arr.length; o++) {
                if (o == count1 - 1) {
                    arr[o] = "";

                }
            }
            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            writer.close();
            FileWriter fw = new FileWriter(file, true);
            for (int i = 0; i < arr.length; i++) {
                if (i != count1 - 1) {
                    fw.append(arr[i] + "\n");
                }
            }
            fw.close();
            boolean testExists = false;
            Scanner r = new Scanner(studScores);
            String tempy;
            while (r.hasNext()) {
                tempy = r.next();
                if (tempy.equals(username) && studentExs) {
                    testExists = true;
                } else {
                    testExists = false;
                }
            }
            r.close();

            if (testExists) {
                File studentsFile = new File(username + ".txt");
                if (studentsFile.exists()) {
                    studentsFile.delete();
                }
                String tempVal, tempval1;
                int count123 = 0;
                int count1234 = 0;
                Scanner filereaderrr = new Scanner(studScores);
                while (filereaderrr.hasNextLine()) {
                    tempVal = filereaderrr.nextLine();
                    count123++;
                }
                filereaderrr.close();
                String temporary;
                Scanner filereaderrrr = new Scanner(studScores);
                while (filereaderrrr.hasNextLine()) {
                    temporary = filereaderrrr.next();
                    if (temporary.equals(username)) {
                        break;
                    } else {
                        count1234++;
                    }

                }
                filereaderrrr.close();
                count1234++;
                String[] array = new String[count123];
                int counting = 0;
                Scanner filereaderr = new Scanner(studScores);
                while (filereaderr.hasNextLine()) {
                    tempval1 = filereaderr.nextLine();
                    array[counting] = tempval1;
                    counting++;
                }
                filereaderr.close();

                for (int o = 0; o < count123; o++) {
                    if (o == count1234 - 1) {
                        array[o] = "";
                    }
                }
                PrintWriter writeru = new PrintWriter(studScores);
                writer.print("");
                writeru.close();

                FileWriter fwww = new FileWriter(studScores, true);
                for (int i = 0; i < count123; i++) {
                    if (i != count1234 - 1) {
                        fwww.append(array[i] + "\n");
                    }
                }
                fwww.close();
            } else {
                System.out.println("lotig2");
            }
        } else {
        }
    }


    public void donate() throws IOException {
        FileWriter fw = new FileWriter(file1, true);
        Scanner sc = new Scanner(System.in);
        System.out.println("What's the sum of money you want to donate?");
        sumStud = sc.nextInt();
        fw.append(getUsername() + " " + sumStud + "\n");
        fw.close();
    }

    public void inspectDons() throws FileNotFoundException {
        Scanner rsc_don = new Scanner(file1);

        while (rsc_don.hasNextLine()) {

            System.out.println(rsc_don.nextLine() + "$");
        }
        rsc_don.close();
    }

    public void createTest() throws IOException {
        if (!testFile.exists()) {
            File testFile = new File("Subjects.txt");
        }
        Scanner sc = new Scanner(System.in);


        int amount = 0;
        try {
            System.out.println("Decide how many questions do you want to add");
            amount = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Please enter an Integer!");
        }

        for (int i = 0; i < amount; i++) {
            System.out.println("Whats the subject's name for this test?");
            String fileSubs = sc.next();
            FileWriter fwt = new FileWriter("Subjects.txt", true);
            Scanner scReader = new Scanner(testFile);
            String temp1;

            boolean fileExists = false;
            while (true) {
                while (scReader.hasNext()) {
                    temp1 = scReader.next();
                    if (temp1.equals(fileSubs)) {
                        fileExists = true;
                        break;
                    } else {
                        fileExists = false;
                    }
                }

                if (fileExists) {
                    File files = new File(fileSubs + ".txt");
                    FileWriter fw = new FileWriter(files, true);

                    System.out.println("Enter the Question");
                    String question = sc.next();

                    System.out.println("Enter the first alternativee");
                    String question1 = sc.next();

                    System.out.println("Enter the second alternative");
                    String question2 = sc.next();

                    System.out.println("Enter the third alternative");
                    String question3 = sc.next();

                    System.out.println("Enter the fourth alternative");
                    String question4 = sc.next();

                    System.out.println("Enter the correct alternative");
                    int correct = sc.nextInt();
                    fw.append(question + "\n" + question1 + "\n" + question2 + "\n" + question3 + "\n" + question4 + "\n" + correct + "\n");
                    fw.close();
                    break;
                }

                if (!fileExists) {
                    fwt.append(fileSubs + "\n");
                    fwt.close();
                    File files = new File(fileSubs + ".txt");
                    FileWriter fw = new FileWriter(files, true);

                    System.out.println("Enter the Question");
                    String question = sc.next();

                    System.out.println("Enter the first alternative");
                    String question1 = sc.next();

                    System.out.println("Enter the enter the second alternative");
                    String question2 = sc.next();

                    System.out.println("Enter the third alternative");
                    String question3 = sc.next();

                    System.out.println("Enter the fourth alternative");
                    String question4 = sc.next();

                    System.out.println("Enter the correct alternative");
                    int correct = sc.nextInt();
                    fw.append(question + "\n" + question1 + "\n" + question2 + "\n" + question3 + "\n" + question4 + "\n" + correct + "\n");
                    fw.close();
                    break;
                }
                break;
            }

        }
        System.out.println(amount + " Tests were created");
    }

    public void takeTest() throws IOException {
        if (!testFile.exists()) {
            File Allsubs = new File("Subjects.txt");
        }
        Scanner sc = new Scanner(System.in);

        System.out.println("Which test do you want to take?");
        System.out.println("-------------------------------");
        Scanner read = new Scanner(testFile);
        while (read.hasNextLine()) {

            System.out.println(read.nextLine());
        }
        read.close();
        System.out.println("-------------------------------");
        subject = sc.nextLine();
        Scanner reader = new Scanner(testFile);
        String tempval;

        int count = 0;
        while (reader.hasNextLine()) {
            tempval = reader.nextLine();
            if (subject.equals(tempval)) {
                subEx = true;
                break;
            } else {
                subEx = false;
            }
        }
        if (subEx) {
            int counting = 0, cc = 0, ccc = 0;
            String tempVal, temppp;
            File testfilee = new File(subject + ".txt");
            Scanner filereader = new Scanner(testfilee);
            while (filereader.hasNextLine()) {
                temppp = filereader.nextLine();
                counting++;
            }
            filereader.close();

            System.out.println("-------------------------------");
            System.out.println("The " + subject + " test has started!");
            System.out.println("-------------------------------");
            questions = counting / 6;
            String[] str = new String[questions];
            Scanner filereaderr = new Scanner(testfilee);
            while (filereaderr.hasNextLine()) {
                tempVal = filereaderr.nextLine();
                if ((cc + 1) % 6 == 0) {
                    str[ccc] = tempVal;
                    ccc++;
                }
                if (cc == counting) {
                    break;
                }
                cc++;
            }
            filereaderr.close();

            Scanner filereaderrr = new Scanner(testfilee);
            String temptemp;
            String[] questionn = new String[counting];
            int countcount = 0, cccc = 1;
            System.out.println("The question number " + cccc);
            int score = 0;
            int counn = 0;
            int countc = 1;
            overallscore = 0;
            while (filereaderrr.hasNextLine()) {
                if ((countcount + 1) % 6 != 0) {
                    cccc++;
                    temptemp = filereaderrr.nextLine();
                    questionn[countcount] = temptemp;
                    System.out.println(questionn[countcount]);
                }

                if ((countcount + 1) % 6 == 0) {
                    int answer = sc.nextInt();
                    int i = Integer.parseInt(str[counn]);
                    temptemp = filereaderrr.nextLine();
                    questionn[countcount] = temptemp;
                    counn++;

                    if (answer == i) {
                        System.out.println("Correct Answer!");
                        countc++;
                        if (countc - 1 == questions) {
                            overallscore++;
                            break;
                        }
                        System.out.println("The question number " + countc);
                        overallscore++;


                    } else {

                        System.out.println("Wrong Answer!");
                        countc++;
                        if (countc - 1 == questions) {
                            break;
                        }
                        System.out.println("The question number " + countc);
                    }
                }
                countcount++;
            }
            filereaderrr.close();

        } else {
            System.out.println("The test you searched for doesn't exist!");
        }
    }

    public void openStudentScores() throws FileNotFoundException {
        if (!studScores.exists()) {
            File studScoress = new File("StudentsTestScores.txt");
        }
        System.out.println("Which Student you desire to check?");
        System.out.println("----------------------------------");
        Scanner read = new Scanner(studScores);
        Scanner sc1 = new Scanner(System.in);
        while (read.hasNextLine()) {

            System.out.println(read.nextLine());
        }
        read.close();

        String choice = sc1.nextLine();
        System.out.println("----------------------------------");
        System.out.println(choice + " has the following results:");
        File studentsFile = new File(choice + ".txt");
        String tempVal;
        boolean studENT = false;
        Scanner filereaderr = new Scanner(studScores);
        while (filereaderr.hasNextLine()) {
            tempVal = filereaderr.nextLine();
            if (tempVal.equals(choice)) {
                studENT = true;
                break;
            } else {
                studENT = false;
            }
        }
        filereaderr.close();
        if (studENT) {
            Scanner readingit = new Scanner(studentsFile);
            while (readingit.hasNextLine()) {

                System.out.println(readingit.nextLine());
            }
            readingit.close();
        } else {
            System.out.println("The chosen student hasn't taken any test or doesn't Exists!");
        }
    }

    public void SaveStudentScores() throws IOException {

        File studScores = new File("StudentsTestScores.txt");
        studScores.createNewFile();

        File studentScore = new File(username + ".txt");
        FileWriter fw = new FileWriter(studentScore, true);
        fw.append(subject + " " + overallscore + "/" + questions + "\n");
        fw.close();

        Scanner scReader = new Scanner(studScores);
        String temp1;
        while (true) {
            while (scReader.hasNext()) {
                temp1 = scReader.next();
                if (temp1.equals(username)) {
                    fileEx = true;
                    break;
                } else {
                    fileEx = false;
                }
            }

            if (!fileEx) {
                FileWriter fw1 = new FileWriter(studScores, true);
                fw1.append(username + "\n");

                fw1.close();
                break;
            } else {
                break;
            }
        }
    }

    public void removeTest() throws IOException {

        Scanner sc = new Scanner(System.in);
        Scanner read = new Scanner(testFile);
        System.out.println("Which test do you want to remove?");
        System.out.println("---------------------------------");
        int counttt = 0;
        while (read.hasNextLine()) {

            System.out.println(read.nextLine());
            counttt++;
        }

        read.close();
        System.out.println("---------------------------------");
        String testCHOICE = sc.nextLine();
        Scanner reader = new Scanner(testFile);
        String tempval;
        boolean subExx = false;
        int count = 0;
        while (reader.hasNextLine()) {
            tempval = reader.nextLine();
            if (testCHOICE.equals(tempval)) {
                subExx = true;
                break;

            } else {
                subExx = false;
            }
        }

        if (subExx) {
            Scanner read1 = new Scanner(testFile);
            String[] arr = new String[counttt];
            String tempvar;
            for (int i = 0; i < counttt; i++) {
                tempvar = read1.next();
                arr[i] = tempvar;

            }
            read1.close();
            Scanner reading = new Scanner(testFile);
            String temporaryvar;
            int wcountt = 0;
            while (reading.hasNextLine()) {
                temporaryvar = reading.next();
                if (temporaryvar.equals(testCHOICE)) {
                    wcountt++;
                    break;
                }
                wcountt++;
            }
            reading.close();
            for (int o = 0; o < arr.length; o++) {
                if (o == wcountt - 1) {
                    arr[o] = "";
                }
            }
            PrintWriter writer = new PrintWriter(testFile);
            writer.print("");
            writer.close();
            FileWriter fw = new FileWriter(testFile, true);
            for (int i = 0; i < arr.length; i++) {
                if (i != wcountt - 1) {
                    fw.append(arr[i] + "\n");
                }
            }
            fw.close();

            File testfilee = new File(testCHOICE + ".txt");
            if (testfilee.delete()) {
                System.out.println("File deleted Successfully");
            }

        } else {
            System.out.println("This test doesn't exists!");
        }
    }

    public void delTempVal() {
        username = "";
        password = "";
        Accexists = false;
    }

    public void delTempTestVals() {
        overallscore = 0;
        questions = 0;
        fileEx = false;
        subEx = false;
    }

    public void checkStudents() throws FileNotFoundException {
        Scanner scanning = new Scanner(file);
        String temp1, temp2, temp3,sus;

        boolean studentEx = false;
        int countStuds = 0;
        while (scanning.hasNext()) {
            temp1 = scanning.next();
            temp2 = scanning.next();
            temp3 = scanning.next();
            sus= scanning.next();
            if (temp3.equals("3")) {
                countStuds++;
            }
        }
        scanning.close();
        Scanner scanning1 = new Scanner(file);
        String[] studnames = new String[countStuds];
        int index = 0;
        while (scanning1.hasNext()) {
            temp1 = scanning1.next();
            temp2 = scanning1.next();
            temp3 = scanning1.next();
            sus= scanning1.next();
            if (temp3.equals("3")) {
                studnames[index] = temp1+" "+sus;
                index++;
            }
        }
        scanning.close();
        System.out.println("------------------------");
        for (int i = 0; i < countStuds; i++) {
            System.out.println(studnames[i]);
        }
        System.out.println("------------------------");
    }

    public void checkProfessors() throws FileNotFoundException {
        Scanner scanning = new Scanner(file);
        String temp1, temp2, temp3,sus;

        boolean studentEx = false;
        int countStuds = 0;
        while (scanning.hasNext()) {
            temp1 = scanning.next();
            temp2 = scanning.next();
            temp3 = scanning.next();
            sus= scanning.next();
            if (temp3.equals("2")) {
                countStuds++;
            }
        }
        scanning.close();
        Scanner scanning1 = new Scanner(file);
        String[] profnames = new String[countStuds];
        int index = 0;
        while (scanning1.hasNext()) {
            temp1 = scanning1.next();
            temp2 = scanning1.next();
            temp3 = scanning1.next();
            sus= scanning1.next();
            if (temp3.equals("2")) {
                profnames[index] = temp1;
                index++;
            }
        }
        scanning.close();
        System.out.println("------------------------");
        for (int i = 0; i < countStuds; i++) {
            System.out.println(profnames[i]);
        }
        System.out.println("------------------------");
    }

    public void fireProf() throws FileNotFoundException {
        System.out.println("Which professor you desire to fire?");
        Scanner input = new Scanner(System.in);
        Scanner scanning = new Scanner(file);
        String temp1, temp2, temp3,sus;

        boolean studentEx = false;
        int countStuds = 0;
        while (scanning.hasNext()) {
            temp1 = scanning.next();
            temp2 = scanning.next();
            temp3 = scanning.next();
            sus= scanning.next();

            if (temp3.equals("2")) {
                countStuds++;
            }
        }
        scanning.close();
        Scanner scanning1 = new Scanner(file);
        String[] profnames = new String[countStuds];
        int index = 0;
        while (scanning1.hasNext()) {
            temp1 = scanning1.next();
            temp2 = scanning1.next();
            temp3 = scanning1.next();
            sus= scanning1.next();
            if (temp3.equals("2")) {
                profnames[index] = temp1;
                index++;
            }
        }
        scanning.close();
        System.out.println("------------------------");
        for (int i = 0; i < countStuds; i++) {
            System.out.println(profnames[i]);
        }
        System.out.println("------------------------");
        profChoice = input.nextLine();
    }

    public void fireProfessor() throws IOException {
        Scanner read3 = new Scanner(file);
        int count = 0;
        String username1, password1, role1;
        while (read3.hasNextLine()) {
            read3.nextLine();
            count++;
        }
        read3.close();
        Scanner read1 = new Scanner(file);
        String[] arr = new String[count];
        for (int i = 0; i < count; i++) {
            username1 = read1.next();
            password1 = read1.next();
            role1 = read1.next();
            arr[i] = username1 + " " + password1 + " " + role1;
        }
        read1.close();
        int count1 = 0;
        boolean ue = false;
        boolean pe = false;
        boolean profEx = false;
        Scanner read2 = new Scanner(file);
        while (read2.hasNext()) {
            username1 = read2.next();
            password1 = read2.next();
            role1 = read2.next();
            if (!ue) {
                count1++;
            }
            if (username1.equals(profChoice)) {
                ue = true;
                profEx = true;
                break;
            } else {
                ue = false;
            }
        }
        read2.close();

        if (profEx) {
            for (int o = 0; o < arr.length; o++) {
                if (o == count1 - 1) {
                    arr[o] = "";

                }
            }
            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            writer.close();
            FileWriter fw = new FileWriter(file, true);
            for (int i = 0; i < arr.length; i++) {
                if (i != count1 - 1) {
                    fw.append(arr[i] + "\n");
                }
            }
            fw.close();
            System.out.println("Professor " + profChoice + " got fired!");

        } else {
            System.out.println("Professor doesn't Exists!");
        }
    }

    public void suspendStud() throws FileNotFoundException {
        System.out.println("Which student you desire to suspend?");
        Scanner input = new Scanner(System.in);
        Scanner scanning = new Scanner(file);
        String temp1, temp2, temp3,temp4;

        boolean studentEx = false;
        int countStuds = 0;
        while (scanning.hasNext()) {
            temp1 = scanning.next();
            temp2 = scanning.next();
            temp3 = scanning.next();
            temp4 = scanning.next();
            if (temp3.equals("3")) {
                countStuds++;
            }
        }
        scanning.close();
        Scanner scanning1 = new Scanner(file);
        String[] studnames = new String[countStuds];
        int index = 0;
        while (scanning1.hasNext()) {
            temp1 = scanning1.next();
            temp2 = scanning1.next();
            temp3 = scanning1.next();
            temp4 = scanning1.next();

            if (temp3.equals("3")) {
                studnames[index] = temp1;
                index++;
            }
        }
        scanning.close();
        System.out.println("------------------------");
        for (int i = 0; i < countStuds; i++) {
            System.out.println(studnames[i]);
        }
        System.out.println("------------------------");
        studChoice = input.nextLine();
    }

    public void suspendStudent() throws IOException {
        Scanner read3 = new Scanner(file);
        int count = 0;
        String username1, password1, role1,t4;
        while (read3.hasNextLine()) {
            read3.nextLine();
            count++;
        }
        read3.close();
        Scanner read1 = new Scanner(file);
        String[] arr = new String[count];
        for (int i = 0; i < count; i++) {
            username1 = read1.next();
            password1 = read1.next();
            role1 = read1.next();
            t4 = read1.next();
            if(t4.equals("sus")){
                arr[i] = username1 + " " + password1 + " " + role1+ " "+t4;
            }
            if(t4.equals("no")){
                arr[i] = username1 + " " + password1 + " " + role1+ " "+t4;
            }

        }
        read1.close();

        int count1 = 0;
        boolean ue = false;
        boolean pe = false;
        boolean studEx = false,susEx=false;
        Scanner read2 = new Scanner(file);

        while (read2.hasNext()) {
            username1 = read2.next();
            password1 = read2.next();
            role1 = read2.next();
            t4 = read2.next();
            if (!ue) {
                count1++;
            }
            if (ue) {
                studEx = true;
                break;
            }
            if (username1.equals(studChoice)) {
                ue = true;
            } else {
                ue = false;
            }
            if(t4.equals("sus")){
                susEx=true;
            }
            else{
                susEx=false;
            }

        }
        read2.close();
if(studEx){
    if(!susEx) {

        Scanner read12 = new Scanner(file);
        String[] arr12 = new String[count];
        int countingup = 0;
        while (read12.hasNext()) {
            username1 = read12.next();
            password1 = read12.next();
            role1 = read12.next();
            t4 =read12.next();
            if(countingup==count){
                break;
            }
            if (countingup == count1 - 1) {
                arr12[countingup] = username1 + " " + password1 + " " + role1 + " " + "sus";
                countingup++;

                continue;

            }
            if (countingup != count1 - 1) {
                if(t4.equals("sus")){
                    arr12[countingup] = username1 + " " + password1 + " " + role1+ " "+ "sus";
                    countingup++;
                    continue;
                }
                arr12[countingup] = username1 + " " + password1 + " " + role1+ " "+ "no";
                countingup++;
            }
        }
        read12.close();

        PrintWriter writer = new PrintWriter(file);
        writer.print("");
        writer.close();

        FileWriter fw = new FileWriter(file);
        for(int o =0;o<arr12.length;o++){
            System.out.println(arr12[o]);
            fw.append(arr12[o]+"\n");
        }
        fw.close();
        System.out.println("Student " + studChoice + " got suspended!");

    }
    else {
        System.out.println("Student is already suspended");
    }
}
else{
    System.out.println("Student doesn't Exists!");
}

        }
        public void unsuspendStudent() throws IOException {
            Scanner read3 = new Scanner(file);
            int count = 0;
            String username1, password1, role1,t4;
            while (read3.hasNextLine()) {
                read3.nextLine();
                count++;
            }
            read3.close();
            Scanner read1 = new Scanner(file);
            String[] arr = new String[count];
            for (int i = 0; i < count; i++) {
                username1 = read1.next();
                password1 = read1.next();
                role1 = read1.next();
                t4 = read1.next();
                if(t4.equals("sus")){
                    arr[i] = username1 + " " + password1 + " " + role1+ " "+t4;
                }
                if(t4.equals("no")){
                    arr[i] = username1 + " " + password1 + " " + role1+ " "+t4;
                }

            }
            read1.close();

            int count1 = 0;
            boolean ue = false;
            boolean pe = false;
            boolean studEx = false,susEx=false;
            Scanner read2 = new Scanner(file);

            while (read2.hasNext()) {
                username1 = read2.next();
                password1 = read2.next();
                role1 = read2.next();
                t4 = read2.next();
                if (!ue) {
                    count1++;
                }
                if (ue) {
                    studEx = true;
                    break;
                }
                if (username1.equals(studChoice)) {
                    ue = true;
                } else {
                    ue = false;
                }
                if(t4.equals("sus")){
                    susEx=true;
                }
                else{
                    susEx=false;
                }

            }
            read2.close();
            if(susEx){
                if(studEx) {

                    Scanner read12 = new Scanner(file);
                    String[] arr12 = new String[count];
                    int countingup = 0;
                    while (read12.hasNext()) {
                        username1 = read12.next();
                        password1 = read12.next();
                        role1 = read12.next();
                        t4 =read12.next();
                        if(countingup==count){
                            break;
                        }
                        if (countingup == count1 - 1) {
                            arr12[countingup] = username1 + " " + password1 + " " + role1 + " " + "no";
                            countingup++;

                            continue;

                        }
                        if (countingup != count1 - 1) {
                            if(t4.equals("no")){
                                arr12[countingup] = username1 + " " + password1 + " " + role1+ " "+ "no";
                                countingup++;
                                continue;
                            }
                            arr12[countingup] = username1 + " " + password1 + " " + role1+ " "+ "sus";
                            countingup++;
                        }
                    }
                    read12.close();

                    PrintWriter writer = new PrintWriter(file);
                    writer.print("");
                    writer.close();

                    FileWriter fw = new FileWriter(file);
                    for(int o =0;o<arr12.length;o++){
                        fw.append(arr12[o]+"\n");
                    }
                    fw.close();
                    System.out.println("Student " + studChoice + " got unsuspended!");

                }
                else {
                    System.out.println("Student is already unsuspended");
                }
            }
            else{

                System.out.println("Student doesn't Exists!");
            }
        }
    }
