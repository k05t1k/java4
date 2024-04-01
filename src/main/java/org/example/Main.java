package org.example;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // создание массива с названием фирмы часов
        String[] firms = {"Rolex company", "Concern Casio", "Swatch factory"};
        // создание матрицы продуктов, в которой находится название продукта, а также его фирма
        String[][] products = {
                {"Rolex", firms[0]},
                {"Casio", firms[1]},
                {"Swatch", firms[2]}
        };
        // создание листа для пользователей по типу данных string (строка)
        ArrayList<String[]> customers = new ArrayList<>();

        // объявление класса считывание символов с клавиатуры
        Scanner scanner = new Scanner(System.in);

        // объявление переменных, которые будут обозначать
        // ФИО
        // почта
        // телефонный номер
        String fullName;
        String email;
        String phoneNumber;

        // объявляем перменную, отвечающую за продолжение создания заказов
        String answer;

        // объявление счетчика
        int i = 0;

        // бесконечный цикл
        while (true) {
            // вывод идентификатора заказа
            System.out.println("Введите данные для заказа " + (i + 1) + ":");
            // ввод ФИО
            System.out.print("ФИО: ");
            fullName = scanner.nextLine();
            // ввод почты
            System.out.print("Email: ");
            email = scanner.nextLine();
            // ввод номера телефона
            System.out.print("Номер телефона: ");
            phoneNumber = scanner.nextLine();

            // вывод допустимых продуктов для закупа
            System.out.println("Список имеющихся позиций в магазине:");
            for (int j = 0; j < products.length; j++) {
                System.out.println((j + 1) + ". " + products[j][0] + " - " + products[j][1]);
            }

            // ввод идентификатору товара для его выбора для покупки
            System.out.print("Выберите позицию товара (введите номер): ");
            int productIndex = Integer.parseInt(scanner.nextLine()) - 1;
            // ввод кол-ва закупаемого товара
            System.out.print("Количество: ");
            int quantity = Integer.parseInt(scanner.nextLine());

            // добавление в переменную типа ArrayList данных о заказчике и его заказе
            customers.add(new String[]{fullName, email, phoneNumber,
                    products[productIndex][0], products[productIndex][1],
                    String.valueOf(quantity)});

            // программа запрашивает продолжение выполнения записи заказов
            // если ввести "n", то программа прекратит работу
            // если ввести что-либо отличное от "n", то программа продолжит работу
            System.out.println("Хотите продолжить? (y/n):");
            answer = scanner.nextLine();
            if (answer.equals("n"))
                break;

            // обновление счетчика
            i++;
        }

        // цикл для вывода все информации о заказчике и его заказа
        for (int k = 0; k < customers.size(); k++) {
            String[] customer = customers.get(k);
            System.out.println("\nЗаказ " + (k + 1) + ":");
            System.out.println("Заказчик: " + customer[0]);
            System.out.println("Email: " + customer[1]);
            System.out.println("Номер телефона: " + customer[2]);
            System.out.println("Товар: " + customer[3] + " - " + customer[4]);
            System.out.println("Количество: " + customer[5]);
        }
    }
}
