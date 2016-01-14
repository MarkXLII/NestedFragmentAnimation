package com.helpshift.nestedfragmentanimation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class SupportFragment extends android.support.v4.app.Fragment {

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setRetainInstance(true);
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_support, container, false);
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    view.findViewById(R.id.addFaqFlow).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        FragmentUtil.replaceFragment(new FaqFlowFragment(), R.id.supportContainer, getChildFragmentManager());
      }
    });

    view.findViewById(R.id.addConversationFlow).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        FragmentUtil.replaceFragment(new ConversationFlowFragment(), R.id.supportContainer,
         getChildFragmentManager());
      }
    });
  }

  public boolean onBackPressed() {
    List<Fragment> fragments = getChildFragmentManager().getFragments();
    if (fragments != null) {
      for (Fragment fragment : fragments) {
        if (fragment != null
         && fragment.isVisible()
         && (fragment instanceof FaqFlowFragment
         || fragment instanceof ConversationFlowFragment)) {
          FragmentManager childFragmentManager = fragment.getChildFragmentManager();
          if (childFragmentManager.getBackStackEntryCount() > 0) {
            childFragmentManager.popBackStack();
            return true;
          }
        }
      }
    }
    return false;
  }
}
