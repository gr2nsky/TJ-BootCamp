//
//  DBModel.swift
//  iosLec2
//
//  Created by 윤재필 on 2021/07/27.
//

import Foundation

class DBModel{
    var scode: String?
    var sname: String?
    var sdept: String?
    var sphone: String?
    
    //Empty constructor
    init(){
        
    }
    
    init(scode: String, sname: String, sdept: String, sphone: String){
        self.scode = scode
        self.sname = sname
        self.sdept = sdept
        self.sphone = sphone
    }
}
