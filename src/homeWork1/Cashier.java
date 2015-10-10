/*
 Created by Dima on 02.10.2015.
 Написать приложение "Рабочее место кассира в супермаркете", класс Cashier. Оформить всё в виде одного класса.
 Реализовать следующие функции приложения в виде консольного меню:
 Авторизация по имени и паролю, метод boolean isAuthorized(String login, String password).
 Показать меню, метод void showMenu()
 Создать покупку, метод void createPurchase()
 Добавить в покупку товар по штрихкоду, указать кол-во единиц покупаемого товара, метод void addGoods(String barCode, int count)
 Убрать из покупки товар по штрихкоду, указать кол-во единиц покупаемого товара, метод void removeGoods(String barCode, int count)
 Отменить покупку, метод void cancelPurchase().
 Завершить покупку, на экран выводится общаяя сумма покупки, метод double closePurchase()
 */
package homeWork1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Cashier {

    private static String ulogin = "user1";
    private static String upassword = "pass1";
    private static boolean continueWork = true;
    private static Scanner sc;
    private static boolean authorized = false;
    private static ArrayList<Product> productList = new ArrayList<>();
    private static Purchase purchase;
    private static int option;

    public static void main(String[] args) {

        sc = new Scanner(System.in);

        //create product list
        productList.add(new Product("p1", 1.0));
        productList.add(new Product("p2", 2.0));
        productList.add(new Product("p3", 3.0));

        while (continueWork){

            if (authorized != true) {
                System.out.println("Please authorize");

                System.out.print("Login: ");
                String login = "user1";//sc.next();
                System.out.print("Password: ");
                String password = "pass1";//sc.next();

                if (isAuthorized(login, password)) {
                    System.out.println("Wellcome " + login);
                } else {
                    System.out.println("Incorrect login or password. Try again");
                }
            }

            showMenu();
            option = sc.nextInt();
            switch (option) {
                case 1: createPurchase();
                        break;
                case 2:
                {
                    System.out.println("when finish, type y");
                    String enterGoods = "y";
                    while (enterGoods.equals("y")){
                        System.out.println("barcode and count:");
                        addGoods(sc.next(), sc.nextInt());
                        System.out.println("Continue? Y/N");
                        enterGoods = sc.next();
                    }
                    break;
                }
                case 3:
                {
                    System.out.println("barcode and count:");
                    removeGoods(sc.next(),sc.nextInt());
                    break;
                }
                case 4: cancelPurchase();
                        break;
                case 5:
                {
                    System.out.println("Summary: " + closePurchase());
                    break;
                }
            }

            finishWork();
        }
    }

    private static void finishWork(){
        System.out.println("Do you want to finish?");
        if (sc.next().equals("Y")){
            continueWork = false;
        };
    }

    private static boolean isAuthorized(String login, String password){
        if (ulogin.equals(login) && upassword.equals(password)){
            authorized = true;
            return true;
        }
        return false;
    }

    private static void showMenu(){
        System.out.println("OPTIONS:\n" +
                "1 Create purchase\n" +
                "2 Add item by article\n" +
                "3 Remove item by article\n" +
                "4 Cancel purchase\n" +
                "5 Close purchase"
        );
    }

    private static void createPurchase(){
        purchase = new Purchase();
    }

    private  static void addGoods(String barCode, int count){
        if (purchase == null){
            System.out.println("Create purchase first");
            return;
        }
        for (Product product : productList){
            if (product.getArticle().equals(barCode)){
                purchase.addProduct(product, count);
                return;
            }
        }
    }

    private static void removeGoods(String barCode, int count){
        for (Product product : productList){
            if(product.getArticle().equals(barCode)){
                purchase.removeProduct(product,count);
            }
        }
    }

    private static void cancelPurchase(){
        purchase = null;
    }

    private static double  closePurchase(){
        if (purchase == null){
            System.out.println("Create purchase first");
            return 0.0;
        }
        return purchase.closePurchase();
    }
}

