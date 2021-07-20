//
//  ViewController.swift
//  Quiz02
//
//  Created by Kenny on 2021/07/14.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var tfInput: UITextField!
    @IBOutlet weak var tvResult: UITextView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        tvResult.isEditable = false //readOnly
    }
    
    @IBAction func btnAppand(_ sender: UIButton) {
        //아직 착한사용자용
        //1. nil인지? 2.입력값이 공백만 있는지 3.정수로 변환이 가능한지
        guard let strInput = tfInput.text?.trimmingCharacters(in: .whitespacesAndNewlines) else {
            tvResult.text = "올바른 값을 입력해 주세요"
            return
        }
        
        guard let _ = Int(strInput) else {
            return tvResult.text = "올바른 값을 입력해 주세요"
        }
        
        let inputedNum: Int! = Int(strInput)
        for i in 1...9{
            tvResult.text += "\(i) * \(inputedNum!) = \(i * inputedNum) \n"
        }
    }
} // ViewController

