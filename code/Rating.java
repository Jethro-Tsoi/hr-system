public class Rating {

    private int ratingsTotal;
    // private int score;

    // public Rating(int score){
        // score = this.score; 
    public Rating(){
        this.ratingsTotal = 50; 
      }

    public void addScore(int score) {
        this.ratingsTotal = this.ratingsTotal + score;
    }

    public void minusScore(int score) {
        this.ratingsTotal = this.ratingsTotal - score;
    }

    public void getScore() {
        System.out.println("Your score is " + (ratingsTotal));
    }
}
