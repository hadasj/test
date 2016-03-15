package cz.i.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import org.junit.Test;

import cz.i.test.dao.Storage;
import cz.i.test.entity.Obyvatel;

/**
 * @author jan.hadas@i.cz
 */
public class StorageTest {
  private static final Long ID = 1L;
  private static final String NAME = "Michelagniolo";
  private static final String SURNAME = "Buonarroti";
  // 29.10.2015
  private static final LocalDate BIRTH_DATE = LocalDate.of(2015, 10, 29);
  private Storage serviceUnderTest = new Storage();

  @Test
  public void should_write_obyvatel() throws IOException {
    Obyvatel obyvatel = new Obyvatel();
    obyvatel.setId(ID);

    serviceUnderTest.checkStorage();
    serviceUnderTest.write(obyvatel);

    File file = new File("data" + File.separator + ID);
    assertTrue(file.exists());
  }

  @Test
  public void should_read_obyvatel() throws IOException, ClassNotFoundException {
    Obyvatel obyvatel = new Obyvatel();
    obyvatel.setId(ID);
    obyvatel.setFirstName(NAME);
    obyvatel.setSurName(SURNAME);
    obyvatel.setBirthDate(BIRTH_DATE);

    serviceUnderTest.checkStorage();
    serviceUnderTest.write(obyvatel);

    obyvatel = serviceUnderTest.read(ID);
    assertNotNull("Obyvatel wasn't found", obyvatel);
    assertEquals(ID, obyvatel.getId());
    assertEquals(NAME, obyvatel.getFirstName());
    assertEquals(SURNAME, obyvatel.getSurName());
    assertEquals(BIRTH_DATE, obyvatel.getBirthDate());
  }

  @Test
  public void should_delete_obyvatel() throws IOException, ClassNotFoundException {
    Obyvatel obyvatel = new Obyvatel();
    obyvatel.setId(ID);

    serviceUnderTest.checkStorage();
    serviceUnderTest.write(obyvatel);

    serviceUnderTest.delete(ID);

    assertNull("Obyvatel wasn't deleted", serviceUnderTest.read(ID));
  }
}
