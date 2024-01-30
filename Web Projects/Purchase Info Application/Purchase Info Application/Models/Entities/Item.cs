using Microsoft.EntityFrameworkCore;

namespace Purchase_Info_Application.Models.Entities
{
    [PrimaryKey(nameof(Id))]
    public class Item
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public double Price {  get; set; }

    }
}
