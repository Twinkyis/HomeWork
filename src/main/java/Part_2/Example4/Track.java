package Part_2.Example4;

public class Track {

   private int segment1Length;
   private int segment2Length;
   private int segment3Length;
   private int maxNumberOfCarsInsideSegment2;
   private int maxNumberOfCarsOnTrack;
   private boolean[] controlPlaceForSegment2;

   public Track(/*int segment1Length, int segment2Length,
                int segment3Length, int maxNumberOfCarsInsideSegment2,
                int maxNumberOfCarsOnTrack, boolean[] controlPlaceForSegment2*/) {
      this.segment1Length = segment1Length;
      this.segment2Length = segment2Length;
      this.segment3Length = segment3Length;
      this.maxNumberOfCarsInsideSegment2 = maxNumberOfCarsInsideSegment2;
      this.maxNumberOfCarsOnTrack = maxNumberOfCarsOnTrack;
      this.controlPlaceForSegment2 = controlPlaceForSegment2;
   }
   public int getSegment1Length() {
      return this.segment1Length;
   }

   public void setSegment1Length (int a) {
      this.segment1Length = a;
   }

   public int getSegment2Length() {
      return this.segment2Length;
   }

   public void setSegment2Length(int value) {
      this.segment2Length = value;
   }

   public int getSegment3Length() {
      return this.segment3Length;
   }

   public void setSegment3Length(int value) {
      this.segment3Length = value;
   }

   public int getMaxNumberOfCarsInsideSegment2() {
      return this.maxNumberOfCarsInsideSegment2;
   }

   public void setMaxNumberOfCarsInsideSegment2(int value) {
      this.maxNumberOfCarsInsideSegment2 = value;
   }

   public int getMaxNumberOfCarsOnTrack() {
      return this.maxNumberOfCarsOnTrack;
   }

   public void setMaxNumberOfCarsOnTrack(int value) {
      this.maxNumberOfCarsOnTrack = value;
   }

   public boolean[] getControlPlaceForSegment2(){
      return this.controlPlaceForSegment2;
   }

   public void setControlPlaceForSegment2(boolean [] value) {
      this.controlPlaceForSegment2 = value;
   }
}
