//
//  ViewController.swift
//
//  Created by Kenny on 2021/07/21.
//

import UIKit
import WebKit

class ViewController: UIViewController {
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    @IBAction func btnGoSwitch(_ sender: Any) {
        tabBarController?.selectedIndex = 1
    }
    
    @IBAction func btnGoDatepicker(_ sender: Any) {
        tabBarController?.selectedIndex = 2
    }
}

