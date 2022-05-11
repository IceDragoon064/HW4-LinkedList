import java.util.LinkedList;

public class main
{
	public static void main(String args[])
	{
		LinkedList<Integer> test = new LinkedList();
		test.add(1234);
		test.add(153);
		test.add(33);
		
		
		// First item in list
		int firstNum = test.getFirst();
		int firstNumIndex = test.indexOf(firstNum);
		System.out.println("Number " + firstNum + " found at index " + firstNumIndex);
		
		test.removeFirst();
		
		int firstNum2 = test.getFirst();
		int firstNumIndex2 = test.indexOf(firstNum2);
		System.out.println("Number " + firstNum2 + " found at index " + firstNumIndex2);
		
		
		
		test.add(415);
		test.add(064);
		test.add(117);
		
		test.remove(064);
		System.out.println("Number " + test.get(2) + " found at index " + 2);
	}
}

