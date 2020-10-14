package com.codegym;

public class MyListTest {

    public static void main(String[] args) {
	MyList<Integer> list = new MyList<>();

	list.add(12);
	list.add(155);
	list.add(112);
	list.add(153);
	list.add(153);
	list.add(1539);

	list.add(0,1223);
	list.add(3,1);
	list.add(2,293);

	list.remove(3);
	list.remove(0);

//	if(list.contains(2452)){
//		System.out.println("Yes");
//	} else{
//		System.out.println("No");
//	}

//		System.out.println(list.indexOf(112));
//		System.out.println(list.indexOf(-89));

//		System.out.println(list.get(0));
//		System.out.println(list.get(2));
//		System.out.println(list.get(3));
//		System.out.println(list.get(13));

//		list.clear();

		MyList<Integer> list2 = list.clone();



	list2.print();
    }
}
