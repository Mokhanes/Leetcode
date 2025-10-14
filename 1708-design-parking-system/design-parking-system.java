class ParkingSystem {

    int bigc[];
    int midc[];
    int smlc[];

    public ParkingSystem(int big, int medium, int small) {
        bigc = new int[big];
        midc = new int[medium];
        smlc = new int[small];
    }
    
    public boolean addCar(int carType) {
        if(carType == 1){
            for(int i =0;i<bigc.length;i++){
                if(bigc[i] == 0){
                    bigc[i] = 1;
                    return true;
                }
            }
        }else if(carType == 2){
            for(int i =0;i<midc.length;i++){
                if(midc[i] == 0){
                    midc[i] = 1;
                    return true;
                }
            }
        }else if(carType == 3){
            for(int i =0;i<smlc.length;i++){
                if(smlc[i] == 0){
                    smlc[i] = 1;
                    return true;
                }
            }
        }

        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */