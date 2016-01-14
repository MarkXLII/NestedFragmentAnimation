package com.helpshift.nestedfragmentanimation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FaqFlowFragment extends android.support.v4.app.Fragment {

  private static int count = 0;

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_faq_flow, container, false);
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    view.findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        FragmentUtil.replaceFragment(MyFragment.newInstance("FaqFlow" + (++count)), R.id
          .faqFlowContainer,
         getChildFragmentManager());
      }
    });
  }
}
