package base.task_3_3_1.restrictions;

import base.task_3_3_1.Book;

public interface Supplier {
    String getName();
    void bringBook(Administrator administrator, Book book);
}
