package base.task_3_3_1;

import base.task_3_3_1.roles.*;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Big bang theory.");
        Book book2 = new Book("How eat fish.");
        Book book3 = new Book("Fast colors.");

        AdministratorLiblarianReader admin = new AdministratorLiblarianReader("Viktor");
        JustReader reader = new JustReader("Petya");
        SupplierReader supplier = new SupplierReader("Karl");

        admin.orederBook(supplier, book1);
        System.out.println("");

        reader.takeBook(book2);
        admin.findAndIssueBook(reader);
        System.out.println("");


        supplier.bringBook(admin, book3);
        System.out.println("");


        admin.overdueNotification(admin);
    }
}
