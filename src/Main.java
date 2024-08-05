import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner number = new Scanner(System.in);
        System.out.println("Введите арифметическую операцию (например 4+9): ");

        String input = number.nextLine(); //a+b
        try {
            String result = calc(input);
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            number.close();
        }
    }
    public static String calc(String input){
        String[] line = input.split(""); //a+b
        if (line.length != 3) {
            throw new IllegalArgumentException("Неверный вариант ввода.");
        }
        int a = Integer.parseInt(line[0]);
        String operation = line[1];
        int b = Integer.parseInt(line[2]);

        if (a < 1 || a > 10 || b < 1 || b > 10) {
            throw new IllegalArgumentException("Числа должны быть в диапазоне от 1 до 10 включительно.");
        }

        int result;

        switch (operation) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                if (b == 0) {
                    throw new ArithmeticException("Деление на ноль невозможно.");
                }
                result = a / b;
                break;
            default:
                throw new IllegalArgumentException("Неверная операция. Пример: +, -, /, *.");
        }
        return String.valueOf(result);
    }
}

