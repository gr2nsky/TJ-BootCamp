//
//  ViewController.swift
//  Quiz02
//
//  Created by Kenny on 2021/07/14.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var imageView: UIImageView!
    
    let imgOn = UIImage(named: "light_on")
    let imgOff = UIImage(named: "light_off")
    @IBOutlet weak var lblResize: UILabel!
    @IBOutlet weak var lblOnOff: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        imageView.image = imgOff
    }
    
    @IBAction func switchImageResize(_ sender: UISwitch) {
        let scale: CGFloat = 2.0
        var newHeight: CGFloat
        var newWidth: CGFloat
        
        switch sender.isOn {
        case true:
            newWidth = imageView.frame.width * scale
            newHeight = imageView.frame.height * scale
            lblResize.text = "이미지 확대"
        default:
            newWidth = imageView.frame.width / scale
            newHeight = imageView.frame.height / scale
            lblResize.text = "이미지 축소"
        }
        imageView.frame.size = CGSize(width: newWidth, height: newHeight)
    }
    @IBAction func switchImageOnOff(_ sender: UISwitch) {
        switch sender.isOn {
        case true:
            imageView.image = imgOn
            lblOnOff.text = "전구 끄기"
        default:
            imageView.image = imgOff
            lblOnOff.text = "전구 켜기"
        }
    }
    
} // ViewController

