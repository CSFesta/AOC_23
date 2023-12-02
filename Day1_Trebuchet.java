package snippet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1_Trebuchet {
	public static void main(String[] args) {
		System.out.println();
		ArrayList<String> list = new ArrayList<>();
		try {
			Scanner scanner = new Scanner(new File("C:\\Users\\Windows\\Desktop\\inputs_natal\\input1.txt"));
			while (scanner.hasNextLine()) {
				list.add(scanner.nextLine());
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo n�o encontradoas");
			e.printStackTrace();
		}

		int total = 0;
		for (int i = 0; i < list.size(); i++) {
			String str = "" + "";
			for (int j = 0; j < list.get(i).length(); j++) {
				if (Character.isDigit(list.get(i).charAt(j))) {
					str += list.get(i).charAt(j);
					break;
				}
			}
			for (int j = list.get(i).length() - 1; j >= 0; j--) {
				if (Character.isDigit(list.get(i).charAt(j))) {
					str += list.get(i).charAt(j);
					break;
				}
			}
			total += Integer.parseInt(str);
		}
		System.out.println(total);
	}
}
