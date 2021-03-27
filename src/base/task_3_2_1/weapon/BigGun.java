package base.task_3_2_1.weapon;

public class BigGun extends Weapon {
    @Override
    public void shot() {
        System.out.printf("Выстрел %s разрывает противника с первого попадания\n",
                this.getClass().getSimpleName());
    }
}
