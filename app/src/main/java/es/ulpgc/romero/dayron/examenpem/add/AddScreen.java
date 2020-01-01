package es.ulpgc.romero.dayron.examenpem.add;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;
import es.ulpgc.romero.dayron.examenpem.app.AppMediator;
import es.ulpgc.romero.dayron.examenpem.app.Repository;
import es.ulpgc.romero.dayron.examenpem.app.RepositoryContract;


public class AddScreen {

  public static void configure(AddContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    AddState state = mediator.getAddState();

    RepositoryContract repository = Repository.getInstance(context.get());
    AddContract.Router router = new AddRouter(mediator);
    AddContract.Presenter presenter = new AddPresenter(state);
    AddContract.Model model = new AddModel(repository);
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
