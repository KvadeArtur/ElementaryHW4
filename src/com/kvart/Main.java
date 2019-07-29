package com.kvart;

public class Main {

    public static void main(String[] args) {

        // Интерфейс IntQueue
        IntQueue intQueue = new IntLinkedList();

        //Добавление
        intQueue.add(10);
        intQueue.add(20);
        intQueue.add(30);
        intQueue.add(40);
        intQueue.add(50);

        System.out.println(intQueue);

        //Удаление
        try {
            intQueue.remove();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(intQueue);

        //Вызов первого елемента
        System.out.println(intQueue.element());


        // Интерфейс IntStack
        System.out.println();
        IntStack intStack = new IntLinkedList();

        //Добавление
        intStack.push(10);
        intStack.push(20);
        intStack.push(30);
        intStack.push(40);
        intStack.push(50);

        System.out.println(intStack);

        //Удаление
        try {
            intStack.pop();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(intStack);

        //Вызов последнего добавленного елемента
        System.out.println(intStack.peek());


        // Интерфейс IntList
        System.out.println();
        IntList intList = new IntLinkedList();

        //Добавление
        intList.add(10);
        intList.add(20);
        intList.add(30);
        intList.add(2,15);

        System.out.println(intList);

        //Список с вырезанными елементами по индексам
        System.out.println(intList.subList(2,3));

        //Удаление по индексу
        try {
            intList.remove(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(intList);

        //Удаление по значению
        try {
            intList.removeByValue(30);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(intList);

        //Вызов по индексу
        System.out.println(intList.get(2));

        //Замена по индексу
        intList.set(2, 25);
        System.out.println(intList);

        //Размер
        System.out.println(intList.size());

        //Очищение
        intList.clear();
        System.out.println(intList);

        //Проверка на пустоту
        System.out.println(intList.isEmpty());

    }
}
