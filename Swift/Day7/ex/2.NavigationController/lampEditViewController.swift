//
//  lampEditViewController.swift
//  iosTemp
//
//  Created by 윤재필 on 2021/07/22.
//

import UIKit

class lampEditViewController: UIViewController {

    @IBOutlet weak var swImgOnOff: UISwitch!
    @IBOutlet weak var lblOnOff: UILabel!
    @IBOutlet weak var swImgRedYellow: UISwitch!
    
    var isOn: Bool = false;
    var isRed: Bool = false;
    
    var delegate: lampDelegate?
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        swImgOnOff.isOn = isOn
        if isOn {
            lblOnOff.text = "ON"
        } else {
            lblOnOff.text = "OFF"
        }
        swImgRedYellow.isOn = isRed
    }
    
    
    @IBAction func imgOnOff(_ sender: UISwitch) {
        if sender.isOn{
            lblOnOff.text = "ON"
            isOn = true
        } else {
            lblOnOff.text = "OFF"
            isOn = false
            swImgRedYellow.isOn = false
            isRed = false
        }
    }
    
    @IBAction func imgRedYellow(_ sender: UISwitch) {
        if !isOn {
            swImgRedYellow.isOn = false
            isRed = false
            return
        }
        
        if sender.isOn{
            isRed = true
        } else {
            isRed = false
        }
    }
    
    @IBAction func btnDone(_ sender: UIButton) {
        
        if delegate != nil {
            delegate?.didlampControl(self, isOn: isOn, isRed: isRed)
        }
        navigationController?.popViewController(animated: true)
    }
    
}
