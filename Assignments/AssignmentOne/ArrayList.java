/*#**********************************************************************************************************#
#Level 1: 15 Marks
#Question2:
#	Complete the incomplete functions in the ArrayList(Dynamic array API) class. There are 5 incomplete 
#	functions inside the class which are:
#	1) add() - which takes a generic variable as a parameter and adds the element to the dynamic array. 
#			   Insert elements into a dynamic array which doubles in size when the array is 3/4th full 
#			   and halves in size when the array is 1/4th full
#	2) pop() - this function does not take a parameter.When called pop deletes the last element in the dynamic array.
#	3) resize() - this function takes one integer parameter. When called resize changes the size of the array
#				to the value of the parameter sent.
#	4) size() - Does not take ay parameter and returns the number of elements present in the dynamic array.
#	5) toString() - Does not take any parameter and returns the string representation of the dynamic array.
#**********************************************************************************************************#*/
@SuppressWarnings("unchecked")

public class ArrayList<T>
{
	T[] arr;
	int size;
	public ArrayList()
	{
		arr = (T[]) new Object[1];
		size = 0;
	}
	public void add(T ele)
	{
		if(size>=(3*arr.length)/4)
		{
			resize(arr.length*2);
		}
		arr[size++]=ele;
		
	}
	public void pop()
	{
		arr[size-1] = null;
		size--;
		if(size<=(arr.length/4))
		{
			resize(arr.length/2);
		}
		
	}
	public void resize(int length)
	{
		T[] temp = (T[]) new Object[length];
		for (int i=0;i<size ;i++ ) {
			temp[i] = arr[i];
		}
		arr = temp;
		
	}
	public int size()
	{
		return size;
		
	}
	public String toString()
	{
		String str="";
		for (int i=0;i<size ;i++ ) {
			str+=arr[i]+", ";
		}
		str=str.substring(0,str.length()-2);
		str="["+str+"]";
		return str;
	}


/*#*************************************************************************************************************#
#*		DO NOT WRITE/MODIFY CODE BELOW THIS LINE. ANY CHANGES MAY CAUSE YOUR HIDDEN TEST CASES TO FAIL 		*#
#*				YOU MAY USE THE SPACE PROVIDED ABOVE TO WRITE YOUR PROGRAM. ALL THE BEST!					*#
#*************************************************************************************************************#*/



	public static void main(String[] args) {
		ArrayList<Integer> testcase1 = new ArrayList<>();
		testcase1.add(1);
		testcase1.add(2);
		testcase1.add(3);
		testcase1.add(4);
		testcase1.add(5);
		testcase1.pop();
		assert(testcase1.size()==4);
		assert(testcase1.toString().equals("[1, 2, 3, 4]"));
		System.out.println("Testcase1 passed");
		

		ArrayList<String> testcase2 = new ArrayList<>();
		testcase2.add("String1");
		testcase2.add("String2");
		testcase2.add("String3");
		testcase2.pop();
		testcase2.add("String4");
		assert(testcase2.size()==3);
		assert(testcase2.toString().equals("[String1, String2, String4]"));
		System.out.println("Testcase2 passed");
		

		ArrayList<Student> testcase3 = new ArrayList<>();
		testcase3.add(new Student("st1",1,98.7));
		testcase3.add(new Student("st2",2,88.7));
		assert(testcase3.size()==2);
		testcase3.add(new Student("st3",4,48.7));
		testcase3.add(new Student("st4",3,8.7));
		assert(testcase3.size()==4);
		testcase3.pop();
		testcase3.pop();
		testcase3.pop();
		assert(testcase3.toString().equals("[Name: st1, RollNo: 1, Marks: 98.7]"));		
		System.out.print("Testcase3 passed");
	}
}
class Student
	{
		String name;
		int rollno;
		double marks;
		public Student(String n, int r, double m)
		{
			name = n;
			rollno = r;
			marks = m;
		}	
		public String toString()
		{
			return "Name: "+name+", RollNo: "+rollno+", Marks: "+marks;
		}
	}