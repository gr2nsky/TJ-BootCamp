//
//  JsonModel.swift
//  iosLec2
//
//  Created by 윤재필 on 2021/07/27.
//

import Foundation

class InsertModel{
    var urlPath = "http://192.168.2.4:8080/ios/studentInsert_ios.jsp"
    
    func insertItem(code: String, name: String, dept: String, phone: String) -> Bool{
        var result: Bool = true
        let urlAdd = "?code=\(code)&name=\(name)&dept=\(dept)&phone\(phone)"
        urlPath += urlAdd
        
        //한글 url encoding
        urlPath = urlPath.addingPercentEncoding(withAllowedCharacters: .urlQueryAllowed)!
        
        let url: URL = URL(string: urlPath)!
        let defualtSession = Foundation.URLSession(configuration: URLSessionConfiguration.default)
        let task = defualtSession.dataTask(with: url){(data, responds, error) in
            if error != nil{
                print("Failed to insert data")
                result = false
            } else {
                print("Data is inserted!")
            }
        }
        task.resume()
        return result
    }
    
}
