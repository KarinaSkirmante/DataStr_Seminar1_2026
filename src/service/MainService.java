package service;

import java.util.Arrays;

import datastr.MyArrayList;

public class MainService {

	public static void main(String[] args) {
		MyArrayList symbols = new MyArrayList(3);
		symbols.add('a');// a
		symbols.add('b');// a b
		symbols.add('c');// a b c
		symbols.add('a');// a b c a
		try
		{
			symbols.print();// a b c a
			symbols.add('Z', 1);// a Z b c a
			symbols.print();// a Z b c a
			symbols.remove(2);//a Z c a
			symbols.print();//a Z c a
			System.out.println(symbols.get(1));//Z
			System.out.println(symbols.search('a'));//0 3
			System.out.println(
					Arrays.toString(symbols.getNextElements('a')));//Z
			
			symbols.sort();
			symbols.print();
			symbols.makeEmpty();//padaram tuksu
			symbols.add('W');
			symbols.print();//W
			
			
		}
		catch (Exception e) {
			System.out.println(e);
		}

	}

}
