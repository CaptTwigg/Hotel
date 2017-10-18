import java.util.*;
import java.io.*;

public class hotel2 {
public static void main(String[] args) throws Exception {
	PrintStream print = new PrintStream(new File("test.txt"));
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

	// System.out.print(Arrays.toString(guestArray));
	print.println(guestArray.toString());
	// System.out.print(guests.name);
}
}



// -Show rooms
// -Show customer by name or room
// -Add customer
// -remove customer
// -Show free rooms
