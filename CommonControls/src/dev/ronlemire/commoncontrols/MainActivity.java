 /*
 * Copyright 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.ronlemire.commoncontrols;

import com.example.android.actionbarcompat.R;

import dev.ronlemire.commoncontrols.ActionBar.ActionBarFragmentActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends ActionBarFragmentActivity {
	public static final String TAG = "EditTextSamples";
	private FragmentManager fm = getSupportFragmentManager();
	private Fragment sampleListFragment;
	private String sampleSelected;
	public static View sampleListView;
	private EditText messagesEditText;

	private SampleListReceiver sampleListReceiver;
	private IntentFilter sampleListFilter;
  	private MessageFromButtonsReceiver messageFromButtonsReceiver;
 	private MessageFromCheckBoxesReceiver messageFromCheckBoxesReceiver;
 	private MessageFromDateTimeReceiver messageFromDateTimeReceiver;
 	private MessageFromGalleryReceiver messageFromGalleryReceiver;
 	private MessageFromGridViewReceiver messageFromGridViewReceiver;
 	private MessageFromGridViewCustomReceiver messageFromGridViewCustomReceiver;
 	private MessageFromImageViewReceiver messageFromImageViewReceiver;
 	private MessageFromLayoutFrameReceiver messageFromLayoutFrameReceiver;
 	private MessageFromLayoutRelativeReceiver messageFromLayoutRelativeReceiver;
 	private MessageFromLayoutTable1Receiver messageFromLayoutTable1Receiver;
 	private MessageFromLayoutTable2Receiver messageFromLayoutTable2Receiver;
 	private MessageFromLayoutTable3Receiver messageFromLayoutTable3Receiver;
 	private MessageFromListView1Receiver messageFromListView1Receiver;
 	private MessageFromListView2Receiver messageFromListView2Receiver;
 	private MessageFromListView3Receiver messageFromListView3Receiver;
 	private MessageFromListView4Receiver messageFromListView4Receiver;
 	private MessageFromRadioButtonReceiver messageFromRadioButtonReceiver;
 	private MessageFromSpinnerReceiver messageFromSpinnerReceiver;
 	private MessageFromStylesReceiver messageFromStylesReceiver;
 	private MessageFromTextViewReceiver messageFromTextViewReceiver;
 	private MessageFromWeightGravityReceiver messageFromWeightGravityReceiver;
 	private MessageFromEditTextReceiver messageFromEditTextReceiver;
 	private IntentFilter messageFromButtonsFilter;
	private IntentFilter messageFromCheckBoxesFilter;
	private IntentFilter messageFromDateTimeFilter;
	private IntentFilter messageFromGalleryFilter;
	private IntentFilter messageFromGridViewFilter;
	private IntentFilter messageFromGridViewCustomFilter;
	private IntentFilter messageFromImageViewFilter;
	private IntentFilter messageFromLayoutFrameFilter;
	private IntentFilter messageFromLayoutRelativeFilter;
	private IntentFilter messageFromLayoutTable1Filter;
	private IntentFilter messageFromLayoutTable2Filter;
	private IntentFilter messageFromLayoutTable3Filter;
	private IntentFilter messageFromListView1Filter;
	private IntentFilter messageFromListView2Filter;
	private IntentFilter messageFromListView3Filter;
	private IntentFilter messageFromListView4Filter;
	private IntentFilter messageFromRadioButtonFilter;
	private IntentFilter messageFromSpinnerFilter;
	private IntentFilter messageFromStylesFilter;
	private IntentFilter messageFromTextViewFilter;
	private IntentFilter messageFromWeightGravityFilter;
	private IntentFilter messageFromEditTextFilter;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Test whether if enough display space for 2 panes. Only if tablet and
		// landscape.
		if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE
				&& isTablet()) {
			// 2 panes - list on left - sample on right
			setContentView(R.layout.main_land);
			StartEmptyFragment(); // clear sample pane
		} else {
			// 1 pane - list and sample will overlay each other
			setContentView(R.layout.main);
		}

		// Save reference to List in order to replace later
		sampleListView = this.findViewById(R.id.sampleList_replacer);
		messagesEditText = (EditText) this.findViewById(R.id.etMessages);
		messagesEditText.setEnabled(false);
		messagesEditText.setTextColor(Color.parseColor("#000000")); // black

		// Receiver to catch message sent from List after a sample has been picked
		sampleListReceiver = new SampleListReceiver();
		sampleListFilter = new IntentFilter(
				ListOfControlsFragment.SAMPLE_LIST_FRAGMENT_BROADCAST_INTENT);

		// Messages from controls
 		messageFromButtonsReceiver = new MessageFromButtonsReceiver();
		messageFromButtonsFilter = new IntentFilter(
				ButtonsFragment.MESSAGE_FROM_BUTTONS_INTENT);

		messageFromCheckBoxesReceiver = new MessageFromCheckBoxesReceiver();
		messageFromCheckBoxesFilter = new IntentFilter(
				CheckBoxesFragment.MESSAGE_FROM_CHECKBOXES_INTENT);

		messageFromDateTimeReceiver = new MessageFromDateTimeReceiver();
		messageFromDateTimeFilter = new IntentFilter(
				DateTimeFragment.MESSAGE_FROM_DATETIME_INTENT);

		messageFromGalleryReceiver = new MessageFromGalleryReceiver();
		messageFromGalleryFilter = new IntentFilter(
				GalleryFragment.MESSAGE_FROM_GALLERY_INTENT);

		messageFromGridViewReceiver = new MessageFromGridViewReceiver();
		messageFromGridViewFilter = new IntentFilter(
				GridViewFragment.MESSAGE_FROM_GRIDVIEW_INTENT);

		messageFromGridViewCustomReceiver = new MessageFromGridViewCustomReceiver();
		messageFromGridViewCustomFilter = new IntentFilter(
				GridViewCustomFragment.MESSAGE_FROM_GRIDVIEWCUSTOM_INTENT);

		messageFromImageViewReceiver = new MessageFromImageViewReceiver();
		messageFromImageViewFilter = new IntentFilter(
				ImageViewFragment.MESSAGE_FROM_IMAGEVIEW_INTENT);

		messageFromLayoutFrameReceiver = new MessageFromLayoutFrameReceiver();
		messageFromLayoutFrameFilter = new IntentFilter(
				LayoutFrameFragment.MESSAGE_FROM_LAYOUTFRAME_INTENT);

		messageFromLayoutRelativeReceiver = new MessageFromLayoutRelativeReceiver();
		messageFromLayoutRelativeFilter = new IntentFilter(
				LayoutRelativeFragment.MESSAGE_FROM_LAYOUTRELATIVE_INTENT);

		messageFromLayoutTable1Receiver = new MessageFromLayoutTable1Receiver();
		messageFromLayoutTable1Filter = new IntentFilter(
				LayoutTable1Fragment.MESSAGE_FROM_LAYOUTTABLE1_INTENT);

		messageFromLayoutTable2Receiver = new MessageFromLayoutTable2Receiver();
		messageFromLayoutTable2Filter = new IntentFilter(
				LayoutTable2Fragment.MESSAGE_FROM_LAYOUTTABLE2_INTENT);

		messageFromLayoutTable3Receiver = new MessageFromLayoutTable3Receiver();
		messageFromLayoutTable3Filter = new IntentFilter(
				LayoutTable3Fragment.MESSAGE_FROM_LAYOUTTABLE3_INTENT);

		messageFromListView1Receiver = new MessageFromListView1Receiver();
		messageFromListView1Filter = new IntentFilter(
				ListView1Fragment.MESSAGE_FROM_LISTVIEW1_INTENT);

		messageFromListView2Receiver = new MessageFromListView2Receiver();
		messageFromListView2Filter = new IntentFilter(
				ListView2Fragment.MESSAGE_FROM_LISTVIEW2_INTENT);

		messageFromListView3Receiver = new MessageFromListView3Receiver();
		messageFromListView3Filter = new IntentFilter(
				ListView3Fragment.MESSAGE_FROM_LISTVIEW3_INTENT);

		messageFromListView4Receiver = new MessageFromListView4Receiver();
		messageFromListView4Filter = new IntentFilter(
				ListView4Fragment.MESSAGE_FROM_LISTVIEW4_INTENT);

		messageFromRadioButtonReceiver = new MessageFromRadioButtonReceiver();
		messageFromRadioButtonFilter = new IntentFilter(
				RadioButtonFragment.MESSAGE_FROM_RADIOBUTTON_INTENT);

		messageFromSpinnerReceiver = new MessageFromSpinnerReceiver();
		messageFromSpinnerFilter = new IntentFilter(
				SpinnerFragment.MESSAGE_FROM_SPINNER_INTENT);

		messageFromStylesReceiver = new MessageFromStylesReceiver();
		messageFromStylesFilter = new IntentFilter(
				StylesFragment.MESSAGE_FROM_STYLES_INTENT);

		messageFromTextViewReceiver = new MessageFromTextViewReceiver();
		messageFromTextViewFilter = new IntentFilter(
				TextViewFragment.MESSAGE_FROM_TEXTVIEW_INTENT);

		messageFromWeightGravityReceiver = new MessageFromWeightGravityReceiver();
		messageFromWeightGravityFilter = new IntentFilter(
				WeightGravityFragment.MESSAGE_FROM_WEIGHTGRAVITY_INTENT);

		messageFromEditTextReceiver = new MessageFromEditTextReceiver();
		messageFromEditTextFilter = new IntentFilter(
				EditTextFragment.MESSAGE_FROM_EDITTEXT_INTENT);

		
		// Fill list pane with sample list
		StartListofControlsFragment();
	}

	@Override
	public void onResume() {
		super.onResume();
		registerReceiver(sampleListReceiver, sampleListFilter);
 		registerReceiver(messageFromButtonsReceiver, messageFromButtonsFilter);
		registerReceiver(messageFromCheckBoxesReceiver, messageFromCheckBoxesFilter);
		registerReceiver(messageFromDateTimeReceiver, messageFromDateTimeFilter);
		registerReceiver(messageFromGalleryReceiver, messageFromGalleryFilter);
		registerReceiver(messageFromGridViewReceiver, messageFromGridViewFilter);
		registerReceiver(messageFromGridViewCustomReceiver, messageFromGridViewCustomFilter);
		registerReceiver(messageFromImageViewReceiver, messageFromImageViewFilter);
		registerReceiver(messageFromLayoutFrameReceiver, messageFromLayoutFrameFilter);
		registerReceiver(messageFromLayoutRelativeReceiver, messageFromLayoutRelativeFilter);
		registerReceiver(messageFromLayoutTable1Receiver, messageFromLayoutTable1Filter);
		registerReceiver(messageFromLayoutTable2Receiver, messageFromLayoutTable2Filter);
		registerReceiver(messageFromLayoutTable3Receiver, messageFromLayoutTable3Filter);
		registerReceiver(messageFromListView1Receiver, messageFromListView1Filter);
		registerReceiver(messageFromListView2Receiver, messageFromListView2Filter);
		registerReceiver(messageFromListView3Receiver, messageFromListView3Filter);
		registerReceiver(messageFromListView4Receiver, messageFromListView4Filter);
		registerReceiver(messageFromRadioButtonReceiver, messageFromRadioButtonFilter);
		registerReceiver(messageFromSpinnerReceiver, messageFromSpinnerFilter);
		registerReceiver(messageFromStylesReceiver, messageFromStylesFilter);
		registerReceiver(messageFromTextViewReceiver, messageFromTextViewFilter);
		registerReceiver(messageFromWeightGravityReceiver, messageFromWeightGravityFilter);
		registerReceiver(messageFromEditTextReceiver, messageFromEditTextFilter);
	}

	@Override
	protected void onPause() {
		super.onPause();
		unregisterReceiver(sampleListReceiver);
 		unregisterReceiver(messageFromButtonsReceiver);
		unregisterReceiver(messageFromCheckBoxesReceiver);
		unregisterReceiver(messageFromDateTimeReceiver);
		unregisterReceiver(messageFromGalleryReceiver);
		unregisterReceiver(messageFromGridViewReceiver);
		unregisterReceiver(messageFromGridViewCustomReceiver);
		unregisterReceiver(messageFromImageViewReceiver);
		unregisterReceiver(messageFromLayoutFrameReceiver);
		unregisterReceiver(messageFromLayoutRelativeReceiver);
		unregisterReceiver(messageFromLayoutTable1Receiver);
		unregisterReceiver(messageFromLayoutTable2Receiver);
		unregisterReceiver(messageFromLayoutTable3Receiver);
		unregisterReceiver(messageFromListView1Receiver);
		unregisterReceiver(messageFromListView2Receiver);
		unregisterReceiver(messageFromListView3Receiver);
		unregisterReceiver(messageFromListView4Receiver);
		unregisterReceiver(messageFromRadioButtonReceiver);
		unregisterReceiver(messageFromSpinnerReceiver);
		unregisterReceiver(messageFromStylesReceiver);
		unregisterReceiver(messageFromTextViewReceiver);
		unregisterReceiver(messageFromWeightGravityReceiver);
		unregisterReceiver(messageFromEditTextReceiver);
	}

	// *****************************************************************************
	// BroadcastReceivers
	// *****************************************************************************
	class SampleListReceiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			// Sample selected from list will be in Intent's extra data
			sampleSelected = intent
					.getStringExtra(ListOfControlsFragment.SAMPLE_SELECTED);

			// Start sample fragment depending on which sample was selected
			ClearMessageBox();
			if (sampleSelected.equals("ButtonsFragment")) {
				StartButtonsFragment();
   		} else if (sampleSelected.equals("CheckBoxesFragment")) {
				StartCheckBoxesFragment();
   		} else if (sampleSelected.equals("DateTimeFragment")) {
				StartDateTimeFragment();
   		} else if (sampleSelected.equals("EditTextFragment")) {
				StartEditTextFragment();
   		} else if (sampleSelected.equals("GalleryFragment")) {
				StartGalleryFragment();
   		} else if (sampleSelected.equals("GridViewFragment")) {
				StartGridViewFragment();
   		} else if (sampleSelected.equals("GridViewCustomFragment")) {
				StartGridViewCustomFragment();
   		} else if (sampleSelected.equals("ImageViewFragment")) {
				StartImageViewFragment();
   		} else if (sampleSelected.equals("LayoutFrameFragment")) {
				StartLayoutFrameFragment();
   		} else if (sampleSelected.equals("LayoutRelativeFragment")) {
				StartLayoutRelativeFragment();
   		} else if (sampleSelected.equals("LayoutTable1Fragment")) {
				StartLayoutTable1Fragment();
   		} else if (sampleSelected.equals("LayoutTable2Fragment")) {
				StartLayoutTable2Fragment();
   		} else if (sampleSelected.equals("LayoutTable3Fragment")) {
				StartLayoutTable3Fragment();
   		} else if (sampleSelected.equals("ListView1Fragment")) {
				StartListView1Fragment();
   		} else if (sampleSelected.equals("ListView2Fragment")) {
				StartListView2Fragment();
   		} else if (sampleSelected.equals("ListView3Fragment")) {
				StartListView3Fragment();
   		} else if (sampleSelected.equals("ListView4Fragment")) {
				StartListView4Fragment();
   		} else if (sampleSelected.equals("RadioButtonFragment")) {
				StartRadioButtonFragment();
   		} else if (sampleSelected.equals("SpinnerFragment")) {
				StartSpinnerFragment();
   		} else if (sampleSelected.equals("StylesFragment")) {
				StartStylesFragment();
   		} else if (sampleSelected.equals("TextViewFragment")) {
				StartTextViewFragment();
   		} else if (sampleSelected.equals("WeightGravityFragment")) {
				StartWeightGravityFragment();
         }
		}
	}

 	class MessageFromButtonsReceiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			String message = (String) intent
					.getSerializableExtra(ButtonsFragment.OUT_MESSAGE_KEY);
			messagesEditText.setText(message);
		}
	}

	class MessageFromCheckBoxesReceiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			String message = (String) intent
					.getSerializableExtra(CheckBoxesFragment.OUT_MESSAGE_KEY);
			messagesEditText.setText(message);
		}
	}

	class MessageFromDateTimeReceiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			String message = (String) intent
					.getSerializableExtra(DateTimeFragment.OUT_MESSAGE_KEY);
			messagesEditText.setText(message);
		}
	}

	class MessageFromGalleryReceiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			String message = (String) intent
					.getSerializableExtra(EditTextFragment.OUT_MESSAGE_KEY);
			messagesEditText.setText(message);
		}
	}

	class MessageFromGridViewReceiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			String message = (String) intent
					.getSerializableExtra(GalleryFragment.OUT_MESSAGE_KEY);
			messagesEditText.setText(message);
		}
	}

	class MessageFromGridViewCustomReceiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			String message = (String) intent
					.getSerializableExtra(GridViewFragment.OUT_MESSAGE_KEY);
			messagesEditText.setText(message);
		}
	}

	class MessageFromImageViewReceiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			String message = (String) intent
					.getSerializableExtra(GridViewCustomFragment.OUT_MESSAGE_KEY);
			messagesEditText.setText(message);
		}
	}

	class MessageFromLayoutFrameReceiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			String message = (String) intent
					.getSerializableExtra(ImageViewFragment.OUT_MESSAGE_KEY);
			messagesEditText.setText(message);
		}
	}

	class MessageFromLayoutRelativeReceiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			String message = (String) intent
					.getSerializableExtra(LayoutFrameFragment.OUT_MESSAGE_KEY);
			messagesEditText.setText(message);
		}
	}

	class MessageFromLayoutTable1Receiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			String message = (String) intent
					.getSerializableExtra(LayoutRelativeFragment.OUT_MESSAGE_KEY);
			messagesEditText.setText(message);
		}
	}

	class MessageFromLayoutTable2Receiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			String message = (String) intent
					.getSerializableExtra(LayoutTable1Fragment.OUT_MESSAGE_KEY);
			messagesEditText.setText(message);
		}
	}

	class MessageFromLayoutTable3Receiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			String message = (String) intent
					.getSerializableExtra(LayoutTable2Fragment.OUT_MESSAGE_KEY);
			messagesEditText.setText(message);
		}
	}

	class MessageFromListView1Receiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			String message = (String) intent
					.getSerializableExtra(LayoutTable3Fragment.OUT_MESSAGE_KEY);
			messagesEditText.setText(message);
		}
	}

	class MessageFromListView2Receiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			String message = (String) intent
					.getSerializableExtra(ListView1Fragment.OUT_MESSAGE_KEY);
			messagesEditText.setText(message);
		}
	}

	class MessageFromListView3Receiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			String message = (String) intent
					.getSerializableExtra(ListView2Fragment.OUT_MESSAGE_KEY);
			messagesEditText.setText(message);
		}
	}

	class MessageFromListView4Receiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			String message = (String) intent
					.getSerializableExtra(ListView3Fragment.OUT_MESSAGE_KEY);
			messagesEditText.setText(message);
		}
	}

	class MessageFromRadioButtonReceiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			String message = (String) intent
					.getSerializableExtra(ListView4Fragment.OUT_MESSAGE_KEY);
			messagesEditText.setText(message);
		}
	}

	class MessageFromSpinnerReceiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			String message = (String) intent
					.getSerializableExtra(RadioButtonFragment.OUT_MESSAGE_KEY);
			messagesEditText.setText(message);
		}
	}

	class MessageFromStylesReceiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			String message = (String) intent
					.getSerializableExtra(SpinnerFragment.OUT_MESSAGE_KEY);
			messagesEditText.setText(message);
		}
	}

	class MessageFromTextViewReceiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			String message = (String) intent
					.getSerializableExtra(StylesFragment.OUT_MESSAGE_KEY);
			messagesEditText.setText(message);
		}
	}

	class MessageFromWeightGravityReceiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			String message = (String) intent
					.getSerializableExtra(TextViewFragment.OUT_MESSAGE_KEY);
			messagesEditText.setText(message);
		}
	}

	class MessageFromEditTextReceiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			String message = (String) intent
					.getSerializableExtra(WeightGravityFragment.OUT_MESSAGE_KEY);
			messagesEditText.setText(message);
		}
	}

	
	// *****************************************************************************
	// Start Fragments
	// *****************************************************************************
	public void StartListofControlsFragment() {
		sampleListFragment = (Fragment) getSupportFragmentManager()
				.findFragmentById(R.id.sampleList_replacer);
		sampleListFragment = ListOfControlsFragment
				.newInstance("inMessageGoesHere");
		FragmentTransaction fragmentTransaction = getSupportFragmentManager()
				.beginTransaction();
		fragmentTransaction.replace(R.id.sampleList_replacer,
				sampleListFragment);
		fragmentTransaction.commit();
	}

	public void StartEmptyFragment() {
		Fragment sampleEmptyFragment = (Fragment) fm
				.findFragmentById(R.id.sample_replacer);
		sampleEmptyFragment = EmptyFragment.newInstance();

		fm.beginTransaction()
				.replace(R.id.sample_replacer, sampleEmptyFragment).commit(); // begin
																				// the
																				// transition
	}

 public void StartButtonsFragment() {
	if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE
			&& isTablet()) {
		Fragment buttonsFragment = (Fragment) fm
				.findFragmentById(R.id.sample_replacer);
		buttonsFragment = ButtonsFragment.newInstance("Buttons");

		fm.beginTransaction()
			.replace(R.id.sample_replacer, buttonsFragment)
			.commit();
	} else {
		ButtonsFragment buttonsFragment = ButtonsFragment
				.newInstance("Buttons");
		getSupportFragmentManager().beginTransaction()
				.replace(MainActivity.sampleListView.getId(), buttonsFragment)
				.commit();
	}
}	

public void StartCheckBoxesFragment() {
	if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE
			&& isTablet()) {
		Fragment checkBoxesFragment = (Fragment) fm
				.findFragmentById(R.id.sample_replacer);
		checkBoxesFragment = CheckBoxesFragment.newInstance("CheckBoxes");

		fm.beginTransaction()
			.replace(R.id.sample_replacer, checkBoxesFragment)
			.commit();
	} else {
		CheckBoxesFragment checkBoxesFragment = CheckBoxesFragment
				.newInstance("CheckBoxes");
		getSupportFragmentManager().beginTransaction()
				.replace(MainActivity.sampleListView.getId(), checkBoxesFragment)
				.commit();
	}
}	

public void StartDateTimeFragment() {
	if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE
			&& isTablet()) {
		Fragment dateTimeFragment = (Fragment) fm
				.findFragmentById(R.id.sample_replacer);
		dateTimeFragment = DateTimeFragment.newInstance("DateTime");

		fm.beginTransaction()
			.replace(R.id.sample_replacer, dateTimeFragment)
			.commit();
	} else {
		DateTimeFragment dateTimeFragment = DateTimeFragment
				.newInstance("DateTime");
		getSupportFragmentManager().beginTransaction()
				.replace(MainActivity.sampleListView.getId(), dateTimeFragment)
				.commit();
	}
}	

public void StartEditTextFragment() {
	if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE
			&& isTablet()) {
		Fragment editTextFragment = (Fragment) fm
				.findFragmentById(R.id.sample_replacer);
		editTextFragment = EditTextFragment.newInstance("EditText");

		fm.beginTransaction()
			.replace(R.id.sample_replacer, editTextFragment)
			.commit();
	} else {
		EditTextFragment editTextFragment = EditTextFragment
				.newInstance("EditText");
		getSupportFragmentManager().beginTransaction()
				.replace(MainActivity.sampleListView.getId(), editTextFragment)
				.commit();
	}
}	

public void StartGalleryFragment() {
	if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE
			&& isTablet()) {
		Fragment galleryFragment = (Fragment) fm
				.findFragmentById(R.id.sample_replacer);
		galleryFragment = GalleryFragment.newInstance("Gallery");

		fm.beginTransaction()
			.replace(R.id.sample_replacer, galleryFragment)
			.commit();
	} else {
		GalleryFragment galleryFragment = GalleryFragment
				.newInstance("Gallery");
		getSupportFragmentManager().beginTransaction()
				.replace(MainActivity.sampleListView.getId(), galleryFragment)
				.commit();
	}
}	

public void StartGridViewFragment() {
	if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE
			&& isTablet()) {
		Fragment gridViewFragment = (Fragment) fm
				.findFragmentById(R.id.sample_replacer);
		gridViewFragment = GridViewFragment.newInstance("GridView");

		fm.beginTransaction()
			.replace(R.id.sample_replacer, gridViewFragment)
			.commit();
	} else {
		GridViewFragment gridViewFragment = GridViewFragment
				.newInstance("GridView");
		getSupportFragmentManager().beginTransaction()
				.replace(MainActivity.sampleListView.getId(), gridViewFragment)
				.commit();
	}
}	

public void StartGridViewCustomFragment() {
	if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE
			&& isTablet()) {
		Fragment gridViewCustomFragment = (Fragment) fm
				.findFragmentById(R.id.sample_replacer);
		gridViewCustomFragment = GridViewCustomFragment.newInstance("GridViewCustom");

		fm.beginTransaction()
			.replace(R.id.sample_replacer, gridViewCustomFragment)
			.commit();
	} else {
		GridViewCustomFragment gridViewCustomFragment = GridViewCustomFragment
				.newInstance("GridViewCustom");
		getSupportFragmentManager().beginTransaction()
				.replace(MainActivity.sampleListView.getId(), gridViewCustomFragment)
				.commit();
	}
}	

public void StartImageViewFragment() {
	if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE
			&& isTablet()) {
		Fragment imageViewFragment = (Fragment) fm
				.findFragmentById(R.id.sample_replacer);
		imageViewFragment = ImageViewFragment.newInstance("ImageView");

		fm.beginTransaction()
			.replace(R.id.sample_replacer, imageViewFragment)
			.commit();
	} else {
		ImageViewFragment imageViewFragment = ImageViewFragment
				.newInstance("ImageView");
		getSupportFragmentManager().beginTransaction()
				.replace(MainActivity.sampleListView.getId(), imageViewFragment)
				.commit();
	}
}	

public void StartLayoutFrameFragment() {
	if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE
			&& isTablet()) {
		Fragment layoutFrameFragment = (Fragment) fm
				.findFragmentById(R.id.sample_replacer);
		layoutFrameFragment = LayoutFrameFragment.newInstance("LayoutFrame");

		fm.beginTransaction()
			.replace(R.id.sample_replacer, layoutFrameFragment)
			.commit();
	} else {
		LayoutFrameFragment layoutFrameFragment = LayoutFrameFragment
				.newInstance("LayoutFrame");
		getSupportFragmentManager().beginTransaction()
				.replace(MainActivity.sampleListView.getId(), layoutFrameFragment)
				.commit();
	}
}	

public void StartLayoutRelativeFragment() {
	if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE
			&& isTablet()) {
		Fragment layoutRelativeFragment = (Fragment) fm
				.findFragmentById(R.id.sample_replacer);
		layoutRelativeFragment = LayoutRelativeFragment.newInstance("LayoutRelative");

		fm.beginTransaction()
			.replace(R.id.sample_replacer, layoutRelativeFragment)
			.commit();
	} else {
		LayoutRelativeFragment layoutRelativeFragment = LayoutRelativeFragment
				.newInstance("LayoutRelative");
		getSupportFragmentManager().beginTransaction()
				.replace(MainActivity.sampleListView.getId(), layoutRelativeFragment)
				.commit();
	}
}	

public void StartLayoutTable1Fragment() {
	if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE
			&& isTablet()) {
		Fragment layoutTable1Fragment = (Fragment) fm
				.findFragmentById(R.id.sample_replacer);
		layoutTable1Fragment = LayoutTable1Fragment.newInstance("LayoutTable1");

		fm.beginTransaction()
			.replace(R.id.sample_replacer, layoutTable1Fragment)
			.commit();
	} else {
		LayoutTable1Fragment layoutTable1Fragment = LayoutTable1Fragment
				.newInstance("LayoutTable1");
		getSupportFragmentManager().beginTransaction()
				.replace(MainActivity.sampleListView.getId(), layoutTable1Fragment)
				.commit();
	}
}	

public void StartLayoutTable2Fragment() {
	if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE
			&& isTablet()) {
		Fragment layoutTable2Fragment = (Fragment) fm
				.findFragmentById(R.id.sample_replacer);
		layoutTable2Fragment = LayoutTable2Fragment.newInstance("LayoutTable2");

		fm.beginTransaction()
			.replace(R.id.sample_replacer, layoutTable2Fragment)
			.commit();
	} else {
		LayoutTable2Fragment layoutTable2Fragment = LayoutTable2Fragment
				.newInstance("LayoutTable2");
		getSupportFragmentManager().beginTransaction()
				.replace(MainActivity.sampleListView.getId(), layoutTable2Fragment)
				.commit();
	}
}	

public void StartLayoutTable3Fragment() {
	if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE
			&& isTablet()) {
		Fragment layoutTable3Fragment = (Fragment) fm
				.findFragmentById(R.id.sample_replacer);
		layoutTable3Fragment = LayoutTable3Fragment.newInstance("LayoutTable3");

		fm.beginTransaction()
			.replace(R.id.sample_replacer, layoutTable3Fragment)
			.commit();
	} else {
		LayoutTable3Fragment layoutTable3Fragment = LayoutTable3Fragment
				.newInstance("LayoutTable3");
		getSupportFragmentManager().beginTransaction()
				.replace(MainActivity.sampleListView.getId(), layoutTable3Fragment)
				.commit();
	}
}	

public void StartListView1Fragment() {
	if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE
			&& isTablet()) {
		Fragment listView1Fragment = (Fragment) fm
				.findFragmentById(R.id.sample_replacer);
		listView1Fragment = ListView1Fragment.newInstance("ListView1");

		fm.beginTransaction()
			.replace(R.id.sample_replacer, listView1Fragment)
			.commit();
	} else {
		ListView1Fragment listView1Fragment = ListView1Fragment
				.newInstance("ListView1");
		getSupportFragmentManager().beginTransaction()
				.replace(MainActivity.sampleListView.getId(), listView1Fragment)
				.commit();
	}
}	

public void StartListView2Fragment() {
	if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE
			&& isTablet()) {
		Fragment listView2Fragment = (Fragment) fm
				.findFragmentById(R.id.sample_replacer);
		listView2Fragment = ListView2Fragment.newInstance("ListView2");

		fm.beginTransaction()
			.replace(R.id.sample_replacer, listView2Fragment)
			.commit();
	} else {
		ListView2Fragment listView2Fragment = ListView2Fragment
				.newInstance("ListView2");
		getSupportFragmentManager().beginTransaction()
				.replace(MainActivity.sampleListView.getId(), listView2Fragment)
				.commit();
	}
}	

public void StartListView3Fragment() {
	if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE
			&& isTablet()) {
		Fragment listView3Fragment = (Fragment) fm
				.findFragmentById(R.id.sample_replacer);
		listView3Fragment = ListView3Fragment.newInstance("ListView3");

		fm.beginTransaction()
			.replace(R.id.sample_replacer, listView3Fragment)
			.commit();
	} else {
		ListView3Fragment listView3Fragment = ListView3Fragment
				.newInstance("ListView3");
		getSupportFragmentManager().beginTransaction()
				.replace(MainActivity.sampleListView.getId(), listView3Fragment)
				.commit();
	}
}	

public void StartListView4Fragment() {
	if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE
			&& isTablet()) {
		Fragment listView4Fragment = (Fragment) fm
				.findFragmentById(R.id.sample_replacer);
		listView4Fragment = ListView4Fragment.newInstance("ListView4");

		fm.beginTransaction()
			.replace(R.id.sample_replacer, listView4Fragment)
			.commit();
	} else {
		ListView4Fragment listView4Fragment = ListView4Fragment
				.newInstance("ListView4");
		getSupportFragmentManager().beginTransaction()
				.replace(MainActivity.sampleListView.getId(), listView4Fragment)
				.commit();
	}
}	

public void StartRadioButtonFragment() {
	if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE
			&& isTablet()) {
		Fragment radioButtonFragment = (Fragment) fm
				.findFragmentById(R.id.sample_replacer);
		radioButtonFragment = RadioButtonFragment.newInstance("RadioButton");

		fm.beginTransaction()
			.replace(R.id.sample_replacer, radioButtonFragment)
			.commit();
	} else {
		RadioButtonFragment radioButtonFragment = RadioButtonFragment
				.newInstance("RadioButton");
		getSupportFragmentManager().beginTransaction()
				.replace(MainActivity.sampleListView.getId(), radioButtonFragment)
				.commit();
	}
}	

public void StartSpinnerFragment() {
	if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE
			&& isTablet()) {
		Fragment spinnerFragment = (Fragment) fm
				.findFragmentById(R.id.sample_replacer);
		spinnerFragment = SpinnerFragment.newInstance("Spinner");

		fm.beginTransaction()
			.replace(R.id.sample_replacer, spinnerFragment)
			.commit();
	} else {
		SpinnerFragment spinnerFragment = SpinnerFragment
				.newInstance("Spinner");
		getSupportFragmentManager().beginTransaction()
				.replace(MainActivity.sampleListView.getId(), spinnerFragment)
				.commit();
	}
}	

public void StartStylesFragment() {
	if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE
			&& isTablet()) {
		Fragment stylesFragment = (Fragment) fm
				.findFragmentById(R.id.sample_replacer);
		stylesFragment = StylesFragment.newInstance("Styles");

		fm.beginTransaction()
			.replace(R.id.sample_replacer, stylesFragment)
			.commit();
	} else {
		StylesFragment stylesFragment = StylesFragment
				.newInstance("Styles");
		getSupportFragmentManager().beginTransaction()
				.replace(MainActivity.sampleListView.getId(), stylesFragment)
				.commit();
	}
}	

public void StartTextViewFragment() {
	if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE
			&& isTablet()) {
		Fragment textViewFragment = (Fragment) fm
				.findFragmentById(R.id.sample_replacer);
		textViewFragment = TextViewFragment.newInstance("TextView");

		fm.beginTransaction()
			.replace(R.id.sample_replacer, textViewFragment)
			.commit();
	} else {
		TextViewFragment textViewFragment = TextViewFragment
				.newInstance("TextView");
		getSupportFragmentManager().beginTransaction()
				.replace(MainActivity.sampleListView.getId(), textViewFragment)
				.commit();
	}
}	

public void StartWeightGravityFragment() {
	if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE
			&& isTablet()) {
		Fragment weightGravityFragment = (Fragment) fm
				.findFragmentById(R.id.sample_replacer);
		weightGravityFragment = WeightGravityFragment.newInstance("WeightGravity");

		fm.beginTransaction()
			.replace(R.id.sample_replacer, weightGravityFragment)
			.commit();
	} else {
		WeightGravityFragment weightGravityFragment = WeightGravityFragment
				.newInstance("WeightGravity");
		getSupportFragmentManager().beginTransaction()
				.replace(MainActivity.sampleListView.getId(), weightGravityFragment)
				.commit();
	}
}	


	// *****************************************************************************
	// Action Bar
	// *****************************************************************************
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.main, menu);

		// Calling super after populating the menu is necessary here to ensure
		// that the action bar helpers have a chance to handle this event.
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// Toast.makeText(this, "Tapped home", Toast.LENGTH_SHORT).show();
			ReturnToSampleList();
			break;

		case R.id.menu_refresh:
			// Toast.makeText(this, "Fake refreshing...",
			// Toast.LENGTH_SHORT).show();
			ReturnToSampleList();
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	// *****************************************************************************
	// Helper methods
	// *****************************************************************************
	private boolean isTablet() {
		Display display = getWindowManager().getDefaultDisplay();
		DisplayMetrics displayMetrics = new DisplayMetrics();
		display.getMetrics(displayMetrics);

		int width = displayMetrics.widthPixels / displayMetrics.densityDpi;
		int height = displayMetrics.heightPixels / displayMetrics.densityDpi;

		double screenDiagonal = Math.sqrt(width * width + height * height);
		return (screenDiagonal >= 8.5);
	}

	private void ReturnToSampleList() {
		ClearMessageBox();
		if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE
				&& isTablet()) {
			StartListofControlsFragment();
			StartEmptyFragment();
		} else {
			ListOfControlsFragment sampleListFragment = ListOfControlsFragment
					.newInstance("List");
			getSupportFragmentManager()
					.beginTransaction()
					.replace(MainActivity.sampleListView.getId(),
							sampleListFragment).commit();
		}
	}

	private void ClearMessageBox() {
		messagesEditText.setText("");
	}
}


