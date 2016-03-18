package cz.i.test.dao;

import java.io.IOException;

import cz.i.test.entity.Obyvatel;

/**
 * @author jan.hadas@i.cz
 */
public class ObyvatelDao {

  private Storage storage = new Storage();

  public void insert(Obyvatel obyvatel) throws IOException {
    checkId(obyvatel);
    storage.checkStorage();
    storage.write(obyvatel);
  }

  public void update(Obyvatel obyvatel) throws IOException {
    checkId(obyvatel);
    storage.write(obyvatel);
  }

  public void delete(Obyvatel obyvatel) {
    checkId(obyvatel);
    storage.delete(obyvatel.getId());
  }

  public Obyvatel search(String firstName, String lastName) throws IOException, ClassNotFoundException {
    for (String id : storage.list()) {
      Obyvatel obyvatel = storage.read(Long.parseLong(id));
      if (firstName.equals(obyvatel.getFirstName())
          && lastName.equals(obyvatel.getSurName())) {
        return obyvatel;
      }
    }
    return null;
  }

  public Obyvatel get(Long id) throws IOException, ClassNotFoundException {
    return storage.read(id);
  }

  private void checkId(Obyvatel obyvatel) {
    if (obyvatel.getId() == null) {
      throw new IllegalArgumentException("Obyvatel id is null");
    }
  }

  protected void setStorage(Storage storage) {
    this.storage = storage;
  }

}
