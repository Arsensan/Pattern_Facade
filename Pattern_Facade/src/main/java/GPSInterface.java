public class GPSInterface {
    private GPSPower power;
    private GPSNotifier notifier;
    private RoadAdvisor advisor;


    public GPSInterface (GPSPower power, GPSNotifier notifier, RoadAdvisor advisor){
        this.power = power;
        this.notifier = notifier;
        this.advisor = advisor;
    }

    public void activate(){
        power.powerOn();
        notifier.downloadRoadInformation();
        advisor.route();
    }
    /*
    В конструктор класса передаются все элементы, управление которыми мы хотим скрыть «за фасадом».
     Метод activate() будет выполнять всю рутинную работу за водителя – включать систему,
     загружать информацию о ситуации на дорогах и прокладывать оптимальный маршрут и это все по нажатию одной кнопки!
     */
}
