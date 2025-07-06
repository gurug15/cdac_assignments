namespace COdeFirstWithFluent.Models
{
    public class Employee
    {

        public int EmpNo { get; set; }

        public string Name { get; set; } = null!;

        public int DeptNo { get; set; }

        public decimal Basic { get; set; }

        public virtual Department? DeptNoNavigation { get; set; } = null!;
    }
}
