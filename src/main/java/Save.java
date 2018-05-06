
import java.util.InputMismatchException;
import java.util.Scanner;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Save implements Serializable {
	private static final long serialVersionUID = 5L;
	private Scanner var;
	public static void main(String[] args)  {
		
	}
	
	public void quickSave(GenerateMap map)throws IOException {
		FileOutputStream fos = new FileOutputStream("src/main/java/nl/rug/oop/introduction/saves/quicksave.ser");
	    ObjectOutputStream oos = new ObjectOutputStream(fos);
	    oos.writeObject(map);
	    oos.flush();
	    oos.close();
	}
	public String getInput() {
		var = new Scanner(System.in);
		try {
			return var.nextLine();
		}
		catch(InputMismatchException e) {
			System.out.println("Please enter valid name");
			return getInput();
		} 
	}
	public void save(GenerateMap map)throws IOException {
		System.out.println("Type the save name");
		String nameSave = getInput();
		FileOutputStream fos = new FileOutputStream("src/main/java/nl/rug/oop/introduction/saves/"+nameSave+".ser");
	    ObjectOutputStream oos = new ObjectOutputStream(fos);
	    oos.writeObject(map);
	    oos.flush();
	    oos.close();
	}
}
