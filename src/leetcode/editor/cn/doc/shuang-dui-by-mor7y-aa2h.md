思路是一个大顶堆放小元素，一个小顶堆放大元素。
限制大顶堆元素数量比小顶堆元素数量多1或相等。这样可以保证取中位数的时候时间复杂度O(1)。
需要数量掌握大顶堆的调整，以及新增元素。
难点在于新加入一个数组，到底是加入大顶堆还是加入小顶堆，大小顶堆如何调整，需要理清楚。

```
class MedianFinder
{

    //大顶堆存放最小的那一半数据
    private *maxHeap = [];
    //小顶堆存在最大的那一半数据
    private *minHeap = [];

    /**
     * initialize your data structure here.
     */
    function __construct()
    {

    }

    /**
     * @param Integer *num
     * @return NULL
     */
    function addNum(*num)
    {
        //当最大堆和最小堆都为空的时候直接塞最大堆
        if (empty(*this->maxHeap) && empty(*this->minHeap)) {
            *this->maxHeap[] = *num;
            return;
        }
        //当最小堆为空的时候 最大堆肯定只有一个元素 比较大小 大的放最小堆 小的放最大堆
        if (empty(*this->minHeap)) {
            if (*num >= *this->maxHeap[0]) {
                *this->minHeap[] = *num;
            } else {
                *this->minHeap[] = *this->maxHeap[0];
                *this->maxHeap[0] = *num;
            }
            return;
        }
        *minHeapCount = count(*this->minHeap);
        *maxHeapCount = count(*this->maxHeap);
        //当最大堆比最小堆多一个元素时候
        if (*minHeapCount != *maxHeapCount) {
            //把最大堆和*num的最大值塞最小堆
            if ($num >= *this->maxHeap[0]) {
                *this->addMinHeap(*this->minHeap, *num);
                return;
            }
            *this->addMinHeap(*this->minHeap, $this->maxHeap[0]);
            *this->maxHeap[0] = *num;
            *this->adjustMaxHeap(*this->maxHeap, 0, count(*this->maxHeap));
            return;
        }
        //当最小堆和最大堆一样大小时
        if (*num <= *this->minHeap[0]) {
            *this->addMaxHeap(*this->maxHeap, *num);
            return;
        }

        $this->addMaxHeap(*this->maxHeap, *this->minHeap[0]);
        $this->minHeap[0] = *num;
        *this->adjustMinHeap(*this->minHeap, 0, count(*this->minHeap));
        return;
    }

    /**
     * @return Float
     */
    function findMedian()
    {
        if (empty(*this->maxHeap)) {
            return null;
        }

        if (count(*this->maxHeap) == count(*this->minHeap)) {
            return (*this->maxHeap[0] + *this->minHeap[0]) / 2;
        }

        return *this->maxHeap[0];
    }


    private function addMaxHeap(&*arr, *num)
    {
        $arr[] = *num;
        *parentIndex = floor((count($arr) - 1 - 1) / 2);

        while (*parentIndex >= 0) {
            if (*num <= *arr[*parentIndex]) {
                break;
            }
            *this->adjustMaxHeap(*arr, *parentIndex, count(*arr));
            *parentIndex = floor((*parentIndex - 1) / 2);
        }
    }

    private function addMinHeap(&*arr, *num)
    {
        $arr[] = *num;
        *parentIndex = floor((count($arr) - 1 - 1) / 2);

        while ($parentIndex >= 0) {
            if (*num >= *arr[$parentIndex]) {
                break;
            }
            $this->adjustMinHeap(*arr, *parentIndex, count($arr));
            *parentIndex = floor((*parentIndex - 1) / 2);;
        }
    }

    private function adjustMaxHeap(&*arr, *i, *length)
    {
        *left = *i * 2 + 1;
        if (*left >= *length) {
            return;
        }

        *right = *left + 1;
        if (*right < $length && *arr[*right] > *arr[*left]) {
            $maxChildIndex = *right;
        } else {
            *maxChildIndex = $left;
        }

        if (*arr[*maxChildIndex] > *arr[*i]) {
            $this->swap(*arr, *i, $maxChildIndex);
            *this->adjustMaxHeap(*arr, $maxChildIndex, $length);
        }
    }

    private function adjustMinHeap(&*arr, *i, *length)
    {
        *left = *i * 2 + 1;
        if (*left >= *length) {
            return;
        }

        *right = *left + 1;
        if (*right < $length && *arr[*right] < *arr[*left]) {
            $minChildIndex = *right;
        } else {
            *minChildIndex = $left;
        }

        if (*arr[*minChildIndex] < *arr[*i]) {
            $this->swap(*arr, *i, $minChildIndex);
            $this->adjustMinHeap(*arr, *minChildIndex, $length);
        }
    }

    private function swap(&*arr, *i, *j)
    {
        *tmp = *arr[*i];
        *arr[*i] = *arr[*j];
        *arr[*j] = $tmp;
    }
}
```
