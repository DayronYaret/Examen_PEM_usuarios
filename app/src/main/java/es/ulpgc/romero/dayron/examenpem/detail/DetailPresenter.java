package es.ulpgc.romero.dayron.examenpem.detail;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.romero.dayron.examenpem.app.RepositoryContract;
import es.ulpgc.romero.dayron.examenpem.app.User;

public class DetailPresenter implements DetailContract.Presenter {

  public static String TAG = DetailPresenter.class.getSimpleName();

  private WeakReference<DetailContract.View> view;
  private DetailViewModel viewModel;
  private DetailContract.Model model;
  private DetailContract.Router router;

  public DetailPresenter(DetailState state) {
    viewModel = state;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchData()");

    // use passed state if is necessary
    User usuario = router.getDataFromMaster();

    // call the model
    String data = model.fetchData();

    // set view state
    viewModel.data = data;
    viewModel.user = usuario;

    // update the view
    view.get().displayData(viewModel);

  }

  @Override
  public void delete() {
    model.delete(viewModel.user, new RepositoryContract.Delete() {
      @Override
      public void onDelete(boolean error) {
        if(error ==false){
          view.get().finishActivity();
        }else{
          Log.d("pres", "Hubo un error al eliminar");
        }
      }
    });
  }

  @Override
  public void injectView(WeakReference<DetailContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(DetailContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(DetailContract.Router router) {
    this.router = router;
  }
}
