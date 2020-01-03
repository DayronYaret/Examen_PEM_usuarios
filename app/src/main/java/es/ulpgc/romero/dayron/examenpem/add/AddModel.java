package es.ulpgc.romero.dayron.examenpem.add;

import android.util.Log;

import java.lang.ref.WeakReference;
import java.net.UnknownServiceException;

import es.ulpgc.romero.dayron.examenpem.app.RepositoryContract;
import es.ulpgc.romero.dayron.examenpem.app.User;

public class AddModel implements AddContract.Model {

  public static String TAG = AddModel.class.getSimpleName();
  private RepositoryContract repository;

  public AddModel(RepositoryContract repository) {
    this.repository = repository;
  }

  @Override
  public String fetchData() {
    // Log.e(TAG, "fetchData()");
    return "Hello";
  }

  @Override
  public void add(String userName, String userSurname, String userAge, String userDNI, String userJob, String userCV, RepositoryContract.Add callback) {
    int age = Integer.parseInt(userAge);
    User usuario = new User(userName, userSurname, userDNI.toUpperCase().trim(), userJob, userCV, age);
    repository.add(usuario, callback);
  }
}
