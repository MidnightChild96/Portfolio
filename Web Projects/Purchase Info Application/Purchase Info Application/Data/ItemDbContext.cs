using Microsoft.EntityFrameworkCore;
using Purchase_Info_Application.Models.Entities;

namespace Purchase_Info_Application.Data
{
    public class ItemDbContext : DbContext
    {
        public ItemDbContext(DbContextOptions<ItemDbContext> options) : base(options)
        {

        }

        public DbSet<Item> Items { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Item>()
                .HasIndex(i => new { i.Id})
                .IsUnique(true);
        }
    }
}
