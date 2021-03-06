package cal.entity;

import java.io.*;
import java.util.List;
import java.util.Properties;

import cal.vo.*;

public class CalEntity {
	private ICalEntity ice;
	
	public CalEntity() {
		ice = new CalEntityImpl();
	}
	
	public void doService(List list) {
		ice.doService(list);
	}
	
	public String getMsgAddZeroExc() {
		return ice.getMsgAddZeroExc();
	}
	public String getMsgSubZeroExc() {
		return ice.getMsgSubZeroExc();
	}
	public String getMsgMulOneExc() {
		return ice.getMsgMulOneExc();
	}
	public String getMsgDivOneExc() {
		return ice.getMsgDivOneExc();
	}
}
