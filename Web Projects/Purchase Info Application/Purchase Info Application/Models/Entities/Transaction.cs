using Microsoft.EntityFrameworkCore;
using System.ComponentModel.DataAnnotations.Schema;

namespace Purchase_Info_Application.Models.Entities
{
    [PrimaryKey(nameof(Id))]
    public class Transaction
    {
        public int Id { get; set; }
        public int Tracking {  get; set; }
        [ForeignKey("Users")]
        public int UserId { get; set; }
        [ForeignKey("Items")]
        public int ItemId { get; set; }
        public DateTime DateTime { get; set; }
    }
}
