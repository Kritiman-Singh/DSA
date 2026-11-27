class Solution:
    def maximumSaleItems(self, items: List[List[int]], budget: int) -> int:
        mn = min(p for _, p in items)
        f = [0] * (budget + 1)

        for factor, price in items:
            gain = sum(1 for g, _ in items if g % factor == 0)
            for b in range(budget, price - 1, -1):
                f[b] = max(f[b], f[b - price] + gain)

        return max(f[b] + (budget - b) // mn for b in range(budget + 1))