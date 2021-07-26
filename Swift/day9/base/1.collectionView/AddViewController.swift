//
//  AddViewController.swift
//  IosLecture
//
//  Created by 윤재필 on 2021/07/26.
//

import UIKit

class AddViewController: UIViewController {

    @IBOutlet weak var tfHuman: UITextField!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
    }
    
    @IBAction func btnAppand(_ sender: Any) {
        list.append(tfHuman.text!)
        navigationController?.popViewController(animated: true)
    }
    
}
