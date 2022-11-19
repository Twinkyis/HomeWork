package Part_2.Example4;

public class TrackBuilder {
    public int setSegment1Length;
    public int setSegment2Length;
    public int setSegment3Length;
    public int setMaxNumberOfCarsInsideSegment2;
    public int setMaxNumberOfCarsOnTrack;
    public boolean [] setControlPlaceForSegment2;

    public TrackBuilder(int segment1Length, int segment2Length,
                        int segment3Length, int maxNumberOfCarsInsideSegment2,
                        int maxNumberOfCarsOnTrack, boolean[] controlPlaceForSegment2) {
        this.setSegment1Length = setSegment1Length;
        this.setSegment2Length = setSegment2Length;
        this.setSegment3Length = setSegment3Length;
        this.setMaxNumberOfCarsInsideSegment2 = setMaxNumberOfCarsInsideSegment2;
        this.setMaxNumberOfCarsOnTrack = setMaxNumberOfCarsOnTrack;
        this.setControlPlaceForSegment2 = setControlPlaceForSegment2;
    }
    public Track build() {
        return new Track();
    }
    private void Track(TrackBuilder trackBuilder) {
        setSegment1Length = trackBuilder.setSegment1Length;
        setSegment2Length = trackBuilder.setSegment2Length;
        setSegment3Length = trackBuilder.setSegment3Length;
        setMaxNumberOfCarsInsideSegment2 = trackBuilder.setMaxNumberOfCarsInsideSegment2;
        setMaxNumberOfCarsOnTrack = trackBuilder.setMaxNumberOfCarsOnTrack;
        setControlPlaceForSegment2 = trackBuilder.setControlPlaceForSegment2;
    }
}
