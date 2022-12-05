package gateways;

import entity.inputboundary.Modelizable;
import entity.inputboundary.Populable;

import java.util.ArrayList;
import java.util.HashMap;



public interface Popularity_rank {
    /**
     * <p>get the the ranking list of the populable and modelizable object</p>
     * @param list list
     */
    default ArrayList<Modelizable> rank_by_popularity(HashMap<Integer, Populable> list) {
        ArrayList<Modelizable> result = new ArrayList<>();
        ArrayList<Integer> checked = new ArrayList<>();
        for (Integer key :list.keySet()) {
            if (checked.contains(key)) {
                continue;
            }
            Integer temp = key;
            for (Integer key2 : list.keySet()) {
                if (checked.contains(key2)) {
                    continue;
                }
                if (list.get(key).getPopularity() < list.get(key2).getPopularity()) {
                    temp = key2;
                }

            }
            checked.add(temp);
            result.add((Modelizable) list.get(temp));

        }



        return result;
    }
}
