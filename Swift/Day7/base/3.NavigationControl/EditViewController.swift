//
//  EditViewController.swift
//  iosTemp
//
//  Created by 윤재필 on 2021/07/22.
//

import UIKit

class EditViewController: UIViewController {

    @IBOutlet weak var lblWay: UILabel!
    @IBOutlet weak var tfMessage: UITextField!
    @IBOutlet weak var lblOnOff: UILabel!
    @IBOutlet weak var swIsOn: UISwitch!
    
    var textWayVlaue: String = ""
    var textMessage: String = ""
    var isOn: Bool = false
    
    var delegate: EditDelegate?
    
    override func viewDidLoad() {
        super.viewDidLoad()
        lblWay.text = textWayVlaue
        tfMessage.text = textMessage
        
        swIsOn.isOn = isOn
        if isOn{
            lblOnOff.text = "ON"
        } else {
            lblOnOff.text = "OFF"
        }
        
    }
    
    @IBAction func btnDone(_ sender: UIButton) {
        if delegate != nil{
            delegate?.didMessageEditDone(self, message: tfMessage.text!)
            delegate?.didImageOnOffDone(self, isOn: isOn)
        }
        navigationController?.popViewController(animated: true)
    }
    
    @IBAction func swImageOff(_ sender: UISwitch) {
        if sender.isOn{
            isOn = true
            lblOnOff.text = "ON"
        } else {
            isOn = false
            lblOnOff.text = "OFF"
        }
    }
    
}
