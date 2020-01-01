package es.ulpgc.romero.dayron.examenpem.master;

import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import es.ulpgc.romero.dayron.examenpem.app.RepositoryContract;
import es.ulpgc.romero.dayron.examenpem.app.User;

public class MasterPresenter implements MasterContract.Presenter {

  public static String TAG = MasterPresenter.class.getSimpleName();

  private WeakReference<MasterContract.View> view;
  private MasterViewModel viewModel;
  private MasterContract.Model model;
  private MasterContract.Router router;

  public MasterPresenter(MasterState state) {
    viewModel = state;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchData()");
    // call the model
    String data = model.fetchData();

    // set view state
    viewModel.data = data;

    // update the view
    fillArray();
    //view.get().displayData(viewModel);

  }

  @Override
  public void selectedUser(User usuario) {
    router.passDataToDetail(usuario);
    router.goDetail();
  }

  @Override
  public void goAdd() {
    router.goAdd();
  }

  private void fillArray(){
    model.fillArray(new RepositoryContract.FillArray() {
      @Override
      public void onFillArray(boolean error, ArrayList<User> array) {
        if(error == false){
          viewModel.users = array;
          view.get().displayData(viewModel);
        }else{
          Log.d("pres", "hubo un error al recoger los datos");
        }
      }
    });
  }

  @Override
  public void injectView(WeakReference<MasterContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(MasterContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(MasterContract.Router router) {
    this.router = router;
  }
}
