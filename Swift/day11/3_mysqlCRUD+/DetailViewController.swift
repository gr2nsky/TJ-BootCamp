//
//  DetailViewController.swift
//  iosLec2
//
//  Created by 윤재필 on 2021/07/28.
//

import UIKit

class DetailViewController: UIViewController {

    @IBOutlet weak var tfCode: UITextField!
    @IBOutlet weak var tfName: UITextField!
    @IBOutlet weak var tfDept: UITextField!
    @IBOutlet weak var tfPhone: UITextField!
    
    var gCode: String?
    var gName: String?
    var gDept: String?
    var gPhone: String?
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        tfCode.text = gCode!
        tfName.text = gName!
        tfDept.text = gDept!
        tfPhone.text = gPhone!
    }
    
    func setData(code: String, name: String, dept: String, phone: String){
        self.gCode = code
        self.gName = name
        self.gDept = dept
        self.gPhone = phone
        
    }
    
    @IBAction func btnDelete(_ sender: UIButton) {
        let code = tfCode.text!
        
        let deleteModel = DeleteModel()
        let result = deleteModel.deleteItem(code: code)
        
        if result {
            let resultAlert = UIAlertController(title: "완료", message: "수정 완료", preferredStyle: .alert)
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
    
    @IBAction func btnUpdate(_ sender: UIButton) {
        let code = tfCode.text!
        let name = tfName.text!
        let dept = tfDept.text!
        let phone = tfPhone.text!
        print("inputed phone:\(phone)")
        let updateModel = UpdateModel()
        let result = updateModel.updateItem(code: code, name: name, dept: dept, phone: phone)
        
        if result {
            let resultAlert = UIAlertController(title: "완료", message: "수정 완료", preferredStyle: .alert)
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
