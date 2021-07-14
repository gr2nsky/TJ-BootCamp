//
//  ViewController.swift
//  iosTemp
//
//  Created by 윤재필 on 2021/07/14.
//

import UIKit

class ViewController: UIViewController {

 
    @IBOutlet weak var tfName: UITextField!
    @IBOutlet weak var laMain: UILabel!
    @IBOutlet weak var laHelp: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        laHelp.text = "환영합니다."
    }

 
    @IBAction func btnSend(_ sender: UIButton) {
        let standardTitle = "Welcome!"
        
        //문자열이 비었는지 확인하는 법
        //count, isEmpty

        if tfName.text?.isEmpty == true{
            laMain.text = standardTitle
            laHelp.text = "이름을 입력해야 합니다."
        } else {
            laMain.text = standardTitle + " " + tfName.text!
            laHelp.text = "변경이 완료되었습니다."
        }
    }
    
    @IBAction func btnClear(_ sender: UIButton) {
        let standardTitle = "Welcome!"
        tfName.text?.removeAll()
        laMain.text = standardTitle
        laHelp.text = "화면 초기상태 입니다."
    }
}

