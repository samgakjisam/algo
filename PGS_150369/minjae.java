class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        int deliver_idx = n - 1;
        int pickup_idx = n - 1;
        
        long distance = 0;
        
        while (true) {
            int deliver_goods = cap;
            int pickup_goods = cap;
            
            for (int i = deliver_idx; i >= 0; i--) {
                if (deliveries[i] == 0) {
                    deliver_idx--;
                } else {
                    break;
                }
            }

            for (int i = pickup_idx; i >= 0; i--) {
                if (pickups[i] == 0) {
                    pickup_idx--;
                } else {
                    break;
                }
            }
            
            if (deliver_idx < 0 && pickup_idx < 0) {
                break;
            } else if (deliver_idx < 0) {
                distance += (pickup_idx+1) * 2;
            } else if (pickup_idx < 0) {
                distance += (deliver_idx+1) * 2;
            } else {
                if (deliver_idx >= pickup_idx) {
                    distance += (deliver_idx+1) * 2;
                } else {
                    distance += (pickup_idx+1) * 2;
                }
            }
            
            if (deliver_idx >= 0) {
                while (deliver_goods > 0 && deliver_idx >= 0) {
                    if (deliveries[deliver_idx] > deliver_goods) {
                        deliveries[deliver_idx] -= deliver_goods;
                        deliver_goods = 0;
                    } else if (deliveries[deliver_idx] == deliver_goods) {
                        deliveries[deliver_idx] = 0;
                        deliver_goods = 0;
                        deliver_idx--;
                    } else {
                        deliver_goods -= deliveries[deliver_idx];
                        deliveries[deliver_idx] = 0;
                        deliver_idx--;
                    }
                }
            }
            
            if (pickup_idx >= 0) {
                while (pickup_goods > 0 && pickup_idx >= 0) {
                    if (pickups[pickup_idx] > pickup_goods) {
                        pickups[pickup_idx] -= pickup_goods;
                        pickup_goods = 0;
                    } else if (pickups[pickup_idx] == pickup_goods) {
                        pickups[pickup_idx] = 0;
                        pickup_goods = 0;
                        pickup_idx--;
                    } else {
                        pickup_goods -= pickups[pickup_idx];
                        pickups[pickup_idx] = 0;
                        pickup_idx--;
                    }
                }
            }
        }
        
        return distance;
    }
}