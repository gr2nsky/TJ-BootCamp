//
//  ViewController.swift
//  Quiz02
//
//  Created by Kenny on 2021/07/14.
//

import UIKit

class switchViewController: UIViewController {
    
    @IBOutlet weak var imgView: UIImageView!
    @IBOutlet weak var btnResize: UIButton!
    
    //이미지 사진
    var imgOn: UIImage?
    var imgOff: UIImage?
    
    //확대 여부
    var isZoom = false
    //불이 꺼졌는지 켜졌는지
    var isOn = false
    
    override func viewDidLoad() {
        super.viewDidLoad()
        //이미지 할당
        imgOn = UIImage(named: "light_on.png")
        imgOff = UIImage(named: "light_off.png")
        //이미지 적용
        imgView.image = imgOff
    }
    
    @IBAction func btnResizeImg(_ sender: UIButton) {
        let scale: CGFloat = 2.0
        var newHeight: CGFloat
        var newWidth: CGFloat
        if isZoom {
            newWidth = imgView.frame.width * scale
            newHeight = imgView.frame.height * scale
            btnResize.setTitle("이미지 축소", for: .normal)
            isZoom = false
        }else {
            newWidth = imgView.frame.width / scale
            newHeight = imgView.frame.height / scale
            btnResize.setTitle("이미지 확대", for: .normal)
            isZoom = true
        }
        imgView.frame.size = CGSize(width: newWidth, height: newHeight)
    }
    @IBAction func switchImageOnOff(_ sender: UISwitch) {
        if sender.isOn{
            imgView.image = imgOff
            isOn = false
        } else {
            imgView.image = imgOn
            isOn = true
        }
    }
    
} // ViewController

