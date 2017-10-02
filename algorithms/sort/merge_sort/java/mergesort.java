import java.util.LinkedList;


class Mergesort {

    static void split(LinkedList<Integer> l, LinkedList<Integer> l1, LinkedList<Integer> l2) {
        
    	int control = l.size() - 1;
    	for(int i = 0; i <= control; i++){
    		if(i <= control/2){
    			l1.add(l.get(i));
    		}else{
    			l2.add(l.get(i));
    		}
    	}
    	
    }

    static LinkedList<Integer> merge(LinkedList<Integer> l1,
                                     LinkedList<Integer> l2) {
        LinkedList<Integer> l =  new LinkedList<Integer>();
        
        while(!l1.isEmpty() && !l2.isEmpty()){
        	if(l1.get(0) > l2.get(0)){
        		l.add(l2.get(0));
        		l2.poll();
        	}else{
        		l.add(l1.get(0));
        		l1.poll();
        	}
        }
        
        while(!l1.isEmpty()){
        	l.add(l1.get(0));
        	l1.poll();
        }
        
        while(!l2.isEmpty()){
        	l.add(l2.get(0));
        	l2.poll();
        }
    	return l; 
    }

    static LinkedList<Integer> mergesort(LinkedList<Integer> l) {
    	
    	if((l.size() == 1) || (l.isEmpty())){
    		return l;
    	}
    	
    	LinkedList<Integer> l1 = new LinkedList<Integer>();
    	LinkedList<Integer> l2 = new LinkedList<Integer>();  
    	split(l,l1,l2);
        return merge(mergesort(l1),mergesort(l2));
    }
}
