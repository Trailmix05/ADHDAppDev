import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ApplicationProgram {
    public static void main(String[] args) throws IOException {
        User account = new User();
        Task tasks;

        File f = new File("uData.txt");
        if (!f.exists() && !f.isDirectory()) {
            System.out.println(
                    "Hello! Thank you for your choice in using my application. This is a personal project that I am developing and publishing solo."
                            + " I started sharing a lot of similar signs to ADHD, and I thought of a very simple system to make sure that I was doing the tasks in my task manger. Have a reward system!"
                            + " When you have a reward, you feel more motivated to do something since you know there will be compensation. This is very similar to an allowence, doing a task, and then getting a sum of money in return."
                            + " For this task manager, each task will be associated to a difficulty. Depending on the difficulty, you can get more or less points. The points are collected in order to get to milestones(the reward)."
                            + " The user chooses their tasks, the difficulty, and which milestones reward what.\nThis application is completely based on trust. There is no purpose to setting all of the tasks to the highest difficulty just to get more points."
                            + "\n//THIS APPLICATION IS SUSCEPTIBLE TO CHANGE AND UPDATES\\\\"
                            + "\n\nFirst, please enter:\n-Username:\n-First Name:\n-Last Name:\n-Age:\n-Gender\n-Password:\n\nAll in that order");
            userInformation(account);
            tasks = createTaskTree();
            System.out.println(
                    "The milestone system works on a 1000 points system.\nFor each difficulty level that is attributed, there is a certain number of points given when the a task of that difficulty is done:"
                            + "\n    0 - 3"
                            + "\n    1 - 5"
                            + "\n    2 - 8"
                            + "\n    3 - 12"
                            + "\n    4 - 20"
                            + "\n    5 - 25"
                            + "\n    6 - 30"
                            + "\n    7 - 35"
                            + "\n    8 - 40"
                            + "\n    9 - 45"
                            + "\n    10 - 50"
                            + "\nThe milestones are at:"
                            + "\n    50 points"
                            + "\n    100 points"
                            + "\n    300 points"
                            + "\n    500 points"
                            + "\n    800 points"
                            + "\n    1000 points");

        }
        milestonesRewardsAndInfoInit();
        f = createFile("uData.txt");
        writeToFile(account.username, f);
        writeToFile(account.firstName, f);
        writeToFile(account.lastName, f);
        writeToFile("" + account.age, f);
        writeToFile("" + account.gender, f);

    }

        /*-------------------------------------------------------------------*/
    /*---------------------------------- Milestones ---------------------------------*/
        /*-------------------------------------------------------------------*/
    public static void milestonesRewardsAndInfoInit() {
        Milestone milestone = new Milestone();
        boolean verifiedMilestones = false;
        Scanner input = new Scanner(System.in);
            String rewardMilestone;
            int verification;
            int choice;

            System.out.println("Choose the reward for each milestone:");
            System.out.println("50 points: ");
            rewardMilestone = input.nextLine();
            milestone.milestonePointsRewards[0][1] = rewardMilestone;
            System.out.println("100 points: ");
            rewardMilestone = input.nextLine();
            milestone.milestonePointsRewards[1][1] = rewardMilestone;
            System.out.println("300 points: ");
            rewardMilestone = input.nextLine();
            milestone.milestonePointsRewards[2][1] = rewardMilestone;
            System.out.println("500 points: ");
            rewardMilestone = input.nextLine();
            milestone.milestonePointsRewards[3][1] = rewardMilestone;
            System.out.println("800 points: ");
            rewardMilestone = input.nextLine();
            milestone.milestonePointsRewards[4][1] = rewardMilestone;
            System.out.println("1000 points: ");
            rewardMilestone = input.nextLine();
            milestone.milestonePointsRewards[5][1] = rewardMilestone;
            showMilestones(milestone);
            while (verifiedMilestones == false) {
                System.out.println(
                        "If your entries are valid, please press on 1, if not, please press 2\nIf your entries aren't valid, please choose the corresponding entry that is wrong:");
                verification = input.nextInt();
                if (verification == 1)
                    verifiedMilestones = true;
                else if (verification == 2) {
                    System.out.println(
                            "Please choose :"
                                    + "\n 1 - 50 points"
                                    + "\n 2 - 100 points"
                                    + "\n 3 - 300 points"
                                    + "\n 4 - 500 points"
                                    + "\n 5 - 800 points"
                                    + "\n 6 - 1000 points");
                }
                choice = input.nextInt();
                if (choice == 1) {
                    System.out.println("50 points:");
                    rewardMilestone = input.nextLine();
                    rewardMilestone = input.nextLine();
                    milestone.milestonePointsRewards[0][1] = rewardMilestone;
                } else if (choice == 2) {
                    System.out.println("100 points:");
                    rewardMilestone = input.nextLine();
                    milestone.milestonePointsRewards[1][1] = rewardMilestone;
                } else if (choice == 3) {
                    System.out.println("300 points:");
                    rewardMilestone = input.nextLine();
                    milestone.milestonePointsRewards[2][1] = rewardMilestone;
                } else if (choice == 4) {
                    System.out.println("500 points:");
                    rewardMilestone = input.nextLine();
                    milestone.milestonePointsRewards[3][1] = rewardMilestone;
                } else if (choice == 5) {
                    System.out.println("800 points:");
                    rewardMilestone = input.nextLine();
                    milestone.milestonePointsRewards[4][1] = rewardMilestone;
                } else if (choice == 6) {
                    System.out.println("1000 points:");
                    rewardMilestone = input.nextLine();
                    milestone.milestonePointsRewards[5][1] = rewardMilestone;
                } else {
                    System.out.println(
                            "Please choose :"
                                    + "1 - 50 points"
                                    + "2 - 100 points"
                                    + "3 - 300 points"
                                    + "4 - 500 points"
                                    + "5 - 800 points"
                                    + "6 - 1000 points");
                }
            }
            System.out.println(
                "Awesome! All of your entries have been saved! Now, we're just going to save all of your data and you'll be all good to go!");
        }
    public static void showMilestones(Milestone pfMilestone) {
        System.out.println("So your milestones are:");
        for (int i = 0; i < 6; i++) {
            System.out.println(
                    pfMilestone.milestonePointsRewards[i][0] + " points : " + pfMilestone.milestonePointsRewards[i][1]);
        }
    }
        /*-------------------------------------------------------------------*/
    /*---------------------------------- User ---------------------------------*/
        /*-------------------------------------------------------------------*/

    public static void userInformation(User pfUser) {
        Scanner input = new Scanner(System.in);
            boolean confirmation_User = false;

            System.out.println("Your username:");
            pfUser.username = input.nextLine();
            System.out.println("Your first name:");
            pfUser.firstName = input.nextLine();
            System.out.println("Your last name:");
            pfUser.lastName = input.nextLine();
            System.out.println("Your age:");
            pfUser.age = input.nextInt();
            System.out.println("Your gender:\n1 - Male\n2 - Female\n3 - Other");
            pfUser.gender = input.nextInt();
            while (confirmation_User) {
                System.out.println(
                        "If your entries are valid, please press on 1, if not, please press 2"
                                + "\nIf your entries aren't valid, please choice the corresponding entry that is wrong:");
                if (input.nextInt() == 1)
                    confirmation_User = true;
                else if (input.nextInt() == 2) {
                    System.out.println(
                            "Please choose :"
                                    + "1 - Username"
                                    + "2 - First name"
                                    + "3 - Last name"
                                    + "4 - Age"
                                    + "5 - Gender");
                }
                switch (input.nextInt()) {
                    case 1:
                        System.out.println("Your username:");
                        pfUser.username = input.nextLine();
                        break;
                    case 2:
                        System.out.println("Your first name:");
                        pfUser.username = input.nextLine();
                        break;
                    case 3:
                        System.out.println("Your last name:");
                        pfUser.username = input.nextLine();
                        break;
                    case 4:
                        System.out.println("Your age:");
                        pfUser.username = input.nextLine();
                        break;
                    case 5:
                        System.out.println("Your gender:");
                        pfUser.username = input.nextLine();
                        break;
                    default:
                        System.out.println("Please enter either:"
                                + "1 - Username"
                                + "2 - First name"
                                + "3 - Last name"
                                + "4 - Age"
                                + "5 - Gender");
                        break;
                }
            }
        }

    public static String getuName(User User) {
        return User.username;
    }

    public static String getfName(User User) {
        return User.firstName;
    }

    public static String getlName(User User) {
        return User.lastName;
    }

    public static int getA(User User) {
        return User.age;
    }

    public static int getG(User User) {
        return User.gender;
    }
        /*-------------------------------------------------------------------*/
    /*---------------------------------- Tasks ---------------------------------*/
        /*-------------------------------------------------------------------*/

    public static void showTasks(Task pfTask) {
        for (int i = 0; i < getNbrTasks(pfTask); i++)
            System.out.println(pfTask.arrayTasks[i][0] + " : " + pfTask.arrayTasks[i][1]);
    }

    public static void saveTasks(Task pfTasks) {
        Scanner input = new Scanner(System.in);
            System.out.println(
                    "Now, let's save all of the tasks that you would like to keep track of.");
            int i = 0;
            String Task;
            while (i < getNbrTasks(pfTasks)) {
                System.out.println("Task n°" + (i + 1) + "/" + getNbrTasks(pfTasks));
                Task = input.nextLine();
                System.out.println("The task is : " + Task);
                pfTasks.arrayTasks[i][0] = Task;
                i++;
            }
            System.out.println("Now, let's associate a difficult for each task");
            int j = 0;
            String Difficulty;
            while (j < getNbrTasks(pfTasks)) {
                System.out.println("The difficulty of task n°" + (j + 1) + " is : " + pfTasks.arrayTasks[j][0]);
                Difficulty = "" + input.nextInt();
                System.out.println("The difficulty is : " + Difficulty);
                pfTasks.arrayTasks[j][1] = Difficulty;
                j++;
            }
        }

    public static Task createTaskTree() {
        boolean validInputs = false;
        int nbrTasks;

        System.out.println("How many tasks would you like to keep track of? Please enter a whole number");
        Scanner input = new Scanner(System.in);
            nbrTasks = input.nextInt();
            Task tasks = new Task(nbrTasks);
            while (validInputs == false) {
                saveTasks(tasks);
                showTasks(tasks);
                System.out.println("Is this correct?\n1 - Yes\n2 - No");
                if (input.nextInt() == 1) {
                    validInputs = true;
                }
            }

            return tasks;
    }

    public static int getNbrTasks(Task tasks) {
        return tasks.nbrLines;
    }

    public static String getTask(Task tasks, int line) {
        return tasks.arrayTasks[line][0];
    }

    public static String getDifficulty(Task tasks, int line) {
        return tasks.arrayTasks[line][1];
    }

        /*-------------------------------------------------------------------*/
    /*---------------------------------- File ---------------------------------*/
        /*-------------------------------------------------------------------*/

    public static File createFile(String pfFileName) throws IOException {
        File createFile = new File(pfFileName);
        if (createFile.createNewFile()) {
            System.out.println("File created");
        } else {
            System.out.println("File already exists");
        }
        return createFile;
    }

    public static void writeToFile(String dataToSave, File pfFileNameFile) throws IOException {
        FileWriter saveToFile = new FileWriter(pfFileNameFile);
            saveToFile.write(dataToSave);
    }

    public static void saveTasksToFile(Task tasksToFiles, File pfFileNameFile) throws IOException {
        int len = tasksToFiles.nbrLines;
        for (int i = 0; i < len; i++) {
            writeToFile("Task:" + tasksToFiles.arrayTasks[i][0], pfFileNameFile);
            writeToFile("Difficulty:" + tasksToFiles.arrayTasks[i][1], pfFileNameFile);
        }
    }
}