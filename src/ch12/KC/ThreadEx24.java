 package ch12.KC;

/**
 * Created by Daniel on 2016. 7. 17..
 */
public class ThreadEx24 {
    public static void main(String[] args) {
        Runnable r = new RunnableEx24();
        Thread th1 = new Thread(r);
        Thread th2 = new Thread(r);

        th1.start();
        th2.start();
    }
}


class Account{
    int balance = 1000;

    public void withdraw(int money){
        if (balance >= money){
            try{
                Thread.sleep(1000);
            }
            catch (Exception e){

            }
            balance -= money;
        }
    }
}

class RunnableEx24 implements Runnable{

    Account acc = new Account();

    @Override
    public void run() {
        while (acc.balance > 0){
            int money = (int)(Math.random() * 3 + 1) * 100;
            acc.withdraw(money);
            System.out.println("balance : " + acc.balance);
        }
    }
}