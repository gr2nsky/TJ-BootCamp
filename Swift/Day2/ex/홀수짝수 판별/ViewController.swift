//
//  ViewController.swift
//  Quiz02
//
//  Created by Kenny on 2021/07/14.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var tfNum: UITextField!
    @IBOutlet weak var laMsg: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
    }

    @IBAction func btnRun(_ sender: UIButton) {
        let inputedVal = tfNum.text
        
        let checkedOptionalNum = checkInvalidVal(inputedVal)
        if checkedOptionalNum == 0 {
            laMsg.text = "올바른 값을 입력해 주세요"
            return
        }
        
        let checkedEvenAndOddStr = checkEvenAndOdd(checkedOptionalNum)
        
        laMsg.text = "입력하신 숫자는 \(checkedEvenAndOddStr)입니다."
        
        self.view.endEditing(true)
    }
    
    //홀짝 판별
    func checkEvenAndOdd(_ num: Int) -> String{
        if num % 2 == 0 {
            return "짝수"
        } else {
            return "홀수"
        }
    }
    
    //입력값 검증 0값 검증까지 해결
    func checkInvalidVal(_ inputedVal: String?) -> Int{
        guard let inputedNum = inputedVal else {
            return 0
        }
        
        
        if inputedNum.isEmpty == true{
            return 0
        }
        
        guard let parsedinputedNum = Int(inputedNum) else {
            return 0
        }
        
        return parsedinputedNum
    }
    
    // 공백제거 nill check : 강사님이 해줬는데 사용은 안함
    func checkNil(str: String!) -> Int{
        let check = str.trimmingCharacters(in: .whitespacesAndNewlines)
        if check.isEmpty {
            return 0
        } else {
            return 1
        }
    }
    
    //빈공간 터치시 키보드 Off
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        self.view.endEditing(true)
    }
} // ViewController

