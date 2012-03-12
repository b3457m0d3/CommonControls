package dev.ronlemire.commoncontrols;

import com.example.android.actionbarcompat.R;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ToggleButton;

public class ButtonsFragment extends Fragment{
 	public static final String MESSAGE_FROM_BUTTONS_INTENT = "dev.ronlemire.commoncontrols.MESSAGE_FROM_BUTTONS_INTENT";
	public static final String OUT_MESSAGE_KEY = "OutMessage";
	public static final String IN_MESSAGE_KEY = "InMessage";
	//private String inMessage;
	private View rootView;
	private Intent intent;
	
	// *****************************************************************************
	// Singleton method used to pass variables to a new Fragment instance.
	// *****************************************************************************
	public static ButtonsFragment newInstance(String inMessage) {
		ButtonsFragment inputTypeFragment = new ButtonsFragment();
		Bundle argumentsBundle = new Bundle(); // create a new Bundle
		argumentsBundle.putString(IN_MESSAGE_KEY, inMessage);
		inputTypeFragment.setArguments(argumentsBundle);
		return inputTypeFragment;
	}	

	// *****************************************************************************
	// Fragment Life Cycle events
	// *****************************************************************************
	@Override
	public void onCreate(Bundle argumentsBundle) {
		super.onCreate(argumentsBundle);
		intent = new Intent(MESSAGE_FROM_BUTTONS_INTENT);
		//this.inMessage = getArguments().getString(IN_MESSAGE_KEY);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.buttons_fragment, null);
		
        Button btn1 = (Button)rootView.findViewById(R.id.ccbtn1); 
        btn1.setOnClickListener(new View.OnClickListener() 
        { 
             public void onClick(View v) 
             { 
            	SendMessage("Regular Button pressed.");
             } 
        }); 
        
        ImageButton btn2 = (ImageButton)rootView.findViewById(R.id.ccbtn2); 
        btn2.setOnClickListener(new View.OnClickListener() 
        { 
             public void onClick(View v) 
             { 
             	SendMessage("Image button pressed.");
             } 
        }); 
        
        ToggleButton btn3 = (ToggleButton)rootView.findViewById(R.id.ccbtn3); 
        btn3.setOnClickListener(new View.OnClickListener() 
        { 
             public void onClick(View v) 
             { 
             	SendMessage("Toggle button pressed.");
             } 
        }); 
		
        Button btn4 = (Button)rootView.findViewById(R.id.ccbtn4); 
        btn4.setOnClickListener(new View.OnClickListener() 
        { 
             public void onClick(View v) 
             { 
            	SendMessage("Intent Button pressed.");
                Intent intent = new Intent(Intent.ACTION_VIEW, 
                                        Uri.parse("http://www.androidbook.com")); 
                startActivity(intent); 
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
