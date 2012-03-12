package dev.ronlemire.commoncontrols;

import java.util.Calendar;
import java.util.Date;

import com.example.android.actionbarcompat.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class DateTimeFragment extends Fragment {
	public static final String MESSAGE_FROM_DATETIME_INTENT = "dev.ronlemire.commoncontrols.MESSAGE_FROM_DATETIME_INTENT";
	public static final String OUT_MESSAGE_KEY = "OutMessage";
	public static final String IN_MESSAGE_KEY = "InMessage";
	// private String inMessage;
	private View rootView;
	private Intent intent;
    private int mYear;
    private int mMonth;
    private int mDay;
    private int mHour;
    private int mMinute;
    
	// *****************************************************************************
	// Singleton method used to pass variables to a new Fragment instance.
	// *****************************************************************************
	public static DateTimeFragment newInstance(String inMessage) {
		DateTimeFragment dateTimeFragment = new DateTimeFragment();
		Bundle argumentsBundle = new Bundle(); // create a new Bundle
		argumentsBundle.putString(IN_MESSAGE_KEY, inMessage);
		dateTimeFragment.setArguments(argumentsBundle);
		return dateTimeFragment;
	}

	// *****************************************************************************
	// Fragment Life Cycle events
	// *****************************************************************************
	@Override
	public void onCreate(Bundle argumentsBundle) {
		super.onCreate(argumentsBundle);
		intent = new Intent(MESSAGE_FROM_DATETIME_INTENT);
		// this.inMessage = getArguments().getString(IN_MESSAGE_KEY);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.datetime_fragment, null);
		// context = rootView.getContext();

		TextView dateDefault = (TextView) rootView.findViewById(R.id.dateDefault);
		TextView timeDefault = (TextView) rootView.findViewById(R.id.timeDefault);

		DatePicker dp = (DatePicker)rootView.findViewById(R.id.datePicker);
		// And here, subtract 1 from December (12) to set it to December
		// dp.init(2008, 11, 10, null);
		// The month, and just the month, is zero-based. Add 1 for display.
		// dateDefault.setText("Date defaulted to " + (dp.getMonth() + 1) + "/"
		// +
		// dp.getDayOfMonth() + "/" + dp.getYear());

		final Calendar c = Calendar.getInstance();
		mYear = c.get(Calendar.YEAR);
		mMonth = c.get(Calendar.MONTH);
		mDay = c.get(Calendar.DAY_OF_MONTH);
		mHour = c.get(Calendar.HOUR);
		mMinute = c.get(Calendar.MINUTE);

		Date d = new Date(); // defaults to current date so no need to .init
		// dp.init(mYear, mMonth, mDay, null); // using Calendar properties
		CharSequence s = DateFormat.format("EEEE, MMMM d, yyyy ", d.getTime());
		dateDefault.setText(s);

		TimePicker tp = (TimePicker) rootView.findViewById(R.id.timePicker); // defaults
																			// to
																			// current
																			// time
																			// so
																			// no
																			// need
																			// to
																			// .set
		tp.setIs24HourView(true);
		// tp.setCurrentHour(mHour); // using Calendar properties
		// tp.setCurrentMinute(mMinute); // using Calendar properties

		java.util.Formatter timeF = new java.util.Formatter();
		timeF.format("Time defaulted to %d:%02d", tp.getCurrentHour(),
				tp.getCurrentMinute());
		timeDefault.setText(timeF.toString());

		return rootView;
	}
	
	private void SendMessage(String message) {
		intent.putExtra(OUT_MESSAGE_KEY, message);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		getActivity().sendBroadcast(intent);	
	}
}
