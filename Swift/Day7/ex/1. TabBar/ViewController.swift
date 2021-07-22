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
    
    @IBAction func btnGoButtonImage(_ sender: Any) {
        tabBarController?.selectedIndex = 1
    }
    @IBAction func btnGoThreeSecond(_ sender: Any) {
        tabBarController?.selectedIndex = 2
    }
    
    @IBAction func btnGoPageControl(_ sender: Any) {
        tabBarController?.selectedIndex = 3
    }
}

