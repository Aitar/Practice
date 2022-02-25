"""
https://leetcode-cn.com/problems/complex-number-multiplication/
"""

def complexNumberMultiply(num1: str, num2: str) -> str:
    r1, i1 = num1.split('+')
    r2, i2 = num2.split('+')
    i1 = i1[:-1]
    i2 = i2[:-1]

    r = int(r1) * int(r2) - int(i1) * int(i2)
    i = int(r1) * int(i2) + int(r2) * int(i1)

    return str(r) + '+' + str(i) + 'i'

print(complexNumberMultiply(num1 = "1+-1i", num2 = "1+-1i"))