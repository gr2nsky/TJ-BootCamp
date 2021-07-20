//
//  ViewController.swift
//  Quiz02
//
//  Created by Kenny on 2021/07/14.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var tfScore: UITextField!
    @IBOutlet weak var lblTitle: UILabel!
    @IBOutlet weak var lblMsg: UILabel!
    
    var stepNum: Int = 0
    var scores: Array<Int> = Array(repeating: 0, count: 3)
    var subject = ["국어", "영어", "수학"]
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
    }
    
    @IBAction func btnNext(_ sender: Any) {
        switch stepNum {
        case 0...1:
            stepNum += inputedScore()
        case 2:
            stepNum += inputedScore()
            if stepNum == 3 {
                lblTitle.text = "요약"
                lblMsg.text = returnScoreMsg()
                stepNum += 1
                tfScore.isHidden = true
            }
        default:
            stepNum = 0
            tfScore.isHidden = false
            lblMsg.text = ""
        }
        
        if (stepNum <= 2){
            lblTitle.text = "\(subject[stepNum]) 점수"
        }
        tfScore.text?.removeAll()
    }
    
    func returnScoreMsg() -> String{
        let scoreSum: Int = scores.reduce(0) {$0 + $1}
        let scoreAvg = Double(scoreSum) / Double(scores.count)
        
        return """
            총점은 \(scoreSum)입니다.
            평균은 \( round(scoreAvg * 100) / 100 )입니다.
            국어 점수는 으로 평균\(returnHigerLower(scores[0], scoreAvg))
            영어 점수는 으로 평균\(returnHigerLower(scores[1], scoreAvg))
            수학 점수는 으로 평균\(returnHigerLower(scores[2], scoreAvg))
            """
    }
    
    func returnHigerLower(_ score: Int, _ avg: Double) -> String{
        return Double(score) > avg ? "보다 높습니다." : Double(score) == avg ?
            "과 같습니다." : "보다 낮습니다."
    }
    
    func inputedScore() -> Int{
        let inputedStr: String? = tfScore.text
            
        if inValidInputChecker(inputedStr) == true {
            scores[stepNum] = Int(inputedStr!)!
            return 1
        }
        lblMsg.text = "올바른 값을 입력해주세요."
        return 0
    }
    
    func inValidInputChecker(_ inputedStr: String?) -> Bool{
        if let str = inputedStr {
            return numCheck(str)
        }
        return false
    }
    
    func numCheck(_ inputedStr: String) -> Bool{
        if let str = Int(inputedStr) {
            return true
        } else {
            return false
        }
    }
    
    
    
} // ViewController

