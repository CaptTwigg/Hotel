import java.util.*;
import java.io.*;

public class hotel2 {
public static void main(String[] args) throws Exception {
	ArrayList<Guest> guestArray = new ArrayList<>();
	// Guest guests = new Guest();

	for (int i = 0; i < 5; i++) {
		guestArray.add(new Guest("bob" + i, 22, 1));
	}
	guestArray.remove(2);

	for (int i = 0; i < guestArray.size(); i++) {
		System.out.print(guestArray.get(i).toString());
	}
	System.out.println();

	for (Guest i : guestArray) {
		System.out.print(i.toString());
	}
	System.out.println();
	saveToFile(guestArray);
	// System.out.print(Arrays.toString(guestArray));
	// print.append(guestArray.toString());
	// System.out.print(guests.name);
}
public static void saveToFile(ArrayList<Guest> guestArray) throws FileNotFoundException {
	String format;
	PrintStream print = new PrintStream(new File("test.txt"));
	for (int i = 0; i < guestArray.size(); i++) {
		print.append(guestArray.get(i).toString());
	}

	// return String.format("Name: %s, room: %d, keys: %d\n", this.name, this.room, this.keys);
}

static class Guest {
private String name;
private int room;
private int keys;

public Guest(){
}

public Guest(String name, int room, int keys){
	this.name = name;
	this.room = room;
	this.keys = keys;
}

public String toString(){
	return String.format("%s : %d : %d\n", this.name, this.room, this.keys);
}
}
}



// -Show rooms
// -Show customer by name or room
// -Add customer
// -remove customer
// -Show free rooms
