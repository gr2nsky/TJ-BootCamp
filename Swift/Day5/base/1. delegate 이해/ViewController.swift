//
//  ViewController.swift
//  Quiz02
//
//  Created by Kenny on 2021/07/14.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var tfInput: UITextField!
    @IBOutlet weak var lblResut: UILabel!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        tfInput.delegate = self
    }
    
    @IBAction func btnAction(_ sender: UIButton) {
        lblResut.text = tfInput.text
    }
    
} // ViewController

extension ViewController: UITextFieldDelegate{
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        lblResut.text = tfInput.text
        return true
    }
}
