//
//  ViewController.swift
//
//  Created by 윤재필 on 2021/07/22.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var imageView: UIImageView!
    let imgOn = UIImage(named: "light_on")
    let imgOff = UIImage(named: "light_off")
    let imgRed = UIImage(named: "light_red")
    
    var isOn: Bool = false;
    var isRed: Bool = false;
    
    override func viewDidLoad() {
        super.viewDidLoad()
        imageView.image = imgOff
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        let editViewController = segue.destination as! lampEditViewController
        
        editViewController.isOn = isOn
        editViewController.isRed = isRed
        editViewController.delegate = self
    }
}

extension ViewController: lampDelegate{
    func didlampControl(_ controller: lampEditViewController, isOn: Bool, isRed: Bool) {
        self.isOn = isOn
        self.isRed = isRed
        
        switch isOn {
        case true:
            if isRed {
                imageView.image = imgRed
            } else {
                imageView.image = imgOn
            }
        case false:
            imageView.image = imgOff
        default:
            break
        }
    }
}
