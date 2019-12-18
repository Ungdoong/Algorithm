package practice;

import java.text.SimpleDateFormat;

public class sample {
	public static void main(String[] args) throws Exception{
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		String format_time1 = format1.format(System.currentTimeMillis());
		
		String[] cur_date = format_time1.split("-");
		String str_cur = cur_date[2];
		int cur_day = Integer.parseInt(str_cur);
		int min_day = cur_day - 6;
		if(min_day < 1)	min_day = 1;
		
		String[] arr = getDateArr(cur_day, min_day, cur_date[0], cur_date[1]);
	}
	
	public static String[] getDateArr(int cur_day, int min_day, String year, String month) {
		String[] arr = new String[cur_day - min_day + 1];
		for(int i=min_day; i<=cur_day; i++) {
			String day = Integer.toString(i);
			if(day.length() == 1)	day = "0"+day;
			arr[i-min_day] = year+"-"+month+"-"+day;
		}
		
		return arr;
	}
}