package project.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import project.parse.StationParse;

public class StationDAO {

	public int add() {
		//int result = -1;
		List<Map<String,String>> list = null;
		try {
			list = new StationParse().parse();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Iterator<Map<String, String>> it = list.iterator();
		while(it.hasNext()) {
			it.next();
		}
		return 0;
		
	}
}
