package com.kodonho.java;

public abstract class Building {
	// 1. 속성 정의
//	Height 높이;
//	Address 주소;
//	Coordinate위치;
//	Person 소유자정보;
//	Price 가격;
//	Door 문;
//	
	// 2. 기능정의
	void opened(){

	}

}

abstract class Lock {
	public static final int TYPE_ELECTRIC = 1;
	public static final int TYPE_CLASSIC = 2;
	
	int type;
}

abstract class Door {
	public static final int TYPE_REVOLVE = 1;
	public static final int TYPE_SLIDE = 2;
	public static final int TYPE_HINGED = 3;
	
	Lock lock;
	
	int type;
}

