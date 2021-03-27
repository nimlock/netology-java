package base.task_3_3_1.restrictions;

public interface Administrator {
    String getName();
    void findAndIssueBook(Reader reader);
    void overdueNotification(Reader reader);
}
