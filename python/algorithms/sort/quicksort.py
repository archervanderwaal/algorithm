def quicksort(nums, low, high):
    if high <= low:
        return
    j = partition(nums, low, high)
    quicksort(nums, low, j - 1)
    quicksort(nums, j + 1, high)

def partition(nums, low, high):
    i, j = low, high + 1
    value = nums[low]
    while True:
        while nums[++i] < value:
            if i == high:
                break

        while value < nums[--j]:
            if j == low:
                break
        if i >= j:
            break
        swap(nums, i, j)
    swap(nums, low, j)
    return j

def swap(nums, i, j):
    temp = nums[i]
    nums[i] = nums[j]
    nums[j] = temp

if __name__ == '__main__':
    nums = [5, 4, 3, 2, 1]
    quicksort(nums, 0, len(nums) - 1)
    print(nums)