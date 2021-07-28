//
//  JsonModel.swift
//  iosLec2
//
//  Created by 윤재필 on 2021/07/27.
//

import Foundation

class DeleteModel{
    var urlPath = "http://192.168.2.4:8080/ios/studentDelete_ios.jsp"
    
    func deleteItem(code: String) -> Bool{
        var result: Bool = true
        let urlAdd = "?code=\(code)"
        urlPath += urlAdd
        
        //한글 url encoding
        urlPath = urlPath.addingPercentEncoding(withAllowedCharacters: .urlQueryAllowed)!
        
        let url: URL = URL(string: urlPath)!
        let defualtSession = Foundation.URLSession(configuration: URLSessionConfiguration.default)
        let task = defualtSession.dataTask(with: url){(data, responds, error) in
            if error != nil{
                print("Failed to delete data")
                result = false
            } else {
                print("Data is deleted!")
            }
        }
        task.resume()
        return result
    }
    
}
