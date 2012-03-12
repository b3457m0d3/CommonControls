package dev.ronlemire.commoncontrols;

import com.example.android.actionbarcompat.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class LayoutFrameFragment extends Fragment {
	public static final String MESSAGE_FROM_LAYOUTFRAME_INTENT = "dev.ronlemire.commoncontrols.GALLERY_LAYOUTFRAME_BROADCAST";
	public static final String OUT_MESSAGE_KEY = "OutMessage";
	public static final String IN_MESSAGE_KEY = "InMessage";
	// private String inMessage;
	private View rootView;
	private Intent intent;
	private ImageView one = null;
	private ImageView two = null;

	// *****************************************************************************
	// Singleton method used to pass variables to a new Fragment instance.
	// *****************************************************************************
	public static LayoutFrameFragment newInstance(String inMessage) {
		LayoutFrameFragment layoutFrameFragment = new LayoutFrameFragment();
		Bundle argumentsBundle = new Bundle(); // create a new Bundle
		argumentsBundle.putString(IN_MESSAGE_KEY, inMessage);
		layoutFrameFragment.setArguments(argumentsBundle);
		return layoutFrameFragment;
	}

	// *****************************************************************************
	// Fragment Life Cycle events
	// *****************************************************************************
	@Override
	public void onCreate(Bundle argumentsBundle) {
		super.onCreate(argumentsBundle);
		intent = new Intent(MESSAGE_FROM_LAYOUTFRAME_INTENT);
		// this.inMessage = getArguments().getString(IN_MESSAGE_KEY);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.layoutframe_fragment, null);
		// context = rootView.getContext();

		one = (ImageView) rootView.findViewById(R.id.oneImgView);
		two = (ImageView) rootView.findViewById(R.id.twoImgView);

		one.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				two.setVisibility(View.VISIBLE);

				view.setVisibility(View.GONE);
			}
		});

		two.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				one.setVisibility(View.VISIBLE);

				view.setVisibility(View.GONE);
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
