package ch07.Jaeyun;

abstract class Car {
	String modelName;
	
	abstract void drive ();
	abstract void stop ();
}

abstract class EngineCar extends Car implements Refuelable{
	
	String engine;
	
	@Override
	void drive () {
		System.out .println( modelName + " 부릉~~ (운전)");
	}
	@Override
	void stop () {
		System.out.println( modelName + " 덜덜덜.. 푸쉭~ (멈춤)");
	}
	
	@Override
	public void refuel() {
		System.out.println( modelName + " 쿨럭쿨럭 (주유)");
	}

	
}

class DieselCar extends EngineCar {
	
	String engine = "diesl";
	
}

class GasCar extends EngineCar {
	
	String engine = "gas";
	

}

class PluginHybridElectricCar extends Car implements Refuelable, Rechargeable{
	
	String engine = "gas";
	String mortor = "65kw";

	@Override
	void drive() {
		System.out.print( modelName + " 싱싱덜덜 (운전) .. ");
		this.recharge();
	}

	@Override
	void stop() {
		System.out.println( modelName + " 슈웅 (멈춤)");
	}
	
	@Override
	public void refuel() {
		System.out.println(modelName + " 쿨럭쿨럭 (주유)");
	}

	@Override
	public void recharge() {
		System.out.println(modelName + " 위윙 (충전)");
	}
}

class ElectricCar extends Car implements Rechargeable {
	
	String mortor = "65kw";

	@Override
	void drive() {
		System.out.print( modelName + " 싱싱 (운전) ...");
		this.recharge();
	}

	@Override
	void stop() {
		System.out.println( modelName + " 슈웅 (멈춤)");
	}

	@Override
	public void recharge() {
		System.out.println(modelName + " 위윙 (충전)");
		
	}

}

interface Refuelable {
	void refuel ();
}

interface Rechargeable {
	void recharge ();
}


public class PolymorphismTest {

	public static void main(String[] args) {
		GasCar avante = new GasCar();
		avante.modelName = "아반떼";
		avante.drive();
		avante.stop();
		avante.refuel();
		
		System.out.println();
		
		PluginHybridElectricCar prius = new PluginHybridElectricCar();
		prius.modelName = "프리우스";
		prius.drive();
		prius.stop();
		prius.refuel();
		
		System.out.println();
		
		ElectricCar volt = new ElectricCar();
		volt.modelName = "볼트";
		volt.drive();
		volt.stop();
		volt.recharge();
	}

}
