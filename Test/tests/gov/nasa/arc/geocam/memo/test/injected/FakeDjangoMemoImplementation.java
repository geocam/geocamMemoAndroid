package gov.nasa.arc.geocam.memo.test.injected;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Singleton;

import gov.nasa.arc.geocam.memo.service.DjangoMemoInterface;

public class FakeDjangoMemoImplementation implements DjangoMemoInterface{

	@Override
	public List<String> getMemos() {
		// TODO Auto-generated method stub
		List<String>testStringList = new ArrayList<String>();
		testStringList.add("string1");
		testStringList.add("string2");
		testStringList.add("string3");
		return testStringList;
	}
}
