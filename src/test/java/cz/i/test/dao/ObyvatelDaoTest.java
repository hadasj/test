package cz.i.test.dao;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import net.sf.seaf.test.jmock.JMockSupport;
import org.jmock.Expectations;
import org.jmock.Sequence;
import org.junit.Before;
import org.junit.Test;

import cz.i.test.entity.Obyvatel;

/**
 * @author jan.hadas@i.cz
 */

public class ObyvatelDaoTest extends JMockSupport{
  private static final long ID = 1L;

  private ObyvatelDao serviceUnderTest = new ObyvatelDao();
  private Storage storage;
  private Sequence sequence;

  @Before
  public void setUp() {
    storage = mock(Storage.class);
    sequence = createSequence("sequence");
    serviceUnderTest.setStorage(storage);
  }

  @Test
  public void should_write_new_obyvatel() throws IOException {
    final Obyvatel obyvatel = new Obyvatel();
    obyvatel.setId(ID);

    check(new Expectations(){{
      one(storage).checkStorage();
      inSequence(sequence);

      one(storage).write(obyvatel);
      inSequence(sequence);
    }});

    serviceUnderTest.insert(obyvatel);
  }

  @Test
  public void should_update_obyvatel() throws IOException {
    //TODO: FIX test data..
    final Obyvatel obyvatel = new Obyvatel();

    check(new Expectations(){{
      one(storage).write(obyvatel);
    }});

    serviceUnderTest.update(obyvatel);
  }

  @Test
  public void should_delete_obyvatel() throws IOException {
    final Obyvatel obyvatel = new Obyvatel();
    obyvatel.setId(ID);

    //TODO: FIX mock expectations

    serviceUnderTest.delete(obyvatel);
  }

  @Test
  public void should_return_obyvatel() {
    //TODO: implement search method, FIX test

    Obyvatel obyvatel = serviceUnderTest.search("Martin", null);
    assertNotNull(obyvatel);
  }
}
