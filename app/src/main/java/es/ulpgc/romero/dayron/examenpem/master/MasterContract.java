package es.ulpgc.romero.dayron.examenpem.master;

import java.lang.ref.WeakReference;

import es.ulpgc.romero.dayron.examenpem.app.RepositoryContract;
import es.ulpgc.romero.dayron.examenpem.app.User;

public interface MasterContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(MasterViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();

    void selectedUser(User usuario);

    void goAdd();
  }

  interface Model {
    String fetchData();
    void fillArray(RepositoryContract.FillArray callback);
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(MasterState state);

    MasterState getDataFromPreviousScreen();

    void passDataToDetail(User usuario);

    void goDetail();

    void goAdd();
  }
}
