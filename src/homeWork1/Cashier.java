/*
 Created by Dima on 02.10.2015.
 �������� ���������� "������� ����� ������� � ������������", ����� Cashier. �������� �� � ���� ������ ������.
 ����������� ��������� ������� ���������� � ���� ����������� ����:
 ����������� �� ����� � ������, ����� boolean isAuthorized(String login, String password).
 �������� ����, ����� void showMenu()
 ������� �������, ����� void createPurchase()
 �������� � ������� ����� �� ���������, ������� ���-�� ������ ����������� ������, ����� void addGoods(String barCode, int count)
 ������ �� ������� ����� �� ���������, ������� ���-�� ������ ����������� ������, ����� void removeGoods(String barCode, int count)
 �������� �������, ����� void cancelPurchase().
 ��������� �������, �� ����� ��������� ������ ����� �������, ����� double closePurchase()
 */
package homeWork1;

import jdk.nashorn.internal.objects.NativeArray;

import java.util.ArrayList;
import java.util.Scanner;

public class Cashier {

    private static String ulogin = "user1";
    private static String upassword = "pass1";
    private static boolean continueWork = true;
    private static Scanner sc;
    private static boolean authorized = false;
    private static String articles[] = new String[] {"1","2","3","4","5"};
    private static ArrayList<Purchase> purchase;
    private static int option;

    public static void main(String[] args) {

        sc = new Scanner(System.in);
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
                case 2:
                {
                    System.out.println("barcode and count:");
                    addGoods(sc.next(),sc.nextInt());
                }
                case 3:
                {
                    System.out.println("barcode and count:");
                    removeGoods(sc.next(),sc.nextInt());
                }
                case 4: cancelPurchase();
                case 5:
                {

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
        purchase = new ArrayList<>();
    }

    private  static void addGoods(String barCode, int count){
        purchase.add(new Purchase(barCode,count));
    }

    private static void removeGoods(String barCode, int count){
        int i = purchase.size();
        while (i > 0){
            if (purchase.get(i).getArticle().equals(barCode)){
                if (count == purchase.get(i).getCount()){
                    purchase.remove(i);
                }else{
                    purchase.get(i).setCount(count);
                }
            }
        }
    }

    private static void cancelPurchase(){
        purchase = null;
    }

 /*   double closePurchase(){
        for (int i = 0; i < purchase.size(); i++) {
            System.out.println("Purchase:");
            System.out.println("*" + purchase.get(i).getArticle() + "-" + purchase.get(i).getCount());
        }

    }
*/}

