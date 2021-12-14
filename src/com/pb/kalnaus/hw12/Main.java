package com.pb.kalnaus.hw12;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;


import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Main {


    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        List<PhoneBooks> phoneBooks = new ArrayList<>();
        String action = "";

        ObjectMapper mappers = new ObjectMapper();
        mappers.enable(SerializationFeature.INDENT_OUTPUT);
        SimpleModule modules = new SimpleModule();
        modules.addSerializer(LocalDate.class, new LocalDateSerializer());
        modules.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        mappers.registerModule(modules);

        File file = new File("C:\\Users\\PC\\IdeaProjects\\JavaHomeWork\\src\\com\\pb\\kalnaus\\hw12\\files\\PhoneBook.json");

        System.out.println("Программа Телефонная книга. Может добавлять, удалять, делать поиск, вывод всех записей" +
                ",сортировкой по полю, редактированием элемента. Записывает все в файл и считывает все из него");
        startMessage();
        while (!action.equals("exit")) {
            action = in.nextLine();
            switch (action.toLowerCase().trim()) {

                case "add":
                    addElem(phoneBooks);
                    break;

                case "del":
                    dellElem(phoneBooks);
                    break;

                case "search":
                    searchElem(phoneBooks);
                    break;

                case "print":
                    printCollection(phoneBooks);
                    break;

                case "edit":
                    editNumberCollection(phoneBooks);
                    break;

                case "save":
                    mappers.writeValue(new File(String.valueOf(file)), phoneBooks);
                    System.out.println("Данные успешно сохранены в файл");
                    break;


                case "load":
                    phoneBooks.clear();
                    phoneBooks = mappers.readValue(new File(String.valueOf(file)), new TypeReference<List<PhoneBooks>>() {
                    });
                    System.out.println(phoneBooks);
                    break;

                case "exit":
                    System.out.println("Программа завершила работу.");
                    break;

                default:
                    System.out.println("Вы ввели неверное значение, повторите попытку");
                    break;
            }
        }
    }

    private static void editNumberCollection(List<PhoneBooks> phoneBooks) {
        String tempLine;
        String tempChange;
        int[] tempPhonesNumMass;
        int input;
        try {
            System.out.println("Для редактирования, укажите номер строки, начиная с 0 элемента:");
            phoneBooks.stream().forEach(System.out::println);
            input = Integer.valueOf(in.nextLine());
            System.out.println("Выберите, какое поле редактируем:");
            System.out.println("1 - ФИО:\n2 - дата рождения(формат: yyyy-MM-dd)");
            System.out.println("3 - номера телефонов:\n4 - адресс");
            tempLine = in.nextLine();
            System.out.println("Вы выбрали строку: " + input + "\nВы выбрали поле: " + tempLine + ". Введите значение для замены:");
            tempChange = in.nextLine();

            switch (Integer.valueOf(tempLine)) {
                case 1: //ФИО
                    phoneBooks.get(input).setF_I_O(tempChange);
                    successfullReplaced(input, phoneBooks);

                    break;
                case 2: // Дата рождения
                    phoneBooks.get(input).setB_Day(LocalDate.parse(tempChange.replaceAll("[^\\d-]", ""), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                    successfullReplaced(input, phoneBooks);
                    break;

                case 3: // Номера телефонов)
                    tempPhonesNumMass = Arrays.stream(tempChange.replaceAll("[^\\d,]", "").split(","))
                            .mapToInt(Integer::parseInt).toArray();
                    phoneBooks.get(input).setPhones(tempPhonesNumMass);
                    successfullReplaced(input, phoneBooks);
                    break;

                case 4: //адресс
                    phoneBooks.get(input).setAddress(tempChange);
                    successfullReplaced(input, phoneBooks);
                    break;

                default:
                    System.out.println("Вы ввели неверное значение, повторите попытку");
                    startMessage();
                    break;
            }
        } catch (DateTimeParseException e) {
            System.out.println("Вы указали неверные данные при вводе даты, повторите все сначала");
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Вы ввели неверное значение, повторите попытку");
        }
    }

    private static void successfullReplaced(int editNumCollection, List<PhoneBooks> phoneBooks) {
        phoneBooks.get(editNumCollection).setDate_edit(new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime()));
        System.out.println("Данные успешно изменены");
    }


    private static void printCollection(List<PhoneBooks> phoneBooks) {
        int temp;
        System.out.println("Для вывода отсортированного поля, укажите, по какому полю сортируем:");
        System.out.println(" \"1\" - По ФИО");
        System.out.println(" \"2\" - По дате рождения");
        System.out.println(" \"3\" - По ФИО и дате рождения");
        System.out.println(" \"4\" - По номерам телефонов");
        System.out.println(" \"5\" - По адресам");
        temp = Integer.valueOf(in.nextLine());
        sortCollection(temp, phoneBooks);

    }

    private static void sortCollection(int temp, List<PhoneBooks> phoneBooks) {

        switch (temp) {
            //По ФИО
            case 1:
                Collections.sort(phoneBooks, (a, b) -> a.getF_I_O().compareTo(b.getF_I_O()));
                System.out.println(phoneBooks);

                break;
            case 2:
                //   По дате рождения
                Collections.sort(phoneBooks, (a, b) -> a.getB_Day().compareTo(b.getB_Day()));
                System.out.println(phoneBooks);
                break;

            case 3:
                //По ФИО и дате рождения
                Collections.sort(phoneBooks, (a, b) -> a.getB_Day().compareTo(b.getB_Day()));
                Collections.sort(phoneBooks, (a, b) -> a.getF_I_O().compareTo(b.getF_I_O()));
                System.out.println(phoneBooks);
                break;
            case 4:
                // По номерам телефонов"
                Collections.sort(phoneBooks, (a, b) -> a.getPhones().length - b.getPhones().length);
                System.out.println(phoneBooks);
                break;
            case 5:
                // По адресам"
                Collections.sort(phoneBooks, (a, b) -> a.getAddress().compareTo(b.getAddress()));
                System.out.println(phoneBooks);
                break;
            default:
                System.out.println("Вы ввели неверное значение, повторите попытку");
                startMessage();
                break;

        }
    }


    private static void searchElem(List<PhoneBooks> phoneBooks) {
        int b = 0;
        System.out.println("Введите тект, который ищете:");
        String temp = in.nextLine();
        for (int i = 0; i < phoneBooks.size(); i++) {
            String massString = phoneBooks.get(i).getF_I_O() + " " +
                    phoneBooks.get(i).getB_Day() + " " +
                    Arrays.toString(phoneBooks.get(i).getPhones()) + " " +
                    phoneBooks.get(i).getAddress() + " " +
                    phoneBooks.get(i).getDate_edit();
            if (massString.contains(temp)) {
                System.out.println("Был знайден элемент в массиве. В элементе: " + i);
                System.out.println(massString);
                b++;
            }
        }
        if (b == 0) System.out.println("Совпадений не найдено ");


    }

    private static void dellElem(List<PhoneBooks> phoneBooks) {
        System.out.println("Выберите номер элемента(начиная с 0), который необходимо удалить:");
        System.out.println(phoneBooks);
        try {
            int temp;
            temp = Integer.valueOf(in.nextLine());
            phoneBooks.remove(temp);
            System.out.println("Элемент " + temp + " удален");


        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Вы указали неверные данные.");
        }
    }

    private static void addElem(List<PhoneBooks> list) {
        String fio;
        int[] phonesMass;
        String address;
        LocalDate b_day;
        String timeStamp;
        try {

            //-----------------------------------------------------------------------//
            System.out.println("Введите ФИО");
            fio = in.nextLine();
            if (fio.length() == 0) {
                System.out.println("ОШИБКА. Вы не ввели ФИО");
                startMessage();
                return;
            }
            System.out.println("Введите дату рождения в формате yyyy-MM-dd");
            b_day = LocalDate.parse(in.nextLine().replaceAll("[^\\d-]", ""), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//-----------------------------------------------------------------------//
            System.out.println("Введите номера телефонов, через запятую");
            phonesMass = Arrays.stream(in.nextLine().replaceAll("[^\\d,]", "").split(","))
                    .mapToInt(Integer::parseInt)
                    .toArray();
//-----------------------------------------------------------------------//
            System.out.println("Введите адрес");
            address = in.nextLine();
            if (address.length() == 0) {
                System.out.println("ОШИБКА. Вы не ввели адресс");
                startMessage();
                return;
            }
//-----------------------------------------------------------------------//
            timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
            System.out.println(" ФИО =" + fio + " день варенья =" + b_day + " телефоный(е) номера =" + Arrays.toString(phonesMass) + " адрес =" + address + " время редактирования =" + timeStamp);
            list.add(new PhoneBooks(fio, b_day, phonesMass, address, timeStamp));
            System.out.println("Данные успешно добавленны");
        } catch (DateTimeParseException e) {
            System.out.println("Вы ввели неверную дату. Повторите операцию еще раз");
            startMessage();
        } catch (NumberFormatException e) {
            System.out.println("Вы ввели не номер телефона. Попробуйте выполнить действие сначала");
            startMessage();
        }
    }

    private static void startMessage() {
        System.out.println("Для справки: add    - добавить элемент ");
        System.out.println("             del    - удалить элемент ");
        System.out.println("             search - поиск элемента ");
        System.out.println("             print - вывод всех записей с сортировкой по указанному полю");
        System.out.println("             edit - редактировать элемент ");
        System.out.println("             save - запись элемента в файл ");
        System.out.println("             load - чтение элементов из файла ");
        System.out.println("             exit - завершение программы ");
        System.out.println("Выберите действие, которое вы хотите выполнить: ");
    }
}