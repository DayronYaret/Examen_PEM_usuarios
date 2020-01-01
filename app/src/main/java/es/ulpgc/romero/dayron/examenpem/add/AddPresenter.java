package es.ulpgc.romero.dayron.examenpem.add;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.romero.dayron.examenpem.app.RepositoryContract;

public class AddPresenter implements AddContract.Presenter {

  public static String TAG = AddPresenter.class.getSimpleName();

  private WeakReference<AddContract.View> view;
  private AddViewModel viewModel;
  private AddContract.Model model;
  private AddContract.Router router;

  public AddPresenter(AddState state) {
    viewModel = state;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchData()");

    // use passed state if is necessary
    AddState state = router.getDataFromPreviousScreen();
    if (state != null) {

      // update view and model state
      viewModel.data = state.data;

      // update the view
      view.get().displayData(viewModel);

      return;
    }

    // call the model
    String data = model.fetchData();

    // set view state
    viewModel.data = data;

    // update the view
    view.get().displayData(viewModel);

  }

  @Override
  public void add(String userName, String userSurname, String userAge, String userDNI, String userJob, String userCV) {
    model.add(userName, userSurname, userAge, userDNI, userJob, userCV, new RepositoryContract.Add() {
      @Override
      public void onAdd(boolean error) {
        if(error == false){
          view.get().finishActivity();
        }else{
          Log.d("pres2", "hubo un error añadiendo");
        }
      }
    });
  }

  @Override
  public void injectView(WeakReference<AddContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(AddContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(AddContract.Router router) {
    this.router = router;
  }
}
