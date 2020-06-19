package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PaypalService;

public class Program {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		
		
		System.out.println("Enter the contract data: ");
		System.out.print("Number: ");
		int number = sc.nextInt();
		sc.nextLine();
		System.out.print("Date (dd/MM/yyyy ): ");
		Date date = sdf.parse(sc.nextLine());
		System.out.print("Contract value: ");
		double totalValue = sc.nextDouble();
		
		Contract contract = new Contract(number, date, totalValue);
		
		System.out.println("Enter the number of installments: ");
		int n = sc.nextInt();
		
		ContractService contractService = new ContractService(new PaypalService());
		contractService.processContract(contract, n);
		
		System.out.println("Installments: ");
		for(Installment x : contract.getInstallments()) {
			System.out.println(x);
		}
		
		sc.close();
		
	}

}
