package com;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;

class ReportProcessor {

	/**
	 * @param id_list
	 * @param report
	 * @param k
	 * @return
	 */
	public int[] solution(String[] id_list, String[] report, int k) {
        
        
        HashMap<String, List<String>> results = new HashMap<>();
        
		HashSet<String> reports = new HashSet<>();

        // 중복 신고 제거 (Set은 중복제거 콜렉션형태)
        for(int i = 0; i < report.length; i++){
            reports.add(report[i]);
        }


		ArrayList<String> reportArrList = new ArrayList<>();


		for(Iterator<String> it = reports.iterator(); it.hasNext();){
			reportArrList.add(it.next());
		}
        
        // 쪼개서 신고당하는 사람이 있으면 거기에다 배열 집어넣음
        for(int i = 0; i < reportArrList.size(); i++){
			String str =  reportArrList.get(i);
            String[] arr = str.split(" ");
            
            // 신고당한사람 
            String 신고한사람 = arr[0];
            String 신고당한사람 = arr[1];
            List<String> arr1 = results.get(신고당한사람);
            // 신고당한 사람을 key 신고한 사람을 배열로 넣음

            if(arr1 != null &&  arr1.size() > 0){
                arr1.add(신고한사람);         
                results.put(신고당한사람, arr1);
            }else {
                arr1 =  new ArrayList<>();
                arr1.add(신고한사람);            
                results.put(신고당한사람, arr1);                
            }
                       
        }
		
		ArrayList<String> memberList = new ArrayList<>();
		// 신고한 사람의 수가 k 이상이면 신고한 사람 count 하나씩 늘림 
		for(int i =0; i < id_list.length; i++){
			List<String> strArr =  results.get(id_list[i]);
			if(strArr == null){			
				continue;
			}
			if(strArr.size() >= k){
				for(int j = 0; j < strArr.size(); j++){
					
					memberList.add(strArr.get(j));
				}   
			}
			
		}   


		ArrayList<Integer> mailCountList = new ArrayList<>();
		for(int i =0; i < id_list.length; i++){
			int count = 0;
			for(int j = 0;j < memberList.size(); j++){
				if(id_list[i].equals(memberList.get(j))){
					count++;
				}
			}
			mailCountList.add(count);
		}
        
        
        

		int[] answer = new int[mailCountList.size()];
   		 for (int i = 0 ; i < mailCountList.size() ; i++) {
			answer[i] = mailCountList.get(i).intValue();
		 }
        return answer;
    }

	@Test
	void contextLoads() {
		assertArrayEquals(this.solution(new String[] {"muzi", "frodo", "apeach", "neo"}, new String[] {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}, 2), new int[]{2,1,1,0});

		assertArrayEquals(this.solution(new String[] {"con", "ryan"}, new String[] {"ryan con", "ryan con", "ryan con", "ryan con"}, 3), new int[]{0,0});
	}

}
