/* Question :(week 2) 
you are given an array which includes product of subset of array any array 'S' of length l,
Find element of an array S
of length L.
l=3, a [] = {10,10,5,0,2,1,2,5}
a [] = {2,1,5} will be able to output provided subset product.
Explanation:
[] product [0]
[1] product [1]
[2] product [2]
[5] product [5]
[1,2] product [2]
[1,5] product [5]
[2,5] product [10]
[1,2,5] product [10] */

// Solution:
class week2{

int realArrLen;
    int[] a;

    week2(int realArrLen, int[] a) {

        this.realArrLen = realArrLen;
        // like this.a = a;
        int len = 0;
        int[] passer = new int[a.length];
        // At first all unique elements are separated
        // similar repeated numbers are removed
        // Comparing elements
        // if they are same or not,
        // Push if they are not same
        // remaining elements

        for (int i = 0; i < a.length; i++) {
            boolean push = false;
            for (int j = 0; j < a.length; j++) {
                if (i >= j) {
                    if (i == a.length - 1) {
                        push = true;
                        break;
                    }
                    continue;
                }

                if (a[i] == a[j]) {
                    push = false;
                    break;
                } else if (a[i] != a[j]) {
                    push = true;
                }
            }
            if (push) {
                passer[len] = a[i];
                push = false;
                len++;
            }
        }
        // Creating array with length of unique elements that are counted from above

        int[] originalPasser = new int[len];

        for (int i = 0; i < len; i++) {
            originalPasser[i] = passer[i];
            // System.out.println(passer[i]);
        }
        // Substituting to the global variable


        this.a = originalPasser;

    }

    void resultFinder() {

        // Compilation of whole required functions

        int[][] outputValues = findPrime(a);
        // 0 index contains primenumbers including 1 if exists

        int[] primeValues = outputValues[0];
        // index 0 of 1 contains the number of unique elements found

        int primeItterator = outputValues[1][0];
         // System.out.println(primeItterator);
        // Checking if the required number is already satisfied
        // or not, if yes, print the whole subset elements

        // System.out.println(primeItterator);
        if (primeItterator == realArrLen) {

            for (int i = 0; i < primeItterator; i++) {
                System.out.println(primeValues[i]);
            }
        } else {

            int[] extra = extrasSearch(primeValues, primeItterator);
            // System.out.println(extra[0]);
            for (int i = 0; i < realArrLen; i++) {
                if (i >= primeItterator) {
                    int num = i - primeItterator;
                    System.out.println(extra[num]);
                } else {
                    System.out.println(primeValues[i]);
                }

            }
        }

    }

    int[] extrasSearch(int[] primes, int primeItterator) {

        int[] extras = new int[realArrLen];
        int extrasin = 0;
        boolean skip = false;
        for (int i = 0; i < a.length; i++) {
            for (int ext = 0; ext < primes.length; ext++) {
                if (a[i] == primes[ext]) {
                    skip = true;
                    break;
                }
            }
            if (skip) {
                skip = false;
                continue;
            }

            boolean push = true;

            for (int j = 0; j < primeItterator; j++) {

                if (primes[j] == 1) {
                    continue;
                } else {
                    // System.out.println(a[i]);
                    float checkval = (float) a[i] / (float) primes[j];
                    if (checkval == Math.floorDiv(a[i], primes[j])) {
                        push = false;
                    }
                }
            }

            if (push) {
                extras[extrasin] = a[i];
                extrasin++;
            }

        }

        return extras;

    }

    int[][] findPrime(int[] arr) {
        // Findout Prime numbers among element of given array arr

        int[] ourPrimeElements = new int[realArrLen];
        int primeItterator = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == 0) {
                continue;
            } else if (arr[i] == 1) {
                ourPrimeElements[primeItterator] = 1;
                primeItterator++;

            } else if (arr[i] == 2) {
                ourPrimeElements[primeItterator] = 2;
                primeItterator++;
            } else if (arr[i] == 3) {
                ourPrimeElements[primeItterator] = 3;
                primeItterator++;
            }

            else {

                boolean prime = true;
                // int element = Math.floorDiv(arr[i], 2);
                int divideLimit = Math.floorDiv(arr[i], 2);
                for (int j = 2; j <= divideLimit; j++) {

                    float check = (float) a[i] / j;
                    // System.out.println(a[i]);
                    // System.out.println(j);
                    // System.out.println(check);

                    if (check == Math.floorDiv(a[i], j)) {

                        prime = false;

                    }
                }

                if (prime == true) {

                    ourPrimeElements[primeItterator] = a[i];
                    primeItterator++;
                }

            }

        }

        int[][] returner = { ourPrimeElements, { primeItterator } };

        return returner;

    }

    public static void main(String[] args) {

        int[] input = { 10, 10, 5, 0, 2, 1, 2, 5 };

        Week2 sub = new Week2(3, input);
        sub.resultFinder();
    }

}

