package com.chinamworld.bocmbci.biz.dept.adapter;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.chinamworld.bocmbci.R;
import com.chinamworld.bocmbci.bii.constant.Comm;
import com.chinamworld.bocmbci.constant.LocalData;
import com.chinamworld.bocmbci.utils.StringUtil;

public class AccAndDetailListAdapter extends BaseAdapter {

	private Context context = null;

	private List<Map<String, Object>> accountList = null;
	
	private OnItemClickListener imageItemClickListener = null;
	

	public AccAndDetailListAdapter(Context context, List<Map<String, Object>> accountList) {
		this.context = context;
		this.accountList = accountList;
	}

	@Override
	public int getCount() {
		return accountList.size();
	}

	@Override
	public Object getItem(int position) {
		return accountList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.dept_acc_list_item, null);
		}
		TextView accTypeTv = (TextView) convertView
				.findViewById(R.id.dept_type_tv);
		TextView cardDescriptionTv = (TextView) convertView
				.findViewById(R.id.dept_card_description_tv);
		TextView accNoTv = (TextView) convertView
				.findViewById(R.id.dept_account_num_tv);
		

		
		String strAccountType = LocalData.AccountType.get((String) accountList.get(position).get(Comm.ACCOUNT_TYPE));
		accTypeTv.setText(strAccountType);
		
		cardDescriptionTv.setText((String) accountList.get(position).get(Comm.NICKNAME));
		String accountNumber = (String) accountList.get(position).get(Comm.ACCOUNTNUMBER);
		accNoTv.setText(StringUtil.getForSixForString(accountNumber));
		((FrameLayout)convertView.findViewById(R.id.acc_frame_back)).setVisibility(View.GONE);
		((ImageView)convertView.findViewById(R.id.financeic_btn_goitem)).setVisibility(View.GONE);
		return convertView;
	}

	public OnItemClickListener getImageItemClickListener() {
		return imageItemClickListener;
	}

	public void setImageItemClickListener(OnItemClickListener imageItemClickListener) {
		this.imageItemClickListener = imageItemClickListener;
	}
}
