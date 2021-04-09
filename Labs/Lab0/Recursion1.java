public class Recursion1{
	public static int FindFact(int number){
		if (number <= 0) {
			return 1;
		}
		return number * FindFact(number - 1);
	}

	public static void main(String args[]){
		int value = FindFact(3);
		String[] s = new String[1];
		System.out.println(value);
		
	}
}