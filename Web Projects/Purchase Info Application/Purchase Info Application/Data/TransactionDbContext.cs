using Microsoft.EntityFrameworkCore;
using Purchase_Info_Application.Models.Entities;

namespace Purchase_Info_Application.Data
{
    public class TransactionDbContext : DbContext
    {
        public TransactionDbContext(DbContextOptions<TransactionDbContext> options) : base(options)
        {

        }

        public DbSet<Transaction> Transactions { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Transaction>()
                .HasIndex(t => new { t.Id})
                .IsUnique(true);
        }
    }
}
