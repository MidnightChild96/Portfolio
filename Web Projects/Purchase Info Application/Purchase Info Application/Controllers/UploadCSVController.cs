using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Purchase_Info_Application.Data;

namespace Purchase_Info_Application.Controllers
{
    public class UploadCSVController : Controller
    {
        private readonly UserDbContext _userDbContext;
        private readonly ItemDbContext _itemDbContext;
        private readonly TransactionDbContext _transactionDbContext;

        //[HttpPost]
       //public async Task<IActionResult> UploadCSV(Note note)
       //{
       //}
    }
}
