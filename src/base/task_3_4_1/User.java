package base.task_3_4_1;

class User {
    protected String login;
    protected String email;
    protected String password;
    protected int age;

    protected User(String login, String email, String password, int age) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.age = age;
    }
}
