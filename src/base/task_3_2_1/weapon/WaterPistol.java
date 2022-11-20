package base.task_3_2_1.weapon;

public class WaterPistol extends Weapon {
    @Override
    public void shot() {
        System.out.printf("Выстрел из %s рассекает противника надвое мощной струёй воды\n",
                this.getClass().getSimpleName());
    }
}
