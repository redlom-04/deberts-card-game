import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class Main {
	public static void main(String[] args) {

		try {
			writeTextFromFileByPath("asdf", "src/main/resources/text.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			String result = readTextFromFileByPath("src/main/resources/text.txt");
			System.out.println(result);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("File didn't found");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Sorry we can't read the file");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Sorry we didn't know the error");
		}
	}

	private static String readTextFromFileByPath(String path) throws IOException {
		FileReader fileReader = new FileReader(path);
		StringBuilder stringBuilder = new StringBuilder();
		int value = 0;
		while (value != -1) {
			value = fileReader.read();
			if (value != -1) {
				stringBuilder.append((char) value);
			}
		}
		fileReader.close();
		return stringBuilder.toString();
	}
	private static void writeTextFromFileByPath(String text, String path) throws IOException {
		FileWriter fileWriter = new FileWriter(path);
		fileWriter.write(text);
		fileWriter.flush();
		fileWriter.close();
	}

}
