package datastr;

import java.util.ArrayList;

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

	public void add(char element) {
		if(isFull()) {
			resize();
		}
		
		list[howManyElements++] = element;
		//howManyElements++; <- palielināšanu veikt cita koda rindiņā
	}
	
	public void add(char element, int index) throws IllegalArgumentException  {
		if(index < 0){
			throw new IllegalArgumentException("Nav iespējams pievienot elementu, jo indekss ir negatīvs");
		}

		if(index > howManyElements) {
			throw new IllegalArgumentException("Nav iespējams pievienot elementu, jo indekss ir lielāks par atļauto");
		}
		
		if(index == howManyElements) {//gadījums, ja grib kā pēdejo saraksta elemntu pievienot
			add(element);
			return;//apstādina funkcija darbību. ja nelietojam return, tad lieotjam elso bloku pēc if
		}
		
		if(isFull()) {
			resize();
		}
		
		for(int i = howManyElements; i > index; i--) {
			list[i] = list[i-1];
		}

		list[index] = element;
		howManyElements++;
	}
	
	public int getHowManyElements() {
		return howManyElements;
	}
	
	//1. funkcijas deklarācija
	public void remove(int index) throws Exception {
		if(isEmpty()) {
			throw new Exception("Saraksts ir tukšs, līdz ar to neko nevar izdzēst");
		}
		if(index < 0){
			throw new IllegalArgumentException("Nevar izdzēst elementu, jo indekss ir negatīvs");
		}
		if(index >= howManyElements) {
			throw new IllegalArgumentException("Nav iespējams idzēst elementu, jo indekss ir lielāks vai vienāds ar elementu skaitu");
		}
		
		for(int i = index; i < howManyElements-1; i++) {
			list[i] = list[i+1];
		}
		
		list[howManyElements-1] = ' ';//priekš referenču vērtībām būs null
		howManyElements--; 
		//abas iepriekšējas koda rindas var optimizēt -> list[--howManyElements] = ' ';

	}

	public char get(int index) throws Exception {
		if(isEmpty()) {
			throw new Exception("Saraksts ir tukšs, līdz ar to nevar iegūt elementu");
		}
		
		if(index < 0){
			throw new IllegalArgumentException("Nevar iegūt elementu, jo indekss ir negatīvs");
		}
		
		if(index >= howManyElements) {
			throw new IllegalArgumentException("Nav iespējams iegūt elementu, jo indekss ir lielāks vai vienāds ar elementu skaitu");
		}
		
		return list[index];
	}
	
	
	public int[] search(char element) throws Exception{
		if(isEmpty()) {
			throw new Exception("Saraksts ir tukšs, līdz ar to nav ieespējams veikt elementa meklēšanu");
		}
		
		int howManyIndexes = 0;
		for(int i = 0;i < howManyElements; i++) {
			if(list[i] == element) {
				howManyIndexes++;
			}
		}
		
		
		int[] indexArray = new int[howManyIndexes];
		int indexForIndexesArray = 0;
		for(int i = 0; i < howManyElements; i++) {
			if(list[i] == element) {
				indexArray[indexForIndexesArray] = i;
				indexForIndexesArray++;
			}
		}
		
		if(indexForIndexesArray == 0) {
			throw new Exception("Meklētais elements " 
		+ element + " neatrodas sarakstā");
		}
		
		return indexArray;
		
	}
	
	
	
	
}
