class Cricketer{
	public void best(){
		System.out.println("He is the best cricketer");
	}
}

public class Captain extends Cricketer{
	public void hit(){
		System.out.println("Dhoni hits 3 six in a row");
	}
	public void best(){  //method overriding
		System.out.println("HE is known as Captain Cool");
	}
	public static void main(String[] args) {
		Captain player= new Captain();
		player.hit();
		player.best();
	}
}