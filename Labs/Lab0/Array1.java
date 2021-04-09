public class Array1{
	static int[] list;

	public Array1(int n){
		list = new int[n];
		for (int i = 0 ; i < n ; i ++ ) {
			list[i] = i + 1;
		}

	}

	public static int[] resize(int n){
		int[] temp = new int[n];
		for (int i = 0 ; i < list.length ; i ++ ) {
			temp[i] = list[i];
		}
		temp[3] = 4;
		list = temp;

		return list;

	}

	public static void main(String[] args) {
		Array1 myarr = new Array1(3);
		int [] value =  myarr.resize(4);

		for (int i = 0; i < value.length; i++ ) {
			System.out.println(value[i]);
		}

		// int [] arr1 = new int[3];
		// arr1[0] = 1;
		// arr1[1] = 2;
		// arr1[2] = 3;

		// for (int i = 0 ; i < arr1.length ; i ++ ) {
		// 	System.out.println(arr1[i]);
		// }
	}
}