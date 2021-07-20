//
//  main.swift
//  Day04
//
//  Created by hyogang on 2021/07/19.
//
import Foundation
// 함수
func interSum(a: Int, b:Int) -> Int{
    return a + b
}
//var abSum = interSum(a: 5, b: 8)
//print(abSum)
print(interSum(a: 5, b: 8))
func greet(person: String) -> String{
    let greeting = "Hello, \(person)!"
    return greeting
}
print(greet(person: "Mac"))
func sayHelloWorld() -> String{
    return "Hello, world!"
}
print(sayHelloWorld())
func buildAddress(_ name: String, address: String, city: String, 우편번호 zipCode: String, country: String? = "USA") -> String{
    return """
        \(name)
        \(address)
        \(city)
        \(zipCode)
        \(country ?? "")
        """
}
print(buildAddress("유비", address: "중국", city: "상하이", 우편번호: "123", country: "China"))
print(buildAddress("장비", address: "중국", city: "북경", 우편번호: "234")) // default인 "USA" 출력
print(buildAddress("관우", address: "중국", city: "상하이", 우편번호: "345", country: nil)) // nil일시 아무것도 안나옴
// 가변 매개변수
func sayHelloFriends(me: String, friend: String...) -> String{
    return "Hello \(friend)! I'm \(me)."
}
print(sayHelloFriends(me: "초선", friend: "손견", "손책", "장양"))
// 복수의 갑을 반환하는 함수
func getCountry() -> (dialCode : Int, isoCode: String, name: String) {
    let returnCountry = (dialCode: 82, isoCode: "KR", name: "Korea")
    return returnCountry
}

let ret = getCountry()
print(ret)
print(ret.dialCode)

//시작숫자부터 끝 숫자까지의 합계를 수하는 함수
// 1) for문
func sumStartToEndFor(from startNum: Int, to endNum: Int) -> Int{
    var sum = 0
    for i in startNum...endNum{
        sum += i
    }
    return sum
}

// 2) while문
func sumStartToEndWhile(from startNum: Int, to endNum: Int) -> Int{
    var sum = 0
    var startNum = startNum
    while startNum <= endNum{
        sum += startNum
        startNum += 1
    }
    return sum
}

print("for문 : \(sumStartToEndFor(from: 1, to: 10))")
print("while문 : \(sumStartToEndWhile(from: 1, to: 10))")

//Overloading

//삼각형
func shape(_ r: Double){
    let pi = 3.14
    let area = pi * r * r
    let border = 2 * pi * r
    print("원 : \(area), \(border)")
}

//직사각형
func shape(_ w: Int, _ h: Int){
    let area = w * h
    let border = (w + h) * 2
    print("직사각형 : \(area), \(border)")
}

//직삼각형
func shape(_ w: Int, _ h: Int, _ hypotenuse: Int){
    let area = (w * h) / 2
    let border = w + h + hypotenuse
    print("직각삼격형 : \(area), \(border)")
}

shape(5)
shape(5, 6)
shape(5, 6, 7)


/*
 Class : 전통적인 OOP관점에서의 클래스
 - 단일 상속
 - property
 - constructor
 - method
 - 참조 타입 선언
 
 Struct
 - 상속 불가
 - property
 - constructor
 - method
 - 값 타입 선언 (Call by value)
 */

struct ValueType {
    var property = 1
}
class ReferenceType {
    var property = 1
}

let firstStructInstance: ValueType = ValueType()
var secondStructInstance: ValueType = firstStructInstance
secondStructInstance.property = 2

print("first : \(firstStructInstance.property)" )
print("second : \(secondStructInstance.property)" )

let firstClassInstance: ReferenceType = ReferenceType();
var secondClassInstance = firstClassInstance
secondClassInstance.property = 2

print("first : \(firstClassInstance.property)" )
print("second : \(secondClassInstance.property)" )

