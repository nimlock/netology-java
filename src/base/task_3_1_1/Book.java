package base.task_3_1_1;

enum Status {BORROWED, AVAILABLE, OVERDUED, ARCHIVED}

class Book {
    protected final String title;
    protected Status status;

    protected Book(String title) {
        this.title = title;
        this.status = Status.AVAILABLE;
    }

    protected String getStatus() {
        return this.status.toString();
    }

    protected void setStatus(Status newStatus) {
        this.status = newStatus;
    }
}
