package es.ulpgc.romero.dayron.examenpem.detail;

import java.lang.ref.WeakReference;

import es.ulpgc.romero.dayron.examenpem.app.RepositoryContract;
import es.ulpgc.romero.dayron.examenpem.app.User;

public interface DetailContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(DetailViewModel viewModel);

    void finishActivity();
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();

    void delete();
  }

  interface Model {
    String fetchData();
    void delete(User usuario, RepositoryContract.Delete callback);
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(DetailState state);

    DetailState getDataFromPreviousScreen();

    User getDataFromMaster();
  }
}
