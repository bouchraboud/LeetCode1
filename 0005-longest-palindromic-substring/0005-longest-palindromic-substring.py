class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        max_len = 0  # Variable to track the length of the longest palindrome
        max_palindrome =s[0]  # Variable to store the longest palindrome
       
        for c in set(s):  # Use set to avoid repeating characters
            arr = find_all_occurrences(s, c)

            if len(arr) > 0:
                n = len(arr)

                for i in range(n):  # Loop through the indices of occurrences
                    for j in range(i + 1, n):  # Adjust to check pairs of occurrences
                        substring = s[arr[i]:arr[j] + 1]  # Include arr[j] to capture full range
                        if is_palindrome(substring):  # Check if substring is a palindrome
                            current_len = len(substring)  # Calculate the length of the palindrome
                            if max_len < current_len:
                                max_len = current_len
                                max_palindrome = substring  # Store the longest palindrome found
        
        return max_palindrome  # Return the longest palindrome found


def is_palindrome(s):
    return s == s[::-1]


def find_all_occurrences(s, letter):
    s = s.lower()
    letter = letter.lower()
    indexes = [i for i, char in enumerate(s) if char == letter]
    return indexes