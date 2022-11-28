package Layer3.Gateways;

import Layer1.Entity.inputboundary.Modelizable;
import Layer1.Entity.inputboundary.Populable;

import java.util.ArrayList;
import java.util.HashMap;



public interface Popularity_rank {
    /**
     * <p>get the the ranking list of the populable and modelizable object</p>
     * @param list list
     */
    default ArrayList<Modelizable> rank_by_popularity(HashMap<Integer, Populable> list) {
        ArrayList<Modelizable> result = new ArrayList<>();
        HashMap<Integer, Populable> list_copy = (HashMap<Integer, Populable>) list.clone();
        for (Integer key :list.keySet()) {
            Integer temp = key;
            for (Integer key2 : list.keySet()) {
                if (list.get(key).getPopularity() > list.get(key2).getPopularity()) {
                    temp = key2;
                }

            }
            list_copy.remove(temp);
            result.add((Modelizable) list.get(temp));

        }



        return result;
    }
}
