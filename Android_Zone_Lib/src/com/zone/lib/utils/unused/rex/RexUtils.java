package com.zone.lib.utils.unused.rex;
import java.util.List;

import com.zone.lib.utils.unused.rex.Rex_Phone.PhoneEntity;


public class RexUtils {
	
	public static List<PhoneEntity>  byContextGetPhone(String str){
		return Rex_Phone.byContextGetPhone(str);
	}
}
