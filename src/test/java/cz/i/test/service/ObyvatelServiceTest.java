package cz.i.test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

/**
 * @author jan.hadas@i.cz
 */
public class ObyvatelServiceTest {

  private static final String NAME = "Hanz";
  private static final String SURNAME = "Hagen";
  private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy");

  private ObyvatelService serviceUnderTest = new ObyvatelService();

  @Test
  public void should_persist_new_obyvatel() throws IOException, ClassNotFoundException {
    Long id = serviceUnderTest.createPersist(NAME, SURNAME);

    assertNotNull("ID is null", id);
    // verify persisted entity
    String persistedPerson = serviceUnderTest.print(id);
    assertTrue("Persisted person should have correct name and surname",
            persistedPerson.startsWith(NAME + " " + SURNAME));
  }

   @Test
  public void should_return_formatted_obyvatel_string() throws IOException, ClassNotFoundException {
     Long id = serviceUnderTest.createPersist(NAME, SURNAME, LocalDate.now());
     serviceUnderTest.updateAddressPersist(id, "Prague");

     assertEquals("Birth date doesn't match",
         "Hanz Hagen, " + LocalDate.now().format(DATE_FORMAT) +
                 "\nPrague", serviceUnderTest.print(id));
   }
}
