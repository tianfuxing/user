package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * String -->Date
 * Date -->String
 */
public class DateUtil {
	public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	public static String toString(Date date) {
		if(date != null) {
			return sdf.format(date);
		}
		return "";
	}
	public static Date toDate(String str) {
		try {
			if(str == null || str.trim().equals("")) {
				return null;
			}
			return sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static java.sql.Date change(Date date){
		//将java.util.Date转换为java.sql.Date
		//setDate方法需要的Date是java.sql
		if(date == null) {
			return null;
		}
		java.sql.Date d = new java.sql.Date(date.getTime());
		return d;
	}
}
