package es.ulpgc.romero.dayron.examenpem.master;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import es.ulpgc.romero.dayron.examenpem.R;
import es.ulpgc.romero.dayron.examenpem.app.User;

public class MasterAdapter extends  RecyclerView.Adapter<MasterAdapter.ViewHolder> {

  private final View.OnClickListener clickListener;
  public static String TAG = MasterAdapter.class.getSimpleName();
  private List<User> usersItemList;

  public MasterAdapter(View.OnClickListener listener) {
    usersItemList = new ArrayList<>();
    clickListener = listener;
  }

  public void setItems(List<User> items) {
    usersItemList = items;
    Log.d("Adapter", usersItemList.toString());
    notifyDataSetChanged();
  }

  class ViewHolder extends RecyclerView.ViewHolder {
    final TextView titleView;

    ViewHolder(View view) {
      super(view);
      titleView = view.findViewById(R.id.textViewUser);

    }
  }

  @Override
  public int getItemCount() {
    Log.d("Adapter3", String.valueOf(usersItemList.size()));
    return usersItemList.size();
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
    holder.itemView.setTag(usersItemList.get(position));
    holder.itemView.setOnClickListener(clickListener);
    Log.d("Adapter2", usersItemList.get(position).getNombre());
    holder.titleView.setText(usersItemList.get(position).getNombre());
  }


}
