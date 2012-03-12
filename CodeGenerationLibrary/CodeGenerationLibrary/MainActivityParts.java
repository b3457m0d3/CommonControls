
     <string-array name="list_titles">
        <item>Buttons</item>
        <item>CheckBoxes</item>
        <item>DateTime</item>
        <item>EditText</item>
        <item>Gallery</item>
        <item>GridView</item>
        <item>GridViewCustom</item>
        <item>ImageView</item>
        <item>LayoutFrame</item>
        <item>LayoutRelative</item>
        <item>LayoutTable1</item>
        <item>LayoutTable2</item>
        <item>LayoutTable3</item>
        <item>ListView1</item>
        <item>ListView2</item>
        <item>ListView3</item>
        <item>ListView4</item>
        <item>RadioButton</item>
        <item>Spinner</item>
        <item>Styles</item>
        <item>TextView</item>
        <item>WeightGravity</item>
    </string-array>
    <string-array name="list_activities">
        <item>ButtonsFragment</item>
        <item>CheckBoxesFragment</item>
        <item>DateTimeFragment</item>
        <item>EditTextFragment</item>
        <item>GalleryFragment</item>
        <item>GridViewFragment</item>
        <item>GridViewCustomFragment</item>
        <item>ImageViewFragment</item>
        <item>LayoutFrameFragment</item>
        <item>LayoutRelativeFragment</item>
        <item>LayoutTable1Fragment</item>
        <item>LayoutTable2Fragment</item>
        <item>LayoutTable3Fragment</item>
        <item>ListView1Fragment</item>
        <item>ListView2Fragment</item>
        <item>ListView3Fragment</item>
        <item>ListView4Fragment</item>
        <item>RadioButtonFragment</item>
        <item>SpinnerFragment</item>
        <item>StylesFragment</item>
        <item>TextViewFragment</item>
        <item>WeightGravityFragment</item>
    </string-array>


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


=============================================================================================================================
Receivers
=============================================================================================================================

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

1=============================================================================================================================

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

	
2=============================================================================================================================

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

3=============================================================================================================================

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


