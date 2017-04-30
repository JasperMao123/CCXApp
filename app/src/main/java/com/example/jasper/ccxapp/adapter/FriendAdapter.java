package com.example.jasper.ccxapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jasper.ccxapp.R;

import java.util.List;

import cn.jpush.im.android.api.callback.GetAvatarBitmapCallback;
import cn.jpush.im.android.api.model.UserInfo;

public class FriendAdapter extends BaseAdapter {

	private LayoutInflater mInflater;
    private Context context;
    private List<UserInfo> userInfos;

    public FriendAdapter(Context context) {
    	this.mInflater = LayoutInflater.from(context);
    	this.context = context;
    }

    public FriendAdapter(Context context, List<UserInfo> userInfos) {
    	this.mInflater = LayoutInflater.from(context);
    	this.context = context;
    	this.userInfos = userInfos;
    }

    @Override
    public int getCount() {
    	return userInfos.size();
    }

    @Override
    public Object getItem(int position) {
    	return null;
    }

    @Override
    public long getItemId(int position) {
    	return position;
    }

    @SuppressLint("InflateParams")
	@Override
    public View getView(final int position, View convertView, ViewGroup parent) {
    	ViewHolder holder;
    	//观察convertView随ListView滚动情况
    	//Log.v("MyListViewBase", "getView " + position + " " + convertView);
    	if (convertView == null) {
    		convertView = mInflater.inflate(R.layout.a_friend, null);
    		holder =new ViewHolder();
    		/*得到各个控件的对象*/
    		holder.a_friend_image = (ImageView) convertView.findViewById(R.id.a_friend_image);
    		holder.a_friend_name = (TextView) convertView.findViewById(R.id.a_friend_name);
    		convertView.setTag(holder);//绑定ViewHolder对象
    	}
		holder = (ViewHolder)convertView.getTag();//取出ViewHolder对象                  }
    		/*设置TextView显示的内容，即我们存放在动态数组中的数据*/
		final ViewHolder finalHolder = holder;
		userInfos.get(position).getAvatarBitmap(new GetAvatarBitmapCallback() {
			@Override
			public void gotResult(int i, String s, Bitmap bitmap) {
				if(i == 0) {
					finalHolder.a_friend_image.setImageBitmap(bitmap);
				}
			}
		});

		finalHolder.a_friend_name.setText(userInfos.get(position).getUserName());
		return convertView;
    }

    public final class ViewHolder{
		public ImageView a_friend_image;
    	public TextView a_friend_name;
    }
}
