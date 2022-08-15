package javaalgorithm.comparatorstudy;

import java.util.Arrays;
import java.util.Comparator;

public class Main3 {
	public static void main(String[] args) {
		Person[] personArr = new Person[6];
		personArr[0] = new Person("a", 4, 2, 1);
		personArr[1] = new Person("b", 1, 1, 1);
		personArr[2] = new Person("c", 1, 2, 3);
		personArr[3] = new Person("d", 2, 2, 2);
		personArr[4] = new Person("e", 2, 2, 5);
		personArr[5] = new Person("f", 1, 1, 1);
		
		Arrays.sort(personArr);
		
		for (Person person : personArr) {
			System.out.println(person);
		}
		
		System.out.println("=======================");
		
		Arrays.sort(personArr, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return (o1.nGold + o1.nSilver + o1.nBronze) - (o2.nGold + o2.nSilver + o1.nBronze);
			}	
		});

		for (Person person : personArr) {
			System.out.println(person);
		}		
	}
	
	public static class Person implements Comparable<Person> {
		String name;
		int nGold;
		int nSilver;
		int nBronze;
		
		Person(String name, int nGold, int nSilver, int nBronze) {
			this.name = name;
			this.nGold = nGold;
			this.nSilver = nSilver;
			this.nBronze = nBronze;
		}
		
		@Override
		public String toString() {
			return "name: " + name 
					+ ", nGold: " + nGold 
					+ ", nSilver: " + nSilver
					+ ", nBronze: " + nBronze;
		}

		@Override
		public int compareTo(Person o) {
			if (nGold != o.nGold) return nGold - o.nGold;
			else if (nSilver != o.nSilver) return nSilver - o.nSilver;
			else if (nBronze != o.nBronze) return nBronze - o.nBronze;
			else return name.compareTo(o.name);
		}
	}
}
