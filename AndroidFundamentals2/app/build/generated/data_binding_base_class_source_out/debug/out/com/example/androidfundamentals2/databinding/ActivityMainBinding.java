// Generated by view binder compiler. Do not edit!
package com.example.androidfundamentals2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.androidfundamentals2.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btnLoad;

  @NonNull
  public final Button btnSave;

  @NonNull
  public final CheckBox cbAdult;

  @NonNull
  public final ConstraintLayout drawerLayout;

  @NonNull
  public final EditText etAge;

  @NonNull
  public final EditText etName;

  private ActivityMainBinding(@NonNull ConstraintLayout rootView, @NonNull Button btnLoad,
      @NonNull Button btnSave, @NonNull CheckBox cbAdult, @NonNull ConstraintLayout drawerLayout,
      @NonNull EditText etAge, @NonNull EditText etName) {
    this.rootView = rootView;
    this.btnLoad = btnLoad;
    this.btnSave = btnSave;
    this.cbAdult = cbAdult;
    this.drawerLayout = drawerLayout;
    this.etAge = etAge;
    this.etName = etName;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnLoad;
      Button btnLoad = ViewBindings.findChildViewById(rootView, id);
      if (btnLoad == null) {
        break missingId;
      }

      id = R.id.btnSave;
      Button btnSave = ViewBindings.findChildViewById(rootView, id);
      if (btnSave == null) {
        break missingId;
      }

      id = R.id.cbAdult;
      CheckBox cbAdult = ViewBindings.findChildViewById(rootView, id);
      if (cbAdult == null) {
        break missingId;
      }

      ConstraintLayout drawerLayout = (ConstraintLayout) rootView;

      id = R.id.etAge;
      EditText etAge = ViewBindings.findChildViewById(rootView, id);
      if (etAge == null) {
        break missingId;
      }

      id = R.id.etName;
      EditText etName = ViewBindings.findChildViewById(rootView, id);
      if (etName == null) {
        break missingId;
      }

      return new ActivityMainBinding((ConstraintLayout) rootView, btnLoad, btnSave, cbAdult,
          drawerLayout, etAge, etName);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}