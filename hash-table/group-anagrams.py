class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        # create a dict with list as default_factory
        # when key does not exist, it will default create a list
        ans = collections.defaultdict(list)

        for s in strs:
            ans[tuple(sorted(s))].append(s)
        
        return list(ans.values())