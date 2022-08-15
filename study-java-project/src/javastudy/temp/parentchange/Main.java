package javastudy.temp.parentchange;

public class Main {
	static class Unit {}
	static class AirUnit extends Unit {}
	static class GroundUnit extends Unit {}
	static class Tank extends GroundUnit {}
	static class AirCraft extends AirUnit {}
	static Unit u = new GroundUnit();
	static Tank t = new Tank();
	static AirCraft ac = new AirCraft();	
	
	
	public static void main(String[] args) {
		Unit unit = new Unit();
	}
}

/*
class Unit {}
class AirUnit extends Unit {}
class GroundUnit extends Unit {}
class Tank extends GroundUnit {}
class AirCraft extends AirUnit {}
Unit u = new GroundUnit();
Tank t = new Tank();
AirCraft ac = new AirCraft();

a. u = (Unit)ac;
b. u = ac;
c. GroundUnit gu = (GroundUnit)u;
d. AirUnit au = ac;
e. t = (Tank)u;
f. GroundUnit gu = t;

*/

