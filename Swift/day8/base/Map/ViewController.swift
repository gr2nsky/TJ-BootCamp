//
//  ViewController.swift
//  IosLecture
//
//  Created by 윤재필 on 2021/07/23.
//

import MapKit
import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var locationGo: UISegmentedControl!
    @IBOutlet weak var myMap: MKMapView!
    @IBOutlet weak var lblAddr1: UILabel!
    @IBOutlet weak var lblAddr2: UILabel!
    
    let myLoc = CLLocationManager()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        myLoc.delegate = self
        myLoc.requestWhenInUseAuthorization() // 위치사용 승인 문구
        myLoc.startUpdatingLocation() // gps 좌표 받기 시작
        myMap.showsUserLocation = true
        
    }
    
    func mapMove(_ lat: CLLocationDegrees, _ lon: CLLocationDegrees, _ txt1: String){
        
        //내 위치
        let pLoc = CLLocationCoordinate2DMake(lat, lon)
        
        //배율
        let pSapn = MKCoordinateSpan(latitudeDelta: 0.02, longitudeDelta: 0.02)
        
        //좌표 정보
        let pRegion = MKCoordinateRegion(center: pLoc, span: pSapn)
        
        //현재 지도를 좌표정포로 보이기
        myMap.setRegion(pRegion, animated: true)
        
        let addrLoc = CLLocation(latitude: lat, longitude: lon)
        var txt2 = ""
        
        CLGeocoder().reverseGeocodeLocation(addrLoc, completionHandler: {place, error in
            let pm = place!.first
            txt2 = pm!.country! //국가
            txt2 += " " + pm!.locality! //시도
            txt2 += " " + pm!.thoroughfare! // 동
            self.lblAddr2.text = txt2
            
        })
        lblAddr1.text  = txt1
        
        setPoint(pLoc, txt1, txt2)
    }

    @IBAction func locationGo(_ sender: UISegmentedControl) {
        
        if sender.selectedSegmentIndex == 0 {
            myLoc.startUpdatingLocation()
        } else if sender.selectedSegmentIndex == 1 {
            mapMove(37.65243153, 127.0276397, "둘리 뮤지엄")
        }  else {
            mapMove(37.57244171, 126.9595412, "서대문 형무소 역사관")
        }
        
    }
    
    //마커
    func setPoint(_ loc: CLLocationCoordinate2D, _ txt1: String, _ txt2: String){
        let pin = MKPointAnnotation()
        
        pin.coordinate = loc
        pin.title = txt1
        pin.subtitle = txt2
        
        myMap.addAnnotation(pin)
    }
    
}//ViewController

//myLoc = CLLocationManager() 호출시 자동 실행
extension ViewController: CLLocationManagerDelegate{
    func locationManager(_ manager: CLLocationManager, didUpdateLocations locations: [CLLocation]) {
        let lastLoc = locations.last
        // 지도 보기
        mapMove((lastLoc?.coordinate.latitude)!, (lastLoc?.coordinate.longitude)!, "현재 위치")
        myLoc.stopUpdatingLocation() // 좌표 받기 중지
        
    }
}

