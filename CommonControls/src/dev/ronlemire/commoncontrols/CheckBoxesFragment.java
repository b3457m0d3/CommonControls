package dev.ronlemire.commoncontrols;

import com.example.android.actionbarcompat.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class CheckBoxesFragment extends Fragment {
	public static final String MESSAGE_FROM_CHECKBOXES_INTENT = "dev.ronlemire.commoncontrols.MESSAGE_FROM_CHECKBOXES_INTENT";
	public static final String OUT_MESSAGE_KEY = "OutMessage";
	public static final String IN_MESSAGE_KEY = "InMessage";
	// private String inMessage;
	private View rootView;
	private Intent intent;

	// *****************************************************************************
	// Singleton method used to pass variables to a new Fragment instance.
	// *****************************************************************************
	public static CheckBoxesFragment newInstance(String inMessage) {
		CheckBoxesFragment checkBoxesFragment = new CheckBoxesFragment();
		Bundle argumentsBundle = new Bundle(); // create a new Bundle
		argumentsBundle.putString(IN_MESSAGE_KEY, inMessage);
		checkBoxesFragment.setArguments(argumentsBundle);
		return checkBoxesFragment;
	}

	// *****************************************************************************
	// Fragment Life Cycle events
	// *****************************************************************************
	@Override
	public void onCreate(Bundle argumentsBundle) {
		super.onCreate(argumentsBundle);
		intent = new Intent(MESSAGE_FROM_CHECKBOXES_INTENT);
		// this.inMessage = getArguments().getString(IN_MESSAGE_KEY);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.checkboxes_fragment, null);
		// context = rootView.getContext();

		CheckBox chickenCB = (CheckBox) rootView.findViewById(R.id.chickenCB);
		CheckBox fishCB = (CheckBox) rootView.findViewById(R.id.fishCB);
		CheckBox steakCB = (CheckBox) rootView.findViewById(R.id.steakCB);

		if (fishCB.isChecked())
			fishCB.toggle(); // flips the checkbox to unchecked if it was
								// checked

		chickenCB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

			public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {
				SendMessage("The chicken checkbox is now "
						+ (isChecked ? "checked" : "not checked"));
			}
		});

		fishCB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

			public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {
				SendMessage("The fish checkbox is now "
						+ (isChecked ? "checked" : "not checked"));
			}
		});
		
		steakCB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

			public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {
				SendMessage("The steak checkbox is now "
						+ (isChecked ? "checked" : "not checked"));
			}
		});
		
		return rootView;
	}
	
	private void SendMessage(String message) {
		intent.putExtra(OUT_MESSAGE_KEY, message);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		getActivity().sendBroadcast(intent);	
	}
}