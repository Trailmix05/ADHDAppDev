public class User {
    String username;
    String firstName;
    String lastName;
    int age;
    int gender;
    Task taskList;

    User(){
        this.username = "";
        this.firstName = "";
        this.lastName = "";
        this.age = -1;
        this.gender = -1;
        this.taskList = new Task();
    }

    User(String uID, String userN, String firstN, String lastN, int age, int gender, String pwd){
        this.username = userN;
        this.firstName = firstN;
        this.lastName = lastN;
        this.age = age;
        this.gender = gender;
        this.taskList = new Task();
    }
}
