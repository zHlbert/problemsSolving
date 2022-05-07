package contest.leetcode2022031302;

import java.util.*;

/**
 * 「云闪付」作为各方联手打造的全新移动端统一入口，致力成为消费者省钱省心的移动支付管家。
 * 请你设计一个「云闪付」优惠活动管理系统 DiscountSystem，具体功能如下：
 *
 * AddActivity(int actId, int priceLimit, int discount, int number, int userLimit) -- 表示创建编号为 actId 的优惠减免活动：
 *
 * 单笔消费的原价不小于 priceLimit 时，可享受 discount 的减免
 * 每个用户最多参与该优惠活动 userLimit 次
 * 该优惠活动共有 number 数量的参加名额
 * RemoveActivity(actId) -- 表示结束编号为 actId 的优惠活动
 *
 * Consume(int userId, int cost) -- 表示用户 userId 产生了一笔原价为 cost 的消费。请返回用户的实际支付金额。
 *
 * 单次消费最多可参加一份优惠活动
 * 若可享受优惠减免，则 「支付金额 = 原价 - 优惠减免」
 * 若同时满足多个优惠活动时，则优先参加优惠减免最大的活动
 * 注：若有多个优惠减免最大的活动，优先参加 actId 最小的活动
 */
public class DiscountSystem {

    static class Act {
        int actId;
        int priceLimit;
        int discount;
        int numberLimit;
        int userLimit;
        Map<Integer, Integer> userConsumeCountMap;
        int numberCount;

        public Act(int actId, int priceLimit, int discount, int numberCount, int userLimit) {
            this.actId = actId;
            this.priceLimit = priceLimit;
            this.discount = discount;
            this.numberLimit = numberCount;
            this.userLimit = userLimit;
            this.userConsumeCountMap = new HashMap<>();
            this.numberCount = 0;
        }

        public int getActId() {
            return actId;
        }

        public void setActId(int actId) {
            this.actId = actId;
        }

        public int getPriceLimit() {
            return priceLimit;
        }

        public void setPriceLimit(int priceLimit) {
            this.priceLimit = priceLimit;
        }

        public int getDiscount() {
            return discount;
        }

        public void setDiscount(int discount) {
            this.discount = discount;
        }

        public int getNumberLimit() {
            return numberLimit;
        }

        public void setNumberLimit(int numberLimit) {
            this.numberLimit = numberLimit;
        }

        public int getUserLimit() {
            return userLimit;
        }

        public void setUserLimit(int userLimit) {
            this.userLimit = userLimit;
        }

        public Map<Integer, Integer> getUserConsumeCountMap() {
            return userConsumeCountMap;
        }

        public void setUserConsumeCountMap(Map<Integer, Integer> userConsumeCountMap) {
            this.userConsumeCountMap = userConsumeCountMap;
        }

        public int getNumberCount() {
            return numberCount;
        }

        public void setNumberCount(int numberCount) {
            this.numberCount = numberCount;
        }
    }

    Map<Integer, Act> actMap;

    public DiscountSystem() {
        actMap = new HashMap<>();
    }

    public void addActivity(int actId, int priceLimit, int discount, int number, int userLimit) {
        actMap.put(actId, new Act(actId, priceLimit, discount, number, userLimit));
    }

    public void removeActivity(int actId) {
        actMap.remove(actId);
    }

    public int consume(int userId, int cost) {
        if (actMap.isEmpty()) {
            return cost;
        }
        List<Act> acts = new ArrayList<>(actMap.values());
        Optional<Act> properAct = acts.stream().filter(
                act -> act.numberCount < act.numberLimit
                        && (act.userConsumeCountMap.isEmpty()
                        || act.userConsumeCountMap.getOrDefault(userId, 0) < act.userLimit)
                        && cost >= act.priceLimit)
                .min(Comparator.comparing(Act::getDiscount).reversed().thenComparing(Act::getActId));
        if (properAct.isEmpty()) {
            return cost;
        }

        int actId = properAct.get().actId;
        Act act = actMap.get(actId);
        act.numberCount = act.numberCount + 1;
        Map<Integer, Integer> userConsumeCountMap = act.userConsumeCountMap;
        if (userConsumeCountMap.containsKey(userId)) {
            userConsumeCountMap.put(userId, userConsumeCountMap.get(userId) + 1);
        } else {
            userConsumeCountMap.put(userId, 1);
        }
        return cost - act.discount;
    }
}
