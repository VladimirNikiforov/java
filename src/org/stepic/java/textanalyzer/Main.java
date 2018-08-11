package org.stepic.java.textanalyzer;

import java.util.Arrays;

import static java.awt.SystemColor.text;

public class Main // Наш главный класс, все остальные будут его подклассами
{
    public Label checkLabels (TextAnalyzer[] arr, String text) {
        // наш главный метод
        Label ans;
        for (int i = 0; i < arr.length; i++) {
            ans = arr[i].processText(text);
            if (ans != Label.OK) return ans;
        }
        return Label.OK;
    }
    static abstract class KeywordAnalyzer implements TextAnalyzer {
        private String[] keywords;
        protected abstract String[] getKeywords() ;
        protected abstract Label getLabel();

        public boolean stringContainsItemFromList(String[] arr, String txt)
        {
            for(int i =0; i < arr.length; i++)
            {
                if(txt.contains(arr[i]))
                {
                    return true;
                }
            }
            return false;
        }
        public Label processText(String text) {
            //System.out.println(text);
            //System.out.println(getKeywords());
            //if (this instanceof NegativeTextAnalyzer)
            return stringContainsItemFromList(keywords,text) ? getLabel() : Label.OK;
            //return Arrays.stream(getKeywords()).parallel().anyMatch(text::contains) ? getLabel() : Label.OK;
            //return !text.contains(getKeywords()) ? Label.OK : getLabel();
        }
    }
    enum Label { SPAM, NEGATIVE_TEXT, TOO_LONG, OK }
    static class NegativeTextAnalyzer extends KeywordAnalyzer{
        public String[] getKeywords() {
            return this.keywords;
        }

        public Label getLabel() {
            return Label.NEGATIVE_TEXT;
        }

        private String[] keywords;
    }
    static class SpamAnalyzer extends KeywordAnalyzer {
        private String[] keywords;

        public SpamAnalyzer(String[] spamKeywords) {
            this.keywords = spamKeywords;
        }

        public String[] getKeywords() {
            return this.keywords;
        }
        public Label getLabel() {
            return Label.SPAM;
        }
    }
    static class TooLongTextAnalyzer implements TextAnalyzer {
        private int maxLength;

        public TooLongTextAnalyzer(int maxLength) {
            this.maxLength = maxLength;
        }

        public Label processText(String text) {
            return (text.length() > maxLength) ? Label.TOO_LONG : Label.OK;
        }
    }
    interface TextAnalyzer {
        Label processText(String text);
    }



    public static void main(String[] args) {
        // тесты
        // инициализация анализаторов для проверки в порядке данного набора анализаторов
        String[] spamKeywords = {"spam", "bad"};
        int commentMaxLength = 40;
        TextAnalyzer[] textAnalyzers1 = {
                new SpamAnalyzer(spamKeywords),
                new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(commentMaxLength)
        };
        TextAnalyzer[] textAnalyzers2 = {
                new SpamAnalyzer(spamKeywords),
                new TooLongTextAnalyzer(commentMaxLength),
                new NegativeTextAnalyzer()
        };
        TextAnalyzer[] textAnalyzers3 = {
                new TooLongTextAnalyzer(commentMaxLength),
                new SpamAnalyzer(spamKeywords),
                new NegativeTextAnalyzer()
        };
        TextAnalyzer[] textAnalyzers4 = {
                new TooLongTextAnalyzer(commentMaxLength),
                new NegativeTextAnalyzer(),
                new SpamAnalyzer(spamKeywords)
        };
        TextAnalyzer[] textAnalyzers5 = {
                new NegativeTextAnalyzer(),
                new SpamAnalyzer(spamKeywords),
                new TooLongTextAnalyzer(commentMaxLength)
        };
        TextAnalyzer[] textAnalyzers6 = {
                new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(commentMaxLength),
                new SpamAnalyzer(spamKeywords)
        };
        // тестовые комментарии
        String[] tests = new String[8];
        tests[0] = "This comment is so good.";                            // OK
        tests[1] = "This comment is so Loooooooooooooooooooooooooooong."; // TOO_LONG
        tests[2] = "Very negative comment !!!!=(!!!!;";                   // NEGATIVE_TEXT
        tests[3] = "Very BAAAAAAAAAAAAAAAAAAAAAAAAD comment with :|;";    // NEGATIVE_TEXT or TOO_LONG
        tests[4] = "This comment is so bad....";                          // SPAM
        tests[5] = "The comment is a spam, maybeeeeeeeeeeeeeeeeeeeeee!";  // SPAM or TOO_LONG
        tests[6] = "Negative bad :( spam.";                               // SPAM or NEGATIVE_TEXT
        tests[7] = "Very bad, very neg =(, very ..................";      // SPAM or NEGATIVE_TEXT or TOO_LONG
        TextAnalyzer[][] textAnalyzers = {textAnalyzers1, textAnalyzers2, textAnalyzers3,
                textAnalyzers4, textAnalyzers5, textAnalyzers6};
        Main testObject = new Main();
        int numberOfAnalyzer; // номер анализатора, указанный в идентификаторе textAnalyzers{№}
        int numberOfTest = 0; // номер теста, который соответствует индексу тестовых комментариев
        for (String test : tests) {
            numberOfAnalyzer = 1;
            System.out.print("test #" + numberOfTest + ": ");
            System.out.println(test);
            for (TextAnalyzer[] analyzers : textAnalyzers) {
                System.out.print(numberOfAnalyzer + ": ");
                System.out.println(testObject.checkLabels(analyzers, test));
                numberOfAnalyzer++;
            }
            numberOfTest++;
        }
    }
}