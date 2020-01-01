package es.ulpgc.romero.dayron.examenpem.detail;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;
import es.ulpgc.romero.dayron.examenpem.app.AppMediator;
import es.ulpgc.romero.dayron.examenpem.app.Repository;
import es.ulpgc.romero.dayron.examenpem.app.RepositoryContract;

public class DetailScreen {

  public static void configure(DetailContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    DetailState state = mediator.getDetailState();

    RepositoryContract repository = Repository.getInstance(context.get());
    DetailContract.Router router = new DetailRouter(mediator);
    DetailContract.Presenter presenter = new DetailPresenter(state);
    DetailContract.Model model = new DetailModel(repository);
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
