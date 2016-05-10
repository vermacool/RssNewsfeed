package com.simplerssreader;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class RssAdapter extends BaseAdapter {

	private final List<RssItem> items;
	private final Context context;

	public RssAdapter(Context context, List<RssItem> items) {
		this.items = items;
		this.context = context;
	}

	@Override
	public int getCount() {
		return items.size();
	}

	@Override
	public Object getItem(int position) {
		return items.get(position);
	}

	@Override
	public long getItemId(int id) {
		return id;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = View.inflate(context, R.layout.rss_item, null);
			holder = new ViewHolder();
			holder.itemTitle = (TextView) convertView.findViewById(R.id.itemTitle);
			holder.date= (TextView) convertView.findViewById(R.id.date);
			holder.time= (TextView) convertView.findViewById(R.id.time);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
		try
		{
			if (items.get(position).getDateTime()!=null) {
				Date date = (Date) sdf.parse(items.get(position).getDateTime());
				System.out.println(date);
				SimpleDateFormat day = new SimpleDateFormat("dd-MMM-yyyy");
				SimpleDateFormat time = new SimpleDateFormat("HH:mm");
//			System.out.println(day.format(date));
//			System.out.println(time.format(date));
				Log.d("day", day.format(date));
				Log.d("day", time.format(date));
				holder.itemTitle.setText(items.get(position).getTitle());
				holder.date.setText(day.format(date));
				holder.time.setText(time.format(date));
			}
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		return convertView;
	}

	static class ViewHolder {
		TextView itemTitle;
		TextView date;
		TextView time;
	}
}
