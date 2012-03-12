package dev.ronlemire.commoncontrols;

import com.example.android.actionbarcompat.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

public class RadioButtonFragment extends Fragment {
	public static final String MESSAGE_FROM_RADIOBUTTON_INTENT = "dev.ronlemire.commoncontrols.GALLERY_RADIOBUTTON_BROADCAST";
	public static final String OUT_MESSAGE_KEY = "OutMessage";
	public static final String IN_MESSAGE_KEY = "InMessage";
	//private String inMessage;
	private View rootView;
   private Intent intent;
   protected static final String TAG = "RadioButton";
   
	// *****************************************************************************
	// Singleton method used to pass variables to a new Fragment instance.
	// *****************************************************************************
	public static RadioButtonFragment newInstance(String inMessage) {
		RadioButtonFragment radioButtonFragment = new RadioButtonFragment();
		Bundle argumentsBundle = new Bundle(); // create a new Bundle
		argumentsBundle.putString(IN_MESSAGE_KEY, inMessage);
		radioButtonFragment.setArguments(argumentsBundle);
		return radioButtonFragment;
	}	

	// *****************************************************************************
	// Fragment Life Cycle events
	// *****************************************************************************
	@Override
	public void onCreate(Bundle argumentsBundle) {
		super.onCreate(argumentsBundle);
		intent = new Intent(MESSAGE_FROM_RADIOBUTTON_INTENT);
		//this.inMessage = getArguments().getString(IN_MESSAGE_KEY);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.radiobutton_fragment, null);
		// context = rootView.getContext();
        
        RadioGroup radGrp = (RadioGroup)rootView.findViewById(R.id.radGrp);
        
        int checkedRadioButtonID = radGrp.getCheckedRadioButtonId();

        radGrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			public void onCheckedChanged(RadioGroup arg0, int id) {
				switch(id) {
				case -1:
					SendMessage("Choices cleared!");
					break;
				case R.id.chRBtn:
					SendMessage("Chose Chicken");
					break;
				case R.id.fishRBtn:
					SendMessage("Chose Fish");
					break;
				case R.id.stkRBtn:
					SendMessage("Chose Steak");
					break;
				default:
					SendMessage("Huh?");
					break;
				}
			}});
        
		return rootView;
	}		
   	
	private void SendMessage(String message) {
		intent.putExtra(OUT_MESSAGE_KEY, message);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		getActivity().sendBroadcast(intent);	
	}
}

