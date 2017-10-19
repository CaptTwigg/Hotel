class Guest {
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
	return String.format("Name: %s, room: %d, keys: %d \n", this.name, this.room, this.keys);
}
// public String toString(){
//      return(" Name: " + this.name +
//             " Room: " + this.room +
//             " keys: " + this.keys +
//             "\n");
// }
}
