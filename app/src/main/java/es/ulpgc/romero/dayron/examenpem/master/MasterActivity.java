package es.ulpgc.romero.dayron.examenpem.master;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import es.ulpgc.romero.dayron.examenpem.R;
import es.ulpgc.romero.dayron.examenpem.app.User;

public class MasterActivity
    extends AppCompatActivity implements MasterContract.View {

  public static String TAG = MasterActivity.class.getSimpleName();

  private MasterAdapter listAdapter;
  private MasterContract.Presenter presenter;
  private Button add;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_master);
    add = findViewById(R.id.addButton);

    add.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        presenter.goAdd();
      }
    });

    listAdapter = new MasterAdapter(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        User usuario = (User) view.getTag();
        presenter.selectedUser(usuario);
      }
    });
    RecyclerView recyclerView = findViewById(R.id.usersList);
    recyclerView.setAdapter(listAdapter);
    // do the setup
    MasterScreen.configure(this);
  }

  @Override
  protected void onResume() {
    super.onResume();

    // load the data
    presenter.fetchData();
  }

  @Override
  public void displayData(MasterViewModel viewModel) {
    //Log.e(TAG, "displayData()");
    final ArrayList<User> users = viewModel.users;
    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        listAdapter.setItems(users);
      }
    });
  }

  @Override
  public void injectPresenter(MasterContract.Presenter presenter) {
    this.presenter = presenter;
  }
}
