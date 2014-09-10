package com.github.sancitu.mcdalarmreplica;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity3 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity3);
	}

	@Override
	protected void onResume() {
		super.onResume();

		final ImageView imageView = (ImageView) findViewById(R.id.imageView3);

		ValueAnimator va = ObjectAnimator.ofFloat(imageView, View.X, 60, -60);
		va.setRepeatCount(ValueAnimator.INFINITE);
		va.setRepeatMode(ValueAnimator.RESTART);

		AnimatorSet set = new AnimatorSet();
		set.play(va);
		set.setDuration(500);
		set.setInterpolator(new LinearInterpolator());
		set.start();

		Typeface font = Typeface.createFromAsset(getAssets(), "w006.ttc");

		final TextView textView = (TextView) findViewById(R.id.textView1);
		textView.setTypeface(font);

		new CountDownTimer(120000, 1000) {
		    public void onTick(long millisUntilFinished) {
		    	long secondsUntilFinished = (millisUntilFinished / 1000) % 60;
		    	long minutesUntilFinished = (millisUntilFinished / 1000) / 60;
		    	textView.setText(new String() + minutesUntilFinished + ":" + String.format("%02d", secondsUntilFinished));
		    }
		    public void onFinish() {
		    	textView.setText("›ß™[Š·");
		    }
		}.start();

		Calendar c = Calendar.getInstance();
		c.setTimeZone(TimeZone.getDefault());
		Date dt = new Date();

		SimpleDateFormat sdf1 = new SimpleDateFormat("MŒŽd E", Locale.CHINESE);
		String dts1 = sdf1.format(dt);

		final TextView textView2 = (TextView) findViewById(R.id.textView2);
		textView2.setTypeface(font);
		textView2.setText(dts1);

		SimpleDateFormat sdf2 = new SimpleDateFormat("h:mm a", Locale.ENGLISH);
		String dts2 = sdf2.format(dt);
		final TextView textView3 = (TextView) findViewById(R.id.textView3);
		textView3.setTypeface(font);
		textView3.setPaintFlags(textView3.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
		textView3.setText(dts2);
	}
}
