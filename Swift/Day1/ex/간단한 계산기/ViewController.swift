//
//  ViewController.swift
//  iosTemp
//
//  Created by 윤재필 on 2021/07/14.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var tfNum1: UITextField!
    @IBOutlet weak var tfNum2: UITextField!
    
    @IBOutlet weak var tfSumReuslt: UITextField!
    @IBOutlet weak var tfSubReuslt: UITextField!
    @IBOutlet weak var tfMulReuslt: UITextField!
    @IBOutlet weak var tfDivReuslt: UITextField!
    @IBOutlet weak var tfDivReuslt1: UITextField!
    @IBOutlet weak var tfDivReuslt2: UITextField!
    
    @IBOutlet weak var laHelp: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        laHelp.text = "숫자를 입력하고 계산하기를 눌러주세요."
    }
    
    @IBAction func btnCalc(_ sender: UIButton) {
        if nilChecker() == false {
            laHelp.text = "숫자를 확인해 주세요!"
            return
        }
        
        let num1: Int! = Int(tfNum1.text!)
        let num2: Int! = Int(tfNum2.text!)
        
        tfSumReuslt.text = String(num1 + num2)
        tfSubReuslt.text = String(num1 - num2)
        tfMulReuslt.text = String(num1 * num2)

        tfDivReuslt.text = String(round((Double(num1) / Double(num2))*100)/100)
        tfDivReuslt1.text = String(num1 / num2)
        tfDivReuslt2.text = String(num1 % num2)
        
    }
    
    func nilChecker() -> Bool{
        
        if tfNum1.text?.isEmpty == true {
            return false
        }
        
        if tfNum2.text?.isEmpty == true {
            return false
        }
        
        return true
    }
    
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        self.view.endEditing(true)
    }

}

