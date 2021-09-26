import java.util.Arrays;
import java.util.Collections;

public class Main {

	public static int SIZE1 = 500;
	public static int SIZE2 = 5000;
	public static int SIZE3 = 10000;

	public void randomFill(int[] arr) {
		for(int i=0; i<arr.length;i++) {
			int random = (int)(Math.random()*(0-10000+1)+10000);  
			arr[i] = random;
		}
	}

	public void sortAscending(int[] arr) {
		Arrays.sort(arr);
	}

	public void sortDescending(int[] arr) {
		int temp;    
		for (int i = 0; i < arr.length; i++) {  
			for (int j = i + 1; j < arr.length; j++){  
				if (arr[i] < arr[j]) {  
					temp = arr[i];  
					arr[i] = arr[j];  
					arr[j] = temp;  
				}  
			}  
		}  
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Main m = new Main();

		int[] arr = new int[SIZE2]; //Modify if you want to change the size of the array

		for(int k=0;k<100;k++) {
			m.randomFill(arr);

			//Do m.sortDescending, m.sortAscending or leave it blank depending on how you want your array initially sorted

			//m.sortDescending(arr);
			
			/**	for (int i = 0; i <=arr.length - 1; i++)   
			{  
			System.out.println(arr[i]);  
			} **/
			
			double t1 = System.currentTimeMillis();
			
			int temp = 0;  
			for(int i=0; i < arr.length; i++){  
				for(int j=1; j < (arr.length-i); j++){  
					if(arr[j-1] > arr[j]){  
						//swap elements  
						temp = arr[j-1];  
						arr[j-1] = arr[j];  
						arr[j] = temp;  
					}  

				}  
			}
			
			
			double t2 = System.currentTimeMillis();
			double et = t2-t1;
			System.out.println(et);

			
		}
		
		
	}

}
