//
//  ViewController.swift
//  Quiz02
//
//  Created by Kenny on 2021/07/14.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var tfNum1: UITextField!
    @IBOutlet weak var tfNum2: UITextField!
    @IBOutlet weak var tfResult: UITextField!
    @IBOutlet weak var lblMsg: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        lblMsg.text = "짝수를 입력해 덧셈실행버튼을 눌러주세요."
    }

    @IBAction func btnCalc(_ sender: UIButton) {
        let inputedNum1: String? = tfNum1.text
        let inputedNum2: String? = tfNum2.text
        if invaildInputChecker(inputedNum1, inputedNum2) == false{
            lblMsg.text = "유효하지 않은 입력입니다. 짝수만 입력하세요"
            return
        }
        
        let num1 = Int(inputedNum1!)
        let num2 = Int(inputedNum2!)
        tfResult.text = calc( num1, num2 )
        lblMsg.text = "계산완료"
    }
    
    func invaildInputChecker(_ num1: String?, _ num2: String?) -> Bool{
        return CheckNil(num1, num2)
    }
    
    func CheckNil(_ num1: String?, _ num2: String?) -> Bool{
        if let n1 = num1, let n2 = num2 {
            return CheckNum(n1, n2)
        }
        return false
    }
    
    func CheckNum(_ num1: String, _ num2: String) -> Bool{
        if let n1 = Int(num1), let n2 = Int(num2){
            return checkEven(n1, n2)
        }
        return false
    }
    
    func checkEven(_ num1: Int, _ num2: Int) -> Bool{
        if(num1 % 2 == 0 && num2 % 2 == 0){
            return true
        }
        return false
    }
    
    func calc(_ num1: Int!, _ num2: Int!) -> String{
        return String(num1 + num2)
    }
    
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        self.view.endEditing(true)
    }
    
} // ViewController

