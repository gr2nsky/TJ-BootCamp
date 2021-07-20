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
        //1. nil인지? 2.입력값이 공백만있는게 아니닞?
        let strInput = tfInput.text!.trimmingCharacters(in: .whitespacesAndNewlines)
        
        if !strInput.isEmpty{
            tvResult.text += tfInput.text! + "\n"
        }
    }
} // ViewController

