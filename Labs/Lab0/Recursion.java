public class Recursion{
	public static int FindFact(int number){
		int s = 1;
		for (int i = 1; i <= number; i++)
		{
			/* code */
			s *= i;
		}
		return s;
	}

	public static void main(String args[]){
		int value = FindFact(3);
		System.out.println(value);
	}
}