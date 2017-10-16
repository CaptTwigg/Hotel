import java.util.*;
import java.io.*;

public class hotel {
public static void main(String[] args) throws Exception {
	Hotel hotel = new Hotel("guests.dat");

	showRooms("low", hotel.rooms(5, 2));
	addGuest(hotel, "Oskar Ostrid", 202);
	showGuests("guests.dat");
	searchGuest(hotel, "bob");
}

public static void addGuest(Hotel hotel, String name, int room) throws Exception {
	if (hotel.searchGuest(name).isEmpty()) {
		System.out.printf("Guest added: %s in room %d \n", name, room);
		hotel.addGuest(name, room);
	}else System.out.println("Guest already checked in");
}

public static void searchGuest(Hotel hotel, String name) throws Exception {
	if (hotel.searchGuest(name).isEmpty()) System.out.println("Didn't find anyone");
	else for (String i : hotel.searchGuest(name)) System.out.printf("Found: %s \n", i);
}

public static void showGuests(String file) throws FileNotFoundException {
	Scanner scanner = new Scanner(new File(file));
	for (int i = 0; scanner.hasNextLine(); i++) {
		System.out.printf("Guest number %d | %s \n", i + 1, scanner.nextLine());
	}
}

public static void showRooms(String sort, int[][] roomFloor){
	if (!sort.toLowerCase().equals("low") && !sort.toLowerCase().equals("high")) {
		System.out.println("Not a valid command, must be low or high");
	}
	if (sort.toLowerCase().equals("high")) {
		for (int i = 0; i < roomFloor.length; i++) {
			for (int j = 0; j < roomFloor[0].length; j++) {
				System.out.printf("%-4d", roomFloor[i][j]);
			}
			System.out.println();
		}
	}
	if (sort.toLowerCase().equals("low")) {
		for (int i = roomFloor.length - 1; i >= 0; i--) {
			for (int j = 0; j < roomFloor[0].length; j++) {
				System.out.printf("%-4d", roomFloor[i][j]);
			}
			System.out.println();
		}
	}
}

// starting class hotel
static class Hotel {
private String file;

public Hotel(String file){
	this.file = file;
}

public int[][] rooms(int rooms, int floors){
	int[][] roomFloor = new int[floors][rooms];
	for (int i = 0; i < roomFloor.length; i++) {
		for (int j = 0; j < roomFloor[0].length; j++) {
			roomFloor[i][j] = (i + 1) * 100 + j;
		}
	}
	return roomFloor;
}

// Return array of found guests or empty array if not
public ArrayList<String> searchGuest(String name) throws Exception {
	Scanner scanner = new Scanner(new File(file));
	ArrayList<String> found = new ArrayList<String>();

	while (scanner.hasNextLine()) {
		final String lineFromFile = scanner.nextLine();
		if (lineFromFile.toLowerCase().contains(name.toLowerCase())) {
			found.add(lineFromFile);
		}
	}
	return found;
}

public void addGuest(String name, int room) throws Exception {
	FileWriter writer = new FileWriter(new File(file), true);
	writer.write(name + " " + room + "\n");
	writer.flush();
	writer.close();
}
}
}



// -Show rooms
// -Show customer by name or room
// -Add customer
// -remove customer
// -Show free rooms
