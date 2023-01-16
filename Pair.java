public class Pair {
    private String element;
    private int count;
    private int coef = 1;

    public Pair (String element, int count)
    {
      this.element = element;
      this.count = count;
    }

    public Pair()
    {

    }

    public String getElement() {
      return element;
    }

    public void setElement(String element) {
      this.element = element;
    }

    public int getCount() {
      return count;
    }

    public void setCount(int count) {
      this.count = count;
    }

    public int getCoef()
    {
      return coef;
    }

    public void setCoef(int coef)
    {
      this.coef = coef;
    }
}
