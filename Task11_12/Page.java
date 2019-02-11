package core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class Page {
	private ArrayList<Button> buttons;
	private LinkedList<Field> fields;
	private HashSet<Label> labels;
	private HashMap<String, Dropdown> dropdowns;
	private float id;
	private String title;
	private final String finishOk = "Operation completed successfully!";
	private final String finishNo = "Operation failed!";

	public Page() {
		this.buttons = new ArrayList<Button>();
		this.fields = new LinkedList<Field>();
		this.labels = new HashSet<Label>();
		this.dropdowns = new HashMap<String, Dropdown>();
		this.id = 0f;
		this.title = "";
	}

	public void addToArrayList(Button but) {
		this.buttons.add(but);
	}

	public void addToLinkedList(Field f) {
		fields.add(f);
	}

	public void addToHashSet(Label lab) {
		labels.add(lab);
	}

	public void addToHashMap(String title, Dropdown dr) {
		dropdowns.put(title, dr);
	}

	public void removeFromArrayList(Button but) {
		System.out.println(buttons.remove(but) ? finishOk : finishNo);
	}

	public void removeFromLinkedList(Field f) {
		System.out.println(fields.remove(f) ? finishOk : finishNo);
	}

	public void removeFromHashSet(Label lab) {
		System.out.println(labels.remove(lab) ? finishOk : finishNo);
	}

	public void removeFromHashMap(String title) {
		if (dropdowns.containsKey(title)) {
			dropdowns.remove(title);
			System.out.println(finishOk);
		} else {
			System.out.println(finishNo);
		}
	}

	public void removeFromHashMap(String title, Dropdown dr) {
		System.out.println(dropdowns.remove(title, dr) ? finishOk : finishNo);
	}

	public void replaceInArrayListByIndex(int index, Button but) {
		buttons.set(index, but);
	}

	public void replaceInLinkedListByIndex(int index, Field f) {
		fields.set(index, f);
	}

	public void replaceInHashSet(Label old, Label lab) {
		if (labels.contains(old)) {
			labels.remove(old);
			labels.add(lab);
		} else {
			System.out.println("The element wasn't found!");
		}
	}

	public void replaceInHashMapByIndex(String title, Dropdown dr) {
		if (dropdowns.containsKey(title)) {
			dropdowns.replace(title, dr);
		} else {
			System.out.println("The element with such title is absent!");
		}
		;
	}

	public void replaceInHashMapByIndex(String title, Dropdown dr1, Dropdown dr2) {
		System.out.println(dropdowns.replace(title, dr1, dr2) ? finishOk : finishNo);
	}

	public void printArrayList() {
		System.out.println("ArrayList collection: [name][action]");
		for (Button b : buttons) {
			System.out.println(b);
		}
	}

	public void printLinkedList() {
		System.out.println("LinkedList collection: [id][value]");
		for (Field f : fields) {
			System.out.println(f);
		}
	}

	public void printHashSet() {
		System.out.println("HashSet collection: [name]");
		for (Label lab : labels) {
			System.out.println(lab);
		}
	}

	public void printHashMap() {
		System.out.println("HashMap collection: [List options][isSelected][name]");
		for (Map.Entry<String, Dropdown> dr : dropdowns.entrySet()) {
			System.out.println("Key: " + dr.getKey() + "  Value: " + dr.getValue().toString());
		}
	}
}
