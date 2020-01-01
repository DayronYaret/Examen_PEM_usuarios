package es.ulpgc.romero.dayron.examenpem.detail;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.romero.dayron.examenpem.app.RepositoryContract;
import es.ulpgc.romero.dayron.examenpem.app.User;

public class DetailModel implements DetailContract.Model {

  public static String TAG = DetailModel.class.getSimpleName();

  private RepositoryContract repository;
  public DetailModel(RepositoryContract repository) {
    this.repository= repository;
  }

  @Override
  public String fetchData() {
    // Log.e(TAG, "fetchData()");
    return "Hello";
  }

  @Override
  public void delete(User usuario, RepositoryContract.Delete callback) {
    repository.delete(usuario, callback);
  }
}
