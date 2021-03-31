package base.task_4_2_1;

enum Level {URGENT, CURRENT, LAZY}

public class Task {
    private String name;
    private Level level;

    public Task(String name) {
        this.name = name;
        this.level = Level.CURRENT;
    }

    public Task(String name, Level level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }
}
