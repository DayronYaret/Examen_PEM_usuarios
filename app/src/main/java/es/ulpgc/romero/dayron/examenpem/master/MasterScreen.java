package es.ulpgc.romero.dayron.examenpem.master;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;
import es.ulpgc.romero.dayron.examenpem.app.AppMediator;
import es.ulpgc.romero.dayron.examenpem.app.Repository;
import es.ulpgc.romero.dayron.examenpem.app.RepositoryContract;


public class MasterScreen {

  public static void configure(MasterContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    MasterState state = mediator.getMasterState();

    RepositoryContract repository = Repository.getInstance(context.get());
    MasterContract.Router router = new MasterRouter(mediator);
    MasterContract.Presenter presenter = new MasterPresenter(state);
    MasterContract.Model model = new MasterModel(repository);
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
