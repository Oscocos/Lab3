import java.io.IOException;
import java.net.URL;
import java.util.Scanner;


public class WebScraper {
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static int wordCount(String input) {
        String[] arrayOfWords = input.split(" ");
        return arrayOfWords.length;
    }

    public static int singleWordCount(String input, String word) {
        int count = 0;

        String[] arrayOfWords = input.split(" ");
        for (int i = 0; i < arrayOfWords.length; i++) {
            if (word.equalsIgnoreCase(arrayOfWords[i])) {
                count++;
            }
        }
        return count;
    }


    public static void main(String[] unused) {
        //String input = urlToString("http://erdani.com/tdpl/hamlet.txt");
        String input = "Hola hola hola hola hi hi";
        int count = singleWordCount(input, "hola");
        System.out.println(count);
    }
}
