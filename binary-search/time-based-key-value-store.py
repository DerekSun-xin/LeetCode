class TimeMap:

    def __init__(self):
        self._data = {}

    def set(self, key: str, value: str, timestamp: int) -> None:
        if key not in self._data:
            self._data[key] = [(value, timestamp)]
        else:
            self._data[key].append((value, timestamp))

    def get(self, key: str, timestamp: int) -> str:
        if key not in self._data:
            return ""
        value = self._data[key]
        for i in range(len(value) - 1, -1, -1):
            if timestamp >= value[i][1]:
                return value[i][0]
        return ""
        


# Your TimeMap object will be instantiated and called as such:
# obj = TimeMap()
# obj.set(key,value,timestamp)
# param_2 = obj.get(key,timestamp)