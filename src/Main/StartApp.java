package Main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import Entities.ImportedProduct;
import Entities.Product;
import Entities.UsedProduct;

public class StartApp {
	
	static Scanner scan = new Scanner(System.in);
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	static List<Product> list = new ArrayList<>();
	
	public static void main(String[] args) {
		
		System.out.print("Enter the number of the products: ");
			int n = readInteger();
			
		for (int i=1; i<=n; i++) {
			System.out.println("\nProduct " + i + "# data:");
			System.out.println("Product Common, Used or Imported");
				readType();	
		}
		
		System.out.println("\nPRICE TAGS: ");
		for (Product prod : list) {
			System.out.println(prod);
			
		}
		
		
		
		scan.close();
	}
	
	private static void readType() {
		System.out.print("Type your option: ");
			String type = scan.nextLine();
		System.out.print("Name: ");
			String name = scan.nextLine();
		System.out.print("Price: ");
			double price = readDouble();
			
		if (type.equalsIgnoreCase("COMMON")) {
			Product common = new Product(name, price);
			list.add(common);
				
		} else if (type.equalsIgnoreCase("USED")) {
			System.out.print("Manufacture date (DD/MM/YYYY): ");
			
				try {
					Date date = sdf.parse(scan.next()); scan.nextLine();
					UsedProduct used = new UsedProduct(name, price, date);
					list.add(used);
					
				} catch (ParseException e) {
					System.out.println("Invalid Date!: " + e.getMessage());
					
				} 
			
		} else if (type.equalsIgnoreCase("IMPORTED")) {
			System.out.print("Customs fee: ");
				double customFee = readDouble();
				Product imported = new ImportedProduct(name, price, customFee);
				list.add(imported);
				
		} else {
			System.out.println("Invalid Option, Type again!");
			readType();
			
		}
	}
	
	private static double readDouble() {
		double value = scan.nextDouble(); scan.nextLine();
		return value;
	}
	
	private static int readInteger() {
		int value = scan.nextInt(); scan.nextLine();
		return value;
	}

}
