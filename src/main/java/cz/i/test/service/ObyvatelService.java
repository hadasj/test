package cz.i.test.service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import cz.i.test.dao.ObyvatelDao;
import cz.i.test.entity.Obyvatel;

/**
 * @author jan.hadas@i.cz
 */
public class ObyvatelService {

  private ObyvatelDao obyvatelDao = new ObyvatelDao();
  private Random random = new Random();
  private DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy");

  public Long createPersist(String firstName, String surName) throws IOException {
    Long id = createPersist(firstName, surName, LocalDate.now());

    return id;
  }

  public Long createPersist(String firstName, String surName, LocalDate birthDate) throws IOException {
    Obyvatel obyvatel = createObyvatel(firstName, surName, birthDate);

    obyvatelDao.insert(obyvatel);

    return obyvatel.getId();
  }

  public void updateAddressPersist(Long id, String address) throws IOException, ClassNotFoundException {
    Obyvatel obyvatel = obyvatelDao.get(id);

    obyvatel.setAddress(address);

    obyvatelDao.update(obyvatel);
  }

  public String print(Long id) throws IOException, ClassNotFoundException {
    Obyvatel obyvatel = obyvatelDao.get(id);
    return obyvatel.getFirstName() + " " + obyvatel.getSurName() + ", " + format.format(obyvatel.getBirthDate()) +
        System.lineSeparator() + obyvatel.getAddress();
  }

  private Obyvatel createObyvatel(String firstName, String surName, LocalDate birthDate) {
    Obyvatel obyvatel = new Obyvatel();
    obyvatel.setId(random.nextLong());
    obyvatel.setFirstName(firstName);
    obyvatel.setSurName(surName);
    obyvatel.setBirthDate(birthDate);

    return obyvatel;
  }
}
