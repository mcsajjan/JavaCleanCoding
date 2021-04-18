package galaxy.trade;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputTradeDetails {
	
	File inputFile;
	
	public InputTradeDetails() {
		ClassLoader classLoader = getClass().getClassLoader();
		inputFile = new File(classLoader.getResource("InputData.txt").getFile());		
	}
	
	public String getTradeDealDetails() {
		
		StringBuilder inputData = new StringBuilder("");

		try (Scanner scanner = new Scanner(inputFile)) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if (line.indexOf("?") > 0) {
					break;
				}
				inputData.append(line).append("\n");
			}
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return inputData.toString();
	}

	public List<String> getTradeOrderDetails() {
		List<String> toBeTradedData = new ArrayList<String>();

		try (Scanner scanner = new Scanner(inputFile)) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if (line.indexOf("?") > 0) {
					toBeTradedData.add(line);
				}
			}
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return toBeTradedData;
	}
}
