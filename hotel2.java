import java.util.*;
import java.io.*;

public class hotel2 {
public static void main(String[] args) throws Exception {
	String file = "test.txt";
	// ArrayList<Guest> guestArray = new ArrayList<>();
	ArrayList<Guest> guestArray = loadFile(file);
	//
	// for (int i = 0; i < 5; i++) {
	//      guestArray.add(new Guest("bob" + i, 22, 1));
	// }
	// guestArray.add(new Guest("Kenneth", 102, 8));
	// guestArray.remove(2);

	// for (Guest i : loadFile(file)) {
	//      System.out.print(i.toString());
	// }

	// System.out.println(loadFile(file));
	saveToFile(guestArray, file);
}

public static void saveToFile(ArrayList<Guest> guestArray, String file) throws Exception {
	PrintStream print = new PrintStream(new File(file));
	for (int i = 0; i < guestArray.size(); i++) {
		print.append(guestArray.get(i).toString());
	}
}

public static ArrayList<Guest> loadFile(String file) throws Exception {
	Scanner scanner = new Scanner(new File(file));
	ArrayList<Guest> guestArray = new ArrayList<>();

	while (scanner.hasNextLine()) {
		System.out.println(scanner.nextLine());
		String a = scanner.next();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		// guestArray.add(new Guest(scanner.next(), scanner.nextInt(), scanner.nextInt()));
		guestArray.add(new Guest(a, b, c));

		// guestArray.add(new Guest("sven", 1, 1));
	}

	return guestArray;
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
	return String.format("%s %d %d\n", this.name, this.room, this.keys);
}
}
}



// -Show rooms
// -Show customer by name or room
// -Add customer
// -remove customer
// -Show free rooms
