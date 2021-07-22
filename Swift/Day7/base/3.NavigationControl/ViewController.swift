	//
//  ViewController.swift
//
//  Created by 윤재필 on 2021/07/22.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var tfMessage: UITextField!
    @IBOutlet weak var imgView: UIImageView!
    
    let imgOn = UIImage(named: "light_on.png")
    let imgOff = UIImage(named: "lighy_off.png")
    
    //켜진 전구는 true, 꺼진 전구는 false
    var isOn: Bool = true
    
    override func viewDidLoad() {
        super.viewDidLoad()
        imgView.image = imgOn
    }
    
    //연결담당
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        //연결되는 세그를 잡아주는것 제일 중요
        let editViewController = segue.destination as! EditViewController
        
        if segue.identifier == "editButton"{
            editViewController.textWayVlaue = "Segue: Use Button"
        } else {
            editViewController.textWayVlaue = "Segue: Use Bar Button"
        }
        
        editViewController.isOn = isOn
        editViewController.textMessage = tfMessage.text!
        //서로의 델리게이트를 연결해주지 않으면 정상적으로 값이 넘어오지 않는다.
        editViewController.delegate = self
    }
    
}

extension ViewController: EditDelegate{
    func didMessageEditDone(_ controller: EditViewController, message: String) {
        tfMessage.text = message
    }
    
    func didImageOnOffDone(_ controller: EditViewController, isOn: Bool) {
        if isOn{
            imgView.image = imgOn
            self.isOn = true
        }else{
            imgView.image = imgOff
            self.isOn = false
        }
    }
}
