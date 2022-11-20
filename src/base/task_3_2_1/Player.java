package base.task_3_2_1;

import base.task_3_2_1.weapon.*;

class Player {
    // Указываем тип данных Weapon, который будет храниться в "слотах игрока"
    private Weapon[] weaponSlots;

    protected Player() {
        // Снаряжаем нашего игрока
        weaponSlots = new Weapon[] {
                // заполнить слоты оружием
                new BigGun(),
                new WaterPistol(),
                new LaserGun(),
                new RPG(),
                new MachineGun()
        };
    }

    protected int getSlotsCount() {
        // length - позволяет узнать, сколько всего слотов с оружием у игрока
        return weaponSlots.length;
    }

    protected void shotWithWeapon(int slot) {
        // проверка на выход за границы
        // выбросить IllegalArgumentException,
        // если значение slot некорректно
        if (this.weaponSlots.length < slot + 1 || slot < 0) {
            System.out.println("Указан несуществующий слот :(");
            throw new IllegalArgumentException();
        }

        // Получаем оружие из выбранного слота
        Weapon weapon = weaponSlots[slot];
        // Огонь!
        weapon.shot();
    }
}
