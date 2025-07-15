package com.ssn.test2;

class Parent{
	
}

class Child extends Parent{
	
}

public class Main {
	public static void main(String[] args) {
		Parent p =new Child();
		check((Child) p);
	}
//	static void check(Parent p) {
//		System.out.println("Parent Obj call");
//	}
	
	static void check(Child c) {
		System.out.println("Child Obj call");
	}
}
