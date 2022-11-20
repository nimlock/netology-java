package base.task_3_2_1.weapon;

public class MachineGun extends Weapon {
    @Override
    public void shot() {
        System.out.printf("Стреляя из %s Вы невольно представляете себя терминатором :)\n",
                this.getClass().getSimpleName());
    }
}
