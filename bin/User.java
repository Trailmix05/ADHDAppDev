public class User {
    String userId;
    String username;
    String firstName;
    String lastName;
    int age;
    int gender;
    String password;
    Task taskList;

    User(){
        this.userId = "";
        this.username = "";
        this.firstName = "";
        this.lastName = "";
        this.age = -1;
        this.gender = -1;
        this.password = "";
        this.taskList = new Task();
    }

    User(String uID, String userN, String firstN, String lastN, int age, int gender, String pwd){
        this.userId = uID;
        this.username = userN;
        this.firstName = firstN;
        this.lastName = lastN;
        this.age = age;
        this.gender = gender;
        this.password = pwd;
        this.taskList = new Task();
    }
}
