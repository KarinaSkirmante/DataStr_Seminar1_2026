package datastr;

public class MyArrayList {
	//mainīgie
	private char[] list;
	private int howManyElements = 0;
	private final int DEFAULT_SIZE = 8;
	private int size = DEFAULT_SIZE;
	
	//konstruktori
	public MyArrayList() {
		list = new char[size];
	}
	
	public MyArrayList(int inputSize) {
		if(inputSize > 0 && inputSize < 100000) {
			size = inputSize;
		}
		
		list = new char[size];
		
	}
	
	//funkcijas
	private boolean isEmpty() {
		//1. garais pieraksts
		/*if(howManyElements == 0) {
			return true;
		}
		else
		{
			return false;
		}*/
		//2.īsais if-else
		//return (howManyElements == 0) ? true : false;
		//Cits piemērs īsajam if-else
		/*
		int aaa = 0;
		if(howManyElements == 0) {
			aaa = 3*100;
		}
		else
		{
			aaa = 400/3;
		}
		
		aaa =(howManyElements == 0)? (3*100) : (400/3) ;
		*/
		
				
		//3. ar atgriezto vertību
		return (howManyElements == 0);
		
	}
	
	private boolean isFull() {
		//return (howManyElements==size) ? true : false;
		return (howManyElements==size);
	}
	
	//resize
	private void resize() {
		int newSize = (howManyElements < 200) ? (size * 2) : (int)(size * 1.5);
		char[] newList = new char[newSize];
		
		for(int i = 0; i < howManyElements; i++) {
			newList[i] = list[i];
		}
		
		list = newList;
		size = newSize;
		System.gc();
		
	}

}
