// Generated by view binder compiler. Do not edit!
package com.example.androidfundamentals.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.androidfundamentals.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class CounterBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btnCount;

  @NonNull
  public final TextView tvCount;

  private CounterBinding(@NonNull ConstraintLayout rootView, @NonNull Button btnCount,
      @NonNull TextView tvCount) {
    this.rootView = rootView;
    this.btnCount = btnCount;
    this.tvCount = tvCount;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static CounterBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static CounterBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent,
      boolean attachToParent) {
    View root = inflater.inflate(R.layout.counter, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static CounterBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnCount;
      Button btnCount = ViewBindings.findChildViewById(rootView, id);
      if (btnCount == null) {
        break missingId;
      }

      id = R.id.tvCount;
      TextView tvCount = ViewBindings.findChildViewById(rootView, id);
      if (tvCount == null) {
        break missingId;
      }

      return new CounterBinding((ConstraintLayout) rootView, btnCount, tvCount);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}