class StateInfo {
  late String imagePath;
  late String stateName;
  late String previewName;

  StateInfo(String imagePath, String stateName) {
    this.imagePath = imagePath;
    this.stateName = stateName;
    previewName = '${stateName[0]}_______';
  }
}
