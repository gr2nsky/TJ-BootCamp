//
//  ViewController.swift
//  Quiz02
//
//  Created by Kenny on 2021/07/14.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var pickerView: UIPickerView!
    @IBOutlet weak var lblName: UILabel!
    @IBOutlet weak var tvReuslt: UITextView!
    
    var pickValue: [Int] = Array(2...9)
    var maxArrayNum = 0
    let viewColumnn = 1

    override func viewDidLoad() {
        super.viewDidLoad()
        maxArrayNum = pickValue.count

        lblName.text = "구구단"
        
        pickerView.dataSource = self
        pickerView.delegate = self
    }
    
} // ViewController


extension ViewController: UIPickerViewDataSource{
    // 피커뷰 컬럼 갯수
    func numberOfComponents(in pickerView: UIPickerView) -> Int {
        return viewColumnn
    }
    // 출력할 이미지 파일 갯수
    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        return maxArrayNum
    }
}

extension ViewController: UIPickerViewDelegate{
    //피커뷰에 title 입히기
    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
        return "\(pickValue[row]) 단"
    }
    
    //피커뷰 선택에 따른 결과 처리
    func pickerView(_ pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int) {
        tvReuslt.text.removeAll()
        for i in 2...9{
            let seedNum = pickValue[row]
            tvReuslt.text += "\(seedNum) * \(i) = \(seedNum * i) \n"
        }
    }
}
