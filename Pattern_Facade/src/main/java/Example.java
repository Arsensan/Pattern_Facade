public class Example {
    public static void main(String[] args) {
        GPSPower power = new GPSPower();
        GPSNotifier notifier = new GPSNotifier();
        RoadAdvisor advisor = new RoadAdvisor();


        // включаем навигатор
        power.powerOn();
        // загружаем инофрмацию о пробках
        notifier.downloadRoadInformation();
        // строим маршрут
        advisor.route();
        // выключаем навигатор
        power.powerOff();

    /*
    Работает неплохо, но как вы можете заметить водитель приходится
    слишком много взаимодействовать с навигационной системой,
    если мы ничего не предпримем конкуренты нас смогут обойти.
    В этом нам и поможет паттерн Фасад, в качестве фасада,
    у нас будет выступать класс GPSInterface, который будет
    за водителя выполнять однотипные действия:
     */
        System.out.println("----------------------------------");
    GPSInterface gpsInterface = new GPSInterface(power, notifier, advisor);

    // включаем и настраиваем навигатор
    gpsInterface.activate();
        // выключаем навигатор
    power.powerOff();
}

/*
Я надеюсь вы обратили внимание, что отключение навигационной системы в нашем примере осталось низменным:
-----------
power.powerOff();
-----------
Это одна из полезных особенностей данного паттерна – мы вольны работать с классами, которые скрыты интерфейсом (фасадом),
напрямую, если в этом есть необходимость. И так, если вам необходимо упростить работу с каким-либо интерфейсом или изолировать клиента от сложной системы,
то паттерн Фасад будет идеальным выбором.
 */
}