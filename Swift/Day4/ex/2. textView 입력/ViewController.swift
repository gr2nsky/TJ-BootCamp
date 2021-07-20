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
    }

    @IBAction func btnSend(_ sender: UIButton) {
        guard let _ = tvResult.text?.trimmingCharacters(in: .whitespacesAndNewlines) else {
            return
        }
        tvResult.text += tfInput.text! + "\n"
        tfInput.text?.removeAll()
    }
    
    @IBAction func btnEmoji(_ sender: UIButton) {
        tfInput.text! += "😀"
    }
    
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        self.view.endEditing(true)
    }
    
    
} // ViewController

