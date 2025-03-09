class Complex
{
    private:
      int real;
      int img;
    public:
      Complex();
      Complex(int rael,int img);
      void Accept();
      void Display() const;
      Complex Add(const Complex temp) const;
      Complex operator+(const Complex temp) const;
      Complex operator-(const Complex temp) const;

};