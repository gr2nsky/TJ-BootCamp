//
//  ViewController.swift
//  Quiz02
//
//  Created by Kenny on 2021/07/14.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var lblNow: UILabel!
    @IBOutlet weak var lblSelectedTime: UILabel!
    
    var currentTime : String = ""
    var changeTime : String = ""
    var count : Int = 0
    
    let interval = 1.0 //초
    let timeSelecotr: Selector = #selector(ViewController.updateTime)
    
    override func viewDidLoad() {
        super.viewDidLoad()
        lblSelectedTime.text = "시간을 선택하세요."
        Timer.scheduledTimer(timeInterval: interval, target: self, selector: timeSelecotr, userInfo: nil, repeats: true)
    }
    
    @IBAction func timeSelect(_ sender: UIDatePicker) {
        let datePickerView = sender
        let formatter = DateFormatter()
        
        formatter.locale = Locale(identifier: "ko")
        //24시간을 쓰고싶다면 hh 대신 HH를 사용하면 된다.
        formatter.dateFormat = "yyyy-MM-dd EEE a hh:mm"
        
        let lampOnAlert = UIAlertController(title: "알림", message: "알림을 시작합니다.", preferredStyle: .alert)
        let onAction = UIAlertAction(title: "네, 알겠습니다.", style: .default, handler: nil)
        
        lampOnAlert.addAction(onAction)
        present(lampOnAlert, animated: true, completion: nil)
        
        changeTime = formatter.string(from:datePickerView.date)
        lblSelectedTime.text = "선택시간 : \(changeTime)"
    }
    
    
    @objc func updateTime(){
        let date = NSDate()
        let formatter = DateFormatter()
        
        formatter.locale = Locale(identifier: "ko")
        formatter.dateFormat = "yyyy-MM-dd EEE a hh:mm"

        currentTime = formatter.string(from: date as Date)
        lblNow.text = "현재시간 : \(currentTime)"
        
        if currentTime == changeTime {
            count += 1
            if count % 2 == 0{
                view.backgroundColor = UIColor.red
            }else{
                view.backgroundColor = UIColor.blue
            }
        }else{
            view.backgroundColor = UIColor.white
        }
    }
}
