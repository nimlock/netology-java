package base.task_4_4_2;

import java.util.Objects;

class Student {
    private String name;
    private String group;
    private String studentId;

    protected Student(String name, String group, String studentId) {
        this.name = name;
        this.group = group;
        this.studentId = studentId;
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected String getGroup() {
        return group;
    }

    protected void setGroup(String group) {
        this.group = group;
    }

    protected String getStudentId() {
        return studentId;
    }

    protected void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }

    @Override
    public boolean equals(Object obj) {
        // Сравним с собой
        if (obj == this) {
            return true;
        }
        // Проверим тип
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        // Приведем тип
        Student other = (Student) obj;
        // Сравним значащие поля (не забывая проверку на null)
        return this.studentId != null && this.studentId.equals(other.getStudentId());
    }
}
