package com.helpshift.nestedfragmentanimation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    FragmentUtil.replaceFragment(new SupportFragment(), R.id.topContainer, getSupportFragmentManager());
  }

  @Override
  public void onBackPressed() {
    for (Fragment fragment : getSupportFragmentManager().getFragments()) {
      if (fragment != null
       && fragment.isVisible()
       && fragment instanceof SupportFragment) {
        if (((SupportFragment) fragment).onBackPressed()) {
          return;
        } else {
          FragmentManager childFragmentManager = fragment.getChildFragmentManager();
          if (childFragmentManager.getBackStackEntryCount() > 0) {
            childFragmentManager.popBackStack();
            return;
          }
        }
      }
    }
    super.onBackPressed();
  }
}