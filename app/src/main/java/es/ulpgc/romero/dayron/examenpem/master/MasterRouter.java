package es.ulpgc.romero.dayron.examenpem.master;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.romero.dayron.examenpem.add.AddActivity;
import es.ulpgc.romero.dayron.examenpem.app.AppMediator;
import es.ulpgc.romero.dayron.examenpem.app.User;
import es.ulpgc.romero.dayron.examenpem.detail.DetailActivity;

public class MasterRouter implements MasterContract.Router {

  public static String TAG = MasterRouter.class.getSimpleName();

  private AppMediator mediator;

  public MasterRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, MasterActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToNextScreen(MasterState state) {
    mediator.setMasterState(state);
  }

  @Override
  public MasterState getDataFromPreviousScreen() {
    MasterState state = mediator.getMasterState();
    return state;
  }

  @Override
  public void passDataToDetail(User usuario) {
    mediator.setUser(usuario);
  }

  @Override
  public void goDetail() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, DetailActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void goAdd() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, AddActivity.class);
    context.startActivity(intent);
  }
}
