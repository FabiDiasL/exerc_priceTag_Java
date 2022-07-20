package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Progam {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		List<Product> products = new ArrayList<>();

		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Product #" + i + " data: ");
			System.out.print("Common, used or imported (c/u/i)? ");
			char letter = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();

			if (letter == 'c') {
				products.add(new Product(name, price));
			} else if (letter == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(sc.next());

				products.add(new UsedProduct(name, price, manufactureDate));
			} else if (letter == 'i') {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();

				products.add(new ImportedProduct(name, price, customsFee));
			} else {
				System.out.println("Enter a valid option (c/u/i)! ");
				i--;
			}
		}
		System.out.println();
		System.out.println("PRICE TAGS: ");
		for (Product prod : products) {
			System.out.println(prod.priceTag());
		}
		sc.close();
	}
}
