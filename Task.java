public class Task{
    String[][] arrayTasks;  //A 2D array, with the every line consisting of [Task_Name][Task_Difficulty]
                            //Another way of seeing it is the first column being [Task_Name] and the second column [Task_Difficulty]
    int nbrLines;
    Task(){
        this.nbrLines = 15;
        this.arrayTasks = new String[nbrLines][2];
    }

    Task(int pfNumberOfTasks){
        this.nbrLines = pfNumberOfTasks;
        this.arrayTasks = new String[nbrLines][2];
    }
}