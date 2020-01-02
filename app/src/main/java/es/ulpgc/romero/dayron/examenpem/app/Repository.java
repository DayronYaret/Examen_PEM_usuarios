package es.ulpgc.romero.dayron.examenpem.app;

import android.content.Context;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import androidx.annotation.NonNull;

public class Repository implements RepositoryContract {
  private static Repository INSTANCE;
  private Context context;
  private ArrayList<User> usersList;
  private DatabaseReference userDatabaseRef;


  public static RepositoryContract getInstance(Context context) {
    if (INSTANCE == null) {
      INSTANCE = new Repository(context);
    }
    return INSTANCE;
  }

  private Repository(Context context) {
    this.context = context;
    this.usersList = new ArrayList<>();
  }

  @Override
  public void fillArray(final FillArray callback) {
    /**
     if(userDatabaseRef != null){
     return;
     }
     **/
    userDatabaseRef = FirebaseDatabase.getInstance().getReference().child("usuarios");
    userDatabaseRef.addValueEventListener(new ValueEventListener() {
      @Override
      public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

        usersList.clear();
        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
          String nombre = (String) dataSnapshot1.child("nombre").getValue();
          String apellidos = (String) dataSnapshot1.child("apellidos").getValue();
          String dni = (String) dataSnapshot1.child("dni").getValue();
          int edad = Integer.parseInt(String.valueOf(dataSnapshot1.child("edad").getValue()));
          String profesion = (String) dataSnapshot1.child("profesion").getValue();
          String cv = (String) dataSnapshot1.child("cv").getValue();
          User usuario = new User(nombre, apellidos, dni, profesion, cv, edad);
          usersList.add(usuario);
          //Log.d("repo", String.valueOf(usuario.getEdad()));
        }
        callback.onFillArray(false, usersList);
      }

      @Override
      public void onCancelled(@NonNull DatabaseError databaseError) {

      }
    });
  }

  @Override
  public void add(final User usuario, final Add callback) {
    final DatabaseReference userRef = FirebaseDatabase.getInstance().getReference().child("usuarios");
    userRef.addListenerForSingleValueEvent(new ValueEventListener() {
      @Override
      public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        Log.d("Repo",String.valueOf(dataSnapshot.hasChild(usuario.getDni())));
        if(dataSnapshot.hasChild(usuario.getDni())){
          callback.onAdd(true);
        }else{
          userRef.child(usuario.getDni()).setValue(usuario).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
              if (task.isSuccessful()) {
                callback.onAdd(false);
              } else {
                callback.onAdd(true);
              }
            }
          });
        }
      }

      @Override
      public void onCancelled(@NonNull DatabaseError databaseError) {

      }
    });
    /**
    userRef.child(usuario.getDni()).setValue(usuario).addOnCompleteListener(new OnCompleteListener<Void>() {
      @Override
      public void onComplete(@NonNull Task<Void> task) {
        if (task.isSuccessful()) {
          callback.onAdd(false);
        } else {
          callback.onAdd(true);
        }
      }
    });
     **/
  }


  @Override
  public void delete(User usuario, final Delete callback) {
    Log.d("repo", usuario.getDni());
    DatabaseReference userRef = FirebaseDatabase.getInstance().getReference().child("usuarios");
    userRef.child(usuario.getDni()).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
      @Override
      public void onComplete(@NonNull Task<Void> task) {
        if(task.isSuccessful()){
          callback.onDelete(false);
        }else{
          callback.onDelete(true);
        }
      }
    });
  }

}
