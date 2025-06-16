class Solution:
    def minCost(self, heights, cost):
        # code here
        def total_cost(H: int) -> int:
            return sum(c * abs(h - H) for h, c in zip(heights, cost))

        low, high = min(heights), max(heights)
        best = total_cost(low)

        while low <= high:
            mid = (low + high) // 2
            cm = total_cost(mid)
            cl = total_cost(mid - 1)
            cr = total_cost(mid + 1)

            # Update the best found cost
            best = min(best, cm)
            if cm <= cl and cm <= cr:
                return cm
            if cl < cm:
                high = mid - 1
            else:
                low = mid + 1

        return best
