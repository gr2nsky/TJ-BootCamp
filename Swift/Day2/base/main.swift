//
//  main.swift
//  Day012
//
//  Created by hyogang on 2021/07/15.
//


//비교 연산자
print(1 == 1)
//Tupled 비교연산 : 첫번째에서 판별나면 두번째는 연산 x
print( (1, "zebra") < (2, "apple"))
print( (3, "apple") < (3, "bird"))

//삼항조건연산자
let contentHeight = 40
let hasHeader = true

let rowHeight = contentHeight + (hasHeader ? 50 : 20)
print(rowHeight)

//Optional

var constantNum: Int? = 100
constantNum = nil

var constantNum2: Int! = 100
print(constantNum2!)
print(constantNum2 + 10)

var myName: String? = nil
print(myName as Any)

//Optional binding
if let name: String = myName{
    print(name)
} else {
    print("my name is nil")
}

var myName2: String? = "James"
var yourNmae2: String? = nil

// ,  = and = &
if let name = myName2, let friend = yourNmae2{
    print("\(name) and \(friend)")
}

//Force Unfrapping
print(myName2) // Optional("James")
print(myName2!) // james

//Collection : Array, Dictionary, set, map ...
//var intVariable: Array<Int> = Array<Int>()
//var intVariable: [Int] = [Int]()
var intVariable: [Int] = []
intVariable.append(1)
intVariable.append(10)
intVariable.append(100)
intVariable.append(1000)

print(intVariable)
print(intVariable.contains(100))
print(intVariable.contains(90))

print(intVariable[0])
print(intVariable[0...2])
intVariable.remove(at: 0)
intVariable.removeLast()
intVariable.removeAll()
print(intVariable)

//빈배열로 초기화
intVariable = []

//기본값으로 배열 생성
var threeDouble = Array(repeating: 0.0, count: 3)
print(threeDouble)

var anotherDouble = Array(repeating: 2.5, count: 3)
var sixDouble = threeDouble + anotherDouble
print(sixDouble) //[0.0, 0.0, 0.0, 2.5, 2.5, 2.5]

let intVariable2 = [1,2,3]
print(type(of: intVariable2)) // Array<Int>

var shoppingList = ["egg", "milk"]
print(shoppingList.count)

if shoppingList.isEmpty {

}
shoppingList += ["baking powder"]
shoppingList += ["choco", "coffe"]
print(shoppingList) // ["egg", "milk", "baking powder", "choco", "coffe"]

//배열의 특정 위치데이터 변경 및 제거
shoppingList[0...3] = ["Banana"] //만약 1개가아닝 10개를 넣어도 다 들어감
print(shoppingList) // ["Banana", "coffe"]

shoppingList.insert("apple", at: 0)
print(shoppingList)

//배열의 값과 인덱스가 필요한 경구
for (index, value) in shoppingList.enumerated(){
    print("Item \(index) : \(value)")
}
print(shoppingList.enumerated())

print(sixDouble)
var tot = 0.0
for i in sixDouble {
    tot += i
}
print(tot)



//최대값 찾기
print(sixDouble.min()!)


















