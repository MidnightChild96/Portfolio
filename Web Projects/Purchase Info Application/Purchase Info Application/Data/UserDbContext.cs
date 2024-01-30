using Microsoft.EntityFrameworkCore;
using Purchase_Info_Application.Models.Entities;
using System;

namespace Purchase_Info_Application.Data
{
    public class UserDbContext : DbContext
    {
        public UserDbContext(DbContextOptions<UserDbContext> options) : base(options)
        {

        }

        public DbSet<User> Users { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<User>()
                .HasIndex(u => new { u.Id,})
                .IsUnique(true);
        }
    }
}
