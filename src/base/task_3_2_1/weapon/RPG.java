package base.task_3_2_1.weapon;

public class RPG extends Weapon{
    @Override
    public void shot() {
        System.out.printf("Выстрел из %s оставляет после противника лишь мокрое место\n",
                this.getClass().getSimpleName());
    }
}
