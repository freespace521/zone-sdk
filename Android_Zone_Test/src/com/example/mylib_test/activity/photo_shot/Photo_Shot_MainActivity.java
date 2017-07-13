package com.example.mylib_test.activity.photo_shot;
import com.example.mylib_test.R;
import com.zone.lib.base.activity.kinds.features.FeaturePic;
import com.zone.lib.base.activity.BaseActivity;
import com.zone.lib.base.activity.kinds.FeaturesKind;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;

public class Photo_Shot_MainActivity extends BaseActivity implements OnClickListener{
	private FeaturePic feature_Pic;
	@Override
	public void setContentView() {
		System.err.println("Photo_Shot_MainActivity setContentView");
		setContentView(R.layout.a_photo_shot);
	}
	@Override
	public void findIDs() {
		
	}
	@Override
	public void initData() {
		
	}
	@Override
	public void setListener() {
		
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.shot:
			feature_Pic.openCamera();
			break;
		case R.id.photo:
			feature_Pic.openPhotos();
			break;
		case R.id.clip:
			startActivity(new Intent(this,ClipTest.class));
			break;
		default:
			break;
		}
	}

	@Override
	public void updateKinds() {
		super.updateKinds();

		feature_Pic = new FeaturePic(this) {
			@Override
			protected void getReturnedPicPath(String path) {
				System.out.println(path);
				Intent intent = new Intent(Photo_Shot_MainActivity.this,ShowPicActivity.class);
				Uri uri = Uri.parse(path);
				intent.setData(uri);
				startActivity(intent);
			}
		};
		mKindControl.get(FeaturesKind.class).addFeature(feature_Pic);
	}
}
