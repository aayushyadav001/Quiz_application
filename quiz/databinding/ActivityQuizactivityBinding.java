// Generated by view binder compiler. Do not edit!
package com.example.quiz.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.example.quiz.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityQuizactivityBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final LottieAnimationView animationView;

  @NonNull
  public final LottieAnimationView animationView1;

  @NonNull
  public final TextView balance1;

  @NonNull
  public final ImageView coinwithdrawl2;

  @NonNull
  public final ImageView img;

  @NonNull
  public final LinearLayout linearLayout;

  @NonNull
  public final TextView name2;

  @NonNull
  public final Button option1;

  @NonNull
  public final Button option2;

  @NonNull
  public final Button option3;

  @NonNull
  public final Button option4;

  @NonNull
  public final ImageView profile;

  @NonNull
  public final TextView question;

  @NonNull
  public final LinearLayout sorry;

  @NonNull
  public final TextView textView20;

  @NonNull
  public final TextView textView23;

  @NonNull
  public final TextView textView24;

  @NonNull
  public final LinearLayout winner;

  private ActivityQuizactivityBinding(@NonNull ConstraintLayout rootView,
      @NonNull LottieAnimationView animationView, @NonNull LottieAnimationView animationView1,
      @NonNull TextView balance1, @NonNull ImageView coinwithdrawl2, @NonNull ImageView img,
      @NonNull LinearLayout linearLayout, @NonNull TextView name2, @NonNull Button option1,
      @NonNull Button option2, @NonNull Button option3, @NonNull Button option4,
      @NonNull ImageView profile, @NonNull TextView question, @NonNull LinearLayout sorry,
      @NonNull TextView textView20, @NonNull TextView textView23, @NonNull TextView textView24,
      @NonNull LinearLayout winner) {
    this.rootView = rootView;
    this.animationView = animationView;
    this.animationView1 = animationView1;
    this.balance1 = balance1;
    this.coinwithdrawl2 = coinwithdrawl2;
    this.img = img;
    this.linearLayout = linearLayout;
    this.name2 = name2;
    this.option1 = option1;
    this.option2 = option2;
    this.option3 = option3;
    this.option4 = option4;
    this.profile = profile;
    this.question = question;
    this.sorry = sorry;
    this.textView20 = textView20;
    this.textView23 = textView23;
    this.textView24 = textView24;
    this.winner = winner;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityQuizactivityBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityQuizactivityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_quizactivity, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityQuizactivityBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.animation_view;
      LottieAnimationView animationView = ViewBindings.findChildViewById(rootView, id);
      if (animationView == null) {
        break missingId;
      }

      id = R.id.animation_view1;
      LottieAnimationView animationView1 = ViewBindings.findChildViewById(rootView, id);
      if (animationView1 == null) {
        break missingId;
      }

      id = R.id.balance1;
      TextView balance1 = ViewBindings.findChildViewById(rootView, id);
      if (balance1 == null) {
        break missingId;
      }

      id = R.id.coinwithdrawl2;
      ImageView coinwithdrawl2 = ViewBindings.findChildViewById(rootView, id);
      if (coinwithdrawl2 == null) {
        break missingId;
      }

      id = R.id.img;
      ImageView img = ViewBindings.findChildViewById(rootView, id);
      if (img == null) {
        break missingId;
      }

      id = R.id.linearLayout;
      LinearLayout linearLayout = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout == null) {
        break missingId;
      }

      id = R.id.name2;
      TextView name2 = ViewBindings.findChildViewById(rootView, id);
      if (name2 == null) {
        break missingId;
      }

      id = R.id.option1;
      Button option1 = ViewBindings.findChildViewById(rootView, id);
      if (option1 == null) {
        break missingId;
      }

      id = R.id.option2;
      Button option2 = ViewBindings.findChildViewById(rootView, id);
      if (option2 == null) {
        break missingId;
      }

      id = R.id.option3;
      Button option3 = ViewBindings.findChildViewById(rootView, id);
      if (option3 == null) {
        break missingId;
      }

      id = R.id.option4;
      Button option4 = ViewBindings.findChildViewById(rootView, id);
      if (option4 == null) {
        break missingId;
      }

      id = R.id.profile;
      ImageView profile = ViewBindings.findChildViewById(rootView, id);
      if (profile == null) {
        break missingId;
      }

      id = R.id.question;
      TextView question = ViewBindings.findChildViewById(rootView, id);
      if (question == null) {
        break missingId;
      }

      id = R.id.sorry;
      LinearLayout sorry = ViewBindings.findChildViewById(rootView, id);
      if (sorry == null) {
        break missingId;
      }

      id = R.id.textView20;
      TextView textView20 = ViewBindings.findChildViewById(rootView, id);
      if (textView20 == null) {
        break missingId;
      }

      id = R.id.textView23;
      TextView textView23 = ViewBindings.findChildViewById(rootView, id);
      if (textView23 == null) {
        break missingId;
      }

      id = R.id.textView24;
      TextView textView24 = ViewBindings.findChildViewById(rootView, id);
      if (textView24 == null) {
        break missingId;
      }

      id = R.id.winner;
      LinearLayout winner = ViewBindings.findChildViewById(rootView, id);
      if (winner == null) {
        break missingId;
      }

      return new ActivityQuizactivityBinding((ConstraintLayout) rootView, animationView,
          animationView1, balance1, coinwithdrawl2, img, linearLayout, name2, option1, option2,
          option3, option4, profile, question, sorry, textView20, textView23, textView24, winner);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
