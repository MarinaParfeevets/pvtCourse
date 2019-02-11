package core;

import java.util.Arrays;
import java.util.List;

public class Task12 {
	public static void main(String[] args) {
		Page p = new Page();

		Button b1 = new Button("A1", "but1");
		Button b2 = new Button("A2", "but2");
		Button b3 = new Button("A3", "but3");

		p.addToArrayList(b1); // add to Arraylist
		p.addToArrayList(b2);
		p.addToArrayList(b3);
		p.printArrayList(); // print ArrayList
		p.removeFromArrayList(b3); // remove from ArrayList
		p.printArrayList();
		p.replaceInArrayListByIndex(0, b3); // change by index
		p.printArrayList();

		Field f1 = new Field(123, "field1");
		Field f2 = new Field(234, "field2");
		Field f3 = new Field(354, "field3");
		Field f4 = new Field(523, "field4");

		p.addToLinkedList(f1);
		p.addToLinkedList(f2);
		p.addToLinkedList(f3);
		p.addToLinkedList(f4);
		p.printLinkedList(); // print LinkedList
		p.removeFromLinkedList(f3); // remove
		p.removeFromLinkedList(f3);
		p.printLinkedList();
		p.replaceInLinkedListByIndex(1, f3);
		p.printLinkedList();

		Label l1 = new Label("label1");
		Label l2 = new Label("label2");
		Label l3 = new Label("label3");
		Label l4 = new Label("label4");

		p.addToHashSet(l1);
		p.addToHashSet(l2);
		p.addToHashSet(l3);
		p.addToHashSet(l4);
		p.printHashSet();
		p.replaceInHashSet(l1, l2);
		p.printHashSet();
		p.removeFromHashSet(l2);
		p.printHashSet();

		List<String> list1 = Arrays.asList("list1", "list2", "list3");
		List<String> list2 = Arrays.asList("a", "d");

		Dropdown d1 = new Dropdown(list1, true, "d1");
		Dropdown d2 = new Dropdown(list2, true, "d2");
		Dropdown d3 = new Dropdown(Arrays.asList("li1", "li2", "li3", "li4"), false, "d3");
		Dropdown d4 = new Dropdown(Arrays.asList("droplist1"), false, "d4");

		p.addToHashMap("a", d1);
		p.addToHashMap("aad", d2);
		p.addToHashMap("bj", d3);
		p.addToHashMap("pol", d4);
		p.printHashMap();
		p.removeFromHashMap("a");
		p.removeFromHashMap("a");
		p.removeFromHashMap("bj", d2);
		p.printHashMap();
		p.replaceInHashMapByIndex("pol", d1);
		p.replaceInHashMapByIndex("gh", d2, d3);
		p.printHashMap();

	}
}
