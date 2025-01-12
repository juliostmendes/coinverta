import Service.ApiService;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        String apiKey = "b703f80...";
        ApiService apiService = new ApiService(apiKey);
        Scanner sc = new Scanner(System.in);
        int option = 0;
        double valueToConvert = 0;
        try{
            while(option != 7){
                System.out.println(
                        """
                        ---***---***---***--Coinverta--***---***---***---***---
                        Welcome to Coinverta, choose your convertion option:
                        1) American Dolar [USD] to Brazilian Real [BRL]
                        2) Brazilian Real [BRL] to American Dolar [USD]
                        3) Euro [EUR] to Brazilian Real [BRL]
                        4) Brazilian Real [BRL] to Euro [EUR]
                        5) Argentine Peso [ARS] to Brazilian Real [BRL]
                        6) Brazilian Real [BRL] to Argentine Peso [ARS]
                        7) Exit
                        
                        Chose your option:"""
                );

                option = sc.nextInt();
                if(option < 7){
                    System.out.println("Enter the value you want to convert: ");
                    valueToConvert = sc.nextDouble();
                }

                String response;
                switch(option){
                    case 1:
                        response = apiService.getResponse("USD", "BRL", valueToConvert);
                        break;
                    case 2:
                        response = apiService.getResponse("BRL", "USD", valueToConvert);
                        break;
                    case 3:
                        response = apiService.getResponse("EUR", "BRL", valueToConvert);
                        break;
                    case 4:
                        response = apiService.getResponse("BRL", "EUR", valueToConvert);
                        break;
                    case 5:
                        response = apiService.getResponse("ARS", "BRL", valueToConvert);
                        break;
                    case 6:
                        response = apiService.getResponse("BRL", "ARS", valueToConvert);
                        break;
                    case 7:
                        response = "Thank you, have a good day!";
                        break;
                    default:
                        response = "Select a available option";
                }
                System.out.println(response);
            }

        } catch (InputMismatchException e){
            System.out.println("The input must be a number");
        }


    }
}