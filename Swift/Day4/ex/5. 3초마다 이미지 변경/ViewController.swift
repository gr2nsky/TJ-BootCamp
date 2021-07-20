//
//  ViewController.swift
//  Quiz02
//
//  Created by Kenny on 2021/07/14.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var lblFileName: UILabel!
    @IBOutlet weak var imageView: UIImageView!
    
    var image1: UIImage? = UIImage(named: "light_off.png")
    var image2: UIImage? = UIImage(named: "light_on.png")
    //3초마다 실행되도록 설정
    let interval = 3.0 // 1 sec
    let timeSelector : Selector = #selector(ViewController.updateTime)
    
    var currentTime : String = ""
    var changeTime : String = ""
    var count : Int = 0
    
    override func viewDidLoad() {
        super.viewDidLoad()
        imageView.image = image1
        lblFileName.text = "light_off.png"
        
        Timer.scheduledTimer(timeInterval: interval, target: self, selector: timeSelector, userInfo: nil, repeats: true)
    }
    
    @objc func updateTime(){
        if count == 1{
            count = 0
            imageView.image = image1
            lblFileName.text = "light_off.png"
        } else {
            count = 1
            imageView.image = image2
            lblFileName.text = "light_on.png"
        }
    }
    
} // ViewController

