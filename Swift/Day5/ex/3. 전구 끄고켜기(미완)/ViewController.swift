//
//  ViewController.swift
//  Quiz02
//
//  Created by Kenny on 2021/07/14.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var imageView: UIImageView!
    
    let imgOn = UIImage(named: "light_off.png")
    let imgOff = UIImage(named: "light_on.png")
    let imgRemove = UIImage(named: "lamp_remove.png")
    
    //lamp state
    var isLampOn = true
    
    override func viewDidLoad() {
        super.viewDidLoad()
        imageView.image = imgOn
    }
    
    @IBAction func btnLampOn(_ sender: UIButton) {
        if isLampOn {
            let lampOnAlert = UIAlertController(title: "경고", message: "현재 on 상태입니다.", preferredStyle: .alert)
            let onAction = UIAlertAction(title: "네, 알겠습니다.", style: .default, handler: nil)
            
            lampOnAlert.addAction(onAction)
            present(lampOnAlert, animated: true, completion: nil)
        } else {
            imageView.image = imgOn
            isLampOn = true
        }
    }
    
    @IBAction func btnLampOff(_ sender: UIButton) {
        var msg = ""
        
        if isLampOn {
            msg = "현재 on 상태입니다."
        } else {
            msg = "현재 off 상태입니다."
        }
        
        let lampOnAlert = UIAlertController(title: "경고", message: msg, preferredStyle: .alert)
        let onAction = UIAlertAction(title: "네, 알겠습니다.", style: .default, handler: {ACTION in
            self.imageView.image = self.imgOff
            self.isLampOn = false
        })
        lampOnAlert.addAction(onAction)
        present(lampOnAlert, animated: true, completion: nil)

        
    }
    
    @IBAction func btnLampRemove(_ sender: UIButton) {
        
    }
}
