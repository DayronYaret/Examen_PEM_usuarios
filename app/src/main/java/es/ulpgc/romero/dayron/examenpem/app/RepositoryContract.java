package es.ulpgc.romero.dayron.examenpem.app;

import java.util.ArrayList;

public interface RepositoryContract {
  interface FillArray{
    void onFillArray(boolean error, ArrayList<User> array);
  }
  void fillArray(RepositoryContract.FillArray callback);

  interface Add{
    void onAdd(boolean error);
  }
  void add(User usuario,RepositoryContract.Add callback);

  interface Delete{
    void onDelete(boolean error);
  }
  void delete(User usuario, RepositoryContract.Delete callback);
}
