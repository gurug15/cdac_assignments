using Microsoft.EntityFrameworkCore;

namespace COdeFirstWithFluent.Models
{
    public class EmpDbContext : DbContext
    {

        public EmpDbContext()
        {
        }

        public EmpDbContext(DbContextOptions<EmpDbContext> options)
            : base(options)
        {
        }

        public virtual DbSet<Department> Departments { get; set; }

        public virtual DbSet<Employee> Employees { get; set; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
#warning To protect potentially sensitive information in your connection string, you should move it out of source code. You can avoid scaffolding the connection string by using the Name= syntax to read it from configuration - see https://go.microsoft.com/fwlink/?linkid=2131148. For more guidance on storing connection strings, see https://go.microsoft.com/fwlink/?LinkId=723263.
            => optionsBuilder.UseSqlServer("Data Source=(localdb)\\ProjectModels;Initial Catalog=ActsJune25;Integrated Security=True");

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Department>(entity =>
            {
                entity.HasKey(e => e.DeptNo).HasName("PK__Departme__BE2D3F550F53E82C");

                entity.Property(e => e.DeptNo)
                    .ValueGeneratedNever()
                    .HasColumnName("deptNo");
                entity.Property(e => e.DeptName)
                    .HasMaxLength(20)
                    .IsFixedLength()
                    .HasColumnName("deptName");
            });

            modelBuilder.Entity<Employee>(entity =>
            {
                entity.HasKey(e => e.EmpNo).HasName("PK__Employee__AFB33592B6DA4092");

                entity.Property(e => e.EmpNo)
                    .ValueGeneratedNever()
                    .HasColumnName("empNo");
                entity.Property(e => e.Basic)
                    .HasColumnType("decimal(18, 0)")
                    .HasColumnName("basic");
                entity.Property(e => e.DeptNo).HasColumnName("deptNo");
                entity.Property(e => e.Name)
                    .HasMaxLength(50)
                    .IsUnicode(false)
                    .HasColumnName("name");

                entity.HasOne(d => d.DeptNoNavigation).WithMany(p => p.Employees)
                    .HasForeignKey(d => d.DeptNo)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_Table_Dept");
            });

            //OnModelCreatingPartial(modelBuilder);
        }

        //partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
    }
}
