package base.task_3_1_1;

class FromBorrowedStatusMover extends BookMover {
    protected FromBorrowedStatusMover() {
//      Override superclass field value.
        super.allowedNewStatuses = new Status[]{Status.AVAILABLE, Status.ARCHIVED, Status.OVERDUED};
    }
}
