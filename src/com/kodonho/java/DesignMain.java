package com.kodonho.java;

public class DesignMain {

	public static void main(String[] args) {
		SeoulPolice police = new SeoulPolice();
		Prison prison = new Prison();
		
		Person theif = new Person();
		police.arrest(theif);
		// ...
		// ...
		// 다수를  잡은 후...
		
		// 오후 1시
		police.investigate();
		
		// 오후 2시
		police.judge();
		
		// 오후 3시
		police.transferTo(prison);
	}
}
