package base.task_3_2_1.weapon;

public class LaserGun extends Weapon {
    @Override
    public void shot() {
        System.out.printf("Выстрел %s аккуратно делит врагов на кусочки\n",
                this.getClass().getSimpleName());
    }
}
