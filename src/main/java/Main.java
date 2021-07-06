import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		try {
			String result = readFilePath("src/main/resources/text.txt");
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	private static String readFilePath(String path) throws IOException {
		FileReader fileReader = new FileReader(path);
		StringBuilder stringBuilder = new StringBuilder();
		int value = 0;
		while (value != -1) {
			value = fileReader.read();
			if (value != -1) {
				stringBuilder.append((char) value);
			}
		}
		return stringBuilder.toString();
	}
}
