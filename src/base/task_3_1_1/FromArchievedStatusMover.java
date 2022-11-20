package base.task_3_1_1;

class FromArchievedStatusMover extends BookMover {
    protected FromArchievedStatusMover() {
//      Override superclass field value.
        super.allowedNewStatuses = new Status[]{Status.AVAILABLE};
    }
}
