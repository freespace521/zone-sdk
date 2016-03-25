package com.example.mylib_test.activity.http;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import and.abstractclass.BaseActvity;
import and.sd.FileUtils;
import android.os.Message;
import android.view.View;

import com.example.mylib_test.R;
import com.example.mylib_test.app.Constant;
import com.zone.http2rflist.NetworkGlobalEngine;
import com.zone.http2rflist.Request;
import com.zone.http2rflist.RequestParamsNet;
import com.zone.http2rflist.RequestUtils;

//TODO  listener有问题  null或者 有的时候不应该会有消息
public class NetworkNoPull_Globlo_TestActivity extends BaseActvity{
	final	String UrlPath = Constant.ADDRESS;
	private NetworkGlobalEngine engineGet,enginePost,engineFile;
	private static final int GET_TAG=1,POST_TAG=2,FILE_TAG=3;
	Map<String,String> params=new HashMap<String,String>();
	Map<String,File> fileMap=new HashMap<String,File>();
	@Override
	public void setContentView() {
		setContentView(R.layout.a_network_nopull);
		params.put("name", "疯子");

		
		engineGet=new NetworkGlobalEngine(this, handler);
		engineGet.newCall(new Request.Builder().get().url(UrlPath)
				.params(new RequestParamsNet().setParamsMap(params)).handlerTag(GET_TAG).build());
		
		enginePost=new NetworkGlobalEngine(this, handler);
//		enginePost.sendPost(UrlPath, new RequestParamsNet().setParamsMap(params), POST_TAG,null);
		enginePost.newCall(new Request.Builder().get().url(UrlPath)
				.params(new RequestParamsNet().setParamsMap(params)).handlerTag(POST_TAG).build());

		
		File f = new File(FileUtils.getFile(""), "高达 - 00.mp3");
		File f2 = new File(FileUtils.getFile("DCIM", "Camera"), "20150621_121327.jpg");
		fileMap.put("upload", f);
		fileMap.put("upload2", f2);
		engineFile=new NetworkGlobalEngine(this, handler);
		//留作对比
//		engineFile.sendFile(UrlPath,new RequestParamsNet().setParamsMap(params).setFileMap(fileMap), FILE_TAG,null);
		engineFile.newCall(RequestUtils.post(UrlPath,new RequestParamsNet().setParamsMap(params).setFileMap(fileMap)).handlerTag(FILE_TAG).build());
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
		super.onClick(v);
		switch (v.getId()) {
		case R.id.client_get:
			engineGet.start();
			break;
		case R.id.client_post:
			enginePost.start();
			break;
		case R.id.client_upload:
			engineFile.start();
			break;

		default:
			break;
		}
	}
	@Override
	public boolean handleMessage(Message msg) {
		switch (msg.what) {
		case GET_TAG:
			System.out.println("GET_TAG:"+(String)msg.obj);
			break;
		case POST_TAG:
			System.out.println("POST_TAG:"+(String)msg.obj);
			break;
		case FILE_TAG:
			System.out.println("FILE_TAG:"+(String)msg.obj);
			break;

		default:
			break;
		}
		return super.handleMessage(msg);
	}

}
