package ch07.KC;

/**
 * Created by Daniel on 2016. 4. 24..
 */


class Product1{
    int price;
    int bonusPoint;

    Product1(int price){
        this.price = price;
        bonusPoint = (int)(price/10.0);
    }
}

class Tv3 extends Product1{
    Tv3(){
        super(100);
    }

    @Override
    public String toString() {
        return "Tv";
    }
}

class Computer1 extends Product1{
    Computer1(){
        super(200);
    }

    @Override
    public String toString() {
        return "Computer";
    }
}

class Buyer{
    int money = 1000;
    int bonusPoint = 0;

    void buy(Product1 p){
        if(money < p.price){
            System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
            return;
        }

        money -= p.price;
        bonusPoint += p.bonusPoint;
        System.out.println(p + "을/를 구입하셨습니다.");
    }
}



public class PolyArgumentTest {
    public static void main(String[] args) {
        Buyer b = new Buyer();
        Tv3 tv = new Tv3();
        Computer1 com = new Computer1();

        b.buy(tv);
        b.buy(com);

        System.out.println("현재 남은 돈은" + b.money + "만원입니다.");
        System.out.println("현재 보너스 점수는" + b.bonusPoint + "점입니다.");

    }

}
