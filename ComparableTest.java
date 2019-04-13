package collection;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableTest {

	private static Comparator<StringBuffer> comp = new Comparator<StringBuffer>() {
		@Override
		public int compare(StringBuffer arg0, StringBuffer arg1) {
			return arg0.toString().compareTo(arg1.toString());
		}
	};
	
	
	
	
	/*class Dummy implements Comparator<StringBuffer>{
			
		@Override
		public int compare(StringBuffer arg0, StringBuffer arg1) {
			// TODO Auto-generated method stub
			return arg0.toString().compareTo(arg1.toString());
		}
		
	}*/
	
	
	
	public static void main(String[] args) {
		
		List<StringBuffer> list=new ArrayList<>();
		list.add(new StringBuffer("kkk"));
		list.add(new StringBuffer("abc"));
		list.add(new StringBuffer("pqr"));
		list.add(new StringBuffer("def"));
		list.add(new StringBuffer("xyz"));
		
		Collections.sort(list,  new Comparator<StringBuffer>() {
			@Override
			public int compare(StringBuffer arg0, StringBuffer arg1) {
				return arg0.toString().compareTo(arg1.toString());
			}
			
		});
		System.out.println(list);
		
		
		Collections.sort(list, (sb1,sb2)-> sb2.toString().compareTo(sb1.toString()));
		
		System.out.println(list);
		


		
		
	}
}








