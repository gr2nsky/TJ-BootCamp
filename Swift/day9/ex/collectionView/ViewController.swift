//
//  ViewController.swift
//  IosLecture
//
//  Created by 윤재필 on 2021/07/23.
//

import UIKit

var imageList = ["flower_01", "flower_02", "flower_03", "flower_04", "flower_05", "flower_06" ]

class ViewController: UIViewController {

    @IBOutlet weak var collectionView: UICollectionView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        collectionView.delegate = self
        collectionView.dataSource = self
    }
    
    //뒤에있다가 최상위로 올라올때 실행 (add pop 후 실행되겠지?)
    override func viewWillAppear(_ animated: Bool) {
        collectionView.reloadData()
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        let cell = sender as! CollectionViewCell
        let indexPath = self.collectionView.indexPath(for: cell)
        let detailView = segue.destination as! DetailViewController
        detailView.receiveItems(imageList[indexPath!.row])
    }
    
}//ViewController


extension ViewController: UICollectionViewDataSource, UICollectionViewDelegate{
    
    //cell의 갯수
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return imageList.count
    }
    
    //cell 구성
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        //android의 recyclerview같은느낌
        let cell = collectionView.dequeueReusableCell(withReuseIdentifier: "myCell", for: indexPath) as! CollectionViewCell
        
        cell.fImage.image = UIImage(named: imageList[indexPath.row])!
        
        return cell
    }
} 

//cell layout 정의
extension ViewController: UICollectionViewDelegateFlowLayout{
    //위아래간격
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, minimumLineSpacingForSectionAt section: Int) -> CGFloat {
        return 1
    }
    
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, minimumInteritemSpacingForSectionAt section: Int) -> CGFloat {
        return 1
    }
    
    //cell 사이즈 (옆 라인을 고려하여 설정)
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, sizeForItemAt indexPath: IndexPath) -> CGSize {
        //3등분해 배치, 옆간격 1이므로 1을 뻄
        let width = collectionView.frame.width / 3 - 1
        let size = CGSize(width: width, height: width)
        return size
    }
}
