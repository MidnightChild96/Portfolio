using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Purchase_Info_Application.Data;
using Purchase_Info_Application.Models.Entities;

namespace Purchase_Info_Application.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class StoreController : Controller
    {
        private readonly ItemDbContext _itemDbContext;
        public StoreController(ItemDbContext itemDbContext)
        {
            _itemDbContext = itemDbContext;
        }

        [HttpGet]
        public async Task<IActionResult> GetAllItems()
        {
            return Ok(await _itemDbContext.Items.ToListAsync());
        }

        [HttpPost]
        public async Task<IActionResult> AddItems(List<Item> items)
        {
            foreach (Item item in items)
            {
                await _itemDbContext.Items.AddAsync(item);
            };
            await _itemDbContext.SaveChangesAsync();


            return Ok();
        }
    }
}
