package es.ulpgc.romero.dayron.examenpem.master;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.romero.dayron.examenpem.app.RepositoryContract;

public class MasterModel implements MasterContract.Model {

  public static String TAG = MasterModel.class.getSimpleName();
  private RepositoryContract repository;

  public MasterModel(RepositoryContract repository) {
    this.repository = repository;
  }

  @Override
  public String fetchData() {
    // Log.e(TAG, "fetchData()");
    return "Hello";
  }

  @Override
  public void fillArray(RepositoryContract.FillArray callback) {
    repository.fillArray(callback);
  }
}
