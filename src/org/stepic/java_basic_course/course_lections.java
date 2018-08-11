package org.stepic.java_basic_course;

import java.util.Arrays;

public class course_lections {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
    /*
    static int maxArray(int[] numbers) {...} =>
    => вызов maxArray(new int[] {1,2,3})
    static int maxVarargs(int ... numbers) {...} =>
    => вызов maxVarargs(1,2,3)

    int[] a = {1,2,3}
    int[] b = {4,5,6}
    boolean equals1 = a == b - сравниваются ссылки! ссылаются ли две переменные на один объект
    boolean equals2 = a.equals(b) - сравниваются ссылки!
    boolean equals3 = Arrays.equals(a,b) - необх. import java.util.Arrays;
    boolean equals4 = Array.deepEquals(a,b)

    int[] a = {1,2,3}

    System.out.println(a) -> [I@...
    System.out.println(Arrays.toString(a));
    System.out.println(Arrays.deepToString(a));

    -----------------
    в java.util.Arrays есть много всего:
    сортировка, двоичный поиск, копирование всего или части массива

    -----------------
    Строки

    String hello = "Hello";
    String specialChars = "\r\n\t\"\\";
    String empty = "";

    char[] charArray = {'a','b','c'}
    String string = new String(charArray); - конвертация из char в String
    char[] charsFromString = string.toCharArray(); -- и обратно
    String zeros = "\u0000\u0000";

    String s = "stringIsImmurable";
    int length = s.length();
    char firstChar = s.charAt(0);
    boolean endsWithTable = s.endsWith("table");
    boolean containsIs = s.contains("Is");

    String substring = s.substring(0,6);
    String afterReplace = s.replace("Imm","M");
    String allCapitals = s.toUpperCase();

    String hello = "Hello ";
    String world = "world!";
    String helloWorld = hello + world;
    -- это то же самое, что и блок:
    StringBuilder sb = new StringBuilder();
    sb.append(hello);
    sb.append(world);
    String helloWorld = sb.toString();

    boolean referenceEquals = s1 == s2; -- сравнение ссылок!
    boolean contentEquals = s1.equals(s2); - для строк equals работает! (в отличии от массивов!)
    boolean contentEqualsIgnoreCase = s1.equalsIgnoreCase(s2);

    всё что в одинарных кавычках = это char;
    в двойных = уже строка;
    если есть строка то добавление чисел или символов приводит к конкатенации;
    char + char  = автоматическое преобразование в int .....
    */

        /* //Выберите выражения, которые дадут в качестве результата строку A12.
        System.out.println('A' + '1' + "2");
        System.out.println("A" + 12);
        System.out.println('A' + "12");
        System.out.println("A" + ('\t' + '\u0003'));
        */
        /*
        Реализуйте метод, проверяющий, является ли заданная строка палиндромом.
        Палиндромом называется строка, которая читается одинаково слева направо и справа налево (в том числе пустая).
        При определении "палиндромности" строки должны учитываться только буквы и цифры.
        А пробелы, знаки препинания, а также регистр символов должны игнорироваться.
        Гарантируется, что в метод попадают только строки, состоящие из символов ASCII
        (цифры, латинские буквы, знаки препинания).
         Т.е. русских, китайских и прочих экзотических символов в строке не будет.
        Воспользуйтесь предоставленным шаблоном.
        Декларацию класса, метод main и обработку ввода-вывода добавит проверяющая система.
        Подсказки (не читайте, если хотите решить сами):
        для удаления из строки всех символов, не являющихся буквами и цифрами, можно воспользоваться регулярным выражением
        "[^a-zA-Z0-9]"; найдите в классе String метод, выполняющий замену по регулярному выражению;
        для перестановки символов строки в обратном порядке можно воспользоваться методом reverse(),
        который находится в классе StringBuilder;
        в классе String есть методы для преобразования всей строки в верхний и нижний регистр.
        Sample Input:
        Madam, I'm Adam!
        Sample Output:
        true

        String s = "Madam, I'm Adam!";
        String clear_s = s.replaceAll("[^a-zA-Z0-9]","");
        StringBuilder sb = new StringBuilder();
        sb.append(clear_s);
        sb.reverse();
        String rev_s = sb.toString();
        boolean eq = clear_s.equalsIgnoreCase( rev_s);
        System.out.println(eq);
        ------ alternate
        String str = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return str.equals(new StringBuilder(str).reverse().toString());
        */

        /*
        2.4 Управляющие конструкции - условные операторы и циклы
        if (true){
            do();
         } else {
            els_do();
         }
         System.out.println("Weather is "
                + (weatherIsGood ? "good" : "bad"));

         switch (digit) { - работает с String,int,char,enumerate_types; not works with boolean,long,float!
            case 0:
                text = "zero";
                break;
            case 1:
                text = "one";
                break;
            default:
                text = "???";
         }

         while (haveTime() && haveMoney()){
            goShopping();
         }

         do{
            goShopping();
         } while (haveTime() && haveMoney());

         for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
         }

         for(;;){..} - бесконечный цикл

         for(String arg : args) {
            System.out.println(args);
         }

         boolean found = false;
         for (String element : haystack) {
            if (needle.equals(element)) {
                found = true;
                break;
            }
         }

         int count = 0;
         for (String element : haystack) {
            if (!needle.equals(element)) {
                continue;
            }
            count++;
         }

         --метки!
         boolean found = false;
         outer:
         for (int[] row : matrix) {
            for (int x : row) {
                if (x > 100) {
                    found = true;
                    break outer;
                }
            }
         }

         private static String getGreeting(String name) {
            if (name == null) {
                return "Hello anonymous!";
            } else {
                return "Hello " + name + "!";
            }
         }
        -- + return in "void" method mean immediate exit!

        int i=5; int j = 5;
        i++ + i++ = 5+6 = 11, - пост-инкремент - в пост-инкременте значение будет увеличиваться после инициализации и после этого уже будт проводиться действия
        ++j + ++j = 6+7 = 13  - пре-инкремент  - в пре-инкременте сначала будет увеличиваться значение, а уж потом использоваться эта переменная
        */
        /*
        Реализуйте метод, вычисляющий факториал заданного натурального числа.
        Факториал N вычисляется как 1⋅2⋅...⋅N
        Поскольку это очень быстро растущая функция, то даже для небольших N вместимости типов int и long очень
        скоро не хватит. Поэтому будем использовать BigInteger.
        Воспользуйтесь предоставленным шаблоном. Декларацию класса, метод main и обработку ввода-вывода добавит
        проверяющая система.
        Sample Input 1:
        1
        Sample Output 1:
        1
        Sample Input 2:
        3
        Sample Output 2:
        6

        public static BigInteger factorial(int value) {
            BigInteger f = BigInteger.ONE;
            for (int i=1;i<=value;i++){
                f = f.multiply(BigInteger.valueOf(i));
            }
            return f;
        }
        ------------ alternate
        public static BigInteger factorial(int value) {
            while (value != 1) {
                return BigInteger.valueOf(value).multiply(factorial(value - 1));
            }
            return BigInteger.valueOf(1);
        }
        ------------ alternate
        public static BigInteger factorial(int value) {
            return value > 0 ? factorial(value-1).multiply(BigInteger.valueOf(value)) : BigInteger.valueOf(1);
        }
        */
        /*Реализуйте метод, сливающий два отсортированных по неубыванию массива чисел в один отсортированный
        в том же порядке массив. Массивы могут быть любой длины, в том числе нулевой.
        Предполагается, что вы реализуете алгоритм слияния, имеющий линейную сложность: он будет идти по двум исходным
        массивам и сразу формировать отсортированный результирующий массив.
        Так, чтобы сортировка полученного массива при помощи Arrays.sort() уже не требовалась.
        К сожалению, автоматически это не проверить, так что это остается на вашей совести :)
        Воспользуйтесь предоставленным шаблоном. Декларацию класса, метод main и обработку ввода-вывода добавит
        проверяющая система.
        Пример
        Если на вход подаются массивы {0, 2, 2} и {1, 3}, то на выходе должен получиться массив {0, 1, 2, 2, 3}
        public static int[] mergeArrays(int[] a1, int[] a2) {
            return ...; // your implementation here
        }

        public static int[] mergeArrays(int[] a1, int[] a2) {
                Integer i1 = 0;
                Integer i2 = 0;
                int[] a3 = new int[a1.length + a2.length];
                Integer i3 = 0;
                while (a1.length > i1 && a2.length > i2) {
                    if (a1[i1] < a2[i2]) {
                        a3[i3] = a1[i1];
                        i1++;
                        i3++;
                    } else {
                        a3[i3] = a2[i2];
                        i2++;
                        i3++;
                    }
                }
                if (a1.length > i1) {
                    while (a1.length > i1) {
                        a3[i3] = a1[i1];
                        i1++;
                        i3++;
                    }
                } else {
                    while (a2.length > i2) {
                        a3[i3] = a2[i2];
                        i2++;
                        i3++;
                    }
                }
            return a3;
        }
        ---------- alternate
        public static int[] mergeArrays(int[] a1, int[] a2) {
            int[] r = new int[a1.length+a2.length];
            for(int x=0, y=0, z=0; z< r.length; z++) {
                if(x==a1.length || (y!=a2.length && a1[x]>a2[y])) {
                    r[z] = a2[y];
                    y++;
                } else if(y==a2.length || a1[x]<=a2[y]) {
                    r[z] = a1[x];
                    x++;
                }
            }
            return r;
        }
        ---------- alternate
        public static int[] mergeArrays(int[] a1, int[] a2) {
                int i = 0, j = 0;
                int n = a1.length;
                int m = a2.length;
                int[] result = new int[n + m];
                for (;i < n && j < m;) {
                    result[i + j] = (a1[i] < a2[j])? a1[i++] : a2[j++];
                }
                while (i < n) {
                    result[i + j] = a1[i++];
                }
                while (j < m) {
                    result[i + j] = a2[j++];
                }
                return result;
        }
       ---------- alternate
        public static int[] mergeArrays(int[] a1, int[] a2) {
                int[] result = new int[a1.length + a2.length];
                int aIndex = 0;
                int bIndex = 0;
                for (int i = 0; i < result.length; i++) {
                    result[i] = a1[aIndex] < a2[bIndex] ? a1[aIndex++] : a2[bIndex++];
                    if (aIndex == a1.length) {
                        System.arraycopy(a2, bIndex, result, ++i, a2.length - bIndex);
                        break;
                    }
                    if (bIndex == a2.length) {
                        System.arraycopy(a1, aIndex, result, ++i, a1.length - aIndex);
                        break;
                    }
                }
       ---------- alternate
        public static int[] mergeArrays(int[] a1, int[] a2) {
                int[] a3 = new int[a1.length + a2.length];
                System.arraycopy(a1, 0, a3, 0, a1.length);
                System.arraycopy(a2, 0, a3, a1.length, a2.length);
                Arrays.sort(a3);
                return a3;
        }
       ---------- alternate
        public static int[] mergeArrays(int[] a1, int[] a2) {
            int n = a1.length, m = a2.length;
            int i = 0, j = 0;
            int[] array = new int[n + m];

            while (i < n || j < m)
                array[i + j] = (i < n && (j == m || a1[i] < a2[j])) ? a1[i++] : a2[j++];

            return array;
        }
        */

        /*
        Вам дан список ролей и сценарий пьесы в виде массива строчек.
        Каждая строчка сценария пьесы дана в следующем виде:
        Роль: текст
        Текст может содержать любые символы.
        Напишите метод, который будет группировать строчки по ролям, пронумеровывать их и возвращать результат
        в виде готового текста (см. пример). Каждая группа распечатывается в следующем виде:
        Роль:
        i) текст
        j) текст2
        ...
        ==перевод строки==
        i и j -- номера строк в сценарии. Индексация строчек начинается с единицы, выводить группы следует в
        соответствии с порядком ролей. Переводы строк между группами обязательны, переводы строк в конце текста
        не учитываются.
        Заметим, что вам предстоит обработка огромной пьесы в 50 000 строк для 10 ролей – соответственно,
        неправильная сборка результирующей строчки может выйти за ограничение по времени.
        Обратите внимание еще на несколько нюансов:
        имя персонажа может встречаться в строке более одного раза, в том числе с двоеточием;
        название одной роли может быть префиксом названия другой роли (например, "Лука" и "Лука Лукич");
        роль, у которой нет реплик, тоже должна присутствовать в выходном файле;
        в качестве перевода строки надо использовать символ '\n' (перевод строки в стиле UNIX);
        будьте внимательны, не добавляйте лишних пробелов в конце строк.
        Sample Input:
        roles:
        Городничий
        Аммос Федорович
        Артемий Филиппович
        Лука Лукич
        textLines:
        Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.
        Аммос Федорович: Как ревизор?
        Артемий Филиппович: Как ревизор?
        Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.
        Аммос Федорович: Вот те на!
        Артемий Филиппович: Вот не было заботы, так подай!
        Лука Лукич: Господи боже! еще и с секретным предписаньем!
        Sample Output:
        Городничий:
        1) Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.
        4) Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.

        Аммос Федорович:
        2) Как ревизор?
        5) Вот те на!

        Артемий Филиппович:
        3) Как ревизор?
        6) Вот не было заботы, так подай!

        Лука Лукич:
        7) Господи боже! еще и с секретным предписаньем!

        String[] roles = {"Городничий","Аммос Федорович","Артемий Филиппович","Лука Лукич"};
        String[] textLines = {"Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.","Аммос Федорович: Как ревизор?","Артемий Филиппович: Как ревизор?","Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.","Аммос Федорович: Вот те на!","Артемий Филиппович: Вот не было заботы, так подай!","Лука Лукич: Господи боже! еще и с секретным предписаньем!"};
        StringBuilder[] new_roles = new StringBuilder[roles.length];
        StringBuilder[] sb = new StringBuilder[roles.length];
        // gathering roles
        for (int i=0;i<roles.length;i++) {
            new_roles[i] = new StringBuilder("");
            new_roles[i].append(roles[i]);
            new_roles[i].append(": ");
            sb[i] = new StringBuilder("");
            if (i > 0) {
                sb[i].append("\n");
            }
            sb[i].append(roles[i]);
            sb[i].append(":");
            sb[i].append("\n");
        }
        for (int i=0;i<textLines.length;i++) {
            for (int j=0;j<new_roles.length;j++) {
                if (textLines[i].startsWith(new_roles[j].toString())) {
                    sb[j].append((i+1)+") ");
                    sb[j].append(textLines[i].replaceFirst(new_roles[j].toString(),""));
                    sb[j].append("\n");
                }
            }
        }
        String res = "";
        for(StringBuilder arg : sb) {
            //System.out.println(arg.toString());
            res += arg.toString();
        }
        System.out.println(res);
        -- to answer:
        private String printTextPerRole(String[] roles, String[] textLines) {
            StringBuilder[] new_roles = new StringBuilder[roles.length];
            StringBuilder[] sb = new StringBuilder[roles.length];
            // gathering roles
            for (int i=0;i<roles.length;i++) {
                new_roles[i] = new StringBuilder("");
                new_roles[i].append(roles[i]);
                new_roles[i].append(": ");
                sb[i] = new StringBuilder("");
                if (i > 0) {
                    sb[i].append("\n");
                }
                sb[i].append(roles[i]);
                sb[i].append(":");
                sb[i].append("\n");
            }
            for (int i=0;i<textLines.length;i++) {
                for (int j=0;j<new_roles.length;j++) {
                    if (textLines[i].startsWith(new_roles[j].toString())) {
                        sb[j].append((i+1)+") ");
                        sb[j].append(textLines[i].replaceFirst(new_roles[j].toString(),""));
                        sb[j].append("\n");
                    }
                }
            }
            String res = "";
            for(StringBuilder arg : sb) {
                //System.out.println(arg.toString());
                res += arg.toString();
            }
            return res;
        }
        --------------- alternate
        private String printTextPerRole(String[] roles, String[] textLines) {
                StringBuilder res = new StringBuilder("");
                for(String role: roles){
                    res.append(role).append(':').append('\n');
                    for (int i =  0; i<textLines.length ;i++) {
                        if(textLines[i].startsWith(role +':')){
                            res.append(textLines[i].replaceFirst(role+':',(i+1)+")")).append('\n');
                        }
                    }
                    res.append('\n');
                }
                return  res.toString();
        }
        -------------- alternate
        private String printTextPerRole(String[] roles, String[] textLines) {
                StringBuilder builder = new StringBuilder();
                for (String rol: roles){
                    String temp1 = rol + ":";
                    builder.append(temp1 + "\n");
                    for (int i = 0 ; i < textLines.length; i ++){
                        if (textLines[i].startsWith(temp1)){
                            String temp = textLines[i].replaceFirst(temp1, (i+1)+")");
                            builder.append(temp + "\n");
                        }

                    }
                    builder.append("\n");
                }
                return builder.toString();
            }
        -------------alternate
            private String printTextPerRole(String[] roles, String[] textLines) {
                HashMap<String, StringBuilder> hash = new HashMap<String, StringBuilder>();
                for(String name : roles) {
                    hash.put(name, new StringBuilder());
                }
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < textLines.length; i++) {
                    int border = textLines[i].indexOf(':');
                    String key = textLines[i].substring(0, border);
                    hash.get(key).append((i + 1)).append(")")
                            .append(textLines[i].substring(border + 1, textLines[i].length())).append("\n");
                }

                for (String name : roles) {
                    result.append(name).append(":\n");
                    result.append(hash.get(name));
                    result.append("\n");
                }
                return result.toString();
            }
        -------------alternate
        private String printTextPerRole(String[] roles, String[] textLines) {
           StringBuilder result = new StringBuilder();
                for (String role : roles) {
                    result.append( "\n" + role + ":" + "\n");
                    for (int i = 0; i < textLines.length; i++) {
                        if (textLines[i].startsWith(role + ":"))
                            result.append((i + 1) + ") " +textLines[i].replaceFirst(role + ": ", "") + "\n");
                    }
                }
                return result.toString();
        }
        -------- alternate
        private String printTextPerRole(String[] roles, String[] textLines) {
            StringBuilder SB_Res = new StringBuilder();
            for (String role : roles) {
                SB_Res.append(role.equals(roles[0]) ? role + ":\n" : "\n" + role + ":\n");
                for (int i = 0; i < textLines.length; i++)
                    SB_Res.append(textLines[i].startsWith(role + ":")? textLines[i].replaceFirst(role + ":", String.valueOf(i + 1) + ")") + "\n" : "");
            }
            return SB_Res.toString();
        }
        */

        /*
        http://pastebin.com/eTsVZZrK

        * На игровом поле находится робот. Позиция робота на поле описывается двумя целочисленным координатами: X и Y.
        * Ось X смотрит слева направо, ось Y — снизу вверх. (Помните, как рисовали графики функций в школе?)
        В начальный момент робот находится в некоторой позиции на поле.
        Также известно, куда робот смотрит: вверх, вниз, направо или налево.
        Ваша задача — привести робота в заданную точку игрового поля.
        Робот описывается классом Robot.
        Вы можете пользоваться следующими его методами (реализация вам неизвестна):
        public class Robot {
            public Direction getDirection() {
            // текущее направление взгляда
            }
            public int getX() {
                // текущая координата X
            }
            public int getY() {
                // текущая координата Y
            }
            public void turnLeft() {
                // повернуться на 90 градусов против часовой стрелки
            }
            public void turnRight() {
                // повернуться на 90 градусов по часовой стрелке
            }
            public void stepForward() {
                // шаг в направлении взгляда
                // за один шаг робот изменяет одну свою координату на единицу
            }
        }
        Direction, направление взгляда робота,  — это перечисление:
        public enum Direction {
            UP,
            DOWN,
            LEFT,
            RIGHT
        }
        Как это  выглядит:
        Пример
        В метод передано: toX == 3, toY == 0; начальное состояние робота такое: robot.getX() == 0, robot.getY() == 0,
        robot.getDirection() == Direction.UP
        Чтобы привести робота в указанную точку (3, 0), метод должен вызвать у робота следующие методы:
            robot.turnRight();
            robot.stepForward();
            robot.stepForward();
            robot.stepForward();
        P.S. Если вам понравилось это задание, то вам может прийтись по душе игра Robocode, в которой надо написать алгоритм управления танком. Алгоритмы, написанные разными людьми, соревнуются между собой.
        */

        //Robot robot = new Robot(0, 0, Direction.DOWN);
/*    public static void main(String[] args) {
        Robot robot = new Robot(0,0, Direction.DOWN);
        moveRobot(robot, -10, 20);
    }
    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public static class Robot {
        int x;
        int y;
        Direction dir;

        public Robot (int x, int y, Direction dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        public Direction getDirection() {return dir;}

        public int getX() {return x;}

        public int getY() {return y;}

        public void turnLeft() {
            if      (dir == Direction.UP)    {dir = Direction.LEFT;}
            else if (dir == Direction.DOWN)  {dir = Direction.RIGHT;}
            else if (dir == Direction.LEFT)  {dir = Direction.DOWN;}
            else if (dir == Direction.RIGHT) {dir = Direction.UP;}
        }

        public void turnRight() {
            if      (dir == Direction.UP)    {dir = Direction.RIGHT;}
            else if (dir == Direction.DOWN)  {dir = Direction.LEFT;}
            else if (dir == Direction.LEFT)  {dir = Direction.UP;}
            else if (dir == Direction.RIGHT) {dir = Direction.DOWN;}
        }

        public void stepForward() {
            if (dir == Direction.UP)    {y++;}
            if (dir == Direction.DOWN)  {y--;}
            if (dir == Direction.LEFT)  {x--;}
            if (dir == Direction.RIGHT) {x++;}
        }
    }

        public static void moveRobot(Robot robot, int toX, int toY) {
            int x = toX - robot.getX();
            int y = toY - robot.getY();
            while (!robot.getDirection().equals(Direction.UP)) robot.turnRight();
            if (x < 0) {
                robot.turnLeft();
            } else {
                robot.turnRight();
            }
            while (x != 0) {
                robot.stepForward();
                if (x < 0) {
                    x++;
                } else {
                    x--;
                }
            }
            while (!robot.getDirection().equals(Direction.RIGHT)) robot.turnRight();
            if (y < 0) {
                robot.turnRight();
            } else {
                robot.turnLeft();
            }
            while (y != 0) {
                robot.stepForward();
                if (y < 0) {
                    y++;
                } else {
                    y--;
                }
            }
            ----------------------- alternate
            public static void moveRobot(Robot robot, int toX, int toY)
            {
                int distance = toX - robot.getX();
                Direction direction = distance < 0 ? Direction.LEFT : Direction.RIGHT;
                move(robot, Math.abs(distance), direction);

                distance = toY - robot.getY();
                direction = distance < 0 ? Direction.DOWN : Direction.UP;
                move(robot, Math.abs(distance), direction);
            }

            private static void move(Robot robot, int distance, Direction direction)
            {
                while (direction != robot.getDirection())
                    robot.turnRight();
                while (distance-- > 0)
                    robot.stepForward();
            }
            ----------------------- alternate
            public static void moveRobot(Robot robot, int toX, int toY) {
            int dx = robot.getX() - toX, dy = robot.getY() - toY;

            Direction dirX = dx > 0 ? Direction.LEFT : Direction.RIGHT;
            Direction dirY = dy > 0 ? Direction.DOWN : Direction.UP;

            dx = Math.abs(dx);
            dy = Math.abs(dy);

            while (robot.getDirection() != dirX) robot.turnRight();
            while (dx-- > 0) robot.stepForward();

            while (robot.getDirection() != dirY) robot.turnRight();
            while (dy-- > 0) robot.stepForward();
            ----------------------- alternate
           public static void moveRobot(Robot robot, int toX, int toY) {
              for(; robot.getDirection() != (robot.getX() > toX ? Direction.LEFT : Direction.RIGHT); robot.turnRight());
              for(int i=0, iLen = Math.abs(robot.getX() - toX); i < iLen; i++, robot.stepForward());
              for(; robot.getDirection() != (robot.getY() > toY ? Direction.DOWN : Direction.UP); robot.turnRight());
              for(int i=0, iLen = Math.abs(robot.getY() - toY); i < iLen; i++, robot.stepForward());
           }
            ----------------------- alternate
            public static void moveRobot(Robot robot, int toX, int toY) {
                Direction DirX=robot.getX()>toX? Direction.LEFT:Direction.RIGHT;
                Direction DirY=robot.getY()>toY? Direction.DOWN:Direction.UP;
                while (robot.getDirection()!=DirX) robot.turnLeft();
                while (robot.getX()!=toX) robot.stepForward();
                while (robot.getDirection()!=DirY) robot.turnLeft();
                while (robot.getY()!=toY) robot.stepForward();
            }
            ----------------------- alternate
            public static void moveRobot(Robot robot, int toX, int toY) {
                    while ((robot.getX() != toX) || (robot.getY() != toY)) {
                        int startIndex = Math.abs(toX - robot.getX()) + Math.abs(toY - robot.getY());
                        robot.stepForward();
                        int curIndex = Math.abs(toX - robot.getX()) + Math.abs(toY - robot.getY());
                        if (curIndex == 1) {
                            robot.turnLeft();
                        } else if (startIndex < curIndex) {
                            robot.turnLeft();
                        }
                    }
            }
        }

        }
        //moveRobot(robot, -10, 20);
        //System.out.println(robot.getX()+"_"+robot.getY());
        */
        /*
        http://www.quizful.net/post/features-of-the-application-of-modifiers-in-java
        http://www.javenue.info/post/java-modifiers-summary
        * Где может использоваться модификатор final?
        - В объявлении конструктора.
        + В объявлении нестатического поля класса.
        + В объявлении параметра метода.
        + В объявлении локальной переменной.
        + В объявлении метода.
        + В объявлении класса.
        + В объявлении статического поля класса.
        * */
        /*
        * Дан класс ComplexNumber.
        * Переопределите в нем методы equals() и hashCode() так, чтобы equals() сравнивал экземпляры ComplexNumber
        * по содержимому полей re и im, а hashCode() был бы согласованным с реализацией equals().

        Реализация hashCode(), возвращающая константу или не учитывающая дробную часть re и im, засчитана не будет

        Пример

        ComplexNumber a = new ComplexNumber(1, 1);
        ComplexNumber b = new ComplexNumber(1, 1);
        // a.equals(b) must return true
        // a.hashCode() must be equal to b.hashCode()

        Подсказка 1. Поищите в классе java.lang.Double статический метод, который поможет в решении задачи.
        Подсказка 2. Если задача никак не решается, можно позвать на помощь среду разработки, которая умеет
        сама генерировать equals() и hashCode().
        Если вы воспользовались помощью IDE, то разберитесь, что было сгенерировано и почему оно выглядит именно так.
        Когда вас на собеседовании попросят на бумажке реализовать equals() и hashCode()
        для какого-нибудь простого класса, то среда разработки помочь не сможет.
        * */

 /*
        package org.stepic.java.timer;

        import java.math.BigDecimal;

        public class Main {
            public static void main(String[] args){
                Timer timer = new Timer();
                long time = timer.measureTime(() -> {
                    new BigDecimal("1234567").pow(100000);
                });
                System.out.println(time);
            }
        }

***********************altenate
        package org.stepic.java.timer;

        import java.math.BigDecimal;

        public class Main {
            public static void main(String[] args){
                Timer timer = new Timer();
                long time = timer.measureTime(Main::bigDecimalPower);
                System.out.println(time);
            }

            private static void bigDecimalPower() {
                new BigDecimal("1234567").pow(100000);
            }
        }


--------------------------------------------------------
Реализуйте метод, выполняющий численное интегрирование заданной функции на заданном интервале по формуле левых прямоугольников.

Функция задана объектом, реализующим интерфейс java.util.function.DoubleUnaryOperator. Его метод applyAsDouble() принимает значение аргумента и возвращает значение функции в заданной точке.

Интервал интегрирования задается его конечными точками aa и bb, причем a<=ba<=b. Для получения достаточно точного результата используйте шаг сетки не больше 10−610−6.

Пример. Вызов

integrate(x -> 1, 0, 10)
должен возвращать значение 10.

P.S. Если задача слишком легкая, то дополнительно можете реализовать динамический выбор шага сетки по следующему алгоритму:

Вычислить приближенное значение интеграла функции при начальном значении шага сетки (например, 1).
Вычислить приближенное значение интеграла функции при более мелком шаге сетки (например, уменьшить шаг сетки в два раза).
Если разность двух последовательных приближений интеграла функции достаточно мала, то завершаем алгоритм и возвращаем текущее приближение в качестве результата.
Иначе возвращаемся к шагу 2.
------
public static double integrate(DoubleUnaryOperator f, double a, double b) {
    double s=0;
    for(double x=a; x<b; x+=0.000001, s+=f.applyAsDouble(x)*0.000001);
    return s;
}

---------alternate
 public static double integrate(DoubleUnaryOperator f, double a, double b) {
        double sum = 0.0;
        double step = 1e-6;
        for (double x = a; x < b; x += step) {
           sum += f.applyAsDouble(x);
        }
        return sum * step;
    }
---------alternate
public static double integrateWithGrid(DoubleUnaryOperator f, double a, double b, int grid) {
    double h = (b - a) / grid;
    double result = 0.0;
    for(int i = 0; i < grid; i++) {
        result += f.applyAsDouble(a + h * (i + 0.5));
    }
    result *= h;
    return result;
}

public static double integrate(DoubleUnaryOperator f, double a, double b) {
    int grid = 1;
    double lastRes = integrateWithGrid(f, a, b, grid);
    grid *= 2;
    double currentRes = 0.0;
    while (true) {
        currentRes = integrateWithGrid(f, a, b, grid);
        grid *= 2;
        if (Math.abs(lastRes - currentRes) < 1e-5) {
            return currentRes;
        }
        lastRes = currentRes;
    }
}
---------alternate
    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        // масштаб
        BigInteger scale = BigInteger.valueOf(10);
        // шаг - величина обратная масштабу
        double step = 1 / scale.doubleValue();
        // площадь фигуры
        double area = 0.0;
        // площадь фигуры, посчитанная в прошлый раз
        double area_prev;
        // интегрируем в цикле
        for (double x = a; x < b; x = x + step) {
            // интегрируем по оси Y
            area += f.applyAsDouble(x);
        }
        // домножаем на шаг цикла
        area *= step;
        // пересчитываем в цикле площадь, пока не добьёмся точности
        do {
            // увеличиваем масштаб в 10 раз
            scale = scale.multiply(BigInteger.valueOf(10));
            // пересчитываем шаг
            step = 1 / scale.doubleValue();
            // запоминаем предыдущее значение площади
            area_prev = area;
            // обнуляем площадь
            area = 0.0;
            // интегрируем в цикле
            for (double x = a; x < b; x = x + step) {
            // интегрируем по оси Y
                area += f.applyAsDouble(x);
            }
            // домножаем на шаг цикла
            area *= step;
        // проверяем изменение в пересчитанной площади с заданной точностью
        } while (Math.abs(area - area_prev) > 0.001);
        // возвращаем значение площади
        return area;
    }
-------------------------------------------------------------
Напишите класс AsciiCharSequence, реализующий компактное хранение последовательности ASCII-символов (их коды влезают в один байт) в массиве байт. По сравнению с классом String, хранящим каждый символ как char, AsciiCharSequence будет занимать в два раза меньше памяти.

Класс AsciiCharSequence должен:

реализовывать интерфейс java.lang.CharSequence;
иметь конструктор, принимающий массив байт;
определять методы length(), charAt(), subSequence() и toString()
Сигнатуры методов и ожидания по их поведению смотрите в описании интерфейса java.lang.CharSequence (JavaDoc или исходники).

В данном задании методам charAt() и subSequence() всегда будут подаваться корректные входные параметры, поэтому их проверкой и обработкой ошибок заниматься не нужно. Тем более мы еще не проходили исключения.

P.S. В Java 9 ожидается подобная оптимизация в самом классе String: http://openjdk.java.net/jeps/254
-----------------
public class AsciiCharSequence implements CharSequence {
    byte[] s;
    public AsciiCharSequence(byte[] s) {
        this.s = s;
    }

    @Override
    public int length(){
        return s.length;
    }

    @Override
    public char charAt(int index){
        char s_indx = (char) s[index];
        return s_indx;
    }

    @Override
    public CharSequence subSequence(int start, int end){
        return new AsciiCharSequence(Arrays.copyOfRange(s, start, end));
    };

    @Override
    public String toString() {
        return new String(s);
    }
}
-------------- alternate
    public class AsciiCharSequence implements java.lang.CharSequence{

        byte[] bArr;

        AsciiCharSequence(byte[] bArrtemp) { bArr = bArrtemp;  }

        public AsciiCharSequence subSequence(int start, int end){
            return new AsciiCharSequence(Arrays.copyOfRange(bArr, start, end));
        }

        public char charAt(int index){ return (char) bArr[index]; }

        public int length() { return bArr.length; }

        public String toString(){ return new String(bArr); }
    }
-------------- alternate
public class AsciiCharSequence implements CharSequence {

    private final byte[] value;

    public AsciiCharSequence() {this.value = new byte[0];}

    public AsciiCharSequence(byte[] value)  {this.value = value;}

    public AsciiCharSequence(byte[] value, int start, int end) { this.value = Arrays.copyOfRange(value, start, end); }

    @Override
    public int length() {
        return value.length;
    }

    @Override
    public char charAt(int index) {
        return (char)this.value[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return new AsciiCharSequence(this.value, start, end);
    }

    @Override
    public String toString() {
       return new String(value);
    }
}
-------------- alternate
public class AsciiCharSequence implements CharSequence {
    byte[] asciiCharSeq;

    public AsciiCharSequence(byte[] asciiCharSeq) {
        this.asciiCharSeq = asciiCharSeq;
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return new AsciiCharSequence(Arrays.copyOfRange(this.asciiCharSeq, start, end));
    }

    @Override
    public char charAt(int index) {
        return (char) asciiCharSeq[index];
    }

    @Override
    public int length() {
        return asciiCharSeq.length;
    }

    @Override
    public String toString() {
        return new StringBuilder(this).toString();
    }

    @Override
    public boolean equals(Object obj) {
        return     this == obj
                || obj instanceof AsciiCharSequence
                && this.asciiCharSeq.length == ((AsciiCharSequence) obj).length()
                && this.toString().equals(obj.toString());
    }
}
------------ alternate
public class AsciiCharSequence implements CharSequence {

    private byte[] asciiArray;

    @Override
    public CharSequence subSequence(int i, int i1) {
        byte[] ab = new byte[i1 - i];
        CharSequence a = new AsciiCharSequence(ab);
        for (int j = 0; j < ab.length; j++, i++) {
            ab[j] = asciiArray[i];
        }
        return  a;
    }

    @Override
    public char charAt(int i) {
        return (char) asciiArray[i];
    }

    @Override
    public int length() {
        return asciiArray.length;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < asciiArray.length; i++) {
           result.append((char)asciiArray[i]);
        }
        return  result.toString();
    }

   private AsciiCharSequence (byte[] array) {
asciiArray = array;
    }
}
-------- alternate
public class AsciiCharSequence implements CharSequence {
    private byte[] array;

    public AsciiCharSequence(byte[] array) {
        this.array = new byte[array.length];
        System.arraycopy(array, 0, this.array, 0, array.length);
    }

    @Override
    public int length() {
        return array.length;
    }

    @Override
    public char charAt(int index) {
        return (char)array[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        byte[] subArray = new byte[end - start];
        for (int i = 0; i < subArray.length; i++) {
            subArray[i]= this.array[i+start];
        }
        CharSequence result = new AsciiCharSequence(subArray);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (byte b: array) {
            result.append((char)b);
        }
        return result.toString();
    }
}
------alternate
public class AsciiCharSequence implements CharSequence {
    private byte[] charSequence;

    AsciiCharSequence(byte[] byteSequence) {
        charSequence = byteSequence;
    }

    @Override
    public int length() {
        return charSequence.length;
    }

    @Override
    public char charAt(int index) {
        return (char) charSequence[index];
    }

    @Override
    public AsciiCharSequence subSequence(int start, int end) {
        return new AsciiCharSequence(Arrays.copyOfRange(charSequence, start, end));
    }

    @Override
    public String toString() {
        return new String(charSequence);
    }
}
-----------------------------------------------------
!   Alt+1 - показать/скрыть структуру проекта

public - разрешен доступ отовсюду без ограничений
protected - доступ разрешен только для классов-наследников и для классов текущего пакета
_ - доступ только в пределах пакета
static -
private - доступ только в пределах класса

protected и private не применимы к классам верхнего уровня
final - от этого класса нельзя наследоваться
static final == const

К полям и методам, имеющим модификатор static, можно обращаться, не создавая экземпляр содержащего их класса.
Вложенный класс, объявленный с модификатором static, теряет возможность обращаться к нестатическим членам внешнего класса.

ENUM - перечисленные в объявлении перечисления элементы соответствуют public static final полям класса!
В перечислениях можно после ; поля и методы
В перечислениях уже есть методы .name(), .ordinal(), .values()

extends - наследование

anObject instanceof String - проверка на класс
*/

        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }
}


