//
//  ViewController.swift
//  iosTemp
//
//  Created by 윤재필 on 2021/07/14.
//

import UIKit

class ViewController: UIViewController {
    @IBOutlet weak var tfMain: UILabel!
    var count = 1
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }

    @IBAction func btnTextChanger(_ sender: UIButton) {
        let str1 = "Welcome!"
        let str2 = "Welcome! 윤재필"
        count % 2 == 0 ? (tfMain.text = str1) : (tfMain.text = str2)
        count += 1
    }
    

}

