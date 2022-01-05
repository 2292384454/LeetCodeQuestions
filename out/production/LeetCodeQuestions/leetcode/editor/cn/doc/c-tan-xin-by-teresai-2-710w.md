```c
bool canJump(int* nums, int numsSize){
    int x = 0;
    for (int r = 0; x < numsSize && x <= r; ++x) 
        r = fmax(r, x + nums[x]);
    return x >= numsSize;
}
```