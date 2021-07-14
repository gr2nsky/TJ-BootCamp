//
//  main.swift
//  Day01
//
//  Created by hyogang on 2021/07/14.
//

import Foundation

// commnet
/*
 -------
 화면 출력
 -------
 */
// 문자 출력
print("안녕하세요")

// 숫자 출력
print(12345)

// 계산 출력
print(123 + 456)

/*
 상수와 변수의 작명규칙
 - Camel Case : function, method, variable, constant
 ex) studentName, studentAge ...
 
 - Pascal Case : class, struct, enum, extension, ...
 ex) Student, Product
 
 - Snake Cas : underbar로 연결하여 사용
 
 - 대소문자 구분
 - 첫글자를 숫자나 특수문자로 시작하면 안되나, underbar로 시작 가능(특수용도)
 
 */

// 상수 : 한번 선언된 값에 대해 변경이 불가능
/*
 let <variable name> : <type> = <value>
 */

var intLetNum1: Int = 200
let intLetNum2 = 100
let intLetNum3: Int

intLetNum3 = 200
intLetNum1 = 2000

let sum: Int
sum = intLetNum1 + intLetNum2
// sum = intLetNum2 + intLetNum3

var nickName : String
nickName = "유비"

var aNum = 9, bNum = 10

/*
 문자열 보간법(String Interpolation)
 */

let studentName = "홍길동"

//출력방법

print("name: " + studentName)
print("name : ", studentName)
print("name : \(studentName)")

let age: Int = 0
print("저는 \(age)살 입니다.")
print("저의 형은 \(age + 4)살 입니다.")

var name1 = "유비"
var age1 = 34
var gendar1 = "남자"

//회원의 일므은 유비이고 나이는 34살이며 성별은 남자입니다.
print("회원의 이름은 \(name1)이고 나이는 \(age1)살이며 성별은 \(gendar1)입니다.")


// <<<<<<<<<<<Data type>>>>>>>>>>>>>>>..

var someBool: Bool = true

var someInt: Int = -100
someInt = 100_000

var someFloat: Float = 3.134

var someDouble: Double = 3.12

//숫자 type 변환
let doubleNum = 4.99999
print(Int(doubleNum))
print(Int(doubleNum.rounded()))

//캐릭터
var someCharacter: Character = "a"
someCharacter = "🤭"
print(someCharacter)


let temp = "b"
print(type(of: temp))

var sumMultiString = """
    1234
    abcd
    가나다라
"""
print(sumMultiString)

//문자열과 특수문자
// \n \t \n \", \'

print("aa\tbb\ncc")
let wiseWords = "\"Imagination is more than the knowledge\" - Einstein"
print(wiseWords)

var name = "맥북프로"
var size = 15
var weight = 2.56
var bag = false
var color = "은"

print("이름: \(name)")
print("크기: \(size)")
print("무게: \(weight)")
print("가방: \(bag)")
print("색상: \(color)")

//문자열 수정

var variableString = "Horse"
variableString += "and carriage"
print(variableString)

var string1 = "hello"
var string2 = " there"
var welcome = string1 + string2
print(welcome)

string1.append(string2)
print(string1)

//문자 길이

let str = "12345,67890"
print("str \(str.count) charcters")

if str.count == 0{
    print("Data가 없습니다.")
} else {
    print("Data는 \(str)입니다.")
}


















