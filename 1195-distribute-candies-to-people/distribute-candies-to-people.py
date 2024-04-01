class Solution:
    def distributeCandies(self, candies: int, num_people: int) -> List[int]:
        distribution = [0] * num_people
        
        if num_people <= 0:
            return []
        
        if num_people == 1:
            distribution[0] = candies
            return distribution
        
        # Distribution of Candies
        candies_left = candies
        i = 0  # Index
        current_person = 1
        
        while candies_left > 0:
            if candies_left >= current_person:
                distribution[i] += current_person
                candies_left -= current_person
                i = (i + 1) % num_people
                current_person += 1
            else:
                distribution[i] += candies_left
                candies_left = 0
        
        return distribution