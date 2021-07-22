//
//  EditDelegate.swift
//  iosTemp
//
//  Created by 윤재필 on 2021/07/22.
//

protocol EditDelegate {
    func didMessageEditDone(_ controller: EditViewController, message: String)
    func didImageOnOffDone(_ controller: EditViewController, isOn: Bool)
}
