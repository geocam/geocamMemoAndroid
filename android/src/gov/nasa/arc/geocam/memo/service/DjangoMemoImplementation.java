package gov.nasa.arc.geocam.memo.service;


import java.util.ArrayList;
import java.util.List;

public class DjangoMemoImplementation implements DjangoMemoInterface{

	@Override
	public List<String> getMemos() {
		// TODO Auto-generated method stub
		List<String>testStringList = new ArrayList<String>();
		testStringList.add("string1");
		testStringList.add("string2");
		return testStringList;
	}
}
