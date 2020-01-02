package es.ulpgc.romero.dayron.examenpem.add;

import java.lang.ref.WeakReference;

import es.ulpgc.romero.dayron.examenpem.app.RepositoryContract;

public interface AddContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(AddViewModel viewModel);
    
    void finishActivity();

    void displayError();
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();

    void add(String userName, String userSurname, String userAge, String userDNI, String userJob, String userCV);
    
  }

  interface Model {
    String fetchData();
    void add(String userName, String userSurname, String userAge, String userDNI, String userJob, String userCV, RepositoryContract.Add callback);
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(AddState state);

    AddState getDataFromPreviousScreen();

    void goMaster();
  }
}
