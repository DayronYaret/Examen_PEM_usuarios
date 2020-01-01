package es.ulpgc.romero.dayron.examenpem.add;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.romero.dayron.examenpem.app.AppMediator;
import es.ulpgc.romero.dayron.examenpem.master.MasterActivity;

public class AddRouter implements AddContract.Router {

  public static String TAG = AddRouter.class.getSimpleName();

  private AppMediator mediator;

  public AddRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, AddActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToNextScreen(AddState state) {
    mediator.setAddState(state);
  }

  @Override
  public AddState getDataFromPreviousScreen() {
    AddState state = mediator.getAddState();
    return state;
  }

  @Override
  public void goMaster() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, MasterActivity.class);
    context.startActivity(intent);
  }
}
