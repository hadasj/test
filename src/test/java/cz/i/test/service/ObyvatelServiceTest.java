package cz.i.test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.time.LocalDate;

import org.junit.Test;

/**
 * @author jan.hadas@i.cz
 */
public class ObyvatelServiceTest {

  private static final String NAME = "Hanz";
  private static final String SURNAME = "Hagen";

  private ObyvatelService serviceUnderTest = new ObyvatelService();

  @Test
  public void should_persist_new_obyvatel() throws IOException {
    // TODO: FIX service method
    Long id = serviceUnderTest.createPersist(NAME, SURNAME);

    assertNotNull("ID is null", id);
    //TODO: improve test (add verification that entity is really persisted)
  }

   @Test
  public void should_return_formatted_obyvatel_string() throws IOException, ClassNotFoundException {
     //TODO: FIX test, make test more robust
     Long id = serviceUnderTest.createPersist(NAME, SURNAME, LocalDate.now());
     serviceUnderTest.updateAddressPersist(id, "Prague");

     assertEquals("Birth date doesn't match",
         "Hanz Hagen, 17.03.2016\nPrague", serviceUnderTest.print(id));
   }
}
