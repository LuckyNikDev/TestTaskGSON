package solution;

import models.Root;

public class Main {
    public static void main(String[] args) {
        String fileName;
        Utils utils = new Utils();
        MathOperations mathOperations = new MathOperationsImpl();

        //открываю ввод с консоли, нужно ввести путь до файла или "stop"
        fileName = utils.checkFile();
        if (fileName.equals("stop"))
            return;

        //парсинг файла и проверка валидности
        ParserJson parserJson = new ParserJsonImpl();
        Root root = parserJson.parse(fileName);
        if (utils.checkData(root)) {
            System.out.println("Invalid file data");
            return;
        }

        System.out.println("Average flight time: " + mathOperations.averageTime(root) + " minutes");
        System.out.println("Percentile 90: " +
                mathOperations.calculatingPercentile(root, 90.0));
    }
}
