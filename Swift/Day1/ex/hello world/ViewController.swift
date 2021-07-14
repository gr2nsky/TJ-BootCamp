//
//  ViewController.swift
//  Day1_ios_helloWorld
//
//  Created by 윤재필 on 2021/07/14.
//

import UIKit

class ViewController: UIViewController {
    @IBOutlet weak var tfName: UITextField!
    @IBOutlet weak var tfSize: UITextField!
    @IBOutlet weak var tfWeight: UITextField!
    @IBOutlet weak var tfBag: UITextField!
    @IBOutlet weak var tfColor: UITextField!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
   
    @IBAction func btnOk(_ sender: UIButton) {
        let name: String = "맥북프로"
        let size: Int = 16
        let weight: Double = 2.56
        let bar: Bool = false;
        let color: Character = "은"
        
        tfName.text = name
        tfSize.text = String(size)
        tfWeight.text = String(weight)
        tfBag.text = String(bar)
        tfColor.text = String(color)
        
    }
    @IBAction func btnClear(_ sender: UIButton) {
        tfName.text = ""
        tfSize.text?.removeAll()
        tfWeight.text?.removeAll()
        tfBag.text?.removeAll()
        tfColor.text?.removeAll()
    }
    
} //ViewController

javascript:;
