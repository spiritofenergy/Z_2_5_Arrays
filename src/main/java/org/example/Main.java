package org.example;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        String[] quotes = new String[20];
        for (int i = 0; i < quotes.length; i++) {
            quotes[i] = "";
        }
        int counter = 0;
        for (int i = 0; i < 20; i++) {
            String page = downloadWEbPage("https://api.breakingbadquotes.xyz/v1/quotes");
            int quote4 = page.lastIndexOf("quote");
            int author4 = page.indexOf("author");
            int author_4 = page.indexOf("\"}]");
            String strQuote = page.substring(quote4 + 7, author4 - 2);
            String strAuthor = page.substring(author4 + 9, author_4);
            //   String strShortQuote = page.substring(quote4 + 7, quote4 + 50);
            //  String newQuoteWithAuthor = strAuthor + " " + strQuote;
            //System.out.println(strQuote + " " + strAuthor);
            // System.out.println(strQuote);
            // counter++;


            boolean wordInAlready = false;
            for (int y = 1; y < quotes.length; y++) {
                String existingQuote = quotes[i];
                if (existingQuote.equals(quotes)) {
                    wordInAlready = true;

                }else {
                    System.out.println("Запись");
                    quotes[i] = strQuote;
                }
            }
            writerFileString(strQuote);
        }
            for (int y = 0; y < quotes.length; y++) {
                Thread.sleep(500);
                counter++;
                System.out.println(counter + " " + quotes[y]);
            }
    }
    private static void writerFileString(String strQuote) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("E:\\Sinergy\\Z_2_5_Arrays\\src\\main\\java\\org\\example\\text.txt", true));
        writer.append(strQuote + "\n");
        writer.close();
    }

    private static String downloadWEbPage (String url) throws IOException {
            StringBuilder result = new StringBuilder();
            String line;
            URLConnection urlConnection = new URL(url).openConnection();
            try (InputStream is = urlConnection.getInputStream();
                 BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
                while ((line = br.readLine()) != null) {
                    result.append(line);
                }
            }
            return result.toString();
        }
    }


/*



  String currentQuote = quotes[i];
                if (strQuote.equals(currentQuote)) {
                    wordInAlready = true;
                }

                if (wordInAlready) {
                    System.out.println("word is array");
                } else {
                    quotes[i] = strQuote;
                    writerFileString(strQuote);
                }



  FileReader fileReader = new FileReader("book.txt");
        BufferedReader reader = new BufferedReader(fileReader);
    String[] part = new String[100];
      for (int i = 0; i < 100; i++){
          part[i] = reader.readLine();
        System.out.println(part[i]);

       }
      for(int i = 30; i>20; i--){
            System.out.println(part[i]);
        }

  System.out.println("11.Выведите курс валют за 1 февраля  каждого года с 1994 до текущего года");

        String [] courses = new String[10];
        for(int i = 0; i < 10; i++){
            courses[i]= "Not found";
        }
        for (int day = 1; day <= 10; day++) {
            String strDay = day < 10 ? "0" + day : String.valueOf(day);
            Thread.sleep(500);
            String page1 = downloadWebPage("http://www.cbr.ru/scripts/XML_daily.asp?date_req="+ strDay +"/11/2020");
            int startIndex1 = page1.lastIndexOf("<Value>");
            int endIndex1 = page1.lastIndexOf("</Value>");
            String courseStr1 = page1.substring(startIndex1 + 7, endIndex1);
            System.out.println(strDay +"/11/2020 : " + courseStr1);
            courses[day-1]=courseStr1;
        }
        System.out.println("Курс за 7 ноября " + courses[0]);
    }

    Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size array");
        int size = scanner.nextInt();
        int[] a = new int[size];

        int nextValue;
        int currentIndex = 0;
        do {
            System.out.println("Enter next value : ");
             nextValue = scanner.nextInt();
             a[currentIndex] = nextValue;
            currentIndex++;
        }while (nextValue != 777);

        for ( currentIndex = 0; currentIndex <= size -1; currentIndex++){
            System.out.println(" a [i] = " + a[currentIndex]);
        }
    }*/