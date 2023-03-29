package ru.itmo.lessons.yrok27_03_2027.dz29_03_2023;

public class Group {
    private boolean set;
    private Climber[] arr;
    private Mountain gora;

    public Group(boolean set, Climber[] arr, Mountain gora) {
        if (arr != null && gora != null) {
            this.set = set;
            this.gora = gora;
            this.arr=arr;
        } else throw new IllegalArgumentException("ошибка введеных данных");
    }

    public void AddClimberGroup(Climber hel) {
        if (hel != null && set != false) {
            if (arr == null) {
                Climber[] arr = new Climber[1];
                arr[0] = hel;
                return;
            } else {
                Climber[] arr2 = new Climber[arr.length + 1];
                for (int i = 0; i < arr.length; i++) {
                    arr2[i] = arr[i];
                }
                arr2[arr.length] = hel;
                arr=arr2;
            }
        } else throw new IllegalArgumentException("ошибка введеных данных");
    }

    public void print(){
        System.out.println("В группу входит: ");
        if(arr!=null || arr.length!=0)
        for (var a:arr){
           a.print();
        }
        else System.out.println("В группе нет человек");
        System.out.println("Гора: ");
        gora.print();
        System.out.println("набор :" + (set==true?"открыт": "закрыт"));
    }
}
