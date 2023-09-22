// Generated by view binder compiler. Do not edit!
package com.example.quiz.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.quiz.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class CategoryitemBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final CardView cardbutton;

  @NonNull
  public final TextView category;

  @NonNull
  public final ImageView categoryimage;

  private CategoryitemBinding(@NonNull CardView rootView, @NonNull CardView cardbutton,
      @NonNull TextView category, @NonNull ImageView categoryimage) {
    this.rootView = rootView;
    this.cardbutton = cardbutton;
    this.category = category;
    this.categoryimage = categoryimage;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static CategoryitemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static CategoryitemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.categoryitem, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static CategoryitemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      CardView cardbutton = (CardView) rootView;

      id = R.id.category;
      TextView category = ViewBindings.findChildViewById(rootView, id);
      if (category == null) {
        break missingId;
      }

      id = R.id.categoryimage;
      ImageView categoryimage = ViewBindings.findChildViewById(rootView, id);
      if (categoryimage == null) {
        break missingId;
      }

      return new CategoryitemBinding((CardView) rootView, cardbutton, category, categoryimage);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}