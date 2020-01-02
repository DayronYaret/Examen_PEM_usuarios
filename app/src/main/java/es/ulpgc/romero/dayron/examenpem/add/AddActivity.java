package es.ulpgc.romero.dayron.examenpem.add;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import es.ulpgc.romero.dayron.examenpem.R;

public class AddActivity
    extends AppCompatActivity implements AddContract.View {

  public static String TAG = AddActivity.class.getSimpleName();

  private EditText nombre, apellidos, edad, dni, profesion, cv;
  private Button add;
  private String userName, userSurname, userAge, userDNI, userJob, userCV;
  private AddContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add);
    nombre = findViewById(R.id.nameEditText);
    apellidos = findViewById(R.id.surnameEditText);
    edad = findViewById(R.id.ageEditText);
    dni = findViewById(R.id.dniEditText);
    profesion = findViewById(R.id.jobEditText);
    cv = findViewById(R.id.cvEditText);
    add = findViewById(R.id.addButton);


    add.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        userName = nombre.getText().toString();
        userSurname = apellidos.getText().toString();
        userAge = edad.getText().toString();
        userDNI = dni.getText().toString();
        userJob = profesion.getText().toString();
        userCV = cv.getText().toString();
        Log.d("activity", userName);
        if(userName.equals("") || userSurname.equals("")|| userAge.equals("")|| userJob.equals("")|| userDNI.equals("")|| userCV.equals("")) {
          Toast.makeText(AddActivity.this, "Rellene todos los campos porfavor", Toast.LENGTH_SHORT).show();
        }else{
          presenter.add(userName, userSurname, userAge, userDNI, userJob, userCV);

        }

      }
    });

    // do the setup
    AddScreen.configure(this);
  }

  @Override
  protected void onResume() {
    super.onResume();

    // load the data
    presenter.fetchData();
  }

  @Override
  public void displayData(AddViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data
  }

  @Override
  public void finishActivity() {
    this.finish();
  }

  @Override
  public void displayError() {
    Toast.makeText(this, "Ese DNI ya existe, por lo que no se puede añadir el usuario", Toast.LENGTH_SHORT).show();
  }

  @Override
  public void injectPresenter(AddContract.Presenter presenter) {
    this.presenter = presenter;
  }


}
