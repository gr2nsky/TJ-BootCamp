//
//  ViewController.swift
//  day1_ex1_pront_my_name
//
//  Created by 윤재필 on 2021/07/14.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var tfMain: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }

    @IBAction func btnName(_ sender: UIButton) {
        var tfMainStr = tfMain.text
        tfMainStr?.append(" 윤재필")
        tfMain.text = tfMainStr
    }
    
}

