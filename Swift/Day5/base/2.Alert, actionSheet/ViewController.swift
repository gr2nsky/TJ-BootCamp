//
//  ViewController.swift
//  Quiz02
//
//  Created by Kenny on 2021/07/14.
//

import UIKit

class ViewController: UIViewController {
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
    
    } // ViewController
    
    @IBAction func btnAlert(_ sender: Any) {
        //Controller 초기화
        let testAlert = UIAlertController(title: "Title", message: "Message", preferredStyle: .alert)
        
        //Alert action
        let actionDefault = UIAlertAction(title: "ActionDefault", style: .default, handler: nil)
        
        let actionDestructive = UIAlertAction(title: "Action Destructive", style: .destructive, handler: {ACTION in
            print("destructive action called")
        })
        
        let actionCancel = UIAlertAction(title: "Action Cancel", style: .cancel, handler: {ACTION in
            print("Cancel action called")
        })
        
        //결합
        testAlert.addAction(actionDefault)
        testAlert.addAction(actionDestructive)
        testAlert.addAction(actionCancel)
        
        present(testAlert, animated: true, completion: nil)
    }
    @IBAction func btnActionSheet(_ sender: Any) {
        //Controller 초기화
        let testAlert = UIAlertController(title: "Title", message: "Message", preferredStyle: .actionSheet)
        
        //Alert action
        let actionDefault = UIAlertAction(title: "ActionDefault", style: .default, handler: nil)
        
        let actionDestructive = UIAlertAction(title: "Action Destructive", style: .destructive, handler: {ACTION in
            print("destructive action called")
        })
        
        let actionCancel = UIAlertAction(title: "Action Cancel", style: .cancel, handler: {ACTION in
            print("Cancel action called")
        })
        
        testAlert.addAction(actionDefault)
        testAlert.addAction(actionDestructive)
        testAlert.addAction(actionCancel)
        
        present(testAlert, animated: true, completion: nil)
    }
}
