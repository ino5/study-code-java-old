package javastudy.temp.sorthuman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

//배열들에 대해서
public class SortHuman {
	static final String[][] INPUT = 
		{
			{"A", "1", "1", "2"},
			{"B", "2", "3", "1"},
			{"C", "3", "1", "1"},
			{"D", "2", "2", "1"},
			{"E", "1", "2", "1"},
			{"F", "1", "3", "1"},
			{"G", "2", "1", "1"},
			{"H", "1", "1", "1"},
			{"I", "2", "1", "2"} 
		};
	
	static Map<String, Integer> ID_IDX_MAP = new HashMap<>();
	
	static int N_SIZE;
	
	public static void main(String[] args) {
		
		// 비교 요소 갯수
		N_SIZE = INPUT[0].length - 1;
		
		// id와 input idx 매칭 시키는 맵 만들기
		for (int i = 0; i < INPUT.length; i++) {
			ID_IDX_MAP.put(INPUT[i][0], i);
		}
		
		// idList 만들기
		List<String> idList = new ArrayList<>();
		for (int i = 0; i < INPUT.length; i++) {
			idList.add(INPUT[i][0]);
		}
		
		List<String> answerList = mySort(idList, 1);
		System.out.println(answerList.toString());
	}
	
	// n번째 인덱스의 value를 기준으로 idList를 정렬한다.
	public static List<String> mySort(List<String> idList, int n) {
		
		// 정렬하기위한 맵 만들기
		Map<Integer, List<String>> valueMap = classifyList(idList, n);
		
		// value 배열
		Integer[] valueArr = valueMap.keySet().toArray(new Integer[0]);
		
		// value 배열 정렬
		Arrays.sort(valueArr, Collections.reverseOrder());
		
		// 같은 value 갖는 것들에 대해 '다음 인덱스(n+1)' 기준으로 비교하기
		for (int i = 0; i < valueArr.length; i++) {
			int value = valueArr[i];
			List<String> listInValueMap = valueMap.get(value);
			
			// 해당 value를 가진 리스트에 id가 여러개이고 다음 인덱스가 존재한다면
			if (listInValueMap.size() > 1 && n < N_SIZE) {
				// 해당 리스트를 sort하고 맵에 넣기
				List<String> sortedListInValueMap = mySort(listInValueMap, n + 1);
				valueMap.put(value, sortedListInValueMap);
			}
		}
		
		// 결과 리턴하기
		List<String> resultList = new ArrayList<>();
		for (int i = 0; i < valueArr.length; i++) {
			List<String> listInValueMap = valueMap.get(valueArr[i]);
			for (String val : listInValueMap) {
				resultList.add(val);
			}
		}
		
		return resultList;
	}
	
	// 리스트안에 id들을 n번째 요소를 기준으로 분류하기
	public static Map<Integer, List<String>> classifyList(List<String> list, int n) {
		Map<Integer, List<String>> resultMap = new HashMap<>();
		for (int i = 0; i < list.size(); i++) {
			String id = list.get(i);
			
			// value 가져오기
			int inputIdx = ID_IDX_MAP.get(id);
			int value = Integer.parseInt(INPUT[inputIdx][n]);
			
			// 맵에 이미 해당 값에 대한 리스트 있을 때
			if (resultMap.containsKey(value)) {
				List<String> listInValueMap = resultMap.get(value);
				listInValueMap.add(id);
			}
			
			// 맵에 해당 값에 대한리스트 없을 때
			else {
				List<String> listInValueMap = new ArrayList<>();
				listInValueMap.add(id);
				resultMap.put(value, listInValueMap);
			}
		}		
		
		return resultMap;
	}
}
