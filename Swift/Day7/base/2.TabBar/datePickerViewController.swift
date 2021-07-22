//
//  ViewController.swift
//  Quiz02
//
//  Created by Kenny on 2021/07/14.
//
import UIKit

class datePickerViewController: UIViewController {
    
    
    @IBOutlet weak var lblCurrentTime: UILabel!
    @IBOutlet weak var lblPickerTime: UILabel!
    
    let interval = 0.5 //초
    let timeSelecotr: Selector = #selector(datePickerViewController.updateTime)
    
    override func viewDidLoad() {
        super.viewDidLoad()
        lblPickerTime.text = "시간을 선택하세요."
        //시간주는얘는 아니고 앱이 시작됬을떄 구동을 시키는 것임
        Timer.scheduledTimer(timeInterval: interval, target: self, selector: timeSelecotr, userInfo: nil, repeats: true)
    }
    
    @IBAction func changeDatePicker(_ sender: UIDatePicker) {
        let datePickerView = sender
        let formatter = DateFormatter()
        
        formatter.locale = Locale(identifier: "ko")
        //24시간을 쓰고싶다면 hh 대신 HH를 사용하면 된다.
        formatter.dateFormat = "yyyy-MM-dd EEE a hh:mm"
        lblPickerTime.text = "선택시간 : \(formatter.string(from: datePickerView.date))"
    }
    
    @objc func updateTime(){
        let date = NSDate()
        let formatter = DateFormatter()
        
        formatter.locale = Locale(identifier: "ko")
        formatter.dateFormat = "yyyy-mm-dd EEE a hh:mm:ss"
        lblCurrentTime.text = "현재시간 : \(formatter.string(from: date as Date))"
    }
} // ViewController

