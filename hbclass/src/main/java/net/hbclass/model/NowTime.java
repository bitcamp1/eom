package net.hbclass.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NowTime {
	long curTime = 0;

	public String getCurTime() {
		long curTime = System.currentTimeMillis();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
		String nowTime = sdf.format(new Date(curTime));
		return nowTime;
		
	}

	public void setCurTime(long curTime) {
		this.curTime = curTime;
	}
	
}
