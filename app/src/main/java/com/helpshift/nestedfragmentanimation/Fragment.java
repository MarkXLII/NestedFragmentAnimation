package com.helpshift.nestedfragmentanimation;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;

public class Fragment extends android.support.v4.app.Fragment {

  private static Random random = new Random();
  private String name = "No_Name";

  public static Fragment newInstance(String name) {
    Fragment fragment = new Fragment();
    fragment.name = name;
    return fragment;
  }

  public void addNestedFragment(Fragment fragment) {
    FragmentManager supportFragmentManager = getChildFragmentManager();
    FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
    fragmentTransaction.addToBackStack(null);
    fragmentTransaction.setCustomAnimations(R.anim.slide_in_from_right,
     R.anim.slide_out_to_left,
     R.anim.slide_in_from_left,
     R.anim.slide_out_to_right);
    fragmentTransaction.replace(R.id.nestedContainer, fragment);
    fragmentTransaction.commit();
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment, container, false);
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
}
