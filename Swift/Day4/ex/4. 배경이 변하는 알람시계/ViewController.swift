//
//  ViewController.swift
//  Quiz02
//
//  Created by Kenny on 2021/07/14.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var lblCurrentTime: UILabel!
    @IBOutlet weak var lblPickerTime: UILabel!
    
    var currentTime : String = ""
    var changeTime : String = ""
    var count : Int = 0
    
    let interval = 1.0 //초
    let timeSelecotr: Selector = #selector(ViewController.updateTime)
    
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
        changeTime = formatter.string(from:datePickerView.date)
        lblPickerTime.text = "선택시간 : \(changeTime)"
    }
    
    @objc func updateTime(){
        let date = NSDate()
        let formatter = DateFormatter()
        
        formatter.locale = Locale(identifier: "ko")
        formatter.dateFormat = "yyyy-MM-dd EEE a hh:mm"

        currentTime = formatter.string(from: date as Date)
        lblCurrentTime.text = "현재시간 : \(currentTime)"
        
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
} // ViewController

