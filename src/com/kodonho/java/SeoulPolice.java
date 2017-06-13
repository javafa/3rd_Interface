package com.kodonho.java;

import java.util.ArrayList;
import java.util.List;

public class SeoulPolice extends Building implements Prison.Callback {  // Prison 으로 부터 호출당할 interface 를 구현
	List<Person> persons   = new ArrayList<>();
	List<Person> criminals = new ArrayList<>(); 
	// 경찰의 기본 업무
	public void arrest(Person person){
		persons.add(person);
	}
	// 오후 1시에 전원 조사
	public void investigate(){
		int count = 0;
		for(Person person : persons){
			count++;
			if(count%2 == 0){
				person.evidence = true;
			}else{
				person.evidence = false;
			}
		}
	}
	// 배치처리... 오후2시에 현재 잡혀있는 용의자들을
	// 재판을 해서... 유죄인경우만 교도소로 보낸다.
	public void judge(){
		for(Person person : persons){
			if(person.evidence){
				person.guilty = true;
				criminals.add(person);
			}
		}
	}
	
	// 오후 3시
	public void transferTo(Prison prison){
		// criminals 를 교도소로 보내시오
		prison.setPersons(criminals,this);
	}
	
	// Prison 의 Callback 인터페이스 구현체
	@Override
	public void notice(String message) {
		System.out.println(message);
	}
}

class Prison {
	List<Person> prisoners = new ArrayList<>();
	
	public void setPerson(Person person){
		prisoners.add(person);
	}
	
	public void setPersons(List<Person> criminals, Callback police){ // Police 에서 this를 넘겼지만, 다형성에 의해 인터페이스
		for(Person person : criminals){
			prisoners.add(person);
		}
		police.notice("이송이 완료되었습니다.");
	}
	
	// Prison 에서 호출할 대상을 미리 인터페이스로 설계
	public interface Callback {
		public void notice(String message);
	}
}

class Person {
	boolean guilty = false;
	boolean evidence = false;
}