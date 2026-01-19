public class Exercise09_06 {
  public static void main(String[] args) {
    int size = 100000;
    
    double[] list = new double[size]; 
    
    for (int i = 0; i < list.length; i++) {
      list[i] = Math.random() * list.length;
    }

    StopWatch stopWatch = new StopWatch();
    selectionSort(list);
    stopWatch.stop();
    
    System.out.println("The sort time is " + stopWatch.getElapsedTime());    
  }

  public static void selectionSort(double[] list) {
    for (int i = 0; i < list.length - 1; i++) {
      double currentMin = list[i];
      int currentMinIndex = i;

      for (int j = i + 1; j < list.length; j++) {
        if (currentMin > list[j]) {
          currentMin = list[j];
          currentMinIndex = j;
        }
      }

      if (currentMinIndex != i) {
        list[currentMinIndex] = list[i];
        list[i] = currentMin;
      }
    }
  }
}

class StopWatch {
  private long startTime = System.currentTimeMillis();
  private long endTime = startTime;
  
  public StopWatch() {
  }
  
  public long getStartTime() {
  	return startTime;
  }
  
  public long getEndTime() {
  	return endTime;
  }
  
  public void start() {
    startTime = System.currentTimeMillis();
  }
  
  public void stop() {
    endTime = System.currentTimeMillis();
  }
  
  public long getElapsedTime() {
    return endTime - startTime;
  }  
}
