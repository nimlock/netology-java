package base.task_3_3_1;

public class Book {
    protected String title;

    protected Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }
}
