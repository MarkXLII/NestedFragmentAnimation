package com.helpshift.nestedfragmentanimation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class FragmentUtil {

  public static void replaceFragment(Fragment fragment,
                                     int containerId,
                                     FragmentManager fragmentManager) {
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    fragmentTransaction.setCustomAnimations(R.anim.slide_in_from_right,
     R.anim.slide_out_to_left,
     R.anim.slide_in_from_left,
     R.anim.slide_out_to_right);
    fragmentTransaction.replace(containerId, fragment);
    fragmentTransaction.addToBackStack(null);
    fragmentTransaction.commit();
  }
}
