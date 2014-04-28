package com.example.ui;

import com.astuetz.PagerSlidingTabStrip;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


public class DeviceFragment extends Fragment {
	
	/**
	 * The fragment argument representing the section number for this
	 * fragment.
	 */
	private static final String ARG_SECTION_NUMBER = "section_number";
	
	
	public static final String TAG = DeviceFragment.class
			.getSimpleName();
	
	
	public static DeviceFragment newInstance(int sectionNumber) {
		DeviceFragment fragment = new DeviceFragment();
		Bundle args = new Bundle();
		args.putInt(ARG_SECTION_NUMBER, sectionNumber);
		fragment.setArguments(args);
		return new DeviceFragment();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.detail, container,
				false);
		
		return rootView;
	}



	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onViewCreated(view, savedInstanceState);
		
		 // Initialize the ViewPager and set an adapter
		 ViewPager pager = (ViewPager) view.findViewById(R.id.pager);
		 pager.setAdapter(new MyPagerAdapter(getChildFragmentManager()));

		 // Bind the tabs to the ViewPager
		 PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) view.findViewById(R.id.tabs);
		 tabs.setViewPager(pager);
		
	}
	

	public class MyPagerAdapter extends FragmentStatePagerAdapter {

		public MyPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		private final String[] TITLES = { "Bathroom", "Bedroom", "Kitchen",
				"Washroom" };

		@Override
		public CharSequence getPageTitle(int position) {
			return TITLES[position];
		}

		@Override
		public int getCount() {
			return TITLES.length;
		}

		@Override
		public Fragment getItem(int arg0) {

			switch (arg0) {
			  
	        case 0:
	            return new DeviceListTemplate("a");
	        
	        case 1:
	            return new DeviceListTemplate("b");
	        
	        case 2:
	            return new DeviceListTemplate("c");
			
		    }
			 return new DeviceListTemplate("b");
		}

		

	}
	

}
