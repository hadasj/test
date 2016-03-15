package cz.i.test.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import cz.i.test.entity.Obyvatel;

/**
 * @author jan.hadas@i.cz
 */
public class Storage {

  private static final String STORE = "data";

  /**
   * Creates empty directory for storage (or does nothing if the directory already exists)
   */
  public void checkStorage() {
    new File(STORE).mkdir();
  }

  public void write(Obyvatel obyvatel) throws IOException {
    final ObjectOutput stream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(
       createPath(obyvatel.getId()))));
    try {
      stream.writeObject(obyvatel);
    } finally {
      stream.close();
    }
  }

  public void delete(Long id) {
    File file = new File(createPath(id));
    if (file.exists()) {
      file.delete();
    }
  }

  public Obyvatel read(Long id) throws IOException, ClassNotFoundException {
    File file = new File(createPath(id));
    if (!file.exists()) {
      return null;
    }

    final ObjectInput stream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
    try {
      return (Obyvatel)stream.readObject();
    } finally {
      stream.close();
    }
  }

  private String createPath(Long id) {
    return  STORE + File.separator + id;
  }
}
