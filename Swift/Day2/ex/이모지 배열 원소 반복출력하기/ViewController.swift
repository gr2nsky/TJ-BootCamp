//
//  ViewController.swift
//  Quiz02
//
//  Created by Kenny on 2021/07/14.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var lblEmoji: UILabel!
    
    var arrEmoji = ["😀", "😃", "😁", "😂", "🙃", "😂"]
    var count: Int = 0
    
    override func viewDidLoad() {
        super.viewDidLoad()
        lblEmoji.text = arrEmoji[0]
    }
    
    @IBAction func btnPlay(_ sender: Any) {
        if count == 5 {
            count = 1
        }
        lblEmoji.text = arrEmoji[count]
        count += 1
    }
    @IBAction func btnPrev(_ sender: UIButton) {
        if count == -1 {
            count = 5
        }
        lblEmoji.text = arrEmoji[count]
        count -= 1
    }
    
} // ViewController

