import java.util.*;
import java.io.*;

public class hotel {
public static void main(String[] args) throws Exception {
	Hotel hotel = new Hotel();
	hotel.rooms(5, 2);
	hotel.showRooms("low");
	hotel.searchGuest("guests.dat", "sven");
	hotel.addGuest("guests.dat", "Bobby olsen", 211);
	hotel.showGuests("guests.dat");
}

static class Hotel {
private int[][] roomFloor;

public void rooms(int rooms, int floors){
	this.roomFloor = new int[floors][rooms];
	for (int i = 0; i < roomFloor.length; i++) {
		for (int j = 0; j < roomFloor[0].length; j++) {
			roomFloor[i][j] = (i + 1) * 100 + j;
		}
	}
}

public void showRooms(String sort){
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
public void showGuests(String file) throws FileNotFoundException {
	Scanner scanner = new Scanner(new File(file));
	for (int i = 0; scanner.hasNextLine(); i++) {
		System.out.printf("Guest number %d | %s \n", i + 1, scanner.nextLine());
	}
}

public boolean searchGuest(String file, String name) throws Exception {
	Scanner scanner = new Scanner(new File(file));
	ArrayList<String> found = new ArrayList<String>();

	while (scanner.hasNextLine()) {
		final String lineFromFile = scanner.nextLine();
		if (lineFromFile.toLowerCase().contains(name.toLowerCase())) {
			found.add(lineFromFile);
		}
	}
	if (found.size() > 0) {
		for (String i : found) System.out.printf("found %s \n", i);
		return true;
	} else {
		System.out.print("Didn't find anyone");
		return false;
	}
}
public void addGuest(String file, String name, int room) throws Exception {
	if (!searchGuest(file, name)) {
		FileWriter writer = new FileWriter(new File(file), true);
		writer.write(name + " " + room);
		writer.flush();
		writer.close();
	} else System.out.println("Guest already checked in");
}
}
}



// -Show rooms
// -Show customer by name or room
// -Add customer
// -remove customer
// -Show free rooms
