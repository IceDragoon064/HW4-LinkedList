import java.util.LinkedList;

public class main
{
	public static void main(String args[])
	{
		LinkedList<Integer> test = new LinkedList();
		test.add(1234);
		test.add(153);
		test.add(33);
		
		System.out.println(test.toString());
		System.out.println("Size: " + test.size());
		
		// First item in list
		int firstNum = test.getFirst();
		int firstNumIndex = test.indexOf(firstNum);
		System.out.println("Number " + firstNum + " found at index " + firstNumIndex);
		
		System.out.println("Number " + test.get(1) + " found at index " + 1);
		
		test.removeFirst();
		
		System.out.println(test.toString());
		System.out.println("Size: " + test.size());
		
		int firstNum2 = test.getFirst();
		int firstNumIndex2 = test.indexOf(firstNum2);
		System.out.println("Number " + firstNum2 + " found at index " + firstNumIndex2);
		
		test.removeLast();
		
		System.out.println(test.toString());
		System.out.println("Size: " + test.size());
		
		test.remove();
		
		
		test.add(415);
		test.add(064);
		test.add(117);
		
		System.out.println(test.toString());
		System.out.println("Size: " + test.size());
		
		
		test.remove(test.indexOf(064));
		
		
		System.out.println(test.toString());
		System.out.println("Size: " + test.size());
	};
}

