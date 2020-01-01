package es.ulpgc.romero.dayron.examenpem.detail;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import es.ulpgc.romero.dayron.examenpem.R;

public class DetailActivity
    extends AppCompatActivity implements DetailContract.View {

  public static String TAG = DetailActivity.class.getSimpleName();

  private DetailContract.Presenter presenter;
  private TextView nombre, apellido, profesion, edad, dni, cv;
  private Button delete;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail);
    nombre = findViewById(R.id.nameTextView);
    apellido = findViewById(R.id.surnameTextView);
    profesion = findViewById(R.id.jobTextView);
    edad = findViewById(R.id.ageTextView);
    dni = findViewById(R.id.dniTextView);
    cv = findViewById(R.id.cvTextView);
    delete = findViewById(R.id.deleteButton);

    delete.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        presenter.delete();
      }
    });

    // do the setup
    DetailScreen.configure(this);
  }

  @Override
  protected void onResume() {
    super.onResume();

    // load the data
    presenter.fetchData();
  }

  @Override
  public void displayData(DetailViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data
    nombre.setText(viewModel.user.getNombre());
    apellido.setText(viewModel.user.getApellidos());
    edad.setText(String.valueOf(viewModel.user.getEdad()));
    dni.setText(viewModel.user.getDni());
    profesion.setText(viewModel.user.getProfesion());
    cv.setText(viewModel.user.getCv());
  }

  @Override
  public void finishActivity() {
    finish();
  }

  @Override
  public void injectPresenter(DetailContract.Presenter presenter) {
    this.presenter = presenter;
  }
}
