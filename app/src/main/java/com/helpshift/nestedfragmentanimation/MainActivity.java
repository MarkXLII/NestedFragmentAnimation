package com.helpshift.nestedfragmentanimation;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

  private int count = 0;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Fragment fragment = Fragment.newInstance("Fragment " + (count++));
    FragmentManager supportFragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
    fragmentTransaction.addToBackStack(null);
    fragmentTransaction.setCustomAnimations(R.anim.slide_in_from_right,
     R.anim.slide_out_to_left,
     R.anim.slide_in_from_left,
     R.anim.slide_out_to_right);
    fragmentTransaction.replace(R.id.topContainer, fragment);
    fragmentTransaction.commit();


    (findViewById(R.id.addNested)).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        FragmentManager supportFragmentManager = MainActivity.this.getSupportFragmentManager();
        Fragment fragment = (Fragment) supportFragmentManager.findFragmentById(R.id.topContainer);
        Fragment nestedFragment = getNestedFragment(fragment);
        nestedFragment.addNestedFragment(Fragment.newInstance("Fragment " + (count++)));
      }
    });

    (findViewById(R.id.addTop)).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Fragment fragment = Fragment.newInstance("Fragment " + (count++));
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.setCustomAnimations(R.anim.slide_in_from_right,
         R.anim.slide_out_to_left,
         R.anim.slide_in_from_left,
         R.anim.slide_out_to_right);
        fragmentTransaction.replace(R.id.topContainer, fragment);
        fragmentTransaction.commit();
      }
    });
  }

  private Fragment getNestedFragment(Fragment fragment) {
    FragmentManager fragmentManager = fragment.getChildFragmentManager();
    if (fragmentManager.findFragmentById(R.id.nestedContainer) != null) {
      Fragment nestedFragment = (Fragment) fragmentManager.findFragmentById(R.id.nestedContainer);
      return getNestedFragment(nestedFragment);
    }
    return fragment;
  }
}
