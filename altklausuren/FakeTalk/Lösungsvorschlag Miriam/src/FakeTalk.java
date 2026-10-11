
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

public class FakeTalk {

   public static void main(String[] args) throws FakeNewsException {
      List<Quote> quotes = FakeTalk.loadQuotes("altklausuren/FakeTalk/Lösungsvorschlag Miriam/src/corona.csv");
      try {
         QuoteSelectionTerm selectionTerm = new QuoteSelectionTerm(quotes, 3, 4);

         QuoteTerm t1 = new QuoteTerm("Muenchhausen", selectionTerm);
         QuoteTerm t2 = new QuoteTerm("Pinocchio", selectionTerm);
         selectionTerm.register(t1);
         selectionTerm.register(t2);

         selectionTerm.start();
      } catch (FakeNewsException e) {
         e.printStackTrace();
      }
   }

   private static List<Quote> loadQuotes(String filename) throws FakeNewsException {
      List<Quote> quotes = new LinkedList<>();

      // // REPLACE THE CODE BELOW!
      // for ( int i = 1; i <= 25; i++ ) {
      // quotes.add( FakeTalk.parseQuote( String.format( "%b;Quote Text %d;John
      // Doe;Head of Dummy-Data Department %d;Source Code, 17.10.2022;", i % 2 == 0,
      // i, i ) ) );
      // }
      // // REPLACE THE CODE ABOVE!

      File f = new File(filename);
      try (BufferedReader br = new BufferedReader(new InputStreamReader(
            new FileInputStream(f),
            StandardCharsets.UTF_8))) {
         while (br.ready()) {
            String line = br.readLine();
            quotes.add(FakeTalk.parseQuote(line));
         }
      } catch (Exception e) {
         // JOptionPane.showMessageDialog(null, e.getMessage(), "Error reading file",
         // JOptionPane.ERROR_MESSAGE);
         throw new FakeNewsException(e.getMessage());
      }

      return quotes;
   }

   private static Quote parseQuote(String s) {
      if (s != null) {
         String[] parts = s.trim().split(";");
         if (parts.length == 6 || parts.length == 5) {
            return new Quote(parts[1], parts[2], parts[3], parts[4],
                  Boolean.parseBoolean(parts[0]) ? QuoteType.HOT_SHIT : QuoteType.BULLSHIT);
         }
      }
      return null;
   }

}
