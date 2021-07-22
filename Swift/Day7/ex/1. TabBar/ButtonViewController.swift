//
//  ViewController.swift
//  Quiz02
//
//  Created by Kenny on 2021/07/14.
//

import UIKit

class ButtonViewController: UIViewController {

    @IBOutlet weak var lblTitle: UILabel!
    @IBOutlet weak var ivFlower: UIImageView!
    
    var numImage = 0
    var imageName = ["flower_01.png", "flower_02.png", "flower_03.png", "flower_04.png", "flower_05.png", "flower_06.png"]
    
    override func viewDidLoad() {
        super.viewDidLoad()
        lblTitle.text = imageName[numImage]
        ivFlower.image = UIImage(named: imageName[numImage])
    }

    @IBAction func btnNext(_ sender: Any) {
        numImage += 1
        if numImage >= imageName.count {
            numImage = 0
        }
        setImage()
    }
    @IBAction func btnBefore(_ sender: Any) {
        numImage -= 1
        if numImage <= -1 {
            numImage = imageName.count - 1
        }
        setImage()
    }
    
    func setImage(){
        lblTitle.text = imageName[numImage]
        ivFlower.image = UIImage(named: imageName[numImage])
    }
    
} // ViewController

