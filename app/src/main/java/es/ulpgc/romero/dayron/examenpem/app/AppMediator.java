package es.ulpgc.romero.dayron.examenpem.app;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

import es.ulpgc.romero.dayron.examenpem.add.AddState;
import es.ulpgc.romero.dayron.examenpem.detail.DetailState;
import es.ulpgc.romero.dayron.examenpem.master.MasterState;

public class AppMediator extends Application {

  private AddState addState;
  private MasterState masterState;
  private DetailState detailState;
  private User user;

  @Override
  public void onCreate() {
    super.onCreate();
    FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    addState = new AddState();
    masterState = new MasterState();
    detailState = new DetailState();
    //Comentario para ver si el comit desde el protatil esta bien

  }


  public AddState getAddState() {
    return addState;
  }

  public void setAddState(AddState addState) {
    this.addState = addState;
  }

  public MasterState getMasterState() {
    return masterState;
  }

  public void setMasterState(MasterState masterState) {
    this.masterState = masterState;
  }

  public DetailState getDetailState() {
    return detailState;
  }

  public void setDetailState(DetailState detailState) {
    this.detailState = detailState;
  }

  public void setUser(User usuario) {
    this.user=usuario;
  }
  public User getUser(){
    return user;
  }
}
