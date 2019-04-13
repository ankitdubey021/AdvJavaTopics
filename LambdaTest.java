package collection;

public class LambdaTest {

	
	void m1(MyFuncInterface inteface) {
		
	}
	
	MyFuncInterface lambda=(a, b) -> System.out.println(a+b);
	
	
	
	
}




interface MyFuncInterface{
	void add(int a,int b);
}
