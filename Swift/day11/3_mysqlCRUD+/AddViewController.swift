//
//  AddViewController.swift
//  iosLec2
//
//  Created by 윤재필 on 2021/07/28.
//

import UIKit

class AddViewController: UIViewController {

    @IBOutlet weak var tfCode: UITextField!
    @IBOutlet weak var tfName: UITextField!
    @IBOutlet weak var tfDept: UITextField!
    @IBOutlet weak var tfPhone: UITextField!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }
    
    @IBAction func btnInsert(_ sender: UIButton) {
        let code = tfCode.text!
        let name = tfCode.text!
        let dept = tfCode.text!
        let phone = tfCode.text!
        
        let insertModel = InsertModel()
        let result = insertModel.insertItem(code: code, name: name, dept: dept, phone: phone)
        
        if result {
            let resultAlert = UIAlertController(title: "완료", message: "입력 완료", preferredStyle: .alert)
            let onAction = UIAlertAction(title: "OK", style: .default, handler: {ACTION in
                self.navigationController?.popViewController(animated: true)
            })
            resultAlert.addAction(onAction)
            present(resultAlert, animated: true, completion: nil)
        } else {
            let resultAlert = UIAlertController(title: "실패", message: "에러 발생", preferredStyle: .alert)
            let onAction = UIAlertAction(title: "OK", style: .default, handler: nil)
            resultAlert.addAction(onAction)
            present(resultAlert, animated: true, completion: nil)
        }
    }
    
    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */
}
