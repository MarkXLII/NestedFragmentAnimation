package com.helpshift.nestedfragmentanimation;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.TextView;

import java.util.Random;

public class MyFragment extends android.support.v4.app.Fragment {

  private static Random random = new Random();
  private String name = "No_Name";

  public static MyFragment newInstance(String name) {
    MyFragment myFragment = new MyFragment();
    myFragment.name = name;
    return myFragment;
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.my_fragment, container, false);
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    int color = Color.argb(255,
     random.nextInt(256),
     random.nextInt(256),
     random.nextInt(256));
    view.setBackgroundColor(color);
    TextView textView = (TextView) view.findViewById(R.id.textView);
    textView.setText(this.name);
  }

  @Override
  public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
    /*android.support.v4.app.MyFragment parentFragment = getParentFragment();
    if (parentFragment != null && !enter) {
      Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.zero);
      return animation;
    }*/
    return super.onCreateAnimation(transit, enter, nextAnim);
  }
}
