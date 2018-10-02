public boolean makeBricks(int small, int big, int goal) {

  return small + big * 5 >= goal && small >= goal % 5;
    
}
