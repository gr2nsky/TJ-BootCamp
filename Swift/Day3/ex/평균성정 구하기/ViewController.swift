//
//  ViewController.swift
//  Quiz02
//
//  Created by Kenny on 2021/07/14.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var tfKoreanScore: UITextField!
    @IBOutlet weak var tfMathScore: UITextField!
    @IBOutlet weak var tfEnglishScore: UITextField!
    @IBOutlet weak var lblMsg: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
    }
    
    @IBAction func btnCalc(_ sender: Any) {
        let inputedStrs: [String?] = [tfKoreanScore.text, tfMathScore.text, tfEnglishScore.text]
        if checkNill(inputedStrs) == false {
            lblMsg.text = "올바른 값을 입력해 주세요."
        }
        
        var inputednums: [Int] = []
        for i in inputedStrs{
            let inputedNum = Int(i!)
            inputednums.append(inputedNum!)
        }
        
        let avg = calcAvg(inputednums)
        lblMsg.text = "평균점수는 \(inputednums)입니다."
    }
    
    func checkNill(_ inputedStrs: [String?]) -> Bool{
        var trueConter = 0
        for i in inputedStrs {
            if let inputedStr = i {
                if checkNum(inputedStr){
                    trueConter += 1
                }
            }
        }
        
        if trueConter == inputedStrs.count {
            return true
        }
        return false
    }
    
    func checkNum(_ inputedStr: String) -> Bool{
        if let isNum = Int(inputedStr) {
            return true
        } else {
            return false
        }
    }
    
    func calcAvg(_ inputedNums: [Int]) -> Int{
        return (inputedNums.count / inputedNums.reduce(0) { $0 + $1 })
    }

} // ViewController

